import java.util.Scanner;

public class PrimePair {
    public static void main(String[] args) {

        // Input section:
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); // n < 100,000
        int max = 20000000; // from problem, it is guaranteed that the 100,000th prime pair are less than 20,000,000 << 2^31 - 1
        boolean[] prime = new boolean[max];

        int ans = -1;
        int pairCount = 0;
        int i = 2;
        // Computing section:
        sieve(prime); // now we've found the entire list of primes 

        while(i+2 < max && pairCount < n){
            
            if(prime[i] && prime[i+2]){
                ans = i;
                pairCount++;
            }
            i++;
        }
        // We can assume that we can definitely find Nth pair in this range.

        // Output
        System.out.println("(" + ans + ", " + (ans+2) + ")");
        input.close();
    }

    // Helper method of the sieve approach: O(N * log(log N))
    public static void sieve(boolean[] prime){
        
        for(int i = 2; i < prime.length; i++){
            prime[i] = true;
        }

        int limit = (int)Math.sqrt(prime.length);
        for(int i = 2; i < limit; i++){

            if(prime[i]){

                for(int j = i*i; j < prime.length; j += i){ 
                // noticed we start at i^2 because any number smaller than that should be already marked
                // This is because we already checked any multiple 1, 2, ..., i-1, so we can assume this is already crossed out
                // i * 2, i * 3, i * 4, ..., i * (i-1).
                    prime[j] = false;
                }
            }
        }
    }
}
