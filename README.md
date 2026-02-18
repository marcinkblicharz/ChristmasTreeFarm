A) Początkowe pozycje klocków przy sprawdzaniu miejsca do ułożenia są takie jak w opisie problemu na https://adventofcode.com/2025/day/12
   
| 0 | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- |
| ### | ### | .## | ##. | ### | ### |
| ##. | ##. | ### | ### | #.. | .#. |
| ##. | .## | ##. | ##. | ### | ### |

B) Podczas generowania listy wszystkich pozycji (obroty oraz odwócenia) usuwam duplikaty co zmniejsza ilość kroków do sprawdzenia. Na przykładzie klocka [2], który finalnie może zostać ułożony na 2 sposoby, zamiast 8 (4 obroty * 2 odwrócenia)

| position 0 | position 1 |
|------------|------------|
| .##        | ##.        |
| ###        | ###        |
| ##.        | .##        |

C) Z racji założenia, że zarówno plansza (4x4 lub 12x5) oraz same klocki (3x3) są symetryczne, to pozycją startową podczas umieszczania jest 'lewy górny róg', tj. [0][0]. Podczas kolejnych kroków przesuwam się na planszy w prawo oraz w dół.


OPIS DZIAŁANIA:
1. Deklaracja rozmiaru tablicy
2. Deklaracja ilości poszczególnych typów klocków
3. Wyświetlenie wprowadzonych danych (ilości oraz kształty)
4. Sprawdzenie, czy ilość pól wszystkich klocków jest mniejsza niż ilość dostępnych pól na planszy. Jeśli nie, to nie ma możliwości ich umieszczenia.
5. Rekurecyjne wykonanie fukcji umieszczajacej kolejne klocki na planszy:
    - pobranie pierwszego klocka z listy
    - utworzenie dla niego listy wszystkich możliwych (niepowtarzającyh się) sposobód obrotu oraz odwrócenia
    - przejście po kolenych polach planszy [0][0] -> [rows][cols]
    - jeśli jest możliwe wstawienie, to klocek jest umieszczany na planszy sprawdzając w rekurencji możliwość wstanienia kolejnego klocka z listy na kolejnym dostępnym polu 
      - w przypadku jeśli wstawienie tego kolejnego nie jest możliwe, to aktualny klocek jest usuwany i wykonywana jest kolejna próba wstawienia w następnym polu na planszy. Dla wyniku FALSE wykonywane jest cofnięcie do próby wstawienia poprzedniego klocka 
6. W przypadku umieszczenie wszystkich klocków na planych wyświetlana jest informacj o ilości kroków wykonanych w pętli rekurencji, wraz z czasem wykonania oraz wizualizacja umieszczenia klocków na planszy.