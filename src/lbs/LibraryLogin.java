package lbs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LibraryLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryLogin frame = new LibraryLogin();
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
	public LibraryLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 487);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// white background like the mockup
		contentPane.setBackground(Color.WHITE);
		
		// Large centered heading
		lblNewLabel_1 = new JLabel("Welcome!");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(502, 64, 265, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(482, 144, 285, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		// wider rounded text field
		textField.setBounds(482, 169, 285, 28);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		textField.setBackground(Color.WHITE);
		textField.setOpaque(true);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPassword.setBounds(482, 219, 285, 20);
		contentPane.add(lblPassword);
		
		// use JPasswordField for password input
		textField_1 = new JPasswordField();
		textField_1.setBounds(482, 239, 285, 28);
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		textField_1.setBackground(Color.WHITE);
		textField_1.setOpaque(true);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		// match text fields width and use a large rounded gray button
		btnNewButton.setBounds(511, 299, 223, 28);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(230, 230, 230));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		btnNewButton.setOpaque(true);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// simple show welcome on successful login
				String user = textField.getText();
				String pass = new String(textField_1.getPassword());
				if ("admin".equals(user) && "password".equals(pass)) {
					LibraryDashboard ld = new LibraryDashboard();
					ld.setVisible(true);
					dispose();
				}
			}
		});

	}
}