import java.util.Scanner;

public class SplittingNumbers {
// Adapted Bitwise Operation approach. Thanks to bitmask.
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); // Assume a 32-bit integer structure
        int a = 0, counter = 0, b = 0;

        for(int i = 0; i < 32; i++){

            // Iterate from back to front
            // Example:
            // n = 0000 1101
            // a = 0000 1001
            int curBit = (n >> i) & 1; // bit mask

            if(curBit == 1){
                counter++;
                if(counter%2 == 1){
                    a = a | (1 << i);
                }else{
                    b = b | (1 << i);
                }
            }
        }

        System.out.println(a + " " + b);
        input.close();
    }   
}