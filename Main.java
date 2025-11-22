
// This program is for submission's only
// Content subject to change at any moment
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[] x1 = new double[n];
        double[] x2 = new double[n];
        double[] y1 = new double[n];
        double[] y2 = new double[n];
        double[] xs = new double[2 * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double xu = Double.parseDouble(st.nextToken());
            double yu = Double.parseDouble(st.nextToken());
            double r = Double.parseDouble(st.nextToken());
            x1[i] = xu - r;
            x2[i] = xu + r;
            y1[i] = yu - r;
            y2[i] = yu + r;
            xs[2 * i] = x1[i];
            xs[2 * i + 1] = x2[i];
        }

        Arrays.sort(xs);
        double area = 0.0;

        for (int i = 0; i + 1 < xs.length; i++) {
            double lx = xs[i], rx = xs[i + 1];
            if (rx <= lx) {
                continue;
            }

            List<double[]> segs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (x2[j] > lx && x1[j] < rx) {
                    segs.add(new double[]{y1[j], y2[j]});
                }
            }
            if (segs.isEmpty()) {
                continue;
            }

            segs.sort(Comparator.comparingDouble(a -> a[0]));
            double cy1 = segs.get(0)[0], cy2 = segs.get(0)[1];
            double unionY = 0.0;

            for (int k = 1; k < segs.size(); k++) {
                double ny1 = segs.get(k)[0], ny2 = segs.get(k)[1];
                if (ny1 > cy2) {
                    unionY += cy2 - cy1;
                    cy1 = ny1;
                    cy2 = ny2;
                } else {
                    if (ny2 > cy2) {
                        cy2 = ny2;
                    }
                }
            }
            unionY += cy2 - cy1;
            area += unionY * (rx - lx);
        }

        System.out.printf("%.2f", area);
    }

}
