package it.unipv.sistemioperativi.barsantimilani.imagefilteringbm.model.filter;

/**
 * Represents a filter that can be applied to an image.
 * When the filter is applied, modifiers are added (or subtracted) from the corresponding values already present in the Pixel.
 *
 * @author barsanti-milani
 */
public class ImageFilter {

    private final int alphaModifier;
    private final int redModifier;
    private final int greenModifier;
    private final int blueModifier;
    private final String name;

    /**
     * Default constructor.
     * @param name the name of this filter.
     * @param alphaModifier the modifier for alpha value.
     * @param redModifier the modifier for red value.
     * @param greenModifier the modifier for green value.
     * @param blueModifier the modifier for blue value.
     */
    public ImageFilter(String name, int alphaModifier, int redModifier, int greenModifier, int blueModifier) {

        this.name = name;
        this.alphaModifier = alphaModifier;
        this.redModifier = redModifier;
        this.greenModifier = greenModifier;
        this.blueModifier = blueModifier;

    }

    /**
     * @return the name of this filter.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value of alpha modifier.
     */
    public int getAlphaModifier() {
        return alphaModifier;
    }

    /**
     * @return the value of red modifier.
     */
    public int getRedModifier() {
        return redModifier;
    }

    /**
     * @return the value of green modifier.
     */
    public int getGreenModifier() {
        return greenModifier;
    }

    /**
     * @return the value of blue modifier.
     */
    public int getBlueModifier() {
        return blueModifier;
    }

}
