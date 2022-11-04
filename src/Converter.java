public class Converter {
    static double oneSteplenghtCm = 75; //длина шага в сантиметрах
    static double oneStepEnergCal = 50; //калорий за один шаг
    double distanceInMonth(int sumSteps) { //пройденная дистанция за месяц
        double oneSteplenghtKm = oneSteplenghtCm / 100000; //переводим шаг из сантиметры в километры
        double distance = sumSteps * oneSteplenghtKm;
        return  distance;
    }

    double energInMonth(int sumSteps){ //количество каллорий за месяц
        double oneStepEnergKcal = oneStepEnergCal / 1000; //переводим калории в килокалории
        double energ = sumSteps * oneStepEnergKcal;
        return energ;
    }
}
