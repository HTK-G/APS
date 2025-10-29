
// This program is for submission's only
// Content subject to change at any moment
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] grades = new int[101];

        for (int i = 0; i < N; i++) {
            grades[Integer.parseInt(st.nextToken())]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < grades.length; i++) {

            while (grades[i] != 0) {
                sb.append(i);
                sb.append(' ');
                grades[i]--;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

}
