public class Converter {
    int lenghtStep;
    int calories;
    public Converter(){
        lenghtStep=75;
        calories = 50;
    }
    int convertToKm(int steps){
        return steps*lenghtStep/100000;
    }
    int convertStepsToKilocalories(int steps){
        return steps*calories/1000;
    }
}
