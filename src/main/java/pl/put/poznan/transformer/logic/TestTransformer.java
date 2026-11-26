package pl.put.poznan.transformer.logic;


// Klasa służąca do wykonywania testów
public class TestTransformer {

    public static void main(String[] args) {

        String[] transforms = {"teSt"};

        TextTransformer transformer = new TextTransformer(transforms);

        String result = transformer.transform("Ala ma kota");

        System.out.println(result);
    }
}