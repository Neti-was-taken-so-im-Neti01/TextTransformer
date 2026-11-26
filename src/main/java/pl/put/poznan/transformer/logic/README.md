
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


