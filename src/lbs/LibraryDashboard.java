package lbs;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.BasicStroke; // added for optional border
import java.awt.geom.RoundRectangle2D; // added for rounded corners
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private int totalBooks;
	private int issuedBooks;
	private int members;
	
	
	
	private JLabel lblTotalBooksCount;
	private JLabel lblIssuedBooksCount;
	private JLabel lblMembersCount;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LibraryDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1287, 756);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 246, 621);
		panel.setBackground(new Color(30, 41, 59));
		contentPane.add(panel);
		panel.setLayout(null);
		
		// sidebar button style shared settings
		Font btnFont = new Font("Segoe UI", Font.PLAIN, 14);
		Color btnBg = new Color(55, 65, 81);
		Color btnHoverBg = new Color(64, 75, 95);
		Color btnFg = Color.WHITE;
		int btnWidth = 180;

		
		JButton btnManage = new JButton("Manage Books");
		btnManage.setBounds(32, 119, btnWidth, 40);
		btnManage.setFont(btnFont);
		btnManage.setBackground(btnBg);
		btnManage.setForeground(btnFg);
		btnManage.setFocusPainted(false);
		btnManage.setBorderPainted(false);
		btnManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManage.setOpaque(true);
		panel.add(btnManage);
		
		JButton btnIssue = new JButton("Issue Books");
		btnIssue.setBounds(32, 179, btnWidth, 40);
		btnIssue.setFont(btnFont);
		btnIssue.setBackground(btnBg);
		btnIssue.setForeground(btnFg);
		btnIssue.setFocusPainted(false);
		btnIssue.setBorderPainted(false);
		btnIssue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIssue.setOpaque(true);
		panel.add(btnIssue);
		
		JButton btnReturn = new JButton("Return Books");
		btnReturn.setBounds(32, 239, btnWidth, 40);
		btnReturn.setFont(btnFont);
		btnReturn.setBackground(btnBg);
		btnReturn.setForeground(btnFg);
		btnReturn.setFocusPainted(false);
		btnReturn.setBorderPainted(false);
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setOpaque(true);
		panel.add(btnReturn);
		
		JButton btnMember = new JButton("Member Management");
		btnMember.setBounds(32, 299, btnWidth, 40);
		btnMember.setFont(btnFont);
		btnMember.setBackground(btnBg);
		btnMember.setForeground(btnFg);
		btnMember.setFocusPainted(false);
		btnMember.setBorderPainted(false);
		btnMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMember.setOpaque(true);
		panel.add(btnMember);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(32, 359, btnWidth, 40);
		btnLogout.setFont(btnFont);
		btnLogout.setBackground(btnBg);
		btnLogout.setForeground(btnFg);
		btnLogout.setFocusPainted(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setOpaque(true);
		panel.add(btnLogout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(32, 419, btnWidth, 40);
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
		
		// Action listener for Manage Books button
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ManageBooks().setVisible(true);
			}
		});
		
		// Action listener for Issue Books button
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BorrowTransactionUI().setVisible(true);
			}
		});
		
		// Action listener for Return Books button
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReturnTransaction().setVisible(true);
			}
		});
		
		// Action listener for Member Management button
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberManagement().setVisible(true);
			}
		});
		
		// Action listener for Logout button
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LibraryLogin().setVisible(true);
			}
		});
		
		// Action listener for Exit button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1271, 49);
		panel_1.setBackground(new Color(79, 70, 229));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Library Management System");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Oswald", Font.BOLD, 25));
		lblNewLabel_5.setBounds(10, 11, 402, 27);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 668, 1271, 49);
		panel_1_1.setBackground(new Color(79, 70, 229));
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("University of Ruina");
		lblNewLabel_5_1.setBounds(1100, 11, 161, 27);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Oswald", Font.BOLD, 21));
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel = new JLabel();
		// banner size: keep in sync with setBounds below
		int bannerW = 1025;
		int bannerH = 188;
		lblNewLabel.setBounds(245, 48, 1058, 188);
		// attempt to load the image from classpath first, fallback to Images/ folder on disk
		String imgResourcePath = "/Images/SchoolLibraryLoginIn.jpg";
		ImageIcon icon = null;
		java.net.URL imgUrl = getClass().getResource(imgResourcePath);
		if (imgUrl != null) {
			icon = new ImageIcon(imgUrl);
		} else {
			java.io.File f = new java.io.File("Images/SchoolLibraryLoginIn.jpg");
			if (f.exists()) {
				icon = new ImageIcon(f.getAbsolutePath());
			}
		}
		if (icon != null) {
			// COVER mode: scale to fill the banner area and crop overflow (no stretching)
			Image srcImg = icon.getImage();
			int srcW = srcImg.getWidth(null);
			int srcH = srcImg.getHeight(null);
			if (srcW > 0 && srcH > 0) {
				double scale = Math.max((double) bannerW / srcW, (double) bannerH / srcH);
				int destW = Math.max(1, (int) Math.round(srcW * scale));
				int destH = Math.max(1, (int) Math.round(srcH * scale));
				int x = (bannerW - destW) / 2;
				int y = (bannerH - destH) / 2;
				BufferedImage canvas = new BufferedImage(bannerW, bannerH, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = canvas.createGraphics();
				try {
					// high quality rendering hints
					g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
					g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					// rounded clip and background
					float arc = 24f; // corner radius
					RoundRectangle2D.Float round = new RoundRectangle2D.Float(0, 0, bannerW, bannerH, arc, arc);
					// fill rounded background
					g2.setColor(Color.WHITE);
					g2.fill(round);
					// set clip to rounded area so image is drawn with smooth rounded corners
					java.awt.Shape oldClip = g2.getClip();
					g2.setClip(round);
					// draw scaled image (may be larger than canvas so it crops automatically)
					g2.drawImage(srcImg, x, y, destW, destH, null);
					// restore clip
					g2.setClip(oldClip);
					// optional subtle border around rounded image
					g2.setStroke(new BasicStroke(1.5f));
					g2.setColor(new Color(200, 200, 200, 180));
					g2.draw(round);
				} finally {
					g2.dispose();
				}
				lblNewLabel.setIcon(new ImageIcon(canvas));
			} else {
				// fallback: use original icon if we couldn't measure it
				lblNewLabel.setIcon(icon);
			}
		} else {
			lblNewLabel.setText("Banner image not found");
			lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		}
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LIBRARY DASHBOARD");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(608, 225, 275, 59);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(0, 204, 102));
		panel_2_1_1.setBounds(941, 296, 226, 95);
		contentPane.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Members");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_4.setBounds(80, 11, 70, 14);
		panel_2_1_1.add(lblNewLabel_4);
		
		lblMembersCount = new JLabel("0");
		lblMembersCount.setForeground(Color.WHITE);
		lblMembersCount.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
		lblMembersCount.setBounds(103, 36, 77, 30);
		panel_2_1_1.add(lblMembersCount);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBackground(new Color(255, 153, 51));
		panel_2_1_1_1.setBounds(618, 295, 226, 95);
		contentPane.add(panel_2_1_1_1);
		panel_2_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Issued Books");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_3.setBounds(69, 11, 96, 22);
		panel_2_1_1_1.add(lblNewLabel_3);
		
		lblIssuedBooksCount = new JLabel("0");
		lblIssuedBooksCount.setForeground(Color.WHITE);
		lblIssuedBooksCount.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
		lblIssuedBooksCount.setBounds(106, 34, 48, 30);
		panel_2_1_1_1.add(lblIssuedBooksCount);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setBackground(new Color(51, 153, 255));
		panel_2_1_1_1_1.setBounds(315, 296, 226, 95);
		contentPane.add(panel_2_1_1_1_1);
		panel_2_1_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Books");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_2.setBounds(70, 11, 89, 22);
		panel_2_1_1_1_1.add(lblNewLabel_2);
		
		lblTotalBooksCount = new JLabel("0");
		lblTotalBooksCount.setForeground(Color.WHITE);
		lblTotalBooksCount.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
		lblTotalBooksCount.setBounds(102, 34, 49, 30);
		panel_2_1_1_1_1.add(lblTotalBooksCount);
		
		updateStatistics();
		contentPane.revalidate();
		contentPane.repaint();

	}
	
	public void updateStatistics() {
		totalBooks = BookManager.instance.getBookCount();
		// Assuming issued books count is not yet tracked, defaulting to 0
		issuedBooks = BookManager.instance.getIssuedBookCount(); 
		members = MemberManager.instance.getMemberCount();

		lblTotalBooksCount.setText(String.valueOf(getTotalBooks()));
		lblIssuedBooksCount.setText(String.valueOf(getIssuedBooks()));
		lblMembersCount.setText(String.valueOf(getTotalMembers()));
	}

	public int getTotalBooks() {
		return totalBooks;
	}

	public int getIssuedBooks() {
		return issuedBooks;
	}

	public int getTotalMembers() {
		return members;
	}
}
