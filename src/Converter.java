public class Converter {
    double stepInCm = 75.0;
    double stepInCal = 50.0;
    double stepInKm = stepInCm/(100*1000);
    double stepInKcal = stepInCal/1000;




    double convertToKm(int[][] steps, int month){
        return Math.round(Statistix.countSum(steps, month) * stepInKm);
    }

    double convertToKcal(int[][] steps, int month){
            return Math.round(Statistix.countSum(steps, month)*stepInKcal);
    }
}
