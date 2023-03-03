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
                addSteps(stepTracker);
            }
            else if(i==2) {
                changeGoal(stepTracker);
            }
            else if(i==3) {
                printStatistic(stepTracker);
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
        for(int i=0; i<menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    //Пункт меню.Добавление шагов за день
    static void addSteps(StepTracker stepTracker){
        //Ввод нового отчета
        System.out.println("Добавление новых параметров!");
        stepTracker.addNewNumberStepsPerDay();
    }

    //Пункт меню.Изменение цели
    static void changeGoal(StepTracker stepTracker){
        System.out.println("Добавление новой цели!");
        stepTracker.changeStepGoal();
    }

    static void printStatistic(StepTracker stepTracker){
        System.out.println("Статистика за месяц!");
        stepTracker.printStatistic();
    }
}
