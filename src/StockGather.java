import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

public class StockGather extends JFrame {

	private JPanel contentPane;
	static StockGather frame;
	static boolean toPay = false;
	static	int currBalance = 0;
	static int currDay = 0;
	static int totalAmount; // amount to pay 
	
	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StockGather();
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
	public StockGather() {
		//Database queries
		
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Balance:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(28, 115, 220, 66);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(242, 11, 812, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel f = new JLabel("");
		f.setBounds(10, 0, 170, 134);
		Image bannerImg = new ImageIcon(this.getClass().getResource("/f(1).png")).getImage();
		f.setIcon(new ImageIcon(bannerImg));
		panel.add(f);
		
		JLabel f_1 = new JLabel("");
		f_1.setBounds(10, 144, 170, 134);
		Image bannerImg1 = new ImageIcon(this.getClass().getResource("/f(2).png")).getImage();
		f_1.setIcon(new ImageIcon(bannerImg1));
		panel.add(f_1);
		
		JLabel f_2 = new JLabel("");
		f_2.setBounds(10, 274, 170, 134);
		Image bannerImg2 = new ImageIcon(this.getClass().getResource("/f(3).png")).getImage();
		f_2.setIcon(new ImageIcon(bannerImg2));
		panel.add(f_2);
		
		JLabel f_3 = new JLabel("");
		f_3.setBounds(10, 419, 170, 134);
		Image bannerImg3 = new ImageIcon(this.getClass().getResource("/f(4).png")).getImage();
		f_3.setIcon(new ImageIcon(bannerImg3));
		panel.add(f_3);
		
		JLabel f_4 = new JLabel("");
		f_4.setBounds(346, 467, 144, 134);
		Image bannerImg4 = new ImageIcon(this.getClass().getResource("/f(5).png")).getImage();
		f_4.setIcon(new ImageIcon(bannerImg4));
		panel.add(f_4);
		
		JLabel f_5 = new JLabel("");
		f_5.setBounds(346, 0, 96, 134);
		Image bannerImg5 = new ImageIcon(this.getClass().getResource("/f(6).png")).getImage();
		f_5.setIcon(new ImageIcon(bannerImg5));
		panel.add(f_5);
		
		JLabel f_6 = new JLabel("");
		f_6.setBounds(624, 311, 144, 134);
		Image bannerImg6 = new ImageIcon(this.getClass().getResource("/f(7).png")).getImage();
		f_6.setIcon(new ImageIcon(bannerImg6));
		panel.add(f_6);
		
		JLabel f_7 = new JLabel("");
		f_7.setBounds(624, 0, 144, 134);
		Image bannerImg7 = new ImageIcon(this.getClass().getResource("/f(8).png")).getImage();
		f_7.setIcon(new ImageIcon(bannerImg7));
		panel.add(f_7);
		
		JLabel f_8 = new JLabel("");
		f_8.setBounds(346, 311, 144, 134);
		Image bannerImg8 = new ImageIcon(this.getClass().getResource("/f(9).png")).getImage();
		f_8.setIcon(new ImageIcon(bannerImg8));
		panel.add(f_8);
		
		JLabel f_9 = new JLabel("");
		f_9.setBounds(346, 157, 106, 134);
		Image bannerImg9 = new ImageIcon(this.getClass().getResource("/f(10).png")).getImage();
		f_9.setIcon(new ImageIcon(bannerImg9));
		panel.add(f_9);
		
		JLabel nameLbl = new JLabel("Beef Burger");
		nameLbl.setBounds(190, 11, 109, 23);
		panel.add(nameLbl);
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel priceLbl = new JLabel("price: 700 Rs");
		priceLbl.setBounds(190, 45, 120, 23);
		panel.add(priceLbl);
		priceLbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel disp = new JLabel("Stock");
		disp.setBounds(190, 96, 49, 23);
		panel.add(disp);
		disp.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JSpinner stock = new JSpinner();
		stock.setModel(new SpinnerNumberModel(0, 0, 30, 1));
		stock.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock.setBounds(249, 96, 61, 25);
		panel.add(stock);
		
		JLabel nameLbl_1 = new JLabel("Cheese Burger");
		nameLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLbl_1.setBounds(190, 157, 134, 23);
		panel.add(nameLbl_1);
		
		JLabel priceLbl_1 = new JLabel("price: 600 Rs");
		priceLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_1.setBounds(190, 191, 120, 23);
		panel.add(priceLbl_1);
		
		JLabel disp_1 = new JLabel("Stock");
		disp_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_1.setBounds(190, 234, 49, 23);
		panel.add(disp_1);
		
		JSpinner stock_1 = new JSpinner();
		stock_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_1.setBounds(249, 234, 61, 25);
		panel.add(stock_1);
		
		JLabel lblBbqPizza = new JLabel("BBQ Pizza");
		lblBbqPizza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBbqPizza.setBounds(190, 285, 109, 23);
		panel.add(lblBbqPizza);
		
		JLabel priceLbl_2 = new JLabel("price: 1000 Rs");
		priceLbl_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_2.setBounds(190, 319, 146, 23);
		panel.add(priceLbl_2);
		
		JLabel disp_2 = new JLabel("Stock");
		disp_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_2.setBounds(190, 370, 49, 23);
		panel.add(disp_2);
		
		JSpinner stock_2 = new JSpinner();
		stock_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_2.setBounds(249, 370, 61, 25);
		panel.add(stock_2);
		
		JLabel lblCheesePizza = new JLabel("Cheese Pizza");
		lblCheesePizza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCheesePizza.setBounds(190, 431, 109, 23);
		panel.add(lblCheesePizza);
		
		JLabel priceLbl_3 = new JLabel("price: 1200 Rs");
		priceLbl_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_3.setBounds(190, 465, 134, 23);
		panel.add(priceLbl_3);
		
		JLabel disp_3 = new JLabel("Stock");
		disp_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_3.setBounds(190, 516, 49, 23);
		panel.add(disp_3);
		
		JSpinner stock_3 = new JSpinner();
		stock_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_3.setBounds(249, 516, 61, 25);
		panel.add(stock_3);
		
		JLabel lblCocaCola = new JLabel("Coca Cola");
		lblCocaCola.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCocaCola.setBounds(452, 11, 109, 23);
		panel.add(lblCocaCola);
		
		JLabel priceLbl_4 = new JLabel("price: 80 Rs");
		priceLbl_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_4.setBounds(452, 45, 120, 23);
		panel.add(priceLbl_4);
		
		JLabel disp_4 = new JLabel("Stock");
		disp_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_4.setBounds(452, 96, 49, 23);
		panel.add(disp_4);
		
		JSpinner stock_4 = new JSpinner();
		stock_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_4.setBounds(511, 96, 61, 25);
		panel.add(stock_4);
		
		JLabel lblMilkShake = new JLabel("Milk Shake");
		lblMilkShake.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMilkShake.setBounds(452, 168, 109, 23);
		panel.add(lblMilkShake);
		
		JLabel priceLbl_5 = new JLabel("price: 300 Rs");
		priceLbl_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_5.setBounds(452, 202, 120, 23);
		panel.add(priceLbl_5);
		
		JLabel disp_5 = new JLabel("Stock");
		disp_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_5.setBounds(452, 253, 49, 23);
		panel.add(disp_5);
		
		JSpinner stock_5 = new JSpinner();
		stock_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_5.setBounds(511, 253, 61, 25);
		panel.add(stock_5);
		
		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblIceCream.setBounds(494, 319, 109, 23);
		panel.add(lblIceCream);
		
		JLabel priceLbl_6 = new JLabel("price: 600 Rs");
		priceLbl_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_6.setBounds(494, 353, 120, 23);
		panel.add(priceLbl_6);
		
		JLabel disp_6 = new JLabel("Stock");
		disp_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_6.setBounds(494, 404, 49, 23);
		panel.add(disp_6);
		
		JSpinner stock_6 = new JSpinner();
		stock_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_6.setBounds(553, 404, 61, 25);
		panel.add(stock_6);
		
		JLabel lblPepse = new JLabel("Pepsi");
		lblPepse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPepse.setBounds(500, 479, 109, 23);
		panel.add(lblPepse);
		
		JLabel priceLbl_7 = new JLabel("price: 100 Rs");
		priceLbl_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_7.setBounds(500, 513, 114, 23);
		panel.add(priceLbl_7);
		
		JLabel disp_7 = new JLabel("Stock");
		disp_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_7.setBounds(500, 564, 49, 23);
		panel.add(disp_7);
		
		JSpinner stock_7 = new JSpinner();
		stock_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_7.setBounds(559, 564, 61, 25);
		panel.add(stock_7);
		
		JLabel lblSalad = new JLabel("Salad");
		lblSalad.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSalad.setBounds(634, 144, 109, 23);
		panel.add(lblSalad);
		
		JLabel priceLbl_8 = new JLabel("price: 500 Rs");
		priceLbl_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_8.setBounds(634, 178, 120, 23);
		panel.add(priceLbl_8);
		
		JLabel disp_8 = new JLabel("Stock");
		disp_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_8.setBounds(634, 212, 49, 23);
		panel.add(disp_8);
		
		JSpinner stock_8 = new JSpinner();
		stock_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_8.setBounds(693, 212, 61, 25);
		panel.add(stock_8);
		
		JLabel lblPasta = new JLabel("Pasta");
		lblPasta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPasta.setBounds(634, 456, 109, 23);
		panel.add(lblPasta);
		
		JLabel priceLbl_9 = new JLabel("price: 400 Rs");
		priceLbl_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceLbl_9.setBounds(634, 490, 120, 23);
		panel.add(priceLbl_9);
		
		JLabel disp_9 = new JLabel("Stock");
		disp_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		disp_9.setBounds(634, 528, 49, 23);
		panel.add(disp_9);
		
		JSpinner stock_9 = new JSpinner();
		stock_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stock_9.setBounds(693, 528, 61, 25);
		panel.add(stock_9);
		
		JLabel currMoney = new JLabel(Integer.toString(currBalance));
		currMoney.setFont(new Font("Tahoma", Font.PLAIN, 25));
		currMoney.setBounds(28, 175, 220, 66);
		contentPane.add(currMoney);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Shopping:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(28, 273, 220, 66);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel totalShop = new JLabel("0");
		totalShop.setFont(new Font("Tahoma", Font.PLAIN, 25));
		totalShop.setBounds(28, 331, 220, 66);
		contentPane.add(totalShop);
		
		JLabel dayLbl = new JLabel(Integer.toString(currDay));
		dayLbl.setFont(new Font("Segoe UI Black", Font.PLAIN, 37));
		dayLbl.setBounds(108, 11, 124, 66);
		contentPane.add(dayLbl);
		
		JSpinner stocks[] = {stock,stock_1,stock_2,stock_3,stock_7,stock_4,stock_9,stock_8,stock_6,stock_5};
		
		JButton checkAmountBtn = new JButton("Check total money");
		checkAmountBtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		checkAmountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "truncate table stocks";
					Database.st.executeUpdate(query);
					totalAmount = 0;
					for(int i =0; i <10; i++) {
						int quantityOfItems = Integer.parseInt(stocks[i].getValue().toString());
						if(quantityOfItems != 0) {
							query = "insert into stocks values ("+(i+1)+","+quantityOfItems+")" ;
							Database.st.executeUpdate(query);
						}
						totalAmount += (Integer.parseInt(Database.fprice[i]) * quantityOfItems);
					}
					totalShop.setText(Integer.toString(totalAmount));
					toPay = true;
				}catch(Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		checkAmountBtn.setBounds(28, 452, 206, 47);
		contentPane.add(checkAmountBtn);
		
		JButton payAmountBtn = new JButton("Pay the amount");
		payAmountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toPay == true) {
					if(currBalance > totalAmount) {
						currBalance -= totalAmount;
						try {
							String query = "update players set bal = "+currBalance;
							Database.st.executeUpdate(query);
						}catch(Exception e2) {
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Thanks for your payment now you have "+currBalance+" Rs in your account!",
					               "Click on the check payment button",1);
						frame.dispose();
						Selling.start();
						toPay = false;
					}
					else {
						JOptionPane.showMessageDialog(null, "You haven't enough money to pay",
					               "Click on the check payment button",2);
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "You have to check the payment before paying",
				               "Click on the check payment button",2);
				}
			}
		});
		payAmountBtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		payAmountBtn.setBounds(28, 510, 204, 47);
		contentPane.add(payAmountBtn);
		
		JLabel lable1 = new JLabel("DAY");
		lable1.setFont(new Font("Segoe UI Black", Font.PLAIN, 37));
		lable1.setBounds(10, 11, 93, 66);
		contentPane.add(lable1);
	}
}
