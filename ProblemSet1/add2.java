import java.util.Scanner;

public class add2 {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        long a = input.nextInt();
        long b = input.nextInt();

        System.out.println((long)(a+b));

        input.close();
    }
    
}
