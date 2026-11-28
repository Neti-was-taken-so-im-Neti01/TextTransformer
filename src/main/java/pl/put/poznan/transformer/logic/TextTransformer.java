
package pl.put.poznan.transformer.logic;

/**
 * Klasa tworząca łańcuch dekoratorów na podstawie przekazanych transformacji
 * uruchamia go na podanym tekście.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){

        //Podstawowy obiekt nie zmieniający tekstu
        TextTransform result = new BasicTextTransform();

        if (transforms != null){
            for (String transform : transforms) {
                //Zmiana na wielkie litery zeby ujednolicic styl nazw transformacji
                switch (transform.toUpperCase()){
                    case "TEST":
                        result = new TestDecorator(result);
                        break;
                    case "INTEGERS_TO_WORDS":
                        result = new IntegersToWordsDecorator(result);
                        break;

                    default:
                        // Brak obslugi nieznanych transformacji
                        throw new IllegalArgumentException(
                            "Nieznana transformacja " + transform
                        );
                }
            }
        }
        // Uruchomienie łańcucha transformacji na tekście
        return result.transform(text);
    }
}
