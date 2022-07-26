package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter;

public abstract class ImageFilterFactory {

    private static ImageFilter[] filters;

    public static ImageFilter[] getFilters() {

        if(filters == null) {
            populateFilters();
        }

        return filters;

    }

    private static void populateFilters() {

        filters = new ImageFilter[12];
        filters[0] = new ImageFilter("Default", 0, 0, 0, 0);
        filters[1] = new ImageFilter("Red", 0, 100, -20, -20);
        filters[2] = new ImageFilter("Green", 0, -20, 100, -20);
        filters[3] = new ImageFilter("Blue", 0, -20, -20, 100);
        filters[4] = new ImageFilter("Filter 1", 0, 50, -50, -50);
        filters[5] = new ImageFilter("Filter 2", 0, -50, 50, -50);
        filters[6] = new ImageFilter("Filter 3", 0, -50, -50, 50);
        filters[7] = new ImageFilter("Filter 4", -100, 0, 0, 0);
        filters[8] = new ImageFilter("Filter 5", -50, 30, 30, 30);
        filters[9] = new ImageFilter("Filter 6", -200, 100, 100, 100);
        filters[10] = new ImageFilter("Filter 7", 0, 15, 15, 15);
        filters[11] = new ImageFilter("Filter 8", 0, 44, -11, 57);

    }

}
