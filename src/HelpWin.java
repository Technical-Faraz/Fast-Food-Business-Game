import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class HelpWin extends JFrame {

	private JPanel contentPane;
	static HelpWin frame;
	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HelpWin();
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
	public HelpWin() {
		setTitle("Help");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Projects\\Fast Food Business Game\\Assets\\burger-icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How to Play The Game");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(115, 11, 472, 65);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrSadsa = new JTextArea();
		txtrSadsa.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrSadsa.setText("1. You have to take loan from the bank to start your business.\r\n\r\n2. You have to pay your loan after passing 4 days of your business otherwise \r\n    you will lose the game.\r\n\r\n3. Each day consists of having 10 orders.\r\n\r\n4. You have to buy the food stock before starting the day.and don't buy too \r\n     much because your stock can only be used for one day.\r\n\r\n5. Remaining stock at the last of the day will be counted as your lose.\r\n\r\n6. Each order has min 0 itmes and max 3 items which generates randomly.\r\n\r\n7. You will have 40% of profit rate on each item.\r\n\r\n8. After 4 days, if you are able to pay loan then you will win and the remaining \r\n    amount wil be your high score.\r\n");
		txtrSadsa.setEditable(false);
		txtrSadsa.setBounds(44, 87, 659, 361);
		contentPane.add(txtrSadsa);
	}
}
