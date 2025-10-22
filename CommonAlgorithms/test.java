
public class test {

    public static void main(String[] args) {
        Recursive(4, 3);
    }

    public static void Recursive(int m, int n) {

        if (n > 0) {
            Recursive(m - 1, n - 1);
            System.out.println(n);
            Recursive(m + 1, n - 1);
        }
    }
}
