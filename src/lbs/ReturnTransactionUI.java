package lbs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ReturnTransactionUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    // Encapsulation: Private fields
    private JPanel contentPane;
    private JTextField txtMemberId;
    private JTextField txtBookId;
    private JTextField txtSearch;
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private JButton btnReturn;
    private JButton btnSearch;
    private JButton btnGoBack;
    private JLabel lblTotalIssued;
    private JLabel lblActive;
    private JLabel lblOverdue;
    
    // Business logic layer - Composition
    private List<TransactionReturn> returnTransactions;
    private DateTimeFormatter dateFormatter;
    
    /**
     * Constructor - Create the frame and initialize components.
     */
    public ReturnTransactionUI() {
        initializeBusinessLogic();
        initializeUI();
        // No sample data on startup
        updateStatistics();
    }
    
    /**
     * Initialize business logic components
     */
    private void initializeBusinessLogic() {
        this.returnTransactions = new ArrayList<>();
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    /**
     * Initialize UI components - Demonstrates encapsulation
     */
    private void initializeUI() {
        setTitle("Library Management System - Return Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1165, 690);
        contentPane = new JPanel();
        setResizable(false);
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        createHeader();
        createFooter();
        createMainContent();
        createStatisticsPanel();
        createTablePanel();
        loadBorrowedBooks();
    }
    
    /**
     * Create header panel
     */
    private void createHeader() {
        JPanel header = new JPanel();
        header.setBackground(new Color(79, 70, 229));
        header.setBounds(0, 0, 1149, 49);
        contentPane.add(header);
        
        JLabel lblNewLabel_5 = new JLabel("Library Management System");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Oswald", Font.BOLD, 24));
        header.add(lblNewLabel_5);
    }
    
    /**
     * Create footer panel
     */
    private void createFooter() {
        JPanel footer = new JPanel();
        footer.setBackground(new Color(79, 70, 229));
        footer.setBounds(0, 610, 1190, 49);
        contentPane.add(footer);
        footer.setLayout(null);
        
        JLabel lblNewLabel_5_1 = new JLabel("University of Ruina");
        lblNewLabel_5_1.setBounds(982, 0, 155, 44);
        lblNewLabel_5_1.setForeground(Color.WHITE);
        lblNewLabel_5_1.setFont(new Font("Oswald", Font.BOLD, 21));
        footer.add(lblNewLabel_5_1);
    }
    
    /**
     * Create main content area
     */
    private void createMainContent() {
        JLabel lblReturnBook = new JLabel("Return Books");
        lblReturnBook.setBackground(new Color(0, 0, 0));
        lblReturnBook.setBounds(500, 60, 200, 38);
        lblReturnBook.setForeground(Color.BLACK);
        lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(lblReturnBook);
        
        // Search panel
        JLabel lblSearch = new JLabel("Search:");
        lblSearch.setBounds(30, 120, 80, 25);
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblSearch);
        
        txtSearch = new JTextField();
        txtSearch.setBounds(120, 120, 300, 25);
        txtSearch.setToolTipText("Search by Name, Transaction ID, Member ID");
        contentPane.add(txtSearch);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(440, 120, 80, 25);
        btnSearch.addActionListener(this);
        contentPane.add(btnSearch);
        
        // Return form
        JLabel lblMemberId = new JLabel("Member ID:");
        lblMemberId.setBounds(30, 160, 100, 25);
        lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblMemberId);
        
        txtMemberId = new JTextField();
        txtMemberId.setBounds(140, 160, 150, 25);
        contentPane.add(txtMemberId);
        
        JLabel lblBookId = new JLabel("Transaction ID:");
        lblBookId.setBounds(320, 160, 100, 25);
        lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblBookId);
        
        txtBookId = new JTextField();
        txtBookId.setBounds(430, 160, 150, 25);
        contentPane.add(txtBookId);
        
        btnReturn = new JButton("Return Book");
        btnReturn.setBounds(590, 161, 120, 25);
        btnReturn.setBackground(new Color(34, 197, 94));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnReturn.addActionListener(this);
        contentPane.add(btnReturn);
        
        btnGoBack = new JButton("Go Back");
        btnGoBack.setBounds(30, 520, 100, 30);
        btnGoBack.setBackground(new Color(156, 163, 175));
        btnGoBack.setForeground(Color.WHITE);
        btnGoBack.addActionListener(this);
        contentPane.add(btnGoBack);
    }
    
    /**
     * Create statistics panel - Centered horizontally
     */
    private void createStatisticsPanel() {
        // Calculate center positions for 3 panels (150px wide each with 20px gaps)
        // Total width needed: 150 + 20 + 150 + 20 + 150 = 490px
        // Frame width: 1165px, so start at: (1165 - 490) / 2 = 337px
        int startX = 337;
        int panelWidth = 150;
        int panelHeight = 80;
        int gap = 20;
        int yPosition = 420;
        
        // Total Issued Panel
        JPanel totalIssuedPanel = new JPanel();
        totalIssuedPanel.setBackground(new Color(249, 115, 22));
        totalIssuedPanel.setBounds(startX, yPosition, panelWidth, panelHeight);
        contentPane.add(totalIssuedPanel);
        totalIssuedPanel.setLayout(null);
        
        lblTotalIssued = new JLabel("0");
        lblTotalIssued.setBounds(65, 20, 30, 30);
        lblTotalIssued.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTotalIssued.setForeground(Color.WHITE);
        totalIssuedPanel.add(lblTotalIssued);
        
        JLabel lblTotalIssuedText = new JLabel("Total Issued");
        lblTotalIssuedText.setBounds(40, 50, 80, 20);
        lblTotalIssuedText.setForeground(Color.WHITE);
        lblTotalIssuedText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        totalIssuedPanel.add(lblTotalIssuedText);
        
        // Active Panel
        JPanel activePanel = new JPanel();
        activePanel.setBackground(new Color(34, 197, 94));
        activePanel.setBounds(startX + panelWidth + gap, yPosition, panelWidth, panelHeight);
        contentPane.add(activePanel);
        activePanel.setLayout(null);
        
        lblActive = new JLabel("0");
        lblActive.setBounds(65, 20, 30, 30);
        lblActive.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblActive.setForeground(Color.WHITE);
        activePanel.add(lblActive);
        
        JLabel lblActiveText = new JLabel("Active");
        lblActiveText.setBounds(55, 50, 50, 20);
        lblActiveText.setForeground(Color.WHITE);
        lblActiveText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        activePanel.add(lblActiveText);
        
        // Overdue Panel
        JPanel overduePanel = new JPanel();
        overduePanel.setBackground(new Color(239, 68, 68));
        overduePanel.setBounds(startX + (panelWidth + gap) * 2, yPosition, panelWidth, panelHeight);
        contentPane.add(overduePanel);
        overduePanel.setLayout(null);
        
        lblOverdue = new JLabel("0");
        lblOverdue.setBounds(65, 20, 30, 30);
        lblOverdue.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblOverdue.setForeground(Color.WHITE);
        overduePanel.add(lblOverdue);
        
        JLabel lblOverdueText = new JLabel("Overdue");
        lblOverdueText.setBounds(50, 50, 60, 20);
        lblOverdueText.setForeground(Color.WHITE);
        lblOverdueText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        overduePanel.add(lblOverdueText);
    }
    
    /**
     * Create table panel for displaying transactions
     */
    private void createTablePanel() {
        String[] columnNames = {"Transaction ID", "Book Title", "Member Name", "Member ID", "Issue Date", "Due Date", "Status", "Action"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // Only Action column is editable
            }
        };
        
        transactionTable = new JTable(tableModel);
        transactionTable.setRowHeight(30);
        transactionTable.getTableHeader().setBackground(new Color(243, 244, 246));
        transactionTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(30, 200, 1080, 200);
        contentPane.add(scrollPane);
    }
    
    /**
     * Update statistics display
     */
    private void updateStatistics() {
        int totalIssued = tableModel.getRowCount();
        int active = 0;
        int overdue = 0;
        
        LocalDate today = LocalDate.now();
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String status = (String) tableModel.getValueAt(i, 6);
            String dueDateStr = (String) tableModel.getValueAt(i, 5);
            
            if ("Active".equals(status)) {
                active++;
                try {
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    if (today.isAfter(dueDate)) {
                        overdue++;
                    }
                } catch (Exception e) {
                    // Handle date parsing error
                }
            }
        }
        
        lblTotalIssued.setText(String.valueOf(totalIssued));
        lblActive.setText(String.valueOf(active));
        lblOverdue.setText(String.valueOf(overdue));
    }
    
    /**
     * Polymorphism: Implementation of ActionListener interface
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReturn) {
            processReturnTransaction();
        } else if (e.getSource() == btnSearch) {
            performSearch();
        } else if (e.getSource() == btnGoBack) {
            goBack();
        }
    }
    
    /**
     * Process return transaction - Business logic separated from UI
     */
    private void processReturnTransaction() {
        String memberId = txtMemberId.getText().trim();
        String transactionId = txtBookId.getText().trim();

        // Validation
        if (!validateInput(memberId, transactionId)) {
            return;
        }

        try {
            // Find the original borrow transaction in the central manager
            Transaction originalBorrow = null;
            for (Transaction t : BookManager.instance.getTransactions()) {
                if (t != null && transactionId.equals(t.getTransactionId()) && "borrow".equalsIgnoreCase(t.getType())) {
                    originalBorrow = t;
                    break;
                }
            }

            if (originalBorrow == null) {
                JOptionPane.showMessageDialog(this, "Borrow transaction not found: " + transactionId,
                                              "Not Found", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Determine item id (ISBN) from the original borrow transaction
            String itemId = originalBorrow.getItemId();

            // Update book status to available
            Book book = BookManager.instance.findBookByISBN(itemId);
            if (book != null) {
                book.returnItem();
            }

            // Calculate late fee (if any)
            double lateFee = 0.0;
            if (originalBorrow.getDueDate() != null) {
                LocalDate today = LocalDate.now();
                if (today.isAfter(originalBorrow.getDueDate())) {
                    long daysLate = java.time.temporal.ChronoUnit.DAYS.between(originalBorrow.getDueDate(), today);
                    lateFee = daysLate * 2.0;
                }
            }

            // Generate a return transaction id prefixed by memberId
            // Use centralized TRN### generator so IDs are like TRN001, TRN002, ...
            String returnTransId = TransactionIdGenerator.nextId();

            // Create return transaction (use the full constructor to preserve details)
            TransactionReturn returnTransaction = new TransactionReturn(
                    returnTransId,
                    memberId,
                    itemId,
                    originalBorrow.getTransactionDate(),
                    LocalDate.now(),
                    lateFee,
                    "COMPLETED",
                    ""
            );

            // Process the transaction (business logic hook)
            returnTransaction.processTransaction();

            // Add to central manager so other UIs (like BorrowTransactionUI) can see it
            BookManager.instance.addTransaction(returnTransaction);

            // Add to our local collection for the returns UI
            returnTransactions.add(returnTransaction);

            // Also remove the original borrow transaction from manager if you want it considered returned
            // (optional): remove the borrow transaction so it no longer appears as active
            // We'll remove it from BookManager transactions list
            BookManager.instance.removeTransaction(originalBorrow);

            // Refresh the borrow UI if it's open so tables reflect the change
            BorrowTransactionUI.refreshIfOpen();

            // Update UI
            removeReturnedBookFromTable(memberId, transactionId);
            clearInputFields();
            updateStatistics();

            // Show detailed success message in GUI
            showTransactionResult(returnTransaction);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error processing return: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Show transaction result in a detailed GUI dialog
     */
    private void showTransactionResult(TransactionReturn returnTransaction) {
        StringBuilder message = new StringBuilder();
        message.append("✓ Return Transaction Completed Successfully!\n\n");
        message.append("Transaction Details:\n");
        message.append("• Transaction ID: ").append(returnTransaction.getTransactionId()).append("\n");
        message.append("• Member ID: ").append(returnTransaction.getMemberId()).append("\n");
        message.append("• Item ID: ").append(returnTransaction.getItemId()).append("\n");
        message.append("• Return Date: ").append(returnTransaction.getReturnDate()).append("\n");
        message.append("• Status: ").append(returnTransaction.getStatus()).append("\n");
        
        if (returnTransaction.getLateFee() > 0) {
            message.append("\n⚠ Late Fee Information:\n");
            message.append("• Late Fee Amount: $").append(String.format("%.2f", returnTransaction.getLateFee())).append("\n");
            message.append("• Payment Required: Please collect fee from member\n");
        } else {
            message.append("\n✓ No Late Fees Applied\n");
        }
        
        message.append("\n📚 Book Status: Updated to AVAILABLE");
        
        JOptionPane.showMessageDialog(this, message.toString(), "Transaction Successful", 
                                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Validate input fields
     */
    private boolean validateInput(String memberId, String transactionId) {
        if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member ID", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtMemberId.requestFocus();
            return false;
        }
        
        if (transactionId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Transaction ID", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtBookId.requestFocus();
            return false;
        }
        
        return true;
    }
    
    /**
     * Remove returned book from the active transactions table
     */
    private void removeReturnedBookFromTable(String memberId, String transactionId) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String tableTransactionId = (String) tableModel.getValueAt(i, 0); // Transaction ID is in column 0
            if (tableTransactionId.equals(transactionId)) {
                tableModel.removeRow(i);
                break;
            }
        }
    }
    
    /**
     * Clear input fields
     */
    private void clearInputFields() {
        txtMemberId.setText("");
        txtBookId.setText("");
    }
    
    /**
     * Perform search functionality
     */
    private void performSearch() {
        String searchTerm = txtSearch.getText().trim().toLowerCase();
        
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter search term", "Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Simple search implementation
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount() - 1; j++) { // Exclude action column
                String cellValue = tableModel.getValueAt(i, j).toString().toLowerCase();
                if (cellValue.contains(searchTerm)) {
                    transactionTable.setRowSelectionInterval(i, i);
                    transactionTable.scrollRectToVisible(transactionTable.getCellRect(i, 0, true));
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "No matching records found", "Search", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Go back to previous screen
     */
    private void goBack() {
        // Close current window and return to LibraryDashboard
        this.dispose();
        new LibraryDashboard().setVisible(true);
    }
    
    /**
     * Get all return transactions - Getter method for encapsulation
     */
    public List<TransactionReturn> getReturnTransactions() {
        return new ArrayList<>(returnTransactions); // Return copy to maintain encapsulation
    }
    
    /**
     * Get transaction count - Abstraction of internal complexity
     */
    public int getTransactionCount() {
        return returnTransactions.size();
    }
    
    /**
     * Load borrowed books into the table
     */
    private void loadBorrowedBooks() {
        tableModel.setRowCount(0); // Clear table
        
        for (Transaction t : BookManager.instance.getTransactions()) {
            if (t != null && "borrow".equalsIgnoreCase(t.getType())) {
                Book b = BookManager.instance.findBookByISBN(t.getItemId());
                if (b != null && !b.isAvailable()) {
                    // Find member name
                    String memberName = "Unknown";
                    for (Member m : MemberManager.instance.getMembers()) {
                        if (m.getMemberCode().equals(t.getMemberId())) {
                            memberName = m.getFirstName() + " " + m.getLastName();
                            break;
                        }
                    }
                    
                    // Determine status
                    String status = "Active";
                    if (t.getDueDate() != null && LocalDate.now().isAfter(t.getDueDate())) {
                        status = "Overdue";
                    }
                    
                    tableModel.addRow(new Object[]{
                        t.getTransactionId(),
                        b.getTitle(),
                        memberName,
                        t.getMemberId(),
                        t.getTransactionDate().toString(),
                        t.getDueDate() != null ? t.getDueDate().toString() : "N/A",
                        status,
                        "Return" // Action column
                    });
                }
            }
        }
    }
}