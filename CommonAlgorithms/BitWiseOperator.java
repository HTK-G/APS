
public class BitWiseOperator {

    public static void main(String[] args) {

        int a = 13;
        int b = 7;

        System.out.println(b | (~b));
        System.out.println(a ^ b);
        System.out.println(a | b);
        System.out.println(a & b);

    }
}
