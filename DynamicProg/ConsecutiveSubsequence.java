package DynamicProg;
import java.util.*;

public class ConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        HashMap<Integer, Integer> dp = new HashMap<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        int[] parent = new int[n]; 
        Arrays.fill(parent, -1);

        int bestLen = 0;
        int bestEnd = -1; 

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int len = dp.getOrDefault(val - 1, 0) + 1;

            dp.put(val, len);
            if (dp.containsKey(val - 1)) {
                parent[i] = lastIndex.get(val - 1);
            }

            lastIndex.put(val, i);

            if (len > bestLen) {
                bestLen = len;
                bestEnd = i;
            }
        }

        List<Integer> indices = new ArrayList<>();
        int cur = bestEnd;
        while (cur != -1) {
            indices.add(cur + 1); 
            cur = parent[cur];
        }
        Collections.reverse(indices);

        System.out.println(bestLen);
        for (int idx : indices) System.out.print(idx + " ");
        sc.close();
    }
}
