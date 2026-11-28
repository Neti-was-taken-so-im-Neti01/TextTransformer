package pl.put.poznan.transformer.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dekorator zamieniający liczby całkowite od -1000 do 1000 na polski zapis słowny.
 * Liczby poza zakresem i ułamki pozostają bez zmian.
 */
public class IntegersToWordsDecorator extends TextDecorator {

    // Wyszukuje liczby z opcjonalnym znakiem + lub -.
    // Przed i po liczbie dopuszcza początek lub koniec tekstu, biały znak albo jeden ze znaków: . , ; : ! ? ( ) [ ] { }
    // Dopasowuje również cały zapis ułamkowy, np. 3.14 lub 2,5, aby podczas konwersji pozostawić go bez zmian.
    private static final Pattern NUMBER = Pattern.compile(
            "(?<![^\\s.,;:!?()\\[\\]{}])[+-]?[0-9]+([.,][0-9]+)*(?![^\\s.,;:!?()\\[\\]{}])"
    );

    private static final String[] UNITS = {
            "zero",
            "jeden",
            "dwa",
            "trzy",
            "cztery",
            "pięć",
            "sześć",
            "siedem",
            "osiem",
            "dziewięć"
    };

    private static final String[] TEENS = {
            "dziesięć",
            "jedenaście",
            "dwanaście",
            "trzynaście",
            "czternaście",
            "piętnaście",
            "szesnaście",
            "siedemnaście",
            "osiemnaście",
            "dziewiętnaście"
    };

    private static final String[] TENS = {
            "", "",
            "dwadzieścia",
            "trzydzieści",
            "czterdzieści",
            "pięćdziesiąt",
            "sześćdziesiąt",
            "siedemdziesiąt",
            "osiemdziesiąt",
            "dziewięćdziesiąt"
    };

    private static final String[] HUNDREDS = {
            "",
            "sto",
            "dwieście",
            "trzysta",
            "czterysta",
            "pięćset",
            "sześćset",
            "siedemset",
            "osiemset",
            "dziewięćset"
    };

    public IntegersToWordsDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    @Override
    public String transform(String text) {

        text = textTransform.transform(text);

        Matcher matcher = NUMBER.matcher(text);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String original = matcher.group();
            String replacement = original;

            try {
                int number = Integer.parseInt(original);

                if (number >= -1000 && number <= 1000) {
                    replacement = toWords(number);
                }
            } catch (NumberFormatException exception) {
                // Ułamki i liczby przekraczające zakres int pozostają bez zmian.
            }

            matcher.appendReplacement(
                    result, Matcher.quoteReplacement(replacement)
            );
        }

        matcher.appendTail(result);
        return result.toString();
    }

    private static String toWords(int number) {
        if (number < 0) {
            return "minus " + toWords(-number);
        }

        if (number < 10) {
            return UNITS[number];
        }

        if (number < 20) {
            return TEENS[number - 10];
        }

        if (number < 100) {
            int tens = number / 10;
            int units = number % 10;
            return TENS[tens]
                    + (units == 0 ? "" : " " + toWords(units));
        }

        if (number < 1000) {
            int hundreds = number / 100;
            int rest = number % 100;
            return HUNDREDS[hundreds]
                    + (rest == 0 ? "" : " " + toWords(rest));
        }
        return "tysiąc";
    }
}