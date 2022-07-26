package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.frame;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel.IFBMMainPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class IFBMFrame extends JFrame {

    private final IFBMMainPanel panel;

    public IFBMFrame() {

        super();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((screenSize.width)*4/5, (screenSize.height)*4/5);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new IFBMMainPanel();
        panel.setDimension(this.getWidth(), this.getHeight());
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.setVisible(true);
        this.add(panel, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public IFBMMainPanel getMainPanel() {
        return panel;
    }
}
