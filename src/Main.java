import java.util.Scanner;

public class Main {
    //Список пунктов меню
    static String[] menu = new String[]{
            "1. Добавление шагов за день.",
            "2. Изменение цели по шагам за день.",
            "3. Вывод статистики",
            "0. Выход"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// создание нового экземпляра
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            System.out.println("Введите пункт меню: ");
            int i = scanner.nextInt();
            // здесь будет работа с командами
            if(i==1) {
                addSteps(scanner, stepTracker);
            }
            else if(i==2) {
                changeGoal(scanner, stepTracker);
            }
            else if(i==3) {
                stepTracker.printStatistic();
            }
            else if(i==0) {
                System.out.println("Пока");
                break;
            }
        }
    }

    //Вывод меню
    static void printMenu(){
        System.out.println("Меню!");
        for(int i=0; i<menu.length-1; i++) System.out.println(menu[i]);
        System.out.println(menu[menu.length-1]);
    }

    //Пункт меню.Добавление шагов за день
    static void addSteps(Scanner scanner, StepTracker stepTracker){
        System.out.println("Выберите день для отчета (1-30)");
        int day = scanner.nextInt();
        System.out.println("Выберите месяц для отчета (1-12)");
        int month = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов");
        int steps = scanner.nextInt();
        stepTracker.addNewNumberStepsPerDay(day, month, steps);
    }

    //Пункт меню.Изменение цели
    static void changeGoal(Scanner scanner, StepTracker stepTracker){
        System.out.println("Введите новую цель: ");
        stepTracker.changeStepGoal(scanner.nextInt());
    }
}
