package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter.ImageFilter;
import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.pixel.Pixel;

import java.awt.image.BufferedImage;

/**
 * Represents an image made up of Pixel objects.
 *
 * @author barsanti-milani
 */
public class PixelGrid {

    private final Pixel[][] pixels;
    private final int width;
    private final int height;
    private final Thread[] workerThreads;

    /**
     * Default constructor, creates a PixelGrid using a BufferedImage.
     * @param image the BufferedImage to translate.
     */
    public PixelGrid(BufferedImage image) {

        width = image.getWidth();
        height = image.getHeight();
        pixels = new Pixel[width][height];
        workerThreads = new Thread[height];

        for(int i = 0; i < height; i++){

            int rowIndex = i;

            workerThreads[i] = new Thread() {
                @Override
                public void run() {

                    readRow(rowIndex, image);

                }
            };
            workerThreads[i].start();

        }

        try {

            for (Thread thread : workerThreads) {
                thread.join();  // waiting for all threads to finish before going ahead.
            }

            System.out.println("PixelGrid created. Threads joined. (PixelGrid - default constructor - ln50)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Instances every Pixel object from a specific row of a BufferedImage.
     * @param index the row to read.
     * @param image the image to refer to.
     */
    private void readRow(int index, BufferedImage image){

        for(int i = 0; i < width; i++){

            pixels[i][index] = new Pixel(image.getRGB(i, index));

        }

    }

    /**
     * @return the PixelGrid converted into a BufferedImage.
     */
    public BufferedImage toBufferedImage() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for(int i = 0; i < height; i++) {  // create and start a new Thread for every row.

            int rowIndex = i;
            workerThreads[i] = new Thread() {
                @Override
                public void run() {

                    writeRow(rowIndex, image);

                }
            };
            workerThreads[i].start();

        }

        try {

            for (Thread thread : workerThreads) {
                thread.join();  // waiting for all threads to finish before going ahead.
            }

            System.out.println("BufferedImage created. Threads joined. (PixelGrid - toBufferedImage() - ln99)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return image;

    }

    /**
     * Writes every Pixel object to a specific row of a BufferedImage.
     * @param index the row to write.
     * @param image the image to refer to.
     */
    private void writeRow(int index, BufferedImage image) {

        for(int i = 0; i < width; i++){

            image.setRGB(i, index, pixels[i][index].getRGB());

        }

    }

    /**
     * Applies given filter to all pixels of this PixelGrid.
     * @param filter the filter to apply.
     */
    public void applyFilter(ImageFilter filter) {

        for(int i = 0; i < height; i++){

            int rowIndex = i;

            workerThreads[i] = new Thread() {
                @Override
                public void run() {

                    applyFilterToRow(rowIndex, filter);

                }
            };
            workerThreads[i].start();

        }

        try {

            for (Thread thread : workerThreads) {
                thread.join();  // waiting for all threads to finish before going ahead.
            }

            System.out.println("Filter applied. Threads joined. (PixelGrid - applyFilter(filter) - ln150)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Applies given filter to specific row of this PixelGrid
     * @param index the index of the row.
     * @param filter the filter to apply.
     */
    private void applyFilterToRow(int index, ImageFilter filter){

        for(int i = 0; i < width; i++){

            pixels[i][index].applyFilter(filter);

        }

    }

    /**
     * @param x the X coordinate.
     * @param y the Y coordinate.
     * @return the Pixel corresponding to the given coordinates.
     */
    public Pixel getPixel(int x, int y) {

        return pixels[x][y];

    }

    /**
     * Replaces the Pixel corresponding to the given coordinates with another.
     * @param pixel the new Pixel.
     * @param x the X coordinate.
     * @param y the Y coordinate.
     */
    public void setPixel(Pixel pixel, int x, int y) {

        pixels[x][y] = pixel;

    }

}
