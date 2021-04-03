import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Selling extends JFrame {

	private JPanel contentPane;
	public static Random r;
	final public int totalItemsInOrder = 3;
	final public int totalItems = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					r = new Random();
					Selling frame = new Selling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Selling() {
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dateLbl = new JLabel("Day 1");
		dateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateLbl.setFont(new Font("Tahoma", Font.PLAIN, 31));
		dateLbl.setBounds(37, 78, 199, 54);
		contentPane.add(dateLbl);
		
		JLabel lbl = new JLabel("Account Balance");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl.setBounds(37, 165, 199, 54);
		contentPane.add(lbl);
		
		JLabel amountBalance = new JLabel("price");
		amountBalance.setFont(new Font("Tahoma", Font.PLAIN, 31));
		amountBalance.setBounds(37, 217, 199, 54);
		contentPane.add(amountBalance);
		
		JLabel lblEarning = new JLabel("Earning");
		lblEarning.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblEarning.setBounds(37, 331, 199, 54);
		contentPane.add(lblEarning);
		
		JLabel earningMoney = new JLabel("price");
		earningMoney.setFont(new Font("Tahoma", Font.PLAIN, 31));
		earningMoney.setBounds(33, 379, 199, 54);
		contentPane.add(earningMoney);
		
		JButton btnNewButton = new JButton("Give Order");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(498, 359, 199, 63);
		contentPane.add(btnNewButton);
		
		JLabel item[] = new JLabel[3];
		for(int i = 0; i < 3; i++) {
			item[i] =new JLabel("");
			item[i].setBackground(Color.ORANGE);
			item[i].setBounds(314 + 190*i, 38, 151, 149);
			contentPane.add(item[i]);	
		}
		
		
		JButton generateOrder = new JButton("Get Order!");
		generateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemsInOrder = r.nextInt(totalItemsInOrder + 1);
				for(int i = 0; i < itemsInOrder; i++) {
					String pic = Integer.toString(r.nextInt(totalItems)+1);
					Image bannerImg = new ImageIcon(this.getClass().getResource("/f("+pic+").png")).getImage();
					item[i].setIcon(new ImageIcon(bannerImg));
					item[i].setVisible(true);
				}
				for(int i = itemsInOrder;i < 3;i++) {
					item[i].setVisible(false);
				}
			}
		});
		generateOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		generateOrder.setBounds(388, 217, 199, 63);
		contentPane.add(generateOrder);
		
		JLabel lblNewLabel = new JLabel("Orders Left");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(671, 217, 174, 54);
		contentPane.add(lblNewLabel);
		
		JLabel ordersLeft = new JLabel("10");
		ordersLeft.setFont(new Font("Tahoma", Font.PLAIN, 38));
		ordersLeft.setBounds(612, 217, 60, 54);
		contentPane.add(ordersLeft);
	}
}
