//������, ��������! ������� �� �����! ���������� ��� ���������.
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
                System.out.println("��������� ��������� ���� ������. �������, ��� ��������������� ����� ����������� :)");
                return;
            } else {
                System.out.println("����� ������� ���� �� �������������, �������� ��� ���.");
            }
        }
    }


    static void printMenu() {
        System.out.println("���� ��������?");
        System.out.println("1 - ������ ���������� ����� �� ����������� ����.");
        System.out.println("2 - ���������� ���������� �� ����������� �����.");
        System.out.println("3 - �������� ���� �� ���������� ����� � ����.");
        System.out.println("4 - ��������� ����� �������� �� ���.");
        System.out.println("0 - ����� �� ����������.");
    }
//����� ��� ����� fillArray(int[][]daySteps), ������� ����� �� ������������
}

