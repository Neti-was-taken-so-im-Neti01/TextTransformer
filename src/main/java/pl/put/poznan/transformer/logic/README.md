
## Wzorzec Dekorator

Każdy dekorator implementuje interfejs `TextTransform` i dodaje własną operację, np.  dopisywanie ` abba`.

`BasicTextTransform` jest podstawowym obiektem, który nie zmienia tekstu. `TextDecorator` jest klasą bazową dla dekoratorów i przechowuje obiekt, na którym wykonywana jest wcześniejsza transformacja. `TextTransformer` tworzy łańcuch dekoratorów na podstawie przekazanych nazw transformacji.

### Przykład działania

Dla transformacji `TEST` i tekstu:

```text
Ala ma kota
```

Wynik:

```text
Ala ma kota abba
```

### Dodatkowe informacje

Jako template do kolejnych dekoratorów można wykorzystać `TestDecorator`

`text = textTransform.transform(text);` --> należy pamiętać o tej linijce na początku każdej nowej transformacji ponieważ wywołuje poprzednią transformację. Bez niej transformacje bedą się nadpisywać zamiast wykonywać w łańcuchu.

## Konwersja liczb całkowitych

`IntegersToWordsDecorator` zamienia liczby od -1000 do 1000 na polskie słowa. Ułamki i liczby poza zakresem pozostają bez zmian.

### Przykład działania

Dla transformacji `INTEGERS_TO_WORDS`:

```text
Ala ma 23 koty.
```

Wynik:

```text
Ala ma dwadzieścia trzy koty.
```

### Testy

Klasa `IntegersToWordsTest` w pliku `TestTransformer.java` sprawdza liczby dodatnie, ujemne, granice zakresu, ułamki i liczby w tekście. Wypisuje `OK` lub `BŁĄD`.

| Wejście | Oczekiwany wynik | Otrzymany wynik | Stan |
| --- | --- | --- | --- |
| 0, 10, 41, 50 | zero, dziesięć, czterdzieści jeden, pięćdziesiąt | zero, dziesięć, czterdzieści jeden, pięćdziesiąt | OK |
| 100, 101, 110, 123 | sto, sto jeden, sto dziesięć, sto dwadzieścia trzy | sto, sto jeden, sto dziesięć, sto dwadzieścia trzy | OK |
| 999, 1000, -123, -1000 | dziewięćset dziewięćdziesiąt dziewięć, tysiąc, minus sto dwadzieścia trzy, minus tysiąc | dziewięćset dziewięćdziesiąt dziewięć, tysiąc, minus sto dwadzieścia trzy, minus tysiąc | OK |
| 1001 -1001 3.14 -2,5 abc123 | 1001 -1001 3.14 -2,5 abc123 | 1001 -1001 3.14 -2,5 abc123 | OK |
| Kot Ali ma 9 żyć a jej pies 99 miesięcy. | Kot Ali ma dziewięć żyć a jej pies dziewięćdziesiąt dziewięć miesięcy. | Kot Ali ma dziewięć żyć a jej pies dziewięćdziesiąt dziewięć miesięcy. | OK |