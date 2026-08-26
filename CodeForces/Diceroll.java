package CodeForces;

import java.util.*;

public class Diceroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], i);
            }
            boolean flag = false;
            for (int i = 1; i <= n / 2; i++) {
                if (arr[i] != i) {
                    for (int j = i; j <= n; j *= 2) {
                        if (arr[j] == i) {
                            System.out.println("Swapping " + arr[i] + " and " + arr[j]);
                            int temp = arr[i];
                            arr[i] = i;
                            arr[j] = temp;
                            flag=true;
                            System.out.println("After swap: " + Arrays.toString(arr));
                            break;
                        }
                    }
                }
            }
            for (int i = (n / 2) + 1; i <= n; i++) {
                if (i != arr[i]) {
                    flag = false;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }
}
