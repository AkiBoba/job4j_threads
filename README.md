    Курс job4j уровень Мидл

Многозадачность и параллелизм.

В ОС за выполнение задач отвечает процессор. Чем больше процессоров имеет
компьютер, тем больше задач может одновременно выполнить компьютер.

Один процессор может одновременно выполнять только одну задачу. Задача
выполняемая процессором называется процесс. То есть если в вашем компьютере
два процессора, то он может выполнять два процесса параллельно. Процессы не 
могут обмениваться между собой данными. Это не зависимые элементы.

-1. Запуск нити. Thread#start() [#1016]
-1.1. Состояние нити. [#229175]-
-1.2. Режим ожидания. [#231217]-