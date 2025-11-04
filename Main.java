
// This program is for submission's only
// Content subject to change at any moment
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];

        // store each number as a String
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, maxLen = 0;
        HashSet<Integer> set = new HashSet<>();

        while (right < N) {

            if (!set.contains(list[right])) {
                set.add(list[right]);
            } else {
                maxLen = Math.max(maxLen, set.size());
                while (list[left] != list[right] && left < right) {
                    set.remove(list[left]);
                    left++;
                }
                left++;
            }
            right++;
        }
        maxLen = Math.max(maxLen, set.size());

        System.out.println(maxLen);
    }

}
