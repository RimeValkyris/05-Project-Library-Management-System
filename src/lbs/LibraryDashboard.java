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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Added imports for improved table design
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

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
				new ReturnTransactionUI().setVisible(true);
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
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Library Management System");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Oswald", Font.BOLD, 25));
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
		
		JLabel lblNewLabel_1 = new JLabel("LIBRARY DASHBOARD");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(606, 60, 275, 59);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(0, 204, 102));
		panel_2_1_1.setBounds(947, 128, 226, 95);
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
		panel_2_1_1_1.setBounds(625, 128, 226, 95);
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
		panel_2_1_1_1_1.setBounds(315, 128, 226, 95);
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

		// Add Books Table
		JLabel lblBooks = new JLabel("Books List");
		lblBooks.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblBooks.setBounds(315, 272, 100, 20);
		contentPane.add(lblBooks);

		String[] bookColumns = {"Title", "Author", "Genre", "Year"};
		// Non-editable model for books
		DefaultTableModel bookModel = new DefaultTableModel(bookColumns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Header styling moved below after the table is created to avoid using undefined variables
		// Alternate row stripe renderer
		DefaultTableCellRenderer stripeRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (!isSelected) {
					c.setBackground((row % 2 == 0) ? Color.WHITE : new Color(250, 250, 252));
				}
				// center years
				if (column == 3) {
					setHorizontalAlignment(SwingConstants.CENTER);
				} else {
					setHorizontalAlignment(SwingConstants.LEFT);
				}
				return c;
			}
		};

		JScrollPane bookScroll = new JScrollPane();
		bookScroll.setBounds(315, 303, 450, 354);
		contentPane.add(bookScroll);

		// Populate books
		for (Book b : BookManager.instance.getBooks()) {
			bookModel.addRow(new Object[]{
				b.getTitle(),
				b.getAuthor(),
				b.getGenre(),
				String.valueOf(b.getYear())
			});
		}

		// Add Members Table
		JLabel lblMembersTable = new JLabel("Members List");
		lblMembersTable.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMembersTable.setBounds(780, 272, 120, 20);
		contentPane.add(lblMembersTable);

		String[] memberColumns = {"Member ID", "First Name", "Last Name", "Email"};
		// Non-editable model for members
		DefaultTableModel memberModel = new DefaultTableModel(memberColumns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Header styling moved below after the table is created to avoid using undefined variables
		// reuse stripe renderer from above but align first column center
		DefaultTableCellRenderer memRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (!isSelected) {
					c.setBackground((row % 2 == 0) ? Color.WHITE : new Color(250, 250, 252));
				}
				// center ID column
				if (column == 0) {
					setHorizontalAlignment(SwingConstants.CENTER);
				} else {
					setHorizontalAlignment(SwingConstants.LEFT);
				}
				return c;
			}
		};

		JScrollPane memberScroll = new JScrollPane();
		memberScroll.setBounds(775, 303, 450, 354);
		contentPane.add(memberScroll);
		JTable bookTable = new JTable(bookModel);
		// don't add the table directly to the content pane; show it through the scroll pane
		bookTable.setRowHeight(28);
 		bookTable.setFillsViewportHeight(true);
 		bookTable.setShowGrid(false);
 		bookTable.setIntercellSpacing(new Dimension(6, 6));
 		bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		bookTable.setAutoCreateRowSorter(true);
 		JTable memberTable = new JTable(memberModel);
		// don't add the table directly to the content pane; show it through the scroll pane
 		memberTable.setRowHeight(28);
 		memberTable.setFillsViewportHeight(true);
 		memberTable.setShowGrid(false);
 		memberTable.setIntercellSpacing(new Dimension(6, 6));
 		memberTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		memberTable.setAutoCreateRowSorter(true);
		// Header styling for members
		JTableHeader memberHeader = memberTable.getTableHeader();
		memberHeader.setReorderingAllowed(false);
		memberHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));
		memberHeader.setBackground(new Color(245, 245, 245));
		memberTable.setDefaultRenderer(Object.class, memRenderer);
		// column widths
		memberTable.getColumnModel().getColumn(0).setPreferredWidth(90); // ID
		memberTable.getColumnModel().getColumn(1).setPreferredWidth(140); // First
		memberTable.getColumnModel().getColumn(2).setPreferredWidth(140); // Last
		memberTable.getColumnModel().getColumn(3).setPreferredWidth(220); // Email
		// Header styling for books
		JTableHeader booksHeader = bookTable.getTableHeader();
		booksHeader.setReorderingAllowed(false);
		booksHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));
		booksHeader.setBackground(new Color(245, 245, 245));
		bookTable.setDefaultRenderer(Object.class, stripeRenderer);
		// column widths
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(240); // Title
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(160); // Author
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(120); // Genre
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(60);  // Year

		// Show tables inside their scroll panes so headers and data are visible
		bookScroll.setViewportView(bookTable);
		memberScroll.setViewportView(memberTable);

		// Populate members
		for (Member m : MemberManager.instance.getMembers()) {
			memberModel.addRow(new Object[]{
				m.getMemberCode(),
				m.getFirstName(),
				m.getLastName(),
				m.getEmail()
			});
		}
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
