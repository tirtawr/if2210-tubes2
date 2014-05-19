import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

public class Index {
	
	// Kelas Index adalah kelas yang menyimpan informasi semua kata beserta jumlah
	// kemunculan kata tersebut

    private List<IndexKata> ListKata; // List of IndexKata
    private List<String> ListOfCommonWords = new ArrayList<String>();

    public Index() {
    	// Konstruktor
        ListKata = new ArrayList<IndexKata>();
            
		try {
			File file = new File("commonWords.txt");
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ListOfCommonWords.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    public Index(String strSource) {
    	// Konstruktor dengan parameter bertipe string
        ListKata = new ArrayList<IndexKata>();
        try {
			File file = new File("commonWords.txt");
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ListOfCommonWords.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        StringIndexing(strSource);
    }

    public List<IndexKata> getListKata() {
    	// Getter atribut ListKata
        return ListKata;
    }

    public void addIndexKata(IndexKata Kata) {
    	// Menambahkan objek kelas IndexKata ke ListKata
        ListKata.add(Kata);
    }

    public void delIndexKata(IndexKata Kata) {
    	// Menghapus objek IndexKata dari ListKata
        ListKata.remove(Kata);
    }

    public void PrintIndex() {
    	// Menampilkan tabel hasil indexing ke layar
        for (int i = 0; i < ListKata.size(); i++) {
            ListKata.get(i).PrintIndexKata();
        }
    }
    
    public Boolean isKataAda(String Kata) {
    	// Memeriksa apakah string Kata terkandung di ListKata
    	Boolean KataAda = false;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getKata().compareToIgnoreCase(Kata) == 0) {
    			KataAda = true;
    			break;
    		}
    	}
    	return KataAda;
    }
    
    public int getIndexKata(String Kata) {
    	// Menghasilkan index dimana string Kata tersebut disimpan di ListKata, 
    	// akan mengembalikan nilai -1 apabila kata tersebut tidak ada di
    	int Idx = -1;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getKata().compareToIgnoreCase(Kata) == 0) {
    			Idx = i;
    			break;
    		}
    	}
    	return Idx;
    }
    
    public boolean isACommonWord(String s){
    	boolean found = false;
    	for(String str: ListOfCommonWords){
    		if(s.toLowerCase().contentEquals(str)){
    			found = true;
    			break;
    		}
    	}
    	return found;
    }
    public void StringIndexing(String StrSource) {
    	// Melakukan proses indexing untuk sebuah string
    	String ArrSplit[] = StrSource.split("\\s+");
    	//for (int i = 0; i < ArrSplit.length; i++) {
    	
    	for(String s : ArrSplit){
    		if(!isACommonWord(s) && s.length() > 6 ){
	    		if (!isKataAda(s)) {
	    			// Kalau kata belum terkandung di ListKata, masukkan
	    			// kata tersebut dan isi jumlah kemunculannya dengan 1
	    			IndexKata IK = new IndexKata(s);
	    			addIndexKata(IK);
	    		} else{
	    			// Kalau kata sudah terkandung di ListKata, tambahkan
	    			// jumlah kemunculan kata tersebut
	    			int idx = getIndexKata(s);
	    			ListKata.get(idx).MunculPlus();
	    		}
    		}
    	}
    }
    
    public void Indexing(List<String> Source) {
    	// Melakukan proses indexing dari sebuah list of string
        for (int i = 0; i < Source.size(); i++) {
            String StringSource = Source.get(i);
            StringIndexing(StringSource);
        }
    }
    
    public String KataTop() {
    	// Menghasilkan IndexKata yang memiliki jumlah kemunculan terbanyak
    	int iMax = 0;
    	int MunculMax = 0;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getMuncul() >= MunculMax) {
    			MunculMax = ListKata.get(i).getMuncul();
    			iMax = i;
    		}
    	}
    	return ListKata.get(iMax).getKata();    	
    }
    
    public List<String> KataTopN(int N) {
    	// Menghasilkan list of N string kata yang memiliki jumlah kemunculan terbanyak
    	List<String> TopN = new ArrayList<String>();
    	int iMax;
    	int MunculMax;
    	for (int j = 0; j < N; j++) {
    		iMax = 0; MunculMax = 0;
    		
	    	for (int i = 0; i < ListKata.size(); i++) {
	    		if ((ListKata.get(i).getMuncul() >= MunculMax) &&
	    				(!TopN.contains(ListKata.get(i).getKata()))) {
	    			// Hanya kata-kata yang belum ada di list TopN yang
	    			// dapat menjadi untuk kata dengan MunculMax selanjutnya
	    			MunculMax = ListKata.get(i).getMuncul();
	    			iMax = i;
	    		}
	    	}
	    	TopN.add(ListKata.get(iMax).getKata());
    	}
    	return TopN;
    }

    

}

