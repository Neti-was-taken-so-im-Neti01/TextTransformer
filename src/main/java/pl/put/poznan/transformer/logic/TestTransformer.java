package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do wykonywania testów.
 */
public class TestTransformer {

    public static void main(String[] args) {
        System.out.println("--DecoratorTest--");
        DecoratorTest.run();

        System.out.println("\n--IntegersToWordsTest--");
        IntegersToWordsTest.run();
    }
}

/**
 * Test TextDecorator'a
 */
class DecoratorTest {

    public static void run() {
        String[] transforms = {"teSt"};

        TextTransformer transformer = new TextTransformer(transforms);

        String result = transformer.transform("Ala ma kota");

        System.out.println(result);
    }
}

/**
 * Test IntegersToWordsDecorator'a
 */
class IntegersToWordsTest {

    public static void run() {
        TextTransformer transformer = new TextTransformer(
                new String[]{"INTEGERS_TO_WORDS"}
        );

        String[][] cases = {
                {"0, 10, 41, 50", "zero, dziesięć, czterdzieści jeden, pięćdziesiąt"},
                {"100, 101, 110, 123", "sto, sto jeden, sto dziesięć, sto dwadzieścia trzy"},
                {"999, 1000, -123, -1000", "dziewięćset dziewięćdziesiąt dziewięć, tysiąc, minus sto dwadzieścia trzy, minus tysiąc"},
                {"1001 -1001 3.14 -2,5 abc123", "1001 -1001 3.14 -2,5 abc123"},
                {"Kot Ali ma 9 żyć a jej pies 99 miesięcy.", "Kot Ali ma dziewięć żyć a jej pies dziewięćdziesiąt dziewięć miesięcy."}
        };

        for (String[] testCase : cases) {
            String input = testCase[0];
            String expected = testCase[1];
            String actual = transformer.transform(input);

            //Input, Output, Actual
            System.out.println("I: '" + input + "' \nE: '" + expected + "' \nA: '" + actual + "'");
            System.out.println(expected.equals(actual) ? "OK" : "BŁĄD");
            System.out.println();
        }
    }
}