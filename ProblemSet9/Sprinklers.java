
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sprinklers {

    static class Interval {

        double L, R;

        Interval(double L, double R) {
            this.L = L;
            this.R = R;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        ArrayList<Interval> list = new ArrayList<>();
        double halfW = w / 2.0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r <= halfW) {
                continue;
            }
            double dx = Math.sqrt(r * 1.0 * r - halfW * halfW);
            list.add(new Interval(Math.max(0, x - dx), Math.min(l, x + dx)));
        }

        list.sort((a, b) -> {
            if (a.L == b.L) {
                return Double.compare(b.R, a.R);
            }
            return Double.compare(a.L, b.L);
        });

        int i = 0, used = 0;
        double cur = 0;
        int m = list.size();
        while (cur < l) {
            double best = cur;
            while (i < m && list.get(i).L <= cur + 1e-9) {
                best = Math.max(best, list.get(i).R);
                i++;
            }
            if (best <= cur + 1e-9) {
                System.out.println(-1);
                return;
            }
            used++;
            cur = best;
        }
        System.out.println(used);
    }
}
