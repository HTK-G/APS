
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeatingRod {

    public static void main(String[] args) throws IOException {

        // input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double L1 = Double.parseDouble(st.nextToken());
        double T = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        double L2 = L1 * (1 + T * C);

        if (L1 == L2) {
            System.out.println(String.format("%.3f", 0.0));
            return;
        }

        // Calculation steps
        // L1 = 2*r*sin(theta/2)
        // L2 = 2*pi*(theta/2*pi) = r*theta
        // L2/L1 = L'/L = theta / 2 sin(theta/2)
        // then, we need to find the right theta value
        double ratio = L2 / L1; // from 1 to 1.5

        double left = 0.0, right = Math.PI;

        while (right - left > 0.000000000001) {

            double theta = left + (right - left) / 2;
            double curRatio = theta / (2 * Math.sin(theta / 2));
            if (curRatio > ratio) { // this means theta too big
                right = theta;
            } else {
                left = theta;
            }
        }

        double theta = (left + right) / 2;
        double r = L2 / theta;
        double d = r - r * (Math.cos(theta / 2));

        // output section
        System.out.println(String.format("%.3f", d));

    }

}
