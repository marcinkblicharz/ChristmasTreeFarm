1. Początkowe pozycje klocków przy sprawdzaniu miejsca do ułożenia są takie jak w opisie problemu na https://adventofcode.com/2025/day/12
   
| 0 | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- |
| ### | ### | .## | ##. | ### | ### |
| ##. | ##. | ### | ### | #.. | .#. |
| ##. | .## | ##. | ##. | ### | ### |

2. Podczas generowania listy wszystkich pozycji (obroty oraz odwócenia) usuwam duplikaty co zmniejsza ilość kroków do sprawdzenia. Dotyczy to zwłasza klocka [5], który finalnie może zostać ułożony na 2 sposoby

| position 0 | position 1 |
| --- | --- |
| ### | #.# |
| .#. | ### |
| ### | #.# |

3. Z racji założenia, że zarówno plansza (4x4 lub 12x5) oraz same klocki (3x3) są symetryczne, to pozycją startową podczas umieszczania jest 'lewy górny róg', tj. [0][0]. Podczas kolejnych kroków przesuwam sięna planszy w prawo oraz w dół.
