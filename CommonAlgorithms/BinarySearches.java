
import java.util.Arrays;

public class BinarySearches {

    /*
    This class demonstrates 2 use of binary search:
    1. Using binary search to find a specific value
    2. Using binary search to find boundary: lower or upper
     */
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 1;
        int lowerTarget = 4;
        int upperTarget = 5;

        int targetIdx = binarySearch(list, target);
        int lowerBoundIdx = binaryLowerBoundSearch(list, lowerTarget);
        int upperBoundIdx = binaryUpperBoundSearch(list, upperTarget);
        System.out.println("The original array is: " + Arrays.toString(list));
        System.out.println("The target number  " + target + " is located at index " + targetIdx);
        System.out.println("The first number that is greater than " + lowerTarget + " is located at index " + lowerBoundIdx);
        System.out.println("The last number that is smaller than " + upperTarget + " is located at index " + upperBoundIdx);

    }

    public static int binaryUpperBoundSearch(int[] list, int target) {
        int left = 0;
        int right = list.length;

        while (left < right) {

            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (list[mid] < target) { // if condition met, try to find if there's larger values that suffices too
                left = mid + 1;
            } else { // if mid >= target, that means we have to look to the left
                right = mid;
            }
        }
        return left - 1; // left as the lower bound

    }

    public static int binaryLowerBoundSearch(int[] list, int target) {
        int left = 0;
        int right = list.length;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (list[mid] > target) { // if mid is bigger than target, that means the lower bound is on the left
                right = mid; // since this include list[mid] == target, we don't do right = mid -1
                // so we try to find any possible bound that is lower than this mid and satisfy this condition
            } else { //if  list[mid] < target, then this means our lower bound is to its right definitey
                left = mid + 1;
            }
        }
        return left; // left as the lower bound
    }

    public static int binarySearch(int[] list, int target) {

        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] > target) {

                right = mid - 1; // look into left
            } else if (list[mid] < target) {
                left = mid + 1; // look into right
            }
        }

        return -1; // if not found, return error -1
    }
}
