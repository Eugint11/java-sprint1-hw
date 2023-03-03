public class MonthData {
    int[] days;
    //Конструктор
    public MonthData(){
        days = new int[30];
    }
    //Вывод шагов за месяц по дням
    void printDaysAndStepsFromMonth(){
        for(int i=0; i<days.length; i++) {
            System.out.printf("%d день: %d%n", (i+1), days[i]);
        }
    }
    //Вычисление суммы шагов за месяц
    int sumStepsFromMonth(){
        int sum = 0;
        for(int i=0; i<days.length; i++) {
            sum+=days[i];
        }
        return sum;
    }
    //Поиск дня с максимальным количеством шагов
    int maxSteps(){
        int max = 0;
        for(int i=0; i<days.length; i++) {
            if(max<days[i])
                max = days[i];
        }
        return max;
    }
    //Поиск серии побед
    int bestSeries(int goalByStepsPerDay){
        int localStreak = 0;
        int finalStreak = 0;
        for(int i=0; i<days.length; i++){
            while(i<days.length && days[i]>=goalByStepsPerDay) {
                localStreak++;
                i++;
            }
            if(finalStreak<localStreak)
                finalStreak=localStreak;
            localStreak=0;
        }
        return finalStreak;
    }
}
