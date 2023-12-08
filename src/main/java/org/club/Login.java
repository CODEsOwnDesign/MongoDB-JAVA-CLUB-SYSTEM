package org.club;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents a login window for a sports club system.
 */
public class Login extends JFrame {
    /**
     * Panel for a background.
     */
    SetBackgroundImage loginBackground;

    /**
     * Panel for login image.
     */
    JPanel pLoginImage;

    /**
     * Main panel containing UI components.
     */
    JPanel pMain;

    /**
     * Panel containing buttons.
     */
    JPanel pButton;

    /**
     * Label for login image.
     */
    JLabel lblLoginImage;

    /**
     * Label for username.
     */
    JLabel lblUsername;

    /**
     * Text field for username input.
     */
    JTextField txtUsername;

    /**
     * Label for password.
     */
    JLabel lblPassword;

    /**
     * Password field for password input.
     */
    JPasswordField txtPassword;

    /**
     * Checkbox for showing password.
     */
    JCheckBox chkShowPassword;

    /**
     * Button for resetting password.
     */
    JButton btnResetPassword;

    /**
     * Button for login action.
     */
    JButton btnLogin;

    /**
     * Button for registration.
     */
    JButton btnRegister;

    /**
     * Constructs a new instance of the {@code Login} window.
     * The constructor initializes the look and feel, sets the frame icon,
     * and asynchronously invokes the methods to initialize components and adds them to the frame.
     * Additionally, it packs the frame to ensure proper sizing.
     * <p>
     * The sequence of operations in the constructor:
     * 1. Set the look and feel of the frame to match the system or a predefined style.
     * 2. Set the frame icon to a specific image or icon.
     * 3. Asynchronously initialize UI components using the {@code initializeComponents} method.
     * 4. Asynchronously add UI components to the frame using the {@code addComponentsToFrame} method.
     * 5. Pack the frame to adjust its size based on the preferred sizes of its components.
     *
     * @see Constant#setLookAndFeel(JFrame) for setting the look and feel.
     * @see Constant#setFrameIcon(JFrame) for setting the frame icon.
     * @see #initializeComponents() for initializing UI components.
     * @see #addComponentsToFrame() for adding UI components to the frame.
     */
    public Login() {
        // Set the look and feel to provide a consistent appearance
        Constant.setLookAndFeel(this);

        // Set the frame icon to a specific image or icon
        Constant.setFrameIcon(this);

        // Asynchronously invoke the methods to initialize and add UI components
        SwingUtilities.invokeLater(this::initializeComponents);
        SwingUtilities.invokeLater(this::addComponentsToFrame);

        // Pack the frame to adjust its size based on component preferences
        pack();
    }

