import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Toolkit;

public class MainWin {

	JFrame frmFastFoodBusiness;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frmFastFoodBusiness.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		//Ask for database name from user
		
		//Start the game
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JOptionPane.showMessageDialog(null, "Made by Teamwork of Faraz, Noor, Haris, Ritik",
	               "Welcome in the game",1);
		JOptionPane.showMessageDialog(null, "For More Info about us Visit the website: TechnicalFaraz.com",
	               "TechnicalFaraz.com",1);
		frmFastFoodBusiness = new JFrame();
		frmFastFoodBusiness.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Projects\\Fast Food Business Game\\Assets\\burger-icon.png"));
		frmFastFoodBusiness.setTitle("Fast Food Business Game by Technical Faraz");
		frmFastFoodBusiness.getContentPane().setBackground(new Color(51, 51, 102));
		frmFastFoodBusiness.setBounds(100, 100, 807, 556);
		frmFastFoodBusiness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFastFoodBusiness.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start New Game");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFastFoodBusiness.dispose();
				NewGame.start();
				
			}
		});
		btnStart.setBounds(304, 240, 204, 58);
		frmFastFoodBusiness.getContentPane().add(btnStart);
		
		JButton btnLoad = new JButton("visit our Website");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URL("https://technicalfaraz.com").toURI());
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoad.setBounds(304, 378, 204, 58);
		frmFastFoodBusiness.getContentPane().add(btnLoad);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWin.start();
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHelp.setBounds(304, 309, 204, 58);
		frmFastFoodBusiness.getContentPane().add(btnHelp);
		
		JLabel bannerLbl = new JLabel("");
		bannerLbl.setBackground(Color.LIGHT_GRAY);
		bannerLbl.setBounds(0, 0, 800, 197);
		Image bannerImg = new ImageIcon(this.getClass().getResource("/Banner.png")).getImage();
		bannerLbl.setIcon(new ImageIcon(bannerImg));
		frmFastFoodBusiness.getContentPane().add(bannerLbl);
	}
}
