import java.util.Scanner;

public class StepTracker {
    Scanner scan;
    MonthData[] monthToData;
    int goalByStepsPerDay;
    //Конструктор
    public StepTracker(Scanner scanner){
        monthToData = new MonthData[12];
        goalByStepsPerDay = 10000;
        for(int i=1; i<13; i++){
            monthToData[i-1]=new MonthData();
        }
        scan = scanner;
    }

    //Добавление шагов
    void addNewNumberStepsPerDay(){
        System.out.println("Выберите день для отчета (1-30)");
        int day = scan.nextInt();
        if(!validate("day",day)) {
            return;
        }
        System.out.println("Выберите месяц для отчета (1-12)");
        int month = scan.nextInt();
        if(!validate("month",month)){
            return;
        }
        System.out.println("Введите количество пройденных шагов");
        int steps = scan.nextInt();
        if(!validate("steps",steps)){
            return;
        }
        monthToData[month-1].days[day-1] = steps;
    }

    //Смена цели по шагам в день
    void changeStepGoal(){
        System.out.println("Введите новую цель:");
        int stepGoal = scan.nextInt();
        if(!validate("steps",stepGoal)){
            return;
        }
        if(stepGoal>0) {
            goalByStepsPerDay = stepGoal;
            System.out.printf("Новая цель: выполните %d в день.%n", stepGoal);
            //Установка правильного окончания в сообщении в зависимости от значения stepGoal
            /*
            if (stepGoal == 1 || stepGoal > 20 && stepGoal % 10 == 1) {
                System.out.printf("Новая цель: выполните %d шаг за день.%n", stepGoal);
            } else if (stepGoal < 5 || stepGoal > 20 && (stepGoal % 10 == 2 ||stepGoal % 10 == 3 || stepGoal % 10 == 4)) {
                System.out.printf("Новая цель: выполните %d шага за день.%n", stepGoal);
            } else {
                System.out.printf("Новая цель: выполните %d шагов за день.%n", stepGoal);
            }
            */
        }
        else
            System.out.printf("Введено некорректное значение: %d%nНеобходио указать значение больше нуля.%n",stepGoal);
    }

    //Проверка вводимых значений на адекватность
    boolean validate(String type, int value) {
        switch (type) {
            case ("month"): {
                if (value >= 1 && value <= 12) {
                    return true;
                }
                else {
                    System.out.printf("Неверно указан месяц: %d.%nНеобходио указать значение от 1 до 12 (включительно).%n", value);
                    return false;
                }
            }
            case ("day"): {
                if (value >= 1 && value <= 30) {
                    return true;
                }
                else {
                    System.out.printf("Неверно указан день: %d.%nНеобходио указать значение от 1 до 30 (включительно).%n", value);
                    return false;
                }
            }
            case ("steps"): {
                if (value > 0) {
                    return true;
                }
                else {
                    System.out.printf("Неверно указано количество шагов: %d.%nНеобходио указать значение от нуля и больше.%n", value);
                    return false;
                }
            }
        }
        return true;
    }

    void printStatistic(){
        System.out.print("Введите месяц: ");
        int monthData = scan.nextInt();
        //проверка месяца
        if(!validate("month",monthData)){
            return;
        }
        //количество пройденных шагов по дням
        monthToData[monthData-1].printDaysAndStepsFromMonth();
        //общее количество шагов за месяц
        int sumSteps = monthToData[monthData-1].sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        //максимальное пройденное количество шагов в месяце
        int maxSteps = monthToData[monthData-1].maxSteps();
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        //среднее количество шагов
        double avgSteps = sumSteps/30.0;
        System.out.printf("Среднее пройденное количество шагов в месяце: %,.2f%n", avgSteps);

        Converter converter = new Converter();
        //пройденная дистанция (в км)
        int distance = converter.convertToKm(sumSteps);
        System.out.println("Пройденная дистанция (в км): " + distance);
        //количество сожжённых килокалорий
        int kCalories = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("Количество сожжённых килокалорий: " + kCalories);
        //лучшая серия
        int bestSeries = monthToData[monthData-1].bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия: " + bestSeries);
    }
}

