public class Statistix {
//Собрал статистические методы сюда, чтобы "не перегружать" класс StepTracker

    static void showStepsOnDays(int[][] steps, int month) {
        for ( int i = 0; i<steps[month].length;i++){
            System.out.print ((i+1) + " день: " + steps[month][i] +", ");
            if((i+1)%10==0) System.out.print("\n");
        }
        System.out.print("\b\b\b\n");
    }

    static int findMaxSteps(int[][] steps, int month){
        int max = steps[month][0];
        for ( int i = 1; i<steps[month].length;i++){
            if (max<steps[month][i]) max = steps[month][i];
        }
        return max;
    }

    static int countSum (int[][] steps, int month) {
        int sum = 0;
        for (int i = 0; i < steps[month].length; i++) {
            sum += steps[month][i];
        }
        return sum;
    }
    static int countAvgSteps (int[][] steps, int month){
        return  Math.round(countSum(steps, month)/steps[month].length);


    }

    static int countBestSeries(int[][] steps, int month, int goal){
        int counter = 0;
        int maxCounter = 0;
        for ( int i = 0; i<steps[month].length; i++){
            if (steps[month][i]>=goal){
                counter = ++counter;
                if (maxCounter<counter) maxCounter = counter;
            } else counter = 0;
        }
        return maxCounter;
    }
}
