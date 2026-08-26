package CodeForces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ReversePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], i);
            }
            int[] temp = Arrays.copyOf(arr, n);
            Arrays.sort(temp);
            for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
                int tem = temp[i];
                temp[i] = temp[j];
                temp[j] = tem;
            }
            for (int i = 0; i < arr.length; i++) {
                if (temp[i] > arr[i]) {
                    int j = map.get(temp[i]);
                    while (i < n && i <= j) {
                        int tem = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tem;
                        i++;
                        j--;
                    }
                    break;
                }
            }
            for (int i = 0; i < temp.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
