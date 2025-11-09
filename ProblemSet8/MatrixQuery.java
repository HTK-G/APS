
import java.io.*;
import java.util.StringTokenizer;

public class MatrixQuery {

    public static void main(String[] args) throws IOException {

        // hint: 2 dimensional binary search?
        // Input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];

        // Inititalize matrix
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());

        // Initialize query matrix
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            int ans = 0;
            int lo = 0;
            int hi = Math.min(N, M); //choose the longer side

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (existMatrix(matrix, mid, min, max)) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            System.out.println(ans);
        }

    }

    public static boolean existMatrix(int[][] matrix, int len, int min, int max) {

        // edge case
        if (len == 0) {
            return true;
        }

        for (int i = 0; i + len - 1 < matrix.length; i++) {

            int j = minStartPoint(matrix[i], min);

            if (j == matrix[0].length) {
                continue;
            }

            if (j + len - 1 >= matrix[0].length) {
                continue;
            }

            if (matrix[i + len - 1][j + len - 1] <= max) {

                return true;
            }
        }

        return false;

    }

    public static int minStartPoint(int[] row, int min) {

        // int j = 0;
        // while (j < row.length && row[j] < min) {
        //     j++;
        // }
        // return j;
        // changed to binary search
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (row[mid] < min) {

                lo = mid + 1;

            } else {
                hi = mid;
            }
        }
        return lo;
    }

}

/*
 * // Calculation Steps & output
        for (int[] range : query) {

            int min = range[0];
            int max = range[1];

            int maxSize = 0;
            int i = 0, j = 0;
            // 1. do a search diagnal only,
            // find the first element that is greater or equal to left
            while (i < matrix.length && j < matrix[0].length && matrix[i][j] < min) {
                i++;
                j++;
            }
            // 2. Check this element's size
            maxSize = Math.max(maxSize, size(matrix, i, j, max));

            int row = i - 1;

            // 3. Check above
            while (row >= 0 && matrix[i][j] >= min) // 3. First do a check on 
            {
                maxSize = Math.max(size(matrix, row, j, max), maxSize);
                row--;
            }

            // 4. Check left
            int col = j - 1;

            while (col >= 0 && matrix[i][j] >= min) {

                maxSize = Math.max(size(matrix, i, col, max), maxSize);
                col--;
            }

            // output
            System.out.println(maxSize);
        }
    }

    public static int size(int[][] matrix, int i, int j, int max) {

        int n = 0;

        while (i < matrix.length && j < matrix[0].length && matrix[i][j] < max) {
            i++;
            j++;
            n++;
        }
        return n;
    }
 */
