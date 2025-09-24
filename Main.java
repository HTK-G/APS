
// This program is for submission's only
// Content subject to change at any moment
import java.util.*;

public class Main {

    // store each passenger info
    static class Passenger {

        int arriveTime;
        int index;

        Passenger(int arriveTime, int index) {
            this.arriveTime = arriveTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        // Input Section
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int T = input.nextInt();
        int M = input.nextInt();

        Queue<Passenger> central = new LinkedList<>();
        Queue<Passenger> uptown = new LinkedList<>();

        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int arriveTime = input.nextInt();
            String station = input.next();
            Passenger p = new Passenger(arriveTime, i);

            if (station.equals("Central")) {
                central.add(p);
            } else {
                uptown.add(p);
            }
        }

        // Calculation 
        simulation(central, uptown, result, T, N);

        // Output section
        for (int time : result) {
            System.out.println(time);
        }

        input.close();
    }

    public static void simulation(Queue<Passenger> central, Queue<Passenger> uptown, int[] result, int T, int N) {
        boolean atCentral = true; // cart starts at Central
        int time = 0;

        while (!central.isEmpty() || !uptown.isEmpty()) {

            // pick side reference
            Queue<Passenger> currentSide = atCentral ? central : uptown;
            Queue<Passenger> oppoSide = atCentral ? uptown : central;

            // Case 1: load passengers from current side
            if (!currentSide.isEmpty() && currentSide.peek().arriveTime <= time) {
                int count = 0;
                while (!currentSide.isEmpty() && currentSide.peek().arriveTime <= time && count < N) {
                    Passenger p = currentSide.poll();
                    result[p.index] = time + T; // arrives after travel time
                    count++;
                }
                time += T;
                atCentral = !atCentral; // flip side
            } // Case 2: no one here, but passengers are waiting on the other side
            else if (!oppoSide.isEmpty() && oppoSide.peek().arriveTime <= time) {
                time += T;
                atCentral = !atCentral; // cross empty
            } // Case 3: no one ready anywhere, wait for the next arrival
            else {
                int nextArrive = Integer.MAX_VALUE;
                if (!currentSide.isEmpty()) {
                    nextArrive = Math.min(nextArrive, currentSide.peek().arriveTime);
                }
                if (!oppoSide.isEmpty()) {
                    nextArrive = Math.min(nextArrive, oppoSide.peek().arriveTime);
                }
                time = Math.max(time, nextArrive); // wait until next arrival
            }

        }
    }
}
