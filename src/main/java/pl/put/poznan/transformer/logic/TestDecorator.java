package pl.put.poznan.transformer.logic;

// Dekorator testowy
public class TestDecorator extends TextDecorator {

    public TestDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    @Override
    public String transform(String text) {
        text = textTransform.transform(text);

        return text + " abba";
    }
}