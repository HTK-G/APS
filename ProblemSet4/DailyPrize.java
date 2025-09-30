import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class DailyPrize {

    public static void main(String[] args) {
        
        // Input section & Calculation Steps
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        long total = 0;
        ArrayList<Long> lottery = new ArrayList<>();

        for(int i = 0; i < n; i++){

            int k = input.nextInt();

            for(int j = 0; j < k; j++){

                lottery.add(input.nextLong());
            }
            Collections.sort(lottery);
            long min = lottery.get(0);
            long max = lottery.get(lottery.size()-1);
            total += (long) (max - min);
            lottery.remove(0);
            lottery.remove(lottery.size()-1);
        }


        // Output section
        input.close();
        System.out.println(total);
    }

}
