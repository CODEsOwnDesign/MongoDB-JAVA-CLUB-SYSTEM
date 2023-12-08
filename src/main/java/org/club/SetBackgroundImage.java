package org.club;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A custom JPanel class for setting a background image.
 * <p>
 * This JPanel extension allows setting a background image for a panel.
 * It overrides the
 * `paintComponent` method to paint the background image, ensuring that the image scales
 * and fits the dimensions of the panel.
 * <p>
 * The background image is retrieved from the {@code ResourceLoader} class, and the paint
 * operation is performed using a `BufferedImage` to achieve proper scaling.
 */
public class SetBackgroundImage extends JPanel {
    /**
     * Overrides the paintComponent method to paint the background image.
     *
     * @param g The Graphics object used for painting.
     *          <p>
     *          This method first checks if the background image is available from the {@code ResourceLoader}.
     *          If available, it retrieves the panel dimensions, creates a `BufferedImage` with the panel dimensions,
     *          obtains a graphics context for the `BufferedImage`, scales and draws the background image to fit
     *          the panel's dimensions, disposes of the graphics context, and finally draws the buffered image to the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Check if the background image is available
        if (ResourceLoader.backgroundImage != null) {
            // Get the panel dimensions
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();

            // Create a BufferedImage with the panel dimensions
            BufferedImage bufferedImage = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);

            // Get a graphics context for the bufferedImage
            Graphics2D bufferedGraphics = bufferedImage.createGraphics();

            // Scale and draw the background image to fit the panel's dimensions
            bufferedGraphics.drawImage(ResourceLoader.backgroundImage, 0, 0, panelWidth, panelHeight, this);

            // Dispose of the graphics context
            bufferedGraphics.dispose();

            // Draw the buffered image to the panel
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}
