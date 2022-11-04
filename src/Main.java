import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(); //здесь создали объект stepTracker класса StepTracker
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) { //учет шагов за определенный день
                int month = askMonth(scanner);
                int toDay = askDay(scanner);
                int stepsInDay = askSteps(scanner);
                stepTracker.saveStepsMonth(month, toDay, stepsInDay);
            }
            if (userInput == 2) { //печать статистики за выбранный месяц
                printMonths();
                int month = scanner.nextInt();
                stepTracker.calcStepsMonth(month);
            }
            if (userInput == 3) { //дневная цель
                System.out.println("Введите количество шагов, которые будут являться вашей целью");
                int newTargetSteps = scanner.nextInt();
                stepTracker.changeTargetSteps(newTargetSteps);
            }
            if (userInput < 0 || userInput > 3) { //команда вне диапазона <0
                System.out.println("Такой команды не существует. Выберите другую команду.");
            }
            printMenu(); //печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); //повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Вас приветствует программа учета калорий!");
        System.out.println("Пожалуйста, введите действие, которое Вы хотите выполнить:");
        System.out.println("1 - ввод количества шагов за определенный день;");
        System.out.println("2 - напечатать статистику за определенный месяц;");
        System.out.println("3 - изменить цель по количеству шагов за день;");
        System.out.println("0 - выйти из приложения.");
    }
    private static void printMonths() {
        System.out.println("Укажите месяц 0-ЯНВ, 1-ФЕВ, 2-МАР, 3-АПР, 4-МАЙ, 5-ИЮН, 6-ИЮЛ, 7-АВГ, 8-СЕН, 9-ОКТ, 10-НОЯ, 11-ДЕК");
    }
    private static int askMonth(Scanner scanner) {
        printMonths();
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            System.out.println("Неверно указан месяц, попробуйте повторить ввод");
            printMonths();
            month = scanner.nextInt();
        }
        return month;

    }
    private static int askDay(Scanner scanner) {
        System.out.println("Укажите день");
        int toDay = scanner.nextInt();
        while (toDay < 1 || toDay > 30) {
            System.out.println("Неверно указан день, попробуйте повторить ввод");
            toDay = scanner.nextInt();
        }
        return toDay;
    }
    private static int askSteps(Scanner scanner) {
        System.out.println("Количество шагов");
        int stepsInDay = scanner.nextInt();
        while (stepsInDay < 0) {
            System.out.println("Количество шагов не может быть отрицательным, попробуйте повторить ввод");
            stepsInDay = scanner.nextInt();
        }
        return stepsInDay;
    }
}