    /**
     * Authenticates a user against a specific collection in MongoDB.
     * This method connects to the MongoDB server using the provided connection string,
     * accesses the 'sports_club_system' database, and queries the specified collection
     * to find a user with the provided username and password.
     *
     * @param connectionString The MongoDB connection string.
     * @param enteredUsername  The username entered by the user for authentication.
     * @param enteredPassword  The password entered by the user for authentication.
     * @param collectionName   The name of the collection to authenticate against.
     * @return True if the authentication is successful, indicating that the user was found,
     * false otherwise.
     */
    public static boolean authenticateUser(String connectionString, String enteredUsername, String enteredPassword, String collectionName) {
        try {
            // Step 1: Set up MongoClient settings
            MongoClient mongoClient = MongoClients.create(connectionString);

            // Step 2: Access the 'sports_club_system' database
            MongoDatabase database = mongoClient.getDatabase("sports_club_system");

            // Step 3: Access the specified collection
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Step 4: Create a query to find the user with the provided username and password
            Document query = new Document("username", enteredUsername).append("password", enteredPassword);

            // Step 5: Execute the query and retrieve the first matching document (user)
            Document foundUser = collection.find(query).first();

            // Step 6: Close the MongoClient connection when done
            mongoClient.close();

            // Step 7: Check if the user was found
            return foundUser != null;
        } catch (Exception e) {
            // Step 8: Handle connection errors
            System.err.println("Authentication failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Initializes the UI components for the login window, including labels, text fields,
     * buttons, and panels.
     * The method sets up the overall structure of the login window
     * by defining the layout and appearance of various elements.
     * <p>
     * The sequence of operations in this method:
     * 1. Set up the main login frame, adjusting its title and size using {@code Constant.setUpJFrame}.
     * 2. Create an instance of {@code SetBackgroundImage} to serve as the background.
     * 3. Initialize and configure the login image panel (pLoginImage) with a specific size and image.
     * 4. Initialize and configure the main panel (pMain) containing username, password, and other components.
     * 5. Configure labels, text fields, and checkboxes for username and password entry.
     * 6. Set up actions for the "Show Password" checkbox to toggle password visibility.
     * 7. Initialize and configure the "Forgot Password" button (btnResetPassword) with a specific icon.
     * 8. Initialize and configure the button panel (pButton) containing login and registration buttons.
     * 9. Set up an action listener for the login button to handle authentication against admin and member collections.
     * <p>
     * Note: The method does not directly add components to the frame;
     * that is done in the {@code addComponentsToFrame} method.
     * The asynchronous invocation of this method ensures proper initialization and responsiveness of the UI components.
     *
     * @see Constant#setUpJFrame(JFrame, String, int, int) for setting up the main frame.
     * @see SetBackgroundImage for creating a background image panel.
     * @see Constant#resizeIcon(ImageIcon, int, int) for resizing icons.
     * @see Constant#lblAddMouseListener(javax.swing.JLabel, javax.swing.JTextField) for mouse listeners on labels.
     * @see Constant#setJButton(javax.swing.JButton) for setting up button styles.
     * @see #authenticateUser(String, String, String, String) for handling user authentication.
     */
    private void initializeComponents() {
        // Step 1: Set up the main login frame
        Constant.setUpJFrame(this, "Login Page", 500, 500);

        // Step 2: Create a background image panel
        loginBackground = new SetBackgroundImage();

        // Step 3: Initialize and configure the login image panel (pLoginImage)
        pLoginImage = new JPanel();
        pLoginImage.setPreferredSize(new Dimension(500, 160));
        pLoginImage.setOpaque(false);
        lblLoginImage = new JLabel();
        lblLoginImage.setIcon(Constant.resizeIcon(ResourceLoader.loginImage, 170, 170));
        pLoginImage.add(lblLoginImage);

        // Step 4: Initialize and configure the main panel (pMain)
        pMain = new JPanel();
        pMain.setLayout(null);
        pMain.setPreferredSize(new Dimension(500, 230));
        pMain.setOpaque(false);

        // Step 5: Configure labels, text fields, and checkboxes for username and password entry
        // ... (additional label, text field, and password field initialization)
        // ... (setting bounds, icons, and mouse listeners)
        lblUsername = new JLabel();
        lblUsername.setBounds(10, 0, 120, 120);
        lblUsername.setIcon(Constant.resizeIcon(ResourceLoader.userIcon, 60, 60));
        txtUsername = new JTextField();
        txtUsername.setBounds(75, 30, 400, 60);
        Constant.lblAddMouseListener(lblUsername, txtUsername);

        lblPassword = new JLabel();
        lblPassword.setBounds(10, 70, 120, 120);
        lblPassword.setIcon(Constant.resizeIcon(ResourceLoader.passwdIcon, 60, 60));
        txtPassword = new JPasswordField();
        txtPassword.setBounds(75, 100, 400, 60);
        txtPassword.setEchoChar('*');
        Constant.lblAddMouseListener(lblPassword, txtPassword);

        chkShowPassword = new JCheckBox();
        chkShowPassword.setIcon(Constant.resizeIcon(ResourceLoader.hideIcon, 20, 20));
        chkShowPassword.setBounds(72, 180, 150, 30);
        chkShowPassword.setText("SHOW PASSWORD");
        chkShowPassword.setFont(new Font("Segoe", Font.BOLD, 12));
        chkShowPassword.setForeground(Constant.btnColor);
        chkShowPassword.setContentAreaFilled(false);
        chkShowPassword.setBorderPainted(false);
        chkShowPassword.setFocusPainted(false);

        // Step 6: Set up actions for the "Show Password" checkbox
        chkShowPassword = new JCheckBox();
        chkShowPassword.addActionListener(e -> {
            // Toggle password visibility based on checkbox state
            if (txtPassword.getEchoChar() == '*') {
                txtPassword.setEchoChar((char) 0);
                chkShowPassword.setIcon(Constant.resizeIcon(ResourceLoader.showIcon, 20, 20));
            } else {
                txtPassword.setEchoChar('*');
                chkShowPassword.setIcon(Constant.resizeIcon(ResourceLoader.hideIcon, 20, 20));
            }
        });
        // ... (additional mouse listener for focusing on password field)
        chkShowPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtPassword.requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                chkShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                chkShowPassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        // Step 7: Initialize and configure the "Forgot Password" button (btnResetPassword)
        btnResetPassword = new JButton("FORGOT PASSWORD?");
        // ... (additional button configuration)
        btnResetPassword.setIcon(Constant.resizeIcon(ResourceLoader.forgotIcon, 20, 20));
        Constant.setJButton(btnResetPassword);

        // Step 8: Initialize and configure the button panel (pButton)
        pButton = new JPanel();
        pButton.setPreferredSize(new Dimension(500, 110));
        pButton.setOpaque(false);

        // Step 9: Set up an action listener for the login button
        btnLogin = new JButton("LOGIN");
        // ... (additional button configuration)
        Constant.setJButton(btnLogin);
        btnLogin.addActionListener(initializeLoginProcess -> {
            // Extract entered username and password
            String enteredUsername = getUsernameFromUI();
            String enteredPassword = getPasswordFromUI();

            // Authenticate against the admin collection
            boolean isAdmin = authenticateUser(Constant.getConnectionString(), enteredUsername, enteredPassword, "admin");

            // Authenticate against the member collection
            boolean isMember = authenticateUser(Constant.getConnectionString(), enteredUsername, enteredPassword, "member");

            // Handle authentication results
            if (isAdmin) {
                JOptionPane.showMessageDialog(null, "Admin login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.invokeLater(AdminDashboard::new);
                this.dispose();
            } else if (isMember) {
                JOptionPane.showMessageDialog(null, "Member login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // SwingUtilities.invokeLater(MemberDashboard::new);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        // ... (additional button configuration)
    }


    /**
     * Adds UI components to the main frame, arranging them within the login background.
     * The components include labels, text fields, buttons, and panels for username, password, and buttons.
     * The layout is organized using the BorderLayout manager, with distinct sections for the login image,
     * main components (username, password, etc.), and buttons.
     * <p>
     * The structure of the frame:
     * - North: login image panel containing an image representing the login page.
     * - Center: main panel containing labels, text fields, and checkboxes for username and password entry.
     * - South: button panel containing buttons for actions like login and registration.
     */
    private void addComponentsToFrame() {
        // Add the login background to the main content pane of the frame
        this.getContentPane().add(loginBackground);

        // Add components to the main panel (pMain)
        pMain.add(lblUsername);        // Label for username
        pMain.add(txtUsername);        // Text field for username input
        pMain.add(lblPassword);        // Label for password
        pMain.add(txtPassword);        // Password field for password input
        pMain.add(chkShowPassword);    // Checkbox for showing/hiding password
        pMain.add(btnResetPassword);   // Button for resetting password

        // Add components to the button panel (pButton)
        pButton.add(btnLogin);         // Button for login action
        pButton.add(btnRegister);      // Button for registration

        // Add panels to the login background with specified layout positions
        loginBackground.add(pLoginImage, BorderLayout.NORTH);  // Login image panel at the top
        loginBackground.add(pMain, BorderLayout.CENTER);      // Main panel at the center
        loginBackground.add(pButton, BorderLayout.SOUTH);     // Button panel at the bottom
    }


    /**
     * Retrieves the username entered by the user from the associated text field (txtUsername).
     *
     * @return The entered username as a String.
     * <p>
     * This method is used to obtain the text content of the username text field (txtUsername)
     * within the login window.
     * The entered username is essential for user authentication
     * during the login process.
     * By invoking this method, the current value of the username
     * text field is retrieved and returned as a String.
     * @see #txtUsername The JTextField associated with the username input.
     */
    private String getUsernameFromUI() {
        return txtUsername.getText();
    }

    /**
     * Retrieves the password entered by the user from the associated password field (txtPassword).
     *
     * @return The entered password as a String.
     * <p>
     * This method is used to obtain the text content of the password field (txtPassword)
     * within the login window.
     * The entered password is crucial for user authentication
     * during the login process.
     * By invoking this method, the current value of the password
     * field is retrieved and returned as a String.
     * Note that the password is retrieved
     * securely using the getPassword method of the JPasswordField and converted to a String.
     * @see #txtPassword The JPasswordField associated with the password input.
     */
    private String getPasswordFromUI() {
        return new String(txtPassword.getPassword());
    }

}
