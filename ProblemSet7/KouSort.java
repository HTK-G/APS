
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KouSort {

    static long swaps = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(list, 0, N - 1);
        System.out.println(swaps);

    }

    static void mergeSort(int[] list, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(list, l, mid);
        mergeSort(list, mid + 1, r);

        merge(list, l, mid, r);
    }

    static void merge(int[] list, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            if (list[i] <= list[j]) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
                swaps += (mid - i) + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = list[i++];
        }
        while (j <= r) {
            temp[k++] = list[j++];
        }
        System.arraycopy(temp, 0, list, l, temp.length);

    }

}
