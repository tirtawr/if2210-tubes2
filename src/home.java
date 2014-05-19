import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import RSS.slidinglayout.SLAnimator;


public class home implements ActionListener{

	public JFrame frame1;
	JButton btnClick;
	JLabel label;
	JPanel panel2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window1 = new home();
					window1.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public home() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	
	private void initialize() throws IOException {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(1024, 750);
		frame1.getContentPane().setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 1366, 750);
		frame1.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		btnClick = new JButton("CLICK");
		btnClick.setIcon(new ImageIcon("C:\\Users\\Windy Amelia\\Desktop\\home.png"));
		btnClick.setForeground(Color.RED);
		btnClick.setBackground(Color.WHITE);
		btnClick.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClick.setBounds(413, 562, 130, 45);
		btnClick.addActionListener(this);
		panel2.add(btnClick);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\itb\\OOP\\TUBES 2\\home.png"));
		label.setBounds(0, 0, 1366, 750);
		panel2.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClick){
			SLAnimator.start();

			TheFrame frame = new TheFrame();
			frame.setSize(1024, 700);
			frame.setLocationRelativeTo(null);
			//frame.setVisible(true);
			//NewWindow window1 = new NewWindow();
			//ThePanel tes = new ThePanel();
			frame1.getContentPane().removeAll();
			frame1 = frame;
			//frame1.getContentPane().add(tes);
			frame1.repaint();
		}
	}
}
