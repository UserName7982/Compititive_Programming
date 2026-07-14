package CodeForces._1000Rated;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Olya_and_Game_with_Arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            List<List<Integer>> list = new ArrayList<>();
            int n = sc.nextInt();

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                List<Integer> ls = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int val = sc.nextInt();
                    ls.add(val);
                    min = Math.min(min, val);
                }
                ls.sort(Integer::compareTo);
                list.add(ls);
            }
            int secminindx = -1;
            long total = 0;
            int val = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int secondMin = list.get(i).get(1);

                if (val > secondMin) {
                    val = secondMin;
                    secminindx = i;
                }

                total += (1L*secondMin);
            }

            System.out.println((total - list.get(secminindx).get(1)) + min);
        }
    }
}