import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        // This should be recursive

        // Base case:
        Scanner input = new Scanner(System.in);

        System.out.println(helper(input.nextInt()-1));

        input.close();


    }
    public static int helper(int n){

        if(n == 1 || n == 0){
            return 1;
        }

        return helper(n-1) + helper(n-2);

    }
}
