
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class BaseConversion {

    public static void main(String[] args) {

        // Input section
        Scanner input = new Scanner(System.in);
        int oldBase = input.nextInt();
        int newBase = input.nextInt();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        String original = input.next();   // keep raw input
        String num = original.toUpperCase();
        input.close();

        // Check for validity
        for (char c : num.toCharArray()) {
            // System.out.println("old base: " + oldBase + " Current char: " + c);
            if (!map.containsKey(c) || map.get(c) >= oldBase) {
                System.out.print(original + " is an illegal base " + oldBase + " number");
                return;
            }
        }

        if (oldBase < 2 || oldBase > 16 || newBase < 2 || newBase > 16) {
            System.out.print(original + " is an illegal base " + oldBase + " number");
            return;
        }

        // Edge case
        // if (oldBase == (newBase)) {
        //     System.out.print(original + " base " + oldBase + " = " + num + " base " + newBase);
        //     return;
        // }
        // Burh, I spent one hour debugging, it turned out I'm "too smart"
        // Calculation steps
        String ans = convert(oldBase, newBase, num, map);

        // Output section
        System.out.print(num + " base " + oldBase + " = " + ans + " base " + newBase);
    }

    public static String convert(int oldBase, int newBase, String num, HashMap<Character, Integer> map) {
        // Convert to decimal using BigInteger
        BigInteger value = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(oldBase);
        for (char c : num.toCharArray()) {
            value = value.multiply(base).add(BigInteger.valueOf(map.get(c)));
        }

        // convert to newbase
        // check edge case
        if (value.equals(BigInteger.ZERO)) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        BigInteger newBaseBI = BigInteger.valueOf(newBase);

        while (value.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divRem = value.divideAndRemainder(newBaseBI);

            int residue = divRem[1].intValue();

            if (residue < 10) {
                sb.insert(0, (char) ('0' + residue));
            } else {
                sb.insert(0, (char) ('A' + (residue - 10)));
            }
            value = divRem[0];
        }

        return sb.toString();
    }

}
