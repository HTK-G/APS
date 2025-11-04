
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MathClass {

    public static void main(String[] args) throws IOException {

        // Input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] list = new String[N];

        // store each number as a String
        for (int i = 0; i < N; i++) {
            list[i] = st.nextToken();
        }

        // Define comparing method
        Arrays.sort(list, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {

                // we want to compare (a + b) vs (b + a) lexicographically
                int lenA = a.length();
                int lenB = b.length();

                // i is the index for (a + b)
                // j is the index for (b + a)
                // e.g. take 998, 9
                // i: 9989
                // j: 9998
                int i = 0, j = 0;

                while (i < lenA + lenB && j < lenA + lenB) {

                    char ab = (i < lenA) ? a.charAt(i) : b.charAt(i - lenA);
                    char ba = (j < lenB) ? b.charAt(i) : a.charAt(j - lenB);

                    if (ab != ba) {
                        // we want 9 before 998
                        // becuase if 9989 != 9998
                        // we want 9998 come before 9989
                        // this is b, a, so reverse order

                        // If ab > ba, we want a to be before b, so
                        // this should be a negative number (stays the same)
                        // In java, a negative compare return value
                        // tells "sort" to not move
                        // so we return reversely to
                        return ba - ab;
                    }
                    i++;
                    j++;
                }

                // if they are the same, it is what it is
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String num : list) {

            sb.append(num);
        }

        System.out.println(sb);

    }

}
