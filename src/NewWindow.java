import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class NewWindow implements ActionListener {

	public JFrame frame;
	JPanel panel, panelhasil;
	JButton btnKategoriWorld, btnKategoriTech;
	JTextPane textPane;
	TextArea textArea_world, textArea_Tech;
	JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	private Feed coba;
	private JTextPane textPane_1;
	private JTextField txtAaa;
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window1 = new home();
					window1.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public NewWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(1024, 750);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1366, 750);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelkategori = new JPanel();
		panelkategori.setBackground(Color.LIGHT_GRAY);
		panelkategori.setBounds(0, 93, 87, 657);
		panel.add(panelkategori);
		panelkategori.setLayout(null);
		
		JLabel lblKategori = new JLabel("kategori 1");
		lblKategori.setIcon(new ImageIcon("C:\\Users\\Windy Amelia\\Desktop\\home.png"));
		lblKategori.setBounds(0, 0, 87, 61);
		panelkategori.add(lblKategori);
		lblKategori.setHorizontalAlignment(SwingConstants.CENTER);
		Border blackline = null;
		blackline = BorderFactory.createLineBorder(Color.black);
		lblKategori.setBorder(blackline);
		
		btnKategoriWorld = new JButton("WORLD");
		btnKategoriWorld.setForeground(Color.BLACK);
		btnKategoriWorld.setBackground(Color.LIGHT_GRAY);
		btnKategoriWorld.setFont(new Font("Arial", Font.PLAIN, 10));
		btnKategoriWorld.setBounds(0, 60, 87, 54);
		panelkategori.add(btnKategoriWorld);
		btnKategoriWorld.addActionListener(this);
		
		btnKategoriTech = new JButton("Technology");
		btnKategoriTech.setForeground(Color.BLACK);
		btnKategoriTech.setFont(new Font("Arial", Font.PLAIN, 10));
		btnKategoriTech.setBackground(Color.LIGHT_GRAY);
		btnKategoriTech.setBounds(0, 125, 87, 54);
		panelkategori.add(btnKategoriTech);
		btnKategoriTech.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1366, 93);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtAaa = new JTextField();
		txtAaa.setText("aaa");
		txtAaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAaa.setForeground(Color.YELLOW);
		txtAaa.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAaa.setBounds(110, 11, 86, 20);
		panel_1.add(txtAaa);
		txtAaa.setColumns(10);
		
		JTextPane txtpnAaaa = new JTextPane();
		txtpnAaaa.setText("aaaa");
		txtpnAaaa.setBounds(292, 22, 127, 20);
		panel_1.add(txtpnAaaa);
		
		
		panelhasil = new JPanel(new BorderLayout());
		panelhasil.setBounds(86, 93, 920, 600);
		panel.add(panelhasil);
		panelhasil.setLayout(null);
		
	    
	    Pengkategori PK = new Pengkategori();
		String temp = "";
	    for(FeedMessage fm : PK.ListWorld){
	    	temp += fm.getDescription();
	    	temp += "\n";
	    	temp += fm.getLink();
	    	temp += "\n\n";
	    }
	   
	    textPane_1 = new JTextPane();
	    scrollPane = new JScrollPane(textPane_1);
	    scrollPane.setSize(880, 580);
	    scrollPane.setLocation(10, 10);
		
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    panelhasil.add(scrollPane);
	    scrollPane.setVisible(false);
	}
	
	public List<FeedMessage> hasil()
	{
		
		List<FeedMessage> ListHasil = new ArrayList<FeedMessage>();
		List<String> ListUrl = new ArrayList<String>();
		ListUrl.add("http://rss.cnn.com/rss/edition.rss");
		
	    RSSFeedParser parser = new RSSFeedParser(ListUrl);
	    
	    Feed feed = parser.readFeed();
	    
	    //System.out.println(feed);
	    for (FeedMessage message : feed.getMessages()) {
	    
	      ListHasil.add(message);

	    }
	    
	    return ListHasil;
	}
	
	public void readfile ()
	{
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Pengkategori PK = new Pengkategori();
		String temp = "";
	    for(FeedMessage fm : PK.ListWorld){
	    	temp += fm.getDescription();
	    	temp += "\n";
	    	temp += fm.getLink();
	    	temp += "\n\n";
	    }
	    
	    String tempTech = "";
	    for(FeedMessage fm : PK.ListTech){
	    	tempTech += fm.getDescription();
	    	tempTech += "\n";
	    	tempTech += fm.getLink();
	    	tempTech += "\n\n";
	    }
		if (e.getSource() == btnKategoriWorld)
		{
			//textArea_world.setVisible(true);
			//textArea_world.setText(temp);
			textPane_1.setText(temp);
			//textPane_1.setVisible(true);
			scrollPane.setVisible(true);
		    //scrollPane.add(scrollPane);
		} /*else if (e.getSource() == btnKategoriTech)
		{
			textArea_world.setVisible(false);
			textArea_Tech.setVisible(true);
			textArea_Tech.setText(tempTech);
		}*/
		
	}
}