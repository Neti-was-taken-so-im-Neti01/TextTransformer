package pl.put.poznan.transformer.logic;

/**
 * Klasa bazowa dla dekoratorów.
 * Przechowuje obiekt, który zostanie opakowany kolejną transformacją.
 */
public abstract class TextDecorator implements TextTransform {

    protected TextTransform textTransform;

    public TextDecorator(TextTransform textTransform) {
        this.textTransform = textTransform;
    }
}
