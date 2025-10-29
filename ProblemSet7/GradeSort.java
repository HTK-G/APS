
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GradeSort {

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
