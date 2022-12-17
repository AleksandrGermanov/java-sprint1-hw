//Привет, Вячеслав! Спасибо за ревью! Постарался все исправить.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();

        while (true) {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                tracker.saveSteps(scanner);
            } else if (userInput == 2) {
                tracker.showStatistics(scanner);
            } else if (userInput == 3) {
                tracker.setStepsGoal(scanner);
            } else if (userInput == 4) {
                tracker.resetYear(tracker.daySteps, scanner);
            } else if (userInput == 0) {
                System.out.println("Прогармма завершает свою работу. Спасибо, что воспользовались нашим приложением :)");
                return;
            } else {
                System.out.println("Такой команды пока не предусмотрено, выберите еще раз.");
            }
        }
    }


    static void printMenu() {
        System.out.println("Чего изволите?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выполнить сброс значений за год.");
        System.out.println("0 - Выйти из приложения.");
    }
//здесь был метод fillArray(int[][]daySteps), который нигде не используется
}

