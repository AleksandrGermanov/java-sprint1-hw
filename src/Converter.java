public class Converter {
    double stepInCm = 75.0;
    double stepInCal = 50.0;
    double stepInKm = stepInCm / (100 * 1000);
    double stepInKcal = stepInCal / 1000;

    double convertToKm(int stepsSum) {
        double d=Math.round(stepsSum * stepInKm*1000);
        return d/1000; //по какой-то причине выражение Math.round(stepsSum * stepInKm*1000)/1000 JVM округляет до целого
    }

    double convertToKcal(int stepsSum) {
        double d = Math.round(stepsSum * stepInKcal*1000);
        return d/1000;
    }
}
