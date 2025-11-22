
import java.io.*;
import java.util.*;

public class Parcels {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[7];
        for (int i = 1; i <= 6; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int boxes = 0;

        boxes += a[6];

        boxes += a[5];
        a[1] = Math.max(0, a[1] - 11 * a[5]);

        boxes += a[4];
        int need2 = 5 * a[4];
        if (a[2] >= need2) {
            a[2] -= need2; 
        }else {
            int rem = need2 - a[2];
            a[1] = Math.max(0, a[1] - 4 * rem);
            a[2] = 0;
        }

        boxes += a[3] / 4;
        int r3 = a[3] % 4;
        if (r3 > 0) {
            boxes++;
            int need = 36 - 9 * r3;
            int use2 = 0;
            if (r3 == 1) {
                use2 = Math.min(a[2], 5); 
            }else if (r3 == 2) {
                use2 = Math.min(a[2], 3); 
            }else if (r3 == 3) {
                use2 = Math.min(a[2], 1);
            }
            need -= 4 * use2;
            a[2] -= use2;
            a[1] = Math.max(0, a[1] - need);
        }

        boxes += a[2] / 9;
        int r2 = a[2] % 9;
        if (r2 > 0) {
            boxes++;
            int need = 36 - 4 * r2;
            a[1] = Math.max(0, a[1] - need);
        }

        boxes += a[1] / 36;
        if (a[1] % 36 > 0) {
            boxes++;
        }

        System.out.println(boxes);
    }
}
