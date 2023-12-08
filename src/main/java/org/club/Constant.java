package org.club;

import io.github.cdimascio.dotenv.Dotenv;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * A utility class containing constants and helper methods for the sports club application.
 */
public class Constant {
    // Load environment variables from .env file
    static Dotenv dotenv = Dotenv.configure().load();

    // Retrieve MongoDB connection details from environment variables
    static String database = dotenv.get("MONGO_DATABASE");
    static String user = dotenv.get("MONGO_USER");
    static String password = dotenv.get("MONGO_PASSWORD");
    static String cluster = dotenv.get("MONGO_CLUSTER");

    // Create the MongoDB connection string
    static String connectionString = "mongodb+srv://" + user + ":" + password + "@" + cluster + "/" + database;
    /* Colors */
    static Color btnColor = new Color(90, 90, 189);


    /**
     * Retrieves the MongoDB connection string used for database connectivity.
     *
     * <p>
     * This method returns the MongoDB connection string utilized for establishing
     * connectivity to the MongoDB server.
     * The connection string is typically set during
     * the initialization of the application and serves as a crucial parameter for connecting
     * to the specified MongoDB instance.
     * <p>
     * The purpose of this method is to provide a consistent and centralized way to access
     * the MongoDB connection string throughout the application.
     *
     * @return The MongoDB connection string used for database connectivity.
     */
    public static String getConnectionString() {
        return connectionString;
    }


    /**
     * Resizes a given ImageIcon to the specified width and height.
     *
     * @param image  The ImageIcon to be resized.
     * @param width  The desired width of the resized ImageIcon.
     * @param height The desired height of the resized ImageIcon.
     *               <p>
     *               This method takes an ImageIcon and scales its underlying Image to the specified width and height
     *               using a smooth scaling algorithm (Image.SCALE_SMOOTH).
     *               The resized Image is then used to create
     *               a new ImageIcon, which is returned by the method.
     *               <p>
     *               The purpose of this method is to provide a convenient way to resize ImageIcon instances for
     *               consistent visual appearance across the application.
     * @return A new ImageIcon object representing the resized image.
     * @see ImageIcon
     * @see Image
     */
    static ImageIcon resizeIcon(ImageIcon image, int width, int height) {
        // Get the Image from the ImageIcon and scale it to the specified width and height
        Image icon = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create and return a new ImageIcon from the resized Image
        return new ImageIcon(icon);
    }


