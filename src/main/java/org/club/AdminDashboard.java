package org.club;

import javax.swing.*;
import java.awt.*;

/**
 * The AdminDashboard class represents the main dashboard for the admin user.
 * It extends JFrame to create the graphical user interface.
 */
public class AdminDashboard extends JFrame {
    SetBackgroundImage adminDashboardBackground;
    JPanel mainDashboard;
    JMenuBar menuBar;
    JMenu userMenu, membershipMenu, gameMenu, fileMenu, membersMenu, groupMenu, sportsMenu, storeMenu, transactionsMenu, eventsMenu, scheduleMenu, reportsMenu, helpMenu, profileMenu;
    JMenuItem createUserItem, editUserItem, deactivateUserItem;
    JMenuItem approveMembershipItem, renewMembershipItem, manageFeesItem;
    JMenuItem addGameItem, editGameItem, removeGameItem;

    /**
     * Instantiates a new Admin dashboard.
     * Constructor for creating an instance of the AdminDashboard class.
     * It sets the look and feel, sets the frame icon, and initializes the dashboard.
     */
    public AdminDashboard() {
        // Set the look and feel to provide a consistent appearance
        Constant.setLookAndFeel(this);
        // Set the frame icon to a specific image or icon
        Constant.setFrameIcon(this);
        // Asynchronously invoke the methods to initialize and add UI components
        SwingUtilities.invokeLater(this::initializeAdminDashboardComponents);
        SwingUtilities.invokeLater(this::addComponentsToFrame);
        // Pack the frame to adjust its size based on component preferences
        pack();
    }

    /**
     * Initializes the admin dashboard.
     * Private method to set up the graphical components of the admin dashboard.
     */
    private void initializeAdminDashboardComponents() {
        /* Set up the login frame */
        // Set up JFrame with specified title and size
        Constant.setUpJFrame(this, "Admin Dashboard", 1900, 1000);
        /* Set the background,  */
        // Create a background image panel and add it to the content pane
        adminDashboardBackground = new SetBackgroundImage();
        this.getContentPane().add(adminDashboardBackground);

        mainDashboard = new JPanel();
        mainDashboard.setOpaque(false);
        int width = this.getWidth();
        int height = this.getHeight();
        mainDashboard.setPreferredSize(new Dimension(width, (height - 100)));

        // Create the menu bar
        menuBar = new JMenuBar() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color
                g.setColor(new Color(255, 255, 255));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        menuBar.setPreferredSize(new Dimension((width - 100), 30));
        // User Management Menu
        userMenu = new JMenu("User Management");
        createUserItem = new JMenuItem("Create User");
        editUserItem = new JMenuItem("Edit User");
        deactivateUserItem = new JMenuItem("Deactivate User");

        // Membership Management Menu
        membershipMenu = new JMenu("Membership Management");
        approveMembershipItem = new JMenuItem("Approve Membership");
        renewMembershipItem = new JMenuItem("Renew Membership");
        manageFeesItem = new JMenuItem("Manage Fees");


        // Game Management Menu
        gameMenu = new JMenu("Game Management");
        addGameItem = new JMenuItem("Add Game");
        editGameItem = new JMenuItem("Edit Game");
        removeGameItem = new JMenuItem("Remove Game");
    }

    private void addComponentsToFrame() {
        userMenu.add(createUserItem);
        userMenu.add(editUserItem);
        userMenu.add(deactivateUserItem);

        membershipMenu.add(approveMembershipItem);
        membershipMenu.add(renewMembershipItem);
        membershipMenu.add(manageFeesItem);

        gameMenu.add(addGameItem);
        gameMenu.add(editGameItem);
        gameMenu.add(removeGameItem);

        menuBar.add(userMenu);
        menuBar.add(membershipMenu);
        menuBar.add(gameMenu);

        adminDashboardBackground.add(menuBar, BorderLayout.NORTH);
        adminDashboardBackground.add(mainDashboard, BorderLayout.SOUTH);
    }
}
