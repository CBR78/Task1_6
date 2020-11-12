# Tasks_1-6-JavaCore

#### Task 1 - Anagrams  
Настроить среду разработки, подключиться к Git-серверу по SSH.  
В строке с произвольным количеством слов необходимо развернуть порядок букв в словах. Если в слове встретятся цифры, они должны остаться на прежнем месте. Порядок слов в предложении не меняется. Отрефакторить по правилам Clean code.

Учебные материалы:
1.	Энциклопедия рефакторинга (89 методов)
https://refactoring.guru/ru/refactoring/smells
2.	GoF паттерны проектирования. По своей инициативе. Для начального этапа это учить рано.
https://refactoring.guru/ru/design-patterns/catalog
3.	Руководство по Git. Первые 3 главы, около 250 стр.
https://git-scm.com/book/ru/v2
4.	Руководство по, встроенному в Eclipse, Git-клиенту (200 стр.)
https://wiki.eclipse.org/EGit/User_Guide
5.	JavaDoc по Java 8:
-	Структурирование в Excel 228 пакетов JRE по функциональному назначению, вместо алфавита;
-	Методы классов Objeсt, String, StringBuilder, StringBuffer, StringJoiner, CharSequence, Number с наследниками;
-	Разбор остальных классов-оберток примитивных типов;
-	math-пакет;  
6. Три способа ввода данных через консоль:
- new BufferedReader(new InputStreamReader(System.in)); + .readLine()
- new Scanner(System.in); + .nextLine()
- System.console().readLine();

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Anagrams

#### Task 2 - Unit tests  
Создать юнит-тесты для Task 1.

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Unit_Tests

#### Task 3 - Maven and other useful tools (SonarLint)  
Конвертируйте проект в Maven;

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Maven

#### Task 4 - Integer division  
Запрограммировать «деление в столбик», согласно скриншоту  
и пояснению в википедии https://ru.wikipedia.org/wiki/Деление_столбиком  
Суть задания можно понять и по юнит-тестам во вложении.

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Integer_Division

#### Task 5 - Collection Framework  
Напишите приложение, которое принимает строку и возвращает количество уникальных символов в строке.  
Ожидается, что строка с одинаковой последовательностью символов может быть передана в метод несколько раз.  
Поскольку операция подсчета может занять много времени, метод должен кэшировать результаты, чтобы, когда методу была передана ранее встреченная строка, он просто получил сохраненный результат. При необходимости, используйте коллекции и Map.  

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Collection

#### Task 6 - Stream API  
Есть три текстовых файла с результатами заездов "Формулы 1".  
Необходимо прочитать файлы на диске, обработать с использованием Stream так, чтобы на консоль был выведен рейтинг первых 10 гонщиков.  

Учебные материалы:  
-	io.stream, util.stream, java.time (в т.ч. форматтеры);  
-	Дженерики (<T>, wildcard: extends, super);  
-	Лямбды;  
-	Функциональные интерфейсы.  

Результат - в ветке https://github.com/v-malzam/Tasks_1-6-JavaCore/tree/Stream_API  
Прим. было разработано три работоспособных варианта кода. приведена последняя версия (7 классов программы, согласно первому принципу SOLID, и 3 юнит-теста)
