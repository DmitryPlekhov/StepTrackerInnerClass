public class StepTracker {
    MonthData[] monthToData;
    Converter converter = new Converter();
    int targetSteps = 10000; //целевое количество шагов в день
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void saveStepsMonth(int month, int day, int stepInDay) { //Сохраняем количество шагов в указанный месяц и день
        monthToData[month].saveStepsDay(day, stepInDay);
    }
    void changeTargetSteps(int newTargetSteps) {
        if (newTargetSteps < 0) {
            System.out.println("Вы ввели не допустимое значение. Дневная цель не может быть меньше 0!");
        } else {
            targetSteps = newTargetSteps;
        }
        System.out.println("Текущая цель " + targetSteps + " шагов в день");
    }
    void calcSteps(int month) {
        int sumSteps = 0;
        int maxSerial = 0;
        int middleCalcSerial = 0; //промежуточная переменная количества последовательных дней
        int maxStepsInMonth = 0;
        for (int i = 0; i < monthToData[month].getLengthMonth(); i++) {
            sumSteps = sumSteps + monthToData[month].getStepsDay(i);
            System.out.print((i + 1) + " день: " + monthToData[month].getStepsDay(i));
            if (i != monthToData[month].getLengthMonth() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(" ");
            }
            if (monthToData[month].getStepsDay(i) >= targetSteps) {
                middleCalcSerial++;
                if (middleCalcSerial > maxSerial) {
                    maxSerial = middleCalcSerial;
                }
            } else {
                middleCalcSerial = 0;
            }
            if (monthToData[month].getStepsDay(i) > maxStepsInMonth) {
                maxStepsInMonth = monthToData[month].getStepsDay(i);
            }
        }
        System.out.println("Общее количество шагов за " + month + "-й месяц: " + sumSteps);
        System.out.println("Максимальное пройденое количество шагов в " + month + "-ом месяце: " + maxStepsInMonth);
        System.out.println("Среднее количество шагов в " + month + "-й месяц: " + (sumSteps / monthToData[month].getLengthMonth()));
        System.out.println("Пройденная дистанция за " + month + "-й месяц: " + converter.distanceInMonth(sumSteps) + " км");
        System.out.println("Количество сожженных килокалорий за " + month + "-й месяц: " + converter.energInMonth(sumSteps));
        System.out.println("Лучшая серия в " + month + "-м месяце: " + maxSerial + " дней");
    }
    class MonthData {
        int[] month; //объявили массив c днями

        public MonthData() {
            month = new int[30]; //объявили что в массиве days 30 дней - это конструктор
        }
        void saveStepsDay(int day, int stepsInDay) {
            month[day - 1] = stepsInDay; //сохраняем количество шагов в указанный день
        }
        int getLengthMonth() {
            return month.length; //по запросу из внешнего класса запрашиваем количество дней в месяце
        }
        int getStepsDay(int day) {
            int stepsInDay = month[day]; //из внешнего класса запрашиваем количество шагов в указанный день
            return stepsInDay;
        }
    }
}

