package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter.ImageFilterFactory;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel.secondary.ChooserPanel;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel.secondary.ImageViewerPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IFBMMainPanel extends JPanel {

    private int availableWidth;
    private int availableHeight;
    private ChooserPanel chooserPanel;
    private ImageViewerPanel imageViewerPanel;

    public IFBMMainPanel() {

        super();

        this.setLayout(null);

    }

    public void setDimension(int width, int height) {

        availableHeight = height;
        availableWidth = width;
        this.setSize(availableWidth, availableHeight);

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void init() throws IOException {

        imageViewerPanel = new ImageViewerPanel(
                ImageIO.read(
                        Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/bin/image_library/placeholder.jpg"))
                ),
                new Dimension((availableWidth*2/3)-(availableWidth/20), (availableHeight)-(availableHeight/20))
        );
        imageViewerPanel.setSize((availableWidth*2/3)-(availableWidth/20), (availableHeight)-(availableHeight/20));
        imageViewerPanel.setBounds(availableWidth/20, availableHeight/20, availableWidth*2/3, availableHeight);
        this.add(imageViewerPanel);

        chooserPanel = new ChooserPanel(
                ImageFilterFactory.getFilters(), new Dimension(availableWidth/3+availableWidth/20, availableHeight/20)
        );
        chooserPanel.setSize((availableWidth/3)-(availableWidth/20), (availableHeight)-(availableHeight/20));
        chooserPanel.setBounds(availableWidth*2/3, availableHeight/20, availableWidth/3, availableHeight);
        this.add(chooserPanel);

    }


    public ChooserPanel getFilterChooserPanel() {
        return chooserPanel;
    }

    public ImageViewerPanel getImageViewerPanel() {
        return imageViewerPanel;
    }

}