    /**
     * Configures and sets up the properties for a JButton to enhance its visual appearance and behavior.
     *
     * @param button The JButton to be configured.
     *               <p>
     *               This method customizes the appearance and behavior of the provided JButton by setting its preferred size,
     *               making it non-opaque, non-filled, and removing border painting.
     *               The text color of the button is set to a
     *               predefined color (btnColor).
     *               Additionally, a mouse listener is added to the button to change the cursor to
     *               a hand cursor when the mouse enters the button
     *               and reverts it to the default cursor when the mouse exits.
     *               <p>
     *               The purpose of this method is to provide a consistent and visually appealing style for JButton components
     *               across the application and enhance user interaction by changing the cursor appearance.
     * @see JButton
     * @see Dimension
     * @see Color
     * @see MouseAdapter
     * @see Cursor
     */
    public static void setJButton(JButton button) {
        // Set preferred size for the button
        button.setPreferredSize(new Dimension(80, 40));

        // Make the button non-opaque, non-filled, and remove border painting
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        // Set the text color of the button to a predefined color (btnColor)
        button.setForeground(btnColor);

        // Add a mouse listener to the button for cursor changes
        button.addMouseListener(new MouseAdapter() {
            /**
             * Invoked when the mouse enters the button. Changes the cursor to a hand cursor.
             *
             * @param e The MouseEvent representing the mouse enter event.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            /**
             * Invoked when the mouse exits the button. Changes the cursor back to the default cursor.
             *
             * @param e The MouseEvent representing the mouse exit event.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * Configures and sets up the properties for a JFrame, providing a basic setup for a graphical window.
     *
     * @param frame  The JFrame to be configured.
     * @param title  The title to be set for the JFrame.
     * @param width  The width of the JFrame.
     * @param height The height of the JFrame.
     *               <p>
     *               This method is responsible for configuring essential properties of a JFrame, including setting its title,
     *               size, resizable status,
     *               location on the screen (centered), visibility, and default close operation.
     *               The JFrame's title is set using the provided title parameter, and its size is set to the specified width
     *               and height.
     *               The frame is configured to be non-resizable, centered on the screen, and made visible.
     *               Additionally, the default close operation is set to exit the application when the close button is clicked.
     *               <p>
     *               Note: The "TODO" comment suggests removing or updating the close operation as needed for the specific use case.
     * @see JFrame
     * @see WindowConstants#EXIT_ON_CLOSE
     */
    public static void setUpJFrame(JFrame frame, String title, int width, int height) {
        /* Set up the JFrame properties */
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); /* Center the JFrame on the screen */
        frame.setVisible(true);

        /* TODO: Remember to remove or update the close operation based on the specific requirements */
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Adds a mouse listener to a specified JLabel to interact with a JTextField.
     *
     * @param label     The JLabel to which the mouse listener is added.
     * @param textField The JTextField associated with the specified JLabel.
     *                  <p>
     *                  This method adds a mouse listener to the provided JLabel, allowing interaction
     *                  with a JTextField.
     *                  When the label is clicked, it requests focus for the associated
     *                  text field using {@code textField.requestFocusInWindow()}.
     *                  Additionally, when the
     *                  mouse enters the label, a tooltip with the text "Password" is set for the label.
     *                  <p>
     *                  The purpose of this method is to enhance user experience by providing an alternative
     *                  way to focus on the associated text field and offering helpful information via tooltips.
     * @see JLabel
     * @see JTextField
     * @see MouseEvent
     * @see MouseAdapter
     */
    public static void lblAddMouseListener(JLabel label, JTextField textField) {
        label.addMouseListener(new MouseAdapter() {
            /**
             * Invoked when the label is clicked. Requests focus on the associated text field.
             *
             * @param e The MouseEvent representing the click event.
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.requestFocusInWindow();
            }

            /**
             * Invoked when the mouse enters the label. Sets a tooltip with the text "Password."
             *
             * @param e The MouseEvent representing the mouse enter event.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setToolTipText("Password");
            }
        });
    }


    /**
     * Sets the look and feel for a specified JFrame using the Nimbus look and feel.
     *
     * @param frame The JFrame for which to set the look and feel.
     *              <p>
     *              This method sets the Nimbus look and feels for the provided JFrame, providing a consistent
     *              and modern appearance to Swing-based user interfaces.
     *              The Nimbus look and feel is specified
     *              by the class "javax.swing.plaf.nimbus.NimbusLookAndFeel."
     *              <p>
     *              If successful, the UI of the JFrame is updated to use the chosen look and feel using the
     *              {@code SwingUtilities.updateComponentTreeUI} method.
     *              If any exceptions occur during the process,
     *              such as ClassNotFoundException, InstantiationException, IllegalAccessException, or
     *              UnsupportedLookAndFeelException, a RuntimeException is thrown with details of the exception.
     * @throws RuntimeException If an error occurs while attempting to set the look and feel or
     *                          update the UI.
     *                          The RuntimeException includes details of the exception.
     * @see JFrame
     * @see UIManager#setLookAndFeel(String)
     * @see SwingUtilities#updateComponentTreeUI(java.awt.Component)
     */
    public static void setLookAndFeel(JFrame frame) {
        try {
            /* Set look and feel to Nimbus */
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            // Update the UI to use the chosen look and feel
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            // Throw a RuntimeException with details of the exception if an error occurs
            throw new RuntimeException(e);
        }
    }


    /**
     * Sets the icon for a specified JFrame.
     *
     * @param frame The JFrame for which to set the icon.
     *              <p>
     *              This method attempts to set a custom icon for the provided JFrame by loading
     *              an image file named "club.png" from the specified resource path.
     *              If successful,
     *              the loaded image is set as the icon for the JFrame using the {@code setIconImage}
     *              method.
     *              If the image file cannot be loaded or an IOException occurs during the
     *              process, a RuntimeException is thrown with details of the exception.
     *              <p>
     *              Note: The image file "club.png" is expected to be located in the "src/main/resources/images/"
     *              directory.
     *              Ensure that the file is present at the specified path for the icon to be set successfully.
     * @throws RuntimeException If an IOException occurs while attempting to load the image
     *                          or set it as the frame icon.
     *                          The RuntimeException includes details of the exception.
     * @see JFrame#setIconImage(java.awt.Image)
     * @see ImageIO#read(java.io.File)
     */
    public static void setFrameIcon(JFrame frame) {
        /* Set icon for the frame */
        try {
            // Load the image file from the specified resource path
            Image imageIcon = ImageIO.read(new File("src/main/resources/images/club.png"));

            // Set the loaded image as the icon for the JFrame
            frame.setIconImage(imageIcon);
        } catch (IOException e) {
            // Throw a RuntimeException with details of the exception if an error occurs
            throw new RuntimeException(e);
        }
    }

}
