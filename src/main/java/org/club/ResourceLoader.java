package org.club;

import javax.swing.*;
import java.awt.*;

/**
 * A utility class for loading resources such as images for the sports club application.
 * <p>
 * This class provides static constants representing various images used in the sports club application.
 * These images include the background image, login screen image, user icon, password icon, show and hide
 * icons for password visibility, and icons for forgotten passwords.
 * The paths to these images are specified
 * as constants and loaded as resources within the application.
 * <p>
 * The purpose of this utility class is to centralize the loading of resources, ensuring consistent access
 * to images across different parts of the application.
 */
class ResourceLoader {
    /**
     * The background image for the application.
     */
    public static final Image backgroundImage = new ImageIcon("src/main/resources/images/background.jpg").getImage();

    /**
     * The image used for the login screen.
     */
    public static final ImageIcon loginImage = new ImageIcon("src/main/resources/images/club.png");

    /**
     * The icon representing a user in the application.
     */
    public static final ImageIcon userIcon = new ImageIcon("src/main/resources/images/user.png");

    /**
     * The icon representing a password in the application.
     */
    public static ImageIcon passwdIcon = new ImageIcon("src/main/resources/images/password.png");

    /**
     * The icon representing the option to show a password.
     */
    public static ImageIcon showIcon = new ImageIcon("src/main/resources/images/show.png");

    /**
     * The icon representing the option to hide a password.
     */
    public static ImageIcon hideIcon = new ImageIcon("src/main/resources/images/hide.png");

    /**
     * The icon representing a forgotten password.
     */
    public static ImageIcon forgotIcon = new ImageIcon("src/main/resources/images/forgot.png");
}
