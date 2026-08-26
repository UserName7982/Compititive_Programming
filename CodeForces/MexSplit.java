package CodeForces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MexSplit {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            char[] arr = s.toCharArray();
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);

            if (Arrays.equals(arr, sorted)) {
                System.out.println("Bob");
                continue;
            }

            System.out.println("Alice");

            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] != sorted[i]) {
                    indices.add(i + 1);
                }
            }

            System.out.println(indices.size());
            for (int x : indices) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
