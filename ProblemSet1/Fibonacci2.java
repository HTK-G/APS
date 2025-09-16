import java.util.Scanner;

public class Fibonacci2 {
    public static void main(String[] args){
        //This can be dynamic programmed

        Scanner input = new Scanner(System.in);

        System.out.println(fibo(input.nextInt()));

        input.close();

    }

    public static long fibo(int n){

        if(n == 1 || n == 0){

            return n;
        }

        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2; i <= n; i++){

            dp[i] = dp[i-1] + dp[i-2];

        }

        return dp[n];
    }
}
