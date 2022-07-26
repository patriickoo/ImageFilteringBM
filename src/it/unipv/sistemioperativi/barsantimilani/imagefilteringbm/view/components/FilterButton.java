package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.view.components;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter.ImageFilter;

import javax.swing.*;

public class FilterButton extends JButton {

    private final ImageFilter filter;

    public FilterButton(ImageFilter filter) {

        super(filter.getName());
        this.filter = filter;

    }

    public ImageFilter getFilter() {
        return filter;
    }

}
