public class Converter {
    double stepInCm = 75.0;
    double stepInCal = 50.0;
    double stepInKm = stepInCm / (100 * 1000);
    double stepInKcal = stepInCal / 1000;

    double convertToKm(int stepsSum) {
        return stepsSum * stepInKm;
    }

    double convertToKcal(int stepsSum) {
        return stepsSum * stepInKcal;
    }
}
