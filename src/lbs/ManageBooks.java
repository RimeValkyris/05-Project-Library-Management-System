package lbs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ManageBooks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	
	// List to store book objects
	public static List<Book> bookList = new ArrayList<>();
	
	static {
		// Add initial books
		bookList.add(new Book("978-0156012195", "The Little Prince", 
			"Antoine de Saint-Exupéry", "Children's Literature", "Reynal & Hitchcock", 1943));
		bookList.add(new Book("978-0141439760", "Alice's Adventures in Wonderland", 
			"Lewis Carroll", "Fantasy", "Macmillan", 1865));
		bookList.add(new Book("978-0451524935", "1984", 
			"George Orwell", "Dystopian Fiction", "Secker & Warburg", 1949));
	}
	
	// Update mode variables
	private boolean isUpdateMode = false;
	private int updateIndex = -1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ManageBooks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1287, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(635, 10, 1, 1);
		panel.setLayout(null);
		panel.setBackground(new Color(30, 41, 59));
		contentPane.add(panel);
		
		JButton btnManage = new JButton("Manage Books");
		btnManage.setOpaque(true);
		btnManage.setForeground(Color.WHITE);
		btnManage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnManage.setFocusPainted(false);
		btnManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManage.setBorderPainted(false);
		btnManage.setBackground(new Color(55, 65, 81));
		btnManage.setBounds(32, 119, 180, 40);
		panel.add(btnManage);
		
		JButton btnIssue = new JButton("Issue Books");
		btnIssue.setOpaque(true);
		btnIssue.setForeground(Color.WHITE);
		btnIssue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnIssue.setFocusPainted(false);
		btnIssue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIssue.setBorderPainted(false);
		btnIssue.setBackground(new Color(55, 65, 81));
		btnIssue.setBounds(32, 179, 180, 40);
		panel.add(btnIssue);
		
		JButton btnReturn = new JButton("Return Books");
		btnReturn.setOpaque(true);
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnReturn.setFocusPainted(false);
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setBorderPainted(false);
		btnReturn.setBackground(new Color(55, 65, 81));
		btnReturn.setBounds(32, 239, 180, 40);
		panel.add(btnReturn);
		
		JButton btnMember = new JButton("Member Management");
		btnMember.setOpaque(true);
		btnMember.setForeground(Color.WHITE);
		btnMember.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMember.setFocusPainted(false);
		btnMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMember.setBorderPainted(false);
		btnMember.setBackground(new Color(55, 65, 81));
		btnMember.setBounds(32, 299, 180, 40);
		panel.add(btnMember);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setOpaque(true);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLogout.setFocusPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(55, 65, 81));
		btnLogout.setBounds(32, 359, 180, 40);
		panel.add(btnLogout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setOpaque(true);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnExit.setFocusPainted(false);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(55, 65, 81));
		btnExit.setBounds(32, 419, 180, 40);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 41, 59));
		panel_1.setBounds(0, 49, 412, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 67, 131, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 116, 56, 20);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(97, 119, 257, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Title");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 167, 83, 20);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 170, 257, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Author");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 216, 56, 20);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 219, 257, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 275, 257, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Genre");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 271, 83, 23);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Year");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 371, 83, 20);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 322, 257, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Publisher");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBounds(10, 322, 83, 20);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 374, 257, 20);
		panel_1.add(textField_5);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the table model
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				// Get text from input fields
				String isbn = textField.getText().trim();
				String title = textField_1.getText().trim();
				String author = textField_2.getText().trim();
				String genre = textField_3.getText().trim();
				String publisher = textField_4.getText().trim();
				String year = textField_5.getText().trim();
				
				// Validate input - check if all fields are filled
				if (isbn.isEmpty() || title.isEmpty() || author.isEmpty() || 
					genre.isEmpty() || publisher.isEmpty() || year.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Please fill in all fields!", "Input Error", 
						javax.swing.JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Validate year is a number
				try {
					Integer.parseInt(year);
				} catch (NumberFormatException ex) {
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Year must be a valid number!", "Input Error", 
						javax.swing.JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Create new book object
				Book newBook = new Book(isbn, title, author, genre, publisher, Integer.parseInt(year));
				bookList.add(newBook);
				
				// Add new row to table with status
				String status = newBook.isAvailable() ? "Available" : "Checked Out";
				model.addRow(new Object[]{isbn, title, author, genre, publisher, year, status});
				
				// Clear input fields after adding
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
				// Show success message
				javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
					"Book added successfully!", "Success", 
					javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnAdd.setFocusPainted(false);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(new Color(55, 65, 81));
		btnAdd.setBounds(30, 439, 74, 40);
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Please select a book to delete!", "Selection Error", 
						javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Get confirmation
				int confirm = javax.swing.JOptionPane.showConfirmDialog(ManageBooks.this, 
					"Are you sure you want to delete this book?", "Confirm Delete", 
					javax.swing.JOptionPane.YES_NO_OPTION);
				
				if (confirm == javax.swing.JOptionPane.YES_OPTION) {
					// Remove from list and table
					bookList.remove(selectedRow);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(selectedRow);
					
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Book deleted successfully!", "Success", 
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDelete.setFocusPainted(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(55, 65, 81));
		btnDelete.setBounds(263, 439, 74, 40);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isUpdateMode) {
					// Load mode: Get selected book and populate fields
					int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
						javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
							"Please select a book to update!", "Selection Error", 
							javax.swing.JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					// Get the book from the list
					Book selectedBook = bookList.get(selectedRow);
					
					// Populate text fields with book data
					textField.setText(selectedBook.getIsbn());
					textField_1.setText(selectedBook.getTitle());
					textField_2.setText(selectedBook.getAuthor());
					textField_3.setText(selectedBook.getGenre());
					textField_4.setText(selectedBook.getPublisher());
					textField_5.setText(String.valueOf(selectedBook.getYear()));
					
					// Set update mode
					isUpdateMode = true;
					updateIndex = selectedRow;
					btnUpdate.setText("Save Update");
					
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Edit the book details and click 'Save Update' to confirm changes.", 
						"Update Mode", 
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Save mode: Update the book with new data
					String isbn = textField.getText().trim();
					String title = textField_1.getText().trim();
					String author = textField_2.getText().trim();
					String genre = textField_3.getText().trim();
					String publisher = textField_4.getText().trim();
					String year = textField_5.getText().trim();
					
					// Validate input
					if (isbn.isEmpty() || title.isEmpty() || author.isEmpty() || 
						genre.isEmpty() || publisher.isEmpty() || year.isEmpty()) {
						javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
							"Please fill in all fields!", "Input Error", 
							javax.swing.JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// Validate year is a number
					try {
						Integer.parseInt(year);
					} catch (NumberFormatException ex) {
						javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
							"Year must be a valid number!", "Input Error", 
							javax.swing.JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// Create updated book object
					Book updatedBook = new Book(isbn, title, author, genre, publisher, Integer.parseInt(year));
					
					// Update the book in the list and table
					bookList.set(updateIndex, updatedBook);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setValueAt(isbn, updateIndex, 0);
					model.setValueAt(title, updateIndex, 1);
					model.setValueAt(author, updateIndex, 2);
					model.setValueAt(genre, updateIndex, 3);
					model.setValueAt(publisher, updateIndex, 4);
					model.setValueAt(year, updateIndex, 5);
					String status = updatedBook.isAvailable() ? "Available" : "Checked Out";
					model.setValueAt(status, updateIndex, 6);
					
					// Clear fields and reset mode
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					
					isUpdateMode = false;
					updateIndex = -1;
					btnUpdate.setText("Update");
					
					javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
						"Book updated successfully!", "Success", 
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(55, 65, 81));
		btnUpdate.setBounds(125, 439, 111, 40);
		panel_1.add(btnUpdate);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryDashboard dashboard = new LibraryDashboard();
				dashboard.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setOpaque(true);
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnGoBack.setFocusPainted(false);
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.setBorderPainted(false);
		btnGoBack.setBackground(new Color(55, 65, 81));
		btnGoBack.setBounds(30, 540, 89, 40);
		panel_1.add(btnGoBack);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(79, 70, 229));
		panel_1_1.setBounds(0, 668, 1271, 49);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(79, 70, 229));
		panel_1_1_1.setBounds(0, 0, 1271, 49);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Management");
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 32));
		lblNewLabel_2.setBounds(698, 60, 291, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Search:");
		lblNewLabel_3.setBounds(623, 125, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(675, 122, 314, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = textField_6.getText().trim().toLowerCase();
				
				if (searchText.isEmpty()) {
					// If search is empty, show all books
					refreshTable();
					return;
				}
				
				// Clear current table
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				// Filter and add matching books
				for (Book book : bookList) {
					String title = book.getTitle().toLowerCase();
					String author = book.getAuthor().toLowerCase();
					String isbn = book.getIsbn().toLowerCase();
					String genre = book.getGenre().toLowerCase();
					String publisher = book.getPublisher().toLowerCase();
					String yearStr = String.valueOf(book.getYear());
					String status = book.isAvailable() ? "Available" : "Checked Out";
					status = status.toLowerCase();
					
					// Check if search text matches any field
					if (title.contains(searchText) || 
						author.contains(searchText) || 
						isbn.contains(searchText) ||
						genre.contains(searchText) ||
						publisher.contains(searchText) ||
						yearStr.contains(searchText) ||
						status.contains(searchText)) {
						
						String displayStatus = book.isAvailable() ? "Available" : "Checked Out";
						model.addRow(new Object[]{
							book.getIsbn(), 
							book.getTitle(), 
							book.getAuthor(), 
							book.getGenre(), 
							book.getPublisher(), 
							book.getYear(),
							displayStatus
						});
					}
				}
				
				// Show search results count
				int resultCount = model.getRowCount();
				javax.swing.JOptionPane.showMessageDialog(ManageBooks.this, 
					"Found " + resultCount + " book(s) matching '" + textField_6.getText() + "'", 
					"Search Results", 
					javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSearch.setOpaque(true);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(new Color(55, 65, 81));
		btnSearch.setBounds(1007, 116, 116, 28);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText("");
				refreshTable();
			}
		});
		btnClear.setOpaque(true);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnClear.setFocusPainted(false);
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(55, 65, 81));
		btnClear.setBounds(1133, 116, 74, 28);
		contentPane.add(btnClear);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ISBN");
		model.addColumn("Book Title");
		model.addColumn("Author");
		model.addColumn("Genre");
		model.addColumn("Publisher");
		model.addColumn("Year");
		model.addColumn("Status");
		table.setModel(model);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(441, 158, 820, 450);
		contentPane.add(scrollPane);
		
		// Populate the table with existing books
		refreshTable();
	}
	
	// Add helper methods for OOP functionality
	
	/**
	 * Add a book to the system
	 */
	public void addBook(Book book) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		bookList.add(book);
		String status = book.isAvailable() ? "Available" : "Checked Out";
		model.addRow(new Object[]{
			book.getIsbn(), 
			book.getTitle(), 
			book.getAuthor(), 
			book.getGenre(), 
			book.getPublisher(), 
			book.getYear(),
			status
		});
	}
	
	/**
	 * Get book by index from the list
	 */
	public Book getBook(int index) {
		if (index >= 0 && index < bookList.size()) {
			return bookList.get(index);
		}
		return null;
	}
	
	/**
	 * Remove book by index
	 */
	public void removeBook(int index) {
		if (index >= 0 && index < bookList.size()) {
			bookList.remove(index);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(index);
		}
	}
	
	/**
	 * Update book at specified index
	 */
	public void updateBook(int index, Book updatedBook) {
		if (index >= 0 && index < bookList.size()) {
			bookList.set(index, updatedBook);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setValueAt(updatedBook.getIsbn(), index, 0);
			model.setValueAt(updatedBook.getTitle(), index, 1);
			model.setValueAt(updatedBook.getAuthor(), index, 2);
			model.setValueAt(updatedBook.getGenre(), index, 3);
			model.setValueAt(updatedBook.getPublisher(), index, 4);
			model.setValueAt(updatedBook.getYear(), index, 5);
			String status = updatedBook.isAvailable() ? "Available" : "Checked Out";
			model.setValueAt(status, index, 6);
		}
	}
	
	/**
	 * Refresh the table to show all books
	 */
	private void refreshTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Clear table
		
		// Add all books from the list
		for (Book book : bookList) {
			String status = book.isAvailable() ? "Available" : "Checked Out";
			model.addRow(new Object[]{
				book.getIsbn(), 
				book.getTitle(), 
				book.getAuthor(), 
				book.getGenre(), 
				book.getPublisher(), 
				book.getYear(),
				status
			});
		}
	}
}