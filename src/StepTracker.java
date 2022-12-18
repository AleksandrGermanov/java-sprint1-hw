import java.util.Scanner;

public class StepTracker {

    String[] months = {"������", "�������", "����", "������", "���", "����",
            "����", " ������", "��������", "�������", "������", " �������"};
    int[][] daySteps = new int[12][30];

    int stepsGoal = 10000;
    int month;
    int day;

    Converter converter = new Converter();


    boolean isYes(Scanner scanner) {
        System.out.println("\"��\" - ������� ����� 1, \"���\" - �������� ����� ������ ������");
        return scanner.next().equals("1");
    }

    boolean isMonthSucceed(Scanner scanner) {
        System.out.println("������� ����� 0(\"������\")-11(\"�������\"):");
        int savedMonth = month;
        month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("�� ���������� ���������� �����! ������������ � ������� ����!");
            month = savedMonth;
            return false;
        } else {
            return true;
        }
    }

    void saveSteps(Scanner scanner) {
        boolean isMonthInput = false;

        if (day == 30) {
            System.out.println("� ������� ��� �� ��������� �������� �� ��������� ���� ������.");
            System.out.println("������ ������� � ���������� ������?");
            if (isYes(scanner)) {
                month = month + 1;
                day = 0;
            }
            if (month == 12) {
                month = 0;
            }
        } else {
            System.out.println("������ ������ �������� �� ������� ����� (" +
                    months[month] + ")?");
            if (!isYes(scanner)) {
                isMonthInput = true;
                if (!isMonthSucceed(scanner)) {
                    return;
                }
            }
        }
        if (!isMonthInput)//���� ������������ �� ������ ����� �������, ����������
            System.out.println("������ ������ �������� �� ��������� ����? (������� ���� - " + day + ")");
        if (!isMonthInput && isYes(scanner)) {
            day = day + 1;
            if (day == 31) {
                day = 1;
            }
        } else {
            System.out.println("������� ���� 1-30 (������� ���� - " + day + "):");
            int savedDay = day;
            day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("�� ���������� ���������� ����! ������������ � ������� ����!");
                day = savedDay;
                return;
            }
        }
        System.out.println("������� ��������� �����.");
        daySteps[month][day - 1] = scanner.nextInt();
        System.out.println("����� " + months[month] + ". " +
                day + "-� �����. �������� �����: " + daySteps[month][day - 1] + ".");
    }

    void resetYear(int[][] daySteps, Scanner scanner) {
        /*������� �������� �� ��� ����������� �������� ��� ��������� ���������� �������(����� ���),
        ����� ������������� ���� ����� ��������� �������� �� ���������� ���*/
        System.out.println("�� ����� ������ �������� ���������� ����� �� ���?");
        if (isYes(scanner)) {
            for (int i = 0; i < daySteps.length; i++) {
                for (int j = 0; j < daySteps[i].length; j++) {
                    daySteps[i][j] = 0;
                }
            }
        }
    }

    void setStepsGoal(Scanner scanner) {
        System.out.println("������� ������� ���������� �����:");
        int i;
        i = scanner.nextInt();
        if (i < 0) System.out.println("�� ����� ������������� ��������. ������� ���������� ����� " +
                "�� ����� ��������.");
        else stepsGoal = i;
        System.out.println("������� ���������� �����: " + stepsGoal + ".");
    }


    void showStatistics(Scanner scanner) {
        int stepsSum = Statistix.countSum(daySteps, month);// ��� �������� � ������ Converter
        System.out.print("������� �����: " + months[month] + ". ");
        System.out.print("������� ����: " + day + ". ");
        System.out.println("������� ���������� �����: " + stepsGoal + ".");
        System.out.println("�������� ���������� �� ������� �����?");
        if (!isYes(scanner)) {
            if (!isMonthSucceed(scanner)) return;
        }
        System.out.println("���������� �� " + months[month] + ".");
        System.out.println("���������� ���������� ����� �� ����:");
        Statistix.showStepsOnDays(daySteps, month);
        System.out.println("����� ���������� ����� �� �����: " + stepsSum);
        System.out.println("������������ ���������� ���������� ����� � ������: " +
                Statistix.findMaxSteps(daySteps, month));
        System.out.println("������� ���������� �����: " +
                Statistix.countAvgSteps(daySteps, month));
        System.out.println("���������� ��������� (� ��): " + converter.convertToKm(stepsSum));
        System.out.println("���������� �������� ����������� (� ����): " +
                converter.convertToKcal(stepsSum));
        System.out.println("������ �����: " + Statistix.countBestSeries(daySteps, month, stepsGoal));
    }
}


