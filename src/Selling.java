import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.JTable;

public class Selling extends JFrame {

	private JPanel contentPane;
	static Selling frame;
	public static Random r;
	final public int totalItemsInOrder = 3;
	final public int totalItems = 10;
	private static JTable table;
	static	int currBalance = 0;
	static int currDay = 0;
	static int orderLeft;
	static int earningOnDay;
	static int currOrders[] = new int[3];
	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderLeft =10;
					earningOnDay = 0;
					r = new Random();
					frame = new Selling();
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
		
		try {
			String query = "Select * from players";
			Database.st = Database.conn.createStatement();
			ResultSet rs = Database.st.executeQuery(query);
			rs.next();
			currBalance = rs.getInt(3);
			currDay = rs.getInt(4);
		}catch(Exception e) {
			e.printStackTrace();
		}
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dateLbl = new JLabel(Integer.toString(currDay));
		dateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateLbl.setFont(new Font("Tahoma", Font.PLAIN, 31));
		dateLbl.setBounds(145, 46, 75, 54);
		contentPane.add(dateLbl);
		
		JLabel lbl = new JLabel("Account Balance");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl.setBounds(41, 111, 199, 54);
		contentPane.add(lbl);
		
		JLabel amountBalance = new JLabel(Integer.toString(currBalance));
		amountBalance.setFont(new Font("Tahoma", Font.PLAIN, 31));
		amountBalance.setBounds(41, 163, 199, 54);
		contentPane.add(amountBalance);
		
		JLabel lblEarning = new JLabel("Earning");
		lblEarning.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblEarning.setBounds(37, 277, 199, 54);
		contentPane.add(lblEarning);
		
		JLabel earningMoney = new JLabel(Integer.toString(earningOnDay));
		earningMoney.setFont(new Font("Tahoma", Font.PLAIN, 31));
		earningMoney.setBounds(37, 325, 199, 54);
		contentPane.add(earningMoney);
		
		JLabel ordersLeft = new JLabel(Integer.toString(orderLeft));
		ordersLeft.setFont(new Font("Tahoma", Font.PLAIN, 38));
		ordersLeft.setBounds(37, 426, 60, 54);
		contentPane.add(ordersLeft);
		

		JLabel item[] = new JLabel[3];
		for(int i = 0; i < 3; i++) {
			item[i] =new JLabel("");
			item[i].setBackground(Color.ORANGE);
			item[i].setBounds(314 + 190*i, 38, 151, 149);
			contentPane.add(item[i]);	
		}
		
		JButton btnNewButton = new JButton("Give Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<3; i++) {
					int curr = currOrders[i];
					currOrders[i] = 0; 	//to remove the items from order
					if(curr != 0) {
						try {
							String query = "Select * from stocks where fid ="+curr;
							Database.st = Database.conn.createStatement();
							ResultSet rs = Database.st.executeQuery(query);	
							if(rs.next() == true) {
								int price = Integer.parseInt(Database.fprice[curr-1]);
								earningOnDay += price + price*0.3;
								query = "update stocks set amount =" +Integer.toString(rs.getInt(2) -1)+"where fid = "+curr+ "AND amount != 0";
								Database.st.executeUpdate(query);
								query = "delete stocks where amount = 0";
								Database.st.executeUpdate(query);
								
								item[i].setVisible(false);
							}
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				earningMoney.setText(Integer.toString(earningOnDay));
				printTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(611, 217, 199, 63);
		contentPane.add(btnNewButton);
		
		
		
		JButton generateOrder = new JButton("Get Order!");
		generateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderLeft > 0) {
					orderLeft -=1;
					ordersLeft.setText(Integer.toString(orderLeft));
					int itemsInOrder = r.nextInt(totalItemsInOrder + 1);
					for(int i = 0; i < itemsInOrder; i++) {
						String pic = Integer.toString(r.nextInt(totalItems)+1);
						currOrders[i] = Integer.parseInt(pic);
						System.out.println(currOrders[i]);
						Image bannerImg = new ImageIcon(this.getClass().getResource("/f("+pic+").png")).getImage();
						item[i].setIcon(new ImageIcon(bannerImg));
						item[i].setVisible(true);
					}
					for(int i = itemsInOrder;i < 3;i++) {
						item[i].setVisible(false);
						currOrders[i] = 0;
					}
				}
			}
		});
		generateOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		generateOrder.setBounds(388, 217, 199, 63);
		contentPane.add(generateOrder);
		
		JLabel lblNewLabel = new JLabel("Orders Left");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(96, 426, 174, 54);
		contentPane.add(lblNewLabel);
		
		
		table = new JTable();
		table.setBounds(388, 325, 422, 159);
		contentPane.add(table);
		
		
			printTable();
			JLabel lblDay = new JLabel("Day");
			lblDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblDay.setFont(new Font("Tahoma", Font.PLAIN, 31));
			lblDay.setBounds(20, 46, 199, 54);
			contentPane.add(lblDay);
			
			JButton btnNewButton_1 = new JButton("Start Next Day");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						currDay += 1;
						currBalance += earningOnDay;
						String query = "update players set day = "+currDay+",bal ="+currBalance;
						Database.st.executeUpdate(query);
						if(StockGather.totalAmount > earningOnDay) {
							JOptionPane.showMessageDialog(null, "You have a lose of "+Integer.toString(StockGather.totalAmount - earningOnDay)+" Rs",
						               "Lose On this Day",2);
						}else {
							JOptionPane.showMessageDialog(null, "You have a profit of "+Integer.toString(earningOnDay - StockGather.totalAmount)+" Rs",
						               "Profit On this Day",1);
						}
						frame.dispose();
						StockGather.start();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnNewButton_1.setBounds(47, 491, 223, 35);
			contentPane.add(btnNewButton_1);
		
	}
	public static void printTable() {
		try {
			String query = 
					"select f.fname Item_name, (f.price + f.price*0.3) selling_price, s.amount from items f, stocks s where f.fid = s.fid";
			PreparedStatement pst = Database.conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
