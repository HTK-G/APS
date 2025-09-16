import java.util.Arrays;
import java.util.Scanner;

public class NoBlinkContest {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Inputs
        int S = input.nextInt(); // indicates n = 2^s students, s is ALSO log n, the "depth"
        int M = input.nextInt();

        int size = 1;

        for(int i = 0; i < S; i++){
            size *= 2;
        }

        boolean[] contest = new boolean[size];
        
        Arrays.fill(contest, true);

        for(int i = 0; i < M; i++){
            int temp = input.nextInt();
            contest[temp-1] = false;
        }

        // Calculation steps
        int freePass = 0;

        while (size > 1) {
            boolean[] nextRound = new boolean[size / 2];

            for (int i = 0; i < size; i += 2) {
                boolean p1 = contest[i];
                boolean p2 = contest[i+1];
                // Three cases:
                if (p1 && p2) {
                    // both present → normal match
                    nextRound[i/2] = true;
                } else if (p1 ^ p2) {
                    // one present → free pass
                    freePass++;
                    nextRound[i/2] = true;
                } else {
                    // both missing
                    nextRound[i/2] = false;
                }
            }

            contest = nextRound; // advance to next round
            size /= 2; // the total times of doing this is equal to S, log n. (as n = 2^S)
        }
        // Outputs
        System.out.print(freePass);
        input.close();
    }
    
}
