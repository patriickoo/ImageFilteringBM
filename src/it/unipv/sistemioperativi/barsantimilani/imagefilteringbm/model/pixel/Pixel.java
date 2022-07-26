package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.pixel;

import it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter.ImageFilter;

/**
 * Represents an ARGB pixel.
 *
 * @author barsanti-milani
 */
public class Pixel {

    private int alpha;
    private int red;
    private int green;
    private int blue;

    /**
     * Default constructor.
     * @param argbPixel an ARGB pixel in integer form.
     */
    public Pixel(int argbPixel) {

        //get alpha
        this.alpha = (argbPixel >> 24) & 0xff;

        //get red
        this.red = (argbPixel >> 16) & 0xff;

        //get green
        this.green = (argbPixel >> 8) & 0xff;

        //get blue
        this.blue = argbPixel & 0xff;

    }

    /**
     * @return this Pixel converted into an integer.
     */
    public int getRGB() {
        return ( (alpha << 24) | (red << 16) | (green << 8) | (blue) );
    }

    /**
     * @return the current alpha value of this Pixel.
     */
    public int getAlpha() {
        return alpha;
    }

    /**
     * Replaces current alpha value of this Pixel.
     * @param alpha the new alpha value.
     */
    public void setAlpha(int alpha) {
        this.alpha = Math.min(Math.max(alpha, 0), 255);
    }

    /**
     * @return the current red value of this Pixel.
     */
    public int getRed() {
        return red;
    }

    /**
     * Replaces current red value of this Pixel.
     * @param red the new red value.
     */
    public void setRed(int red) {
        this.red = Math.min(Math.max(red, 0), 255);
    }

    /**
     * @return the current green value of this Pixel.
     */
    public int getGreen() {
        return green;
    }

    /**
     * Replaces current green value of this Pixel.
     * @param green the new green value.
     */
    public void setGreen(int green) {
        this.green = Math.min(Math.max(green, 0), 255);
    }

    /**
     * @return the current blue value of this Pixel.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Replaces current blue value of this Pixel.
     * @param blue the new blue value.
     */
    public void setBlue(int blue) {
        this.blue = Math.min(Math.max(blue, 0), 255);
    }

    /**
     * Applies given filter: adds the modifiers from the filter to the values of this Pixel.
     * @param filter the filter to apply.
     */
    public void applyFilter(ImageFilter filter) {

        setAlpha(alpha + filter.getAlphaModifier());
        setRed(red + filter.getRedModifier());
        setGreen(green + filter.getGreenModifier());
        setBlue(blue + filter.getBlueModifier());

    }

}
