

import java.util.*;

public class Vika_and_the_Bridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).add(i);
            }

            int ans = Integer.MAX_VALUE;

            for (ArrayList<Integer> pos : map.values()) {

                int largest = 0;
                int secondLargest = 0;

                // Gap before first occurrence
                int gap = pos.get(0);
                largest = gap;

                // Gaps between consecutive occurrences
                for (int i = 1; i < pos.size(); i++) {
                    gap = pos.get(i) - pos.get(i - 1) - 1;

                    if (gap >= largest) {
                        secondLargest = largest;
                        largest = gap;
                    } else if (gap > secondLargest) {
                        secondLargest = gap;
                    }
                }

                // Gap after last occurrence
                gap = n - 1 - pos.get(pos.size() - 1);

                if (gap >= largest) {
                    secondLargest = largest;
                    largest = gap;
                } else if (gap > secondLargest) {
                    secondLargest = gap;
                }

                int cur = Math.max(largest / 2, secondLargest);
                ans = Math.min(ans, cur);
            }

            System.out.println(ans);
        }
    }
}