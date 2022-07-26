package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.panel.secondary;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter.ImageFilter;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.components.FilterButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChooserPanel extends JPanel {

    private final FilterButton[] filterButtons;
    private final JButton fileSelectorButton;

    public ChooserPanel(ImageFilter[] filters, Dimension dimension) {

        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        fileSelectorButton = new JButton("Select new image");
        fileSelectorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(fileSelectorButton);

        JLabel title = new JLabel("Choose a filter:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(new EmptyBorder(100,10,10,10));
        this.add(title);

        filterButtons = new FilterButton[filters.length];

        int j=0;
        int buttonHeight = dimension.height/filters.length;
        int buttonWidth = dimension.width;
        for(ImageFilter filter : filters){

            filterButtons[j] = new FilterButton(filter);
            filterButtons[j].setBounds(
                    0, j*buttonHeight, buttonWidth, buttonHeight
            );
            filterButtons[j].setAlignmentX(Component.CENTER_ALIGNMENT);

            this.add(
                    filterButtons[j]
            );

            j++;

        }

    }

    public FilterButton[] getFilterButtons() {
        return filterButtons;
    }

    public JButton getFileSelectorButton(){
        return fileSelectorButton;
    }

}
