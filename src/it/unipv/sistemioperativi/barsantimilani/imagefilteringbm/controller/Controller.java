package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.controller;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.pixel.PixelGrid;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.components.FilterButton;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.frame.IFBMFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The Controller class of the MVC pattern for this project.
 * This is what connects the model to the view.
 *
 * @author barsanti-milani
 */
public class Controller {

    private PixelGrid model;
    private final IFBMFrame view;

    public Controller(PixelGrid pixelGrid, IFBMFrame frame) {

        this.model = pixelGrid;
        this.view = frame;

        addActionListeners();

    }

    private void addActionListeners() {

        view.getMainPanel().getFilterChooserPanel().getFileSelectorButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileFilter(
                                new FileNameExtensionFilter("Image", "png", "jpg", "jpeg")
                        );

                        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                            BufferedImage newImage = null;
                            try {
                                newImage = ImageIO.read(fileChooser.getSelectedFile());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            assert newImage != null;
                            view.getMainPanel().getImageViewerPanel().setImage(newImage);
                            model = new PixelGrid(newImage);

                        }

                    }
                }
        );

        for(FilterButton filterButton : view.getMainPanel().getFilterChooserPanel().getFilterButtons()) {

            filterButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            FilterButton fb = (FilterButton) e.getSource();
                            model = new PixelGrid(view.getMainPanel().getImageViewerPanel().getImage());
                            model.applyFilter(fb.getFilter());
                            view.getMainPanel().getImageViewerPanel().updateImage(model.toBufferedImage());

                        }
                    }
            );

        }

    }

}
