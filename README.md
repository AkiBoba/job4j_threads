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
-4. Thread без общих ресурсов [#267919] 

        3.1.3. Синхронизация ресурсов
-1. Visibility. Общий ресурс вне критической секции [#1102]-
-2. JCIP. Настройка библиотеки [#268575]
-3. Класс хранилища пользователей UserStorage [#1104] ---
-4. ThreadSafe динамический список [#1105]

        3.1.4. Wait, Notify, NotifyAll
-0. Управление нитью через wait. [#6858]
-1. Реализовать шаблон Producer Consumer. [#1098]--
-2. Обеспечить остановку потребителя. [#66825]
-3. Junit тест для блокирующей очереди. [#68589]

        3.1.5. Non Blocking Algoritm
-0. CAS - операции [#6859]-исправлены тесты на многопоточные
-1. Неблокирующий кеш [#4741]

        3.1.6. Пулы
-2. ExecutorService рассылка почты. [#63097]