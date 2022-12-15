import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();


      // fillArray(tracker.daySteps);

        while(true){
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
            tracker.saveSteps(scanner);
            } else if (userInput == 2){
            tracker.showStatistics(scanner);
            } else if(userInput == 3){
                tracker.setStepsGoal(scanner);
            } else if (userInput == 0){
                System.out.println("��������� ��������� ���� ������. �������, ��� ��������������� ����� ����������� :)");
                return;
            } else System.out.println("����� ������� ���� �� �������������, �������� ��� ���.");

        }

    }


static void printMenu(){
    System.out.println("���� ��������?");
    System.out.println("1 - ������ ���������� ����� �� ����������� ����.");
    System.out.println("2 - ���������� ���������� �� ����������� �����.");
    System.out.println("3 - �������� ���� �� ���������� ����� � ����.");
    System.out.println("0 - ����� �� ����������.");
    }

    static  void fillArray(int[][] daySteps) {
        for (int i = 0; i<daySteps.length; i++){
            for (int j = 0; j<daySteps[i].length; j++){
                daySteps[i][j] = (int) Math.round(Math.random() * 10000 + 5000);
            }
        }
    }
}

