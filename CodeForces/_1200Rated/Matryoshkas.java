import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Matryoshkas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                int can = arr[i];
                if (!map.containsKey(can)) {
                    continue;
                }
                while (true) {
                    if (map.containsKey(can)) {
                        map.put(can, map.get(can) - 1);
                        if (map.get(can) == 0) {
                            map.remove(can);
                        }
                        can++;
                    } else {
                        break;
                    }
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}
