package org.club;

import javax.swing.*;

/**
 * The main class of the sports club application.
 *
 * @author GKY
 * @version 1.0 (26 Nov 2023)
 */
public class Main {
    /**
     * The entry point for the sports club system application.
     * <p>
     * This main method serves as the entry point for the sports club system application.
     * It initiates the loading of required resources, such as images, using the ResourceLoader.
     * Additionally, it schedules the execution of the Login window on the event dispatch thread
     * using {@code SwingUtilities.invokeLater(Login::new)}.
     * <p>
     * Note: The TODO comment suggests that further program development should make the Login
     * screen the starting point for the application.
     *
     * @param args The command-line arguments provided to the program (not used in this application).
     * @see ResourceLoader
     * @see SwingUtilities#invokeLater(Runnable)
     * @see Login
     */
    public static void main(String[] args) {
        /* Load the required resources */
        new ResourceLoader();

        /* TODO: Make the program start with the Login screen */
        SwingUtilities.invokeLater(AdminDashboard::new);
    }
}
