package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel.secondary;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageViewerPanel extends JPanel {

    private BufferedImage image;
    private BufferedImage imageBackup;
    private final int maxWidth;
    private final int maxHeight;
    private final JLabel imageLabel;

    public ImageViewerPanel(BufferedImage image, Dimension dimension) {

        super();
        this.setLayout(new FlowLayout());
        this.image = image;
        imageBackup = this.image;

        maxWidth = dimension.width;
        maxHeight = dimension.height;

        imageLabel = new JLabel();
        displayImage(this.image);
        imageLabel.setSize(dimension);

        this.add(imageLabel);

        this.setVisible(true);

    }

    public BufferedImage getImage() {
        return imageBackup;
    }

    public void updateImage(BufferedImage image) {
        this.image = image;
        displayImage(this.image);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        imageBackup = this.image;
        displayImage(this.image);
    }

    private void displayImage(BufferedImage image) {
        imageLabel.setIcon(
                new ImageIcon(resize(image))
        );
    }

    /**
     * Resizes the given image to fit in the panel, maintaining its original aspect ratio.
     * @param image the image to resize.
     * @return the resized image with original aspect ratio.
     */
    private Image resize(BufferedImage image) {

        double aspectRatio = (double) image.getWidth() / image.getHeight();
        int newWidth;
        int newHeight;

        if(image.getWidth() >= image.getHeight()) {

            newWidth = Math.min(maxWidth, image.getWidth());
            newHeight = (int) (newWidth / aspectRatio);

        } else {

            newHeight = Math.min(maxHeight, image.getHeight());
            newWidth = (int) (newHeight * aspectRatio);

        }

        return image.getScaledInstance(
                newWidth,
                newHeight,
                Image.SCALE_SMOOTH
        );

    }

}
