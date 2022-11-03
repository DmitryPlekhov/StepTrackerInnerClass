public class Converter {
    static double oneSteplenght = 0.00075; // длина одного шага в километрах
    static double oneStepEnerg = 0.05; // калорий за один шаг
    double distanceInMonth(int sumSteps) { //пройденная дистанция за месяц
        double distance = sumSteps * oneSteplenght;
        return  distance;
    }

    double energInMonth(int sumSteps){ //количество каллорий за месяц
        double energ = sumSteps * oneStepEnerg;
        return energ;
    }
}
