
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int ans = reverseBytes(num);

        System.out.printf("%d converts to %d", num, ans);
        input.close();
    }

    public static int reverseBytes(int num) {
        int byte1 = num & 255;
        //256 = 00000000 00000000 00000000 11111111
        //256 = 2^8 - 1
        int byte2 = (num >> 8) & 255;
        int byte3 = (num >> 16) & 255;
        int byte4 = (num >> 24) & 255;

        return (byte1 << 24 | byte2 << 16 | byte3 << 8 | byte4);

    }
}
