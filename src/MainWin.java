import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 102));
		frame.setBounds(100, 100, 807, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start New Game");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(304, 240, 204, 58);
		frame.getContentPane().add(btnStart);
		
		JButton btnLoad = new JButton("Load the Game");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoad.setBounds(304, 320, 204, 58);
		frame.getContentPane().add(btnLoad);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHelp.setBounds(304, 397, 204, 58);
		frame.getContentPane().add(btnHelp);
		
		JLabel bannerLbl = new JLabel("");
		bannerLbl.setBackground(Color.LIGHT_GRAY);
		bannerLbl.setBounds(0, 0, 800, 197);
		Image bannerImg = new ImageIcon(this.getClass().getResource("/Banner.png")).getImage();
		bannerLbl.setIcon(new ImageIcon(bannerImg));
		frame.getContentPane().add(bannerLbl);
		
		JLabel lblNewLabel_1 = new JLabel("Made By Team Work:\r\nFaraz (05)\r\nHaris (23)\r\nNoor (24)\r\nRitik (103)");
		lblNewLabel_1.setBounds(561, 208, 167, 247);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("burger pic");
		lblNewLabel_2.setBounds(10, 208, 284, 247);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
