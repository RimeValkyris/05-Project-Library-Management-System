package lbs;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BorrowTransactionUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField studentIdField;
    private JTextField isbnField;
    private JTextField titleField;
    private JTextField todayField;
    private JTextField daysField;
    private DefaultTableModel model;

    public BorrowTransactionUI() {
        setTitle("Library Borrow Transaction");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Header bar
        JPanel header = new JPanel();
        header.setBackground(new Color(79, 70, 229));
        header.setBounds(0, 0, 1190, 49);
        contentPane.add(header);

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(30, 41, 59));
        leftPanel.setBounds(0, 49, 400, 563);
        contentPane.add(leftPanel);

        JLabel lblTitle = new JLabel("Issue New Book");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(27, 31, 250, 38);
        leftPanel.add(lblTitle);

        JLabel lblStudent = new JLabel("Student ID");
        lblStudent.setForeground(Color.WHITE);
        lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblStudent.setBounds(27, 88, 115, 20);
        leftPanel.add(lblStudent);

        studentIdField = new JTextField();
        studentIdField.setBounds(27, 113, 327, 25);
        leftPanel.add(studentIdField);

        JLabel lblIsbn = new JLabel("ISBN");
        lblIsbn.setForeground(Color.WHITE);
        lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIsbn.setBounds(27, 149, 115, 20);
        leftPanel.add(lblIsbn);

        isbnField = new JTextField();
        isbnField.setBounds(27, 174, 327, 25);
        leftPanel.add(isbnField);

        JLabel lblBookTitle = new JLabel("Book Title");
        lblBookTitle.setForeground(Color.WHITE);
        lblBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBookTitle.setBounds(27, 210, 115, 20);
        leftPanel.add(lblBookTitle);

        titleField = new JTextField();
        titleField.setBounds(27, 235, 327, 25);
        leftPanel.add(titleField);

        JLabel lblDate = new JLabel("Date Today");
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDate.setBounds(27, 270, 115, 20);
        leftPanel.add(lblDate);

        todayField = new JTextField(LocalDate.now().toString());
        todayField.setEditable(false);
        todayField.setBounds(27, 295, 327, 25);
        leftPanel.add(todayField);

        JLabel lblDays = new JLabel("Number of Days");
        lblDays.setForeground(Color.WHITE);
        lblDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDays.setBounds(27, 330, 150, 20);
        leftPanel.add(lblDays);

        daysField = new JTextField();
        daysField.setBounds(27, 355, 327, 25);
        leftPanel.add(daysField);

        JButton btnIssue = new JButton("Issue Book");
        btnIssue.setForeground(Color.WHITE);
        btnIssue.setBackground(new Color(55, 65, 81));
        btnIssue.setFocusPainted(false);
        btnIssue.setBounds(27, 410, 180, 40);
        leftPanel.add(btnIssue);

        JButton btnBack = new JButton("Go Back");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(55, 65, 81));
        btnBack.setFocusPainted(false);
        btnBack.setBounds(27, 470, 120, 40);
        leftPanel.add(btnBack);

        // Right panel with tabs
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 49, 784, 563);
        contentPane.add(rightPanel);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 740, 530);
        rightPanel.add(tabbedPane);

        // Tab 1: Borrowed Books
        JPanel borrowedPanel = new JPanel();
        borrowedPanel.setLayout(null);

        JLabel lblBorrowed = new JLabel("Borrowed Books");
        lblBorrowed.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblBorrowed.setBounds(10, 10, 200, 30);
        borrowedPanel.add(lblBorrowed);

        String[] columnNames = {"Title", "ISBN", "Student ID", "Issue Date", "Due Date"};
        model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 700, 430);
        borrowedPanel.add(scrollPane);

        tabbedPane.addTab("Borrowed Books", borrowedPanel);

        // Tab 2: Members
        JPanel membersPanel = new JPanel();
        membersPanel.setLayout(null);

        JLabel lblMembers = new JLabel("Members");
        lblMembers.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMembers.setBounds(10, 10, 200, 30);
        membersPanel.add(lblMembers);

        String[] memberColumns = {"Student ID", "First Name", "Last Name", "Email", "Phone"};
        DefaultTableModel memberModel = new DefaultTableModel(memberColumns, 0);
        JTable memberTable = new JTable(memberModel);
        JScrollPane memberScroll = new JScrollPane(memberTable);
        memberScroll.setBounds(10, 50, 700, 430);
        membersPanel.add(memberScroll);

        // Populate members
        for (Member m : MemberManagement.members) {
            memberModel.addRow(new Object[]{
                String.valueOf(m.getStudentID()),
                m.getFirstName(),
                m.getLastName(),
                m.getEmail(),
                String.valueOf(m.getPhoneNumber())
            });
        }

        tabbedPane.addTab("Members", membersPanel);

        // Tab 3: Books
        JPanel booksPanel = new JPanel();
        booksPanel.setLayout(null);

        JLabel lblBooks = new JLabel("Books");
        lblBooks.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblBooks.setBounds(10, 10, 200, 30);
        booksPanel.add(lblBooks);

        String[] bookColumns = {"Title", "ISBN", "Author", "Genre", "Publisher", "Year"};
        DefaultTableModel bookModel = new DefaultTableModel(bookColumns, 0);
        JTable bookTable = new JTable(bookModel);
        JScrollPane bookScroll = new JScrollPane(bookTable);
        bookScroll.setBounds(10, 50, 700, 430);
        booksPanel.add(bookScroll);

        // Populate books
        for (Book b : BookManager.instance.getBooks()) {
            bookModel.addRow(new Object[]{
                b.getTitle(),
                b.getIsbn(),
                b.getAuthor(),
                b.getGenre(),
                b.getPublisher(),
                String.valueOf(b.getYear())
            });
        }

        tabbedPane.addTab("Books", booksPanel);

        // Button Actions
        btnIssue.addActionListener(e -> issueBook());
        btnBack.addActionListener(e -> {
            dispose();
            new LibraryDashboard().setVisible(true);
        });

        // Footer
        JPanel footer = new JPanel();
        footer.setBackground(new Color(79, 70, 229));
        footer.setBounds(0, 612, 1190, 49);
        contentPane.add(footer);
    }

    /**
     * Handles issuing of a new book.
     */
    private void issueBook() {
        String studentId = studentIdField.getText().trim();
        String isbn = isbnField.getText().trim();
        String title = titleField.getText().trim();

        try {
            int days = Integer.parseInt(daysField.getText().trim());

            Book book = BookManager.instance.findBookByISBN(isbn);
            if (book == null || !book.isAvailable()) {
                JOptionPane.showMessageDialog(this, "Book not available.");
                return;
            }

            // Create BorrowTransaction object
            BorrowTransaction transaction = new BorrowTransaction(studentId, isbn, days);
            transaction.processTransaction();

            // Add transaction to manager
            BookManager.instance.addTransaction(transaction);
            book.checkOut();

            // Add row to table
            model.addRow(new Object[]{
                title.isEmpty() ? book.getTitle() : title,
                isbn,
                studentId,
                transaction.getTransactionDate(),
                transaction.getDueDate()
            });

            JOptionPane.showMessageDialog(this, "Book issued successfully!");

            // Reset fields
            studentIdField.setText("");
            isbnField.setText("");
            titleField.setText("");
            todayField.setText(LocalDate.now().toString());
            daysField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of days.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new BorrowTransactionUI().setVisible(true));
    }
}