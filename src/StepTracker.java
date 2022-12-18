import java.util.Scanner;

public class StepTracker {

    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", " Август", "Сентябрь", "Октябрь", "Ноябрь", " Декабрь"};
    int[][] daySteps = new int[12][30];

    int stepsGoal = 10000;
    int month;
    int day;

    Converter converter = new Converter();


    boolean isYes(Scanner scanner) {
        System.out.println("\"Да\" - введите цифру 1, \"Нет\" - ввдедите любой другой символ");
        return scanner.next().equals("1");
    }

    boolean isMonthSucceed(Scanner scanner) {
        System.out.println("Введите месяц 0(\"Январь\")-11(\"Декабрь\"):");
        int savedMonth = month;
        month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Не получилось определить месяц! Возвращаемся в главное меню!");
            month = savedMonth;
            return false;
        } else {
            return true;
        }
    }

    void saveSteps(Scanner scanner) {
        boolean isMonthInput = false;

        if (day == 30) {
            System.out.println("В прошлый раз вы сохраняли значение за последний день месяца.");
            System.out.println("Хотите перейти к следующему месяцу?");
            if (isYes(scanner)) {
                month = month + 1;
                day = 0;
            }
            if (month == 12) {
                month = 0;
            }
        } else {
            System.out.println("Хотите ввести значение за текущий месяц (" +
                    months[month] + ")?");
            if (!isYes(scanner)) {
                isMonthInput = true;
                if (!isMonthSucceed(scanner)) {
                    return;
                }
            }
        }
        if (!isMonthInput)//Если пользователь не вводил месяц вручную, спрашиваем
            System.out.println("Хотите ввести значение за следующий день? (текущий день - " + day + ")");
        if (!isMonthInput && isYes(scanner)) {
            day = day + 1;
            if (day == 31) {
                day = 1;
            }
        } else {
            System.out.println("Введите день 1-30 (текущий день - " + day + "):");
            int savedDay = day;
            day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("Не получилось определить день! Возвращаемся в главное меню!");
                day = savedDay;
                return;
            }
        }
        System.out.println("Введите количесво шагов.");
        daySteps[month][day - 1] = scanner.nextInt();
        System.out.println("Месяц " + months[month] + ". " +
                day + "-е число. Пройдено шагов: " + daySteps[month][day - 1] + ".");
    }

    void resetYear(int[][] daySteps, Scanner scanner) {
        /*сбросим значение за год воизбежание накладок при повторном заполнении массива(через год),
        иначе незаполненные поля будут содержать значения за предыдущий год*/
        System.out.println("Вы точно хотите сбросить количество шагов за год?");
        if (isYes(scanner)) {
            for (int i = 0; i < daySteps.length; i++) {
                for (int j = 0; j < daySteps[i].length; j++) {
                    daySteps[i][j] = 0;
                }
            }
        }
    }

    void setStepsGoal(Scanner scanner) {
        System.out.println("Введите целевое количество шагов:");
        int i;
        i = scanner.nextInt();
        if (i < 0) System.out.println("Вы ввели отрицательное значение. Целевое количество шагов " +
                "не будет изменено.");
        else stepsGoal = i;
        System.out.println("Целевое количество шагов: " + stepsGoal + ".");
    }


    void showStatistics(Scanner scanner) {
        int stepsSum = Statistix.countSum(daySteps, month);// для передачи в методы Converter
        System.out.print("Текущий месяц: " + months[month] + ". ");
        System.out.print("Текущий день: " + day + ". ");
        System.out.println("Целевое количество шагов: " + stepsGoal + ".");
        System.out.println("Показать статистику за текущий месяц?");
        if (!isYes(scanner)) {
            if (!isMonthSucceed(scanner)) return;
        }
        System.out.println("Статистика за " + months[month] + ".");
        System.out.println("Количество пройденных шагов по дням:");
        Statistix.showStepsOnDays(daySteps, month);
        System.out.println("Общее количество шагов за месяц: " + stepsSum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " +
                Statistix.findMaxSteps(daySteps, month));
        System.out.println("Среднее количество шагов: " +
                Statistix.countAvgSteps(daySteps, month));
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(stepsSum));
        System.out.println("Количество сожжённых килокалорий (в ккал): " +
                converter.convertToKcal(stepsSum));
        System.out.println("Лучшая серия: " + Statistix.countBestSeries(daySteps, month, stepsGoal));
    }
}


