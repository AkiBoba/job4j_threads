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
-3. Прерывание нити [#1019]------
-3.1. Прерывание блокированной нити. [#267413 #270233]
-4. Скачивание файла с ограничением. [#144271]---

        3.1.2. Общие ресурсы
-1. Синхронизация общих ресурсов. [#1096]
-2. Модель памяти Java [#267917]
-3. Immutable объекты [#267918]--
-4. Thread без общих ресурсов [#267919] -