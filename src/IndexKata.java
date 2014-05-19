public class IndexKata {
	
	// Kelas IndexKata merupakan elemen type dari list yang terdapat di atribut
	// ListKata di kelas Index. Kelas ini mengandung informasi untuk sebuah kata
	// dan jumlah kemunculan kata tersebut

	private String Kata; // Nama Kata yang akan dihitung banyak kemunculannya
	private int Muncul;	// Banyak kemunculan kata

	public IndexKata() {
	// Konstruktor
		Kata = "";
		Muncul = 0;
	}

	public IndexKata(String _Kata) {
	// Konstruktor dengan parameter Kata
	// NKata di isi dengan nilai 1 karena kata tersebut
	// min. sudah muncul 1 kali
		Kata = _Kata;
		Muncul = 1;
	}

	public IndexKata(String _Kata, int _Muncul) {
	// Konstruktor dengan parameter Kata dan Muncul
		Kata = _Kata;
		Muncul = _Muncul;
	}

	public String getKata() {
	// Getter atribut Kata
		return Kata;
	}

	public int getMuncul() {
	// Getter atribut Muncul
		return Muncul;
	}

	public void setKata(String _Kata) {
	// Setter atribut Kata
		Kata = _Kata;
	}

	public void setMuncul(int _Muncul) {
	// Setter atribut NKata
		Muncul = _Muncul;
	}

	public void MunculPlus() {
	// Menambahkan atribut NKata sebanyak 1
		Muncul++;
	}

	public void PrintIndexKata() {
		System.out.println(Kata + "[" + Muncul + "]");
	}

	/* public static void main (String[] args) {
		IndexKata a = new IndexKata("a");
		a.PrintIdKata();
		a.MunculPlus();
		a.PrintIdKata();
		a.setMuncul(5);
		a.PrintIdKata();
		String b = "Kanya";
		a.setKata(b);
		a.PrintIdKata();
	} */

}
