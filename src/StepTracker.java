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
    void addNewNumberStepsPerDay(int day, int month, int steps){
        //Проверка введенных пользователем значений
        if(!validate("day",day)) {
            return;
        }
        else if(!validate("month",month)){
            return;
            }
        else if(!validate("steps",steps)){
            return;
        }
        //Запись шагов в выбранный день месяца
        monthToData[month-1].days[day-1] = steps;
    }

    void changeStepGoal(int stepGoal){
        if(0<stepGoal) {
            goalByStepsPerDay = stepGoal;
            if (stepGoal == 1 || stepGoal > 20 && stepGoal % 10 == 1) {
                System.out.printf("Новая цель: выполните %d шаг за день.%n", stepGoal);
            } else if (stepGoal < 5 || stepGoal > 20 && (stepGoal % 10 == 2 ||stepGoal % 10 == 3 || stepGoal % 10 == 4)) {
                System.out.printf("Новая цель: выполните %d шага за день.%n", stepGoal);
            } else {
                System.out.printf("Новая цель: выполните %d шагов за день.%n", stepGoal);
            }
        }
        else
            System.out.printf("Введено некорректное значение: %d%nНеобходио указать значение больше нуля.%n",stepGoal);
    }

    boolean validate(String type, int value) {
        switch (type) {
            case ("month"): {
                if (0 > value || value > 30) {
                    System.out.printf("Неверно указан месяц: %d.%nНеобходио указать значение от 1 до 12 (включительно).%n", value);
                    return false;
                }
                else
                    return true;
            }
            case ("day"): {
                if (0 > value || value > 30) {
                    System.out.printf("Неверно указан день: %d.%nНеобходио указать значение от 1 до 30 (включительно).%n", value);
                    return false;
                }
                else
                    return true;
            }
            case ("steps"): {
                if (0 > value) {
                    System.out.printf("Неверно указано количество шагов: %d.%nНеобходио указать значение от нуля и больше.%n", value);
                    return false;
                }
                else
                    return true;
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
        System.out.printf("Общее количество шагов за месяц: %d%n", sumSteps);
        //максимальное пройденное количество шагов в месяце
        int maxSteps = monthToData[monthData-1].maxSteps();
        System.out.printf("Максимальное пройденное количество шагов в месяце: %d%n", maxSteps);
        //среднее количество шагов
        double avgSteps = sumSteps/30.0;
        System.out.printf("Максимальное пройденное количество шагов в месяце: %f.2%n", avgSteps);

        Converter converter = new Converter();
        //пройденная дистанция (в км)
        int distance = converter.convertToKm(sumSteps);
        System.out.printf("Пройденная дистанция (в км): %d%n", distance);
        //количество сожжённых килокалорий
        int kCalories = converter.convertStepsToKilocalories(sumSteps);
        System.out.printf("Количество сожжённых килокалорий: %d%n", kCalories);
        //лучшая серия
        int bestSeries = monthToData[monthData-1].bestSeries(goalByStepsPerDay);
        System.out.printf("Лучшая серия: %d%n", bestSeries);
    }
}

