package pl.put.poznan.transformer.logic;

/**
 * Podstawowy obiekt, który nie wykonuje żadnej transformacji.
 * Na nim budowany jest łańcuch dekoratorów.
 */
public class BasicTextTransform implements TextTransform {
    
    @Override
    public String transform(String text) {
        return text;
    }
}