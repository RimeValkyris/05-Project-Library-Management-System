package lbs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;

public class LibraryDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LibraryDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 592);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 246, 456);
		panel.setBackground(new Color(30, 41, 59));
		contentPane.add(panel);
		panel.setLayout(null);
		
		// sidebar button style shared settings
		Font btnFont = new Font("Segoe UI", Font.PLAIN, 14);
		Color btnBg = new Color(55, 65, 81);
		Color btnHoverBg = new Color(64, 75, 95);
		Color btnFg = Color.WHITE;
		int btnWidth = 180;
		int btnX = (246 - btnWidth) / 2; // center horizontally inside panel
		
		JButton btnManage = new JButton("Manage Books");
		btnManage.setBounds(btnX, 40, btnWidth, 40);
		btnManage.setFont(btnFont);
		btnManage.setBackground(btnBg);
		btnManage.setForeground(btnFg);
		btnManage.setFocusPainted(false);
		btnManage.setBorderPainted(false);
		btnManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManage.setOpaque(true);
		panel.add(btnManage);
		
		JButton btnIssue = new JButton("Issue Books");
		btnIssue.setBounds(btnX, 100, btnWidth, 40);
		btnIssue.setFont(btnFont);
		btnIssue.setBackground(btnBg);
		btnIssue.setForeground(btnFg);
		btnIssue.setFocusPainted(false);
		btnIssue.setBorderPainted(false);
		btnIssue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIssue.setOpaque(true);
		panel.add(btnIssue);
		
		JButton btnReturn = new JButton("Return Books");
		btnReturn.setBounds(btnX, 160, btnWidth, 40);
		btnReturn.setFont(btnFont);
		btnReturn.setBackground(btnBg);
		btnReturn.setForeground(btnFg);
		btnReturn.setFocusPainted(false);
		btnReturn.setBorderPainted(false);
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setOpaque(true);
		panel.add(btnReturn);
		
		JButton btnMember = new JButton("Member Management");
		btnMember.setBounds(btnX, 220, btnWidth, 40);
		btnMember.setFont(btnFont);
		btnMember.setBackground(btnBg);
		btnMember.setForeground(btnFg);
		btnMember.setFocusPainted(false);
		btnMember.setBorderPainted(false);
		btnMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMember.setOpaque(true);
		panel.add(btnMember);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(btnX, 280, btnWidth, 40);
		btnLogout.setFont(btnFont);
		btnLogout.setBackground(btnBg);
		btnLogout.setForeground(btnFg);
		btnLogout.setFocusPainted(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setOpaque(true);
		panel.add(btnLogout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(btnX, 340, btnWidth, 40);
		btnExit.setFont(btnFont);
		btnExit.setBackground(btnBg);
		btnExit.setForeground(btnFg);
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setOpaque(true);
		panel.add(btnExit);
		
		// simple hover effect (light-weight) using anonymous listeners
		// keep these minimal so we don't need extra imports or utilities
		btnManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnManage.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnManage.setBackground(btnBg); }
		});
		btnIssue.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnIssue.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnIssue.setBackground(btnBg); }
		});
		btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnReturn.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnReturn.setBackground(btnBg); }
		});
		btnMember.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnMember.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnMember.setBackground(btnBg); }
		});
		btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnLogout.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnLogout.setBackground(btnBg); }
		});
		btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { btnExit.setBackground(btnHoverBg); }
			public void mouseExited(java.awt.event.MouseEvent evt) { btnExit.setBackground(btnBg); }
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1271, 49);
		panel_1.setBackground(new Color(79, 70, 229));
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 504, 1271, 49);
		panel_1_1.setBackground(new Color(79, 70, 229));
		contentPane.add(panel_1_1);

	}

	
}