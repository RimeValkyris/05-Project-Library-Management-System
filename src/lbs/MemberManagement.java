package lbs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class MemberManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	// Make members globally accessible for dashboard/statistics (keeps existing usage)
	public static List<Member> members = new ArrayList<>();
	private boolean isEditing = false;
    
    // Helper accessor for encapsulation from other classes
    public static int getMemberCount() {
        return members.size();
    }


	/**
	 * Create the frame.
	 */
	public MemberManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1566, 756);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(79, 70, 229));
		panel_1_1_1.setBounds(0, 0, 1557, 49);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(30, 41, 59));
		panel_1.setBounds(0, 49, 451, 619);
		contentPane.add(panel_1);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setOpaque(true);
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnGoBack.setFocusPainted(false);
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.setBorderPainted(false);
		btnGoBack.setBackground(new Color(55, 65, 81));
		btnGoBack.setBounds(27, 540, 89, 40);
		panel_1.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("Member Management");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 22, 269, 29);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 85, 128, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 122, 89, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(138, 84, 240, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 147, 128, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(148, 124, 109, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 147, 128, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(291, 124, 87, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(292, 147, 149, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Course");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 191, 128, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Section and Year");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(196, 193, 129, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 216, 165, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(195, 216, 130, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 259, 128, 14);
		panel_1.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 284, 333, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(10, 326, 106, 14);
		panel_1.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 351, 266, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Date Joined");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 395, 89, 14);
		panel_1.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 420, 128, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnAdd.setFocusPainted(false);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(new Color(55, 65, 81));
		btnAdd.setBounds(41, 466, 111, 40);
		panel_1.add(btnAdd);
		
		JButton btnGoBack_1_1 = new JButton("Update");
		btnGoBack_1_1.setOpaque(true);
		btnGoBack_1_1.setForeground(Color.WHITE);
		btnGoBack_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnGoBack_1_1.setFocusPainted(false);
		btnGoBack_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack_1_1.setBorderPainted(false);
		btnGoBack_1_1.setBackground(new Color(55, 65, 81));
		btnGoBack_1_1.setBounds(162, 466, 111, 40);
		panel_1.add(btnGoBack_1_1);
		
		JButton btnGoBack_1_2 = new JButton("Remove");
		btnGoBack_1_2.setOpaque(true);
		btnGoBack_1_2.setForeground(Color.WHITE);
		btnGoBack_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnGoBack_1_2.setFocusPainted(false);
		btnGoBack_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack_1_2.setBorderPainted(false);
		btnGoBack_1_2.setBackground(new Color(55, 65, 81));
		btnGoBack_1_2.setBounds(283, 466, 109, 40);
		panel_1.add(btnGoBack_1_2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setOpaque(true);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnClear.setFocusPainted(false);
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(55, 65, 81));
		btnClear.setBounds(325, 540, 89, 40);
		panel_1.add(btnClear);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(79, 70, 229));
		panel_1_1.setBounds(0, 668, 1557, 49);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_10 = new JLabel("Library Member Table");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_10.setBounds(865, 74, 265, 49);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Search:");
		lblNewLabel_11.setBounds(811, 127, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_9 = new JTextField();
		textField_9.setBounds(865, 124, 265, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1140, 123, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(480, 173, 1054, 455);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Student Number");
		model.addColumn("First Name");
		model.addColumn("Middle Name");
		model.addColumn("Last Name");
		model.addColumn("Course");
		model.addColumn("Section and Year");
		model.addColumn("Email");
		model.addColumn("Phone Number");
		model.addColumn("Date Joined");
		table.setModel(model);
		
		// Add sample data for 3 students
		Member member1 = new Member(12345L, "John", "A.", "Doe", "Computer Science", "A-2023", "john.doe@example.com", 1234567890L, "2023-01-01");
		members.add(member1);
		model.addRow(new Object[]{member1.getStudentID(), member1.getFirstName(), member1.getMiddleName(), member1.getLastName(), member1.getCourse(), member1.getSectionAndYear(), member1.getEmail(), member1.getPhoneNumber(), member1.getDateJoined()});
		
		Member member2 = new Member(67890L, "Jane", "B.", "Smith", "Information Technology", "B-2023", "jane.smith@example.com", 9876543210L, "2023-02-15");
		members.add(member2);
		model.addRow(new Object[]{member2.getStudentID(), member2.getFirstName(), member2.getMiddleName(), member2.getLastName(), member2.getCourse(), member2.getSectionAndYear(), member2.getEmail(), member2.getPhoneNumber(), member2.getDateJoined()});
		
		Member member3 = new Member(54321L, "Bob", "C.", "Johnson", "Software Engineering", "C-2023", "bob.johnson@example.com", 5551234567L, "2023-03-10");
		members.add(member3);
		model.addRow(new Object[]{member3.getStudentID(), member3.getFirstName(), member3.getMiddleName(), member3.getLastName(), member3.getCourse(), member3.getSectionAndYear(), member3.getEmail(), member3.getPhoneNumber(), member3.getDateJoined()});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long studentID = Long.parseLong(textField.getText());
					String firstName = textField_1.getText();
					String middleName = textField_2.getText();
					String lastName = textField_3.getText();
					String course = textField_4.getText();
					String sectionAndYear = textField_5.getText();
					String email = textField_6.getText();
					long phoneNumber = Long.parseLong(textField_7.getText());
					String dateJoined = textField_8.getText();
					
					Member member = new Member(studentID, firstName, middleName, lastName, course, sectionAndYear, email, phoneNumber, dateJoined);
					members.add(member);
					
					model.addRow(new Object[]{studentID, firstName, middleName, lastName, course, sectionAndYear, email, phoneNumber, dateJoined});
					
					// Clear the input fields after adding
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
				} catch (NumberFormatException ex) {
					// Handle invalid input, e.g., show error message
					System.out.println("Invalid number format");
				}
			}
		});
		
		btnGoBack_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this member?", "Confirm Remove", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						members.remove(selectedRow);
						model.removeRow(selectedRow);
					}
				}
			}
		});
		
		btnGoBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the main dashboard and close this window
				dispose();
				new LibraryDashboard().setVisible(true);
			}
		});
		
		btnGoBack_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isEditing) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						JOptionPane.showMessageDialog(null, "Edit the member detail and click update to confirm changes");
						// Populate fields with selected row data
						textField.setText(model.getValueAt(selectedRow, 0).toString());
						textField_1.setText(model.getValueAt(selectedRow, 1).toString());
						textField_2.setText(model.getValueAt(selectedRow, 2).toString());
						textField_3.setText(model.getValueAt(selectedRow, 3).toString());
						textField_4.setText(model.getValueAt(selectedRow, 4).toString());
						textField_5.setText(model.getValueAt(selectedRow, 5).toString());
						textField_6.setText(model.getValueAt(selectedRow, 6).toString());
						textField_7.setText(model.getValueAt(selectedRow, 7).toString());
						textField_8.setText(model.getValueAt(selectedRow, 8).toString());
						isEditing = true;
					}
				} else {
					try {
						long studentID = Long.parseLong(textField.getText());
						String firstName = textField_1.getText();
						String middleName = textField_2.getText();
						String lastName = textField_3.getText();
						String course = textField_4.getText();
						String sectionAndYear = textField_5.getText();
						String email = textField_6.getText();
						long phoneNumber = Long.parseLong(textField_7.getText());
						String dateJoined = textField_8.getText();
						
						int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this member?", "Confirm Update", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							int selectedRow = table.getSelectedRow();
							Member m = members.get(selectedRow);
							m.setStudentID(studentID);
							m.setFirstName(firstName);
							m.setMiddleName(middleName);
							m.setLastName(lastName);
							m.setCourse(course);
							m.setSectionAndYear(sectionAndYear);
							m.setEmail(email);
							m.setPhoneNumber(phoneNumber);
							m.setDateJoined(dateJoined);
							
							model.setValueAt(studentID, selectedRow, 0);
							model.setValueAt(firstName, selectedRow, 1);
							model.setValueAt(middleName, selectedRow, 2);
							model.setValueAt(lastName, selectedRow, 3);
							model.setValueAt(course, selectedRow, 4);
							model.setValueAt(sectionAndYear, selectedRow, 5);
							model.setValueAt(email, selectedRow, 6);
							model.setValueAt(phoneNumber, selectedRow, 7);
							model.setValueAt(dateJoined, selectedRow, 8);
						}
					} catch (NumberFormatException ex) {
						System.out.println("Invalid number format");
					}
					isEditing = false;
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchText = textField_9.getText().toLowerCase();
				model.setRowCount(0);
				for (Member m : members) {
					if (searchText.isEmpty() || 
						m.getFirstName().toLowerCase().contains(searchText) ||
						m.getLastName().toLowerCase().contains(searchText) ||
						m.getCourse().toLowerCase().contains(searchText) ||
						m.getEmail().toLowerCase().contains(searchText)) {
						model.addRow(new Object[]{m.getStudentID(), m.getFirstName(), m.getMiddleName(), m.getLastName(), m.getCourse(), m.getSectionAndYear(), m.getEmail(), m.getPhoneNumber(), m.getDateJoined()});
					}
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				isEditing = false;
			}
		});
		
		// Add double-click listener for table row edit
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						// Populate fields with selected row data
						textField.setText(model.getValueAt(selectedRow, 0).toString());
						textField_1.setText(model.getValueAt(selectedRow, 1).toString());
						textField_2.setText(model.getValueAt(selectedRow, 2).toString());
						textField_3.setText(model.getValueAt(selectedRow, 3).toString());
						textField_4.setText(model.getValueAt(selectedRow, 4).toString());
						textField_5.setText(model.getValueAt(selectedRow, 5).toString());
						textField_6.setText(model.getValueAt(selectedRow, 6).toString());
						textField_7.setText(model.getValueAt(selectedRow, 7).toString());
						textField_8.setText(model.getValueAt(selectedRow, 8).toString());
					}
				}
			}
		});
	}
}