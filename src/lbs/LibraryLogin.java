package lbs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
	

	private User adminUser;

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
		// Initialize admin user using OOP encapsulation
		adminUser = new User("admin", "password");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(883, 487);
		setLocationRelativeTo(null);
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
		
		JLabel lblNewLabel_2 = new JLabel("");
		// Improved image loading: try classpath and file-system fallbacks, and provide diagnostic tooltip if not found.
		String[] candidates = new String[] {
			"/SchoolLibraryLogIn.png",
			"SchoolLibraryLogIn.png",
			"/SchoolLibraryLogIn.jpg",
			"SchoolLibraryLoginIn.jpg",
			"/Images/SchoolLibraryLoginIn.jpg",
			"/uno.jpg",
			"uno.jpg"
		};
		ImageIcon icon = tryLoadIcon(candidates);
		// Prefer the known repository Images path if the previous attempts failed
		if (icon == null) {
			// check using JVM working directory; this helps when running from IDE where working dir = project root
			String proj = System.getProperty("user.dir");
			File known = new File(proj + File.separator + "Images" + File.separator + "SchoolLibraryLoginIn.jpg");
			if (known.exists()) icon = new ImageIcon(known.getAbsolutePath());
			// also try the absolute path where the repo contains the file (helpful in local dev)
			File alt = new File("c:" + File.separator + "Users" + File.separator + "ENVY" + File.separator + "git" + File.separator + "05-Project-Shattered-Connexion" + File.separator + "Images" + File.separator + "SchoolLibraryLoginIn.jpg");
			if (alt.exists()) icon = new ImageIcon(alt.getAbsolutePath());
		}
		// Final fallback: create a simple drawn placeholder image so UI always shows an icon
		if (icon != null) {
			Image img = icon.getImage();
			// scale the image to fit the label bounds (355x448) preserving aspect ratio and using high-quality scaling
			Image scaled = getScaledImage(img, 355, 448);
			lblNewLabel_2.setIcon(new ImageIcon(scaled));
		} else {
			BufferedImage placeholder = new BufferedImage(355, 448, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = placeholder.createGraphics();
			try {
				g.setColor(new Color(240, 240, 240));
				g.fillRect(0, 0, 355, 448);
				g.setColor(Color.GRAY);
				g.drawRect(10, 10, 335, 428);
				g.setFont(new Font("SansSerif", Font.PLAIN, 18));
				String s = "Image not found";
				int sw = g.getFontMetrics().stringWidth(s);
				g.drawString(s, (355 - sw) / 2, 220);
			} finally {
				g.dispose();
			}
			lblNewLabel_2.setIcon(new ImageIcon(placeholder));
			String proj = System.getProperty("user.dir");
			String tooltip = "Could not find image. Tried classpath and files:\n" +
				" - " + proj + File.separator + "Images" + File.separator + "SchoolLibraryLoginIn.jpg" +
				"\n - c:\\Users\\ENVY\\git\\05-Project-Shattered-Connexion\\Images\\SchoolLibraryLoginIn.jpg";
			lblNewLabel_2.setToolTipText(tooltip);
		}
		lblNewLabel_2.setBounds(0, 0, 355, 448);
		contentPane.add(lblNewLabel_2);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get user input
				String username = textField.getText().trim();
				String password = new String(textField_1.getPassword());
				
				// Validate input
				if (username.isEmpty() || password.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(LibraryLogin.this, 
						"Please enter both username and password!", "Login Error", 
						javax.swing.JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Use OOP: Encapsulate authentication logic in User object
				if (adminUser.validateCredentials(username, password)) {
					// Login successful - open dashboard
					LibraryDashboard dashboard = new LibraryDashboard();
					dashboard.setVisible(true);
					dispose();
				} else {
					// Login failed
					javax.swing.JOptionPane.showMessageDialog(LibraryLogin.this, 
						"Invalid username or password!", "Login Failed", 
						javax.swing.JOptionPane.ERROR_MESSAGE);
					
					// Clear password field for security
					textField_1.setText("");
				}
			}
		});

	}

	/**
	 * Try loading an ImageIcon from multiple candidate locations. This checks:
	 * - classpath resources via getResource
	 * - classpath streams via getResourceAsStream (ImageIO)
	 * - filesystem paths (as given)
	 * - common project-relative locations like "src/Images/..." and "Images/..."
	 */
	private ImageIcon tryLoadIcon(String... candidates) {
		for (String p : candidates) {
			if (p == null) continue;
			// Diagnostic log for troubleshooting in JAR/IDE
			System.out.println("[ResourceLookup] Trying path: '" + p + "'");
			// 1) try classpath resource url
			java.net.URL url = getClass().getResource(p);
			if (url == null && !p.startsWith("/")) url = getClass().getResource("/" + p);
			if (url != null) {
				System.out.println("[ResourceLookup] Found resource URL: " + url);
				return new ImageIcon(url);
			}
			// 2) try resource as stream (useful if resource is inside a jar)
			InputStream is = getClass().getResourceAsStream(p);
			if (is == null && !p.startsWith("/")) is = getClass().getResourceAsStream("/" + p);
			if (is != null) {
				System.out.println("[ResourceLookup] Found resource as stream: '" + p + "'");
				try {
					Image img = ImageIO.read(is);
					if (img != null) return new ImageIcon(img);
				} catch (IOException e) {
					System.err.println("[ResourceLookup] Failed to read image from stream: " + e.getMessage());
					// ignore and continue trying other paths
				}
			}
			// 3) try filesystem paths
			File f = new File(p);
			if (f.exists()) {
				System.out.println("[ResourceLookup] Found image on filesystem: " + f.getAbsolutePath());
				return new ImageIcon(f.getAbsolutePath());
			}
			// 4) try common project-relative locations
			f = new File("src" + File.separator + p);
			if (f.exists()) {
				System.out.println("[ResourceLookup] Found image at src/ path: " + f.getAbsolutePath());
				return new ImageIcon(f.getAbsolutePath());
			}
			f = new File("Images" + File.separator + p);
			if (f.exists()) {
				System.out.println("[ResourceLookup] Found image at Images/ path: " + f.getAbsolutePath());
				return new ImageIcon(f.getAbsolutePath());
			}
			f = new File("src" + File.separator + "Images" + File.separator + p);
			if (f.exists()) {
				System.out.println("[ResourceLookup] Found image at src/Images/ path: " + f.getAbsolutePath());
				return new ImageIcon(f.getAbsolutePath());
			}
		}
		// Additional fallback: check for Images folder next to the running JAR or classes directory
		try {
			java.net.URL codeLoc = getClass().getProtectionDomain().getCodeSource().getLocation();
			if (codeLoc != null) {
				java.io.File codeFile = new java.io.File(codeLoc.toURI());
				java.io.File jarDir = codeFile.isDirectory() ? codeFile : codeFile.getParentFile();
				if (jarDir != null && jarDir.exists()) {
					System.out.println("[ResourceLookup] Checking jar directory for Images: " + jarDir.getAbsolutePath());
					for (String p : candidates) {
						if (p == null) continue;
						java.io.File f = new java.io.File(jarDir, "Images" + java.io.File.separator + (p.startsWith("/") ? p.substring(1) : p));
						if (f.exists()) {
							System.out.println("[ResourceLookup] Found image in jar-dir Images/: " + f.getAbsolutePath());
							return new ImageIcon(f.getAbsolutePath());
						}
						// also try directly in jar dir
						f = new java.io.File(jarDir, (p.startsWith("/") ? p.substring(1) : p));
						if (f.exists()) {
							System.out.println("[ResourceLookup] Found image in jar-dir: " + f.getAbsolutePath());
							return new ImageIcon(f.getAbsolutePath());
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println("[ResourceLookup] Failed to check jar directory: " + e.getMessage());
		}
		return null;
	}

	private Image getScaledImage(Image src, int maxW, int maxH) {
		if (src == null) return null;
		int w = src.getWidth(null);
		int h = src.getHeight(null);
		if (w <= 0 || h <= 0) return src;
		// COVER behavior: scale so the image fills the target area (may crop)
		double scale = Math.max((double) maxW / w, (double) maxH / h);
		int nw = Math.max(1, (int) Math.round(w * scale));
		int nh = Math.max(1, (int) Math.round(h * scale));
		BufferedImage canvas = new BufferedImage(maxW, maxH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = canvas.createGraphics();
		try {
			// high-quality rendering hints
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			// draw the scaled image centered; negative x/y will crop edges automatically
			int x = (maxW - nw) / 2;
			int y = (maxH - nh) / 2;
			g2.drawImage(src, x, y, nw, nh, null);
		} finally {
			g2.dispose();
		}
		return canvas;
	}

}