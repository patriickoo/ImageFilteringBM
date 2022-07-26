package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.controller.Controller;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.PixelGrid;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.frame.IFBMFrame;

public class IFBM {

    public static void main(String[] args) {

        IFBMFrame view = new IFBMFrame();
        PixelGrid model = new PixelGrid(
                view.getMainPanel().getImageViewerPanel().getImage()
        );
        new Controller(model, view);

    }

}
