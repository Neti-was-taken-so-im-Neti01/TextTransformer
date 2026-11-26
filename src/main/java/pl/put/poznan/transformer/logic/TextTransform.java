package pl.put.poznan.transformer.logic;

/**
 * Interfejs dla wszystkich klas odpowiedzialnych za transformacje tekstu.
 * Dzięki niemu obiekt bazowy i dekoratory mogą być używane w ten sam sposób.
 */
public interface TextTransform {
    String transform(String text);
}