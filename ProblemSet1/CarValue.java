import java.util.HashMap;
import java.util.Scanner;

public class CarValue {

        public static void main(String[] args) {
        

        // Handling input!

        Scanner input = new Scanner(System.in);

        int duration = input.nextInt();
        double downPayment = input.nextDouble();
        double loan = input.nextDouble();
        int numOfRecords = input.nextInt();

        // Initiate the Depreciation Record
        HashMap<Integer, Double> depreciation = new HashMap<>();

        for(int i = 0; i < numOfRecords; i++){
            depreciation.put(input.nextInt(), input.nextDouble());
        }

        // Calculations
        int months = calculation(duration, downPayment, loan, depreciation);


        // Output
        if(months == 1){
            System.out.println("1 month");
        }else{
            System.out.println(months + " months");
        }

        input.close(); // close scanner, good practice :D
    }

    public static int calculation(int duration, double downPayment, double loan, HashMap<Integer, Double> depreciation){

        double payment = loan/duration; // payment each month
        double carValue = downPayment + loan; // initial value of car
        double curDep = depreciation.getOrDefault(0, 0.0);
        // Basically, we want to find the time when loan < carValue

        int months = 0;
        carValue *= (1 - curDep);

        if (loan < carValue) return 0;

        while(months < duration){
            months++;

            // update depreciation rate if there is a new record for this month
            if (depreciation.containsKey(months)) {
                curDep = depreciation.get(months);
            }

            loan -= payment;
            carValue = carValue * (1 - curDep);

            if(loan < carValue){
                return months;
            }
        }
        
        return months;        
    }
    
}
