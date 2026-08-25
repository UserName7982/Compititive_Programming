import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Array_Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Long k = Long.parseLong(st.nextToken());
            long[] arr = new long[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            long ans = (long) 1e18;

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st1.nextToken());
                ans = Math.min(ans, arr[i]);
            }
            if (k >= 3) {
                sb.append(0 + "\n");
            } else {
                Arrays.sort(arr);
                List<Long> diff = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    ans = Math.min(ans, arr[i + 1] - arr[i]);
                }
                if (k > 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            diff.add(arr[j] - arr[i]);
                        }
                    }
                    for (int i = 0; i < diff.size(); i++) {
                        long d = diff.get(i);
                        int pos = lower(arr, d);
                        if (pos < n) {
                            ans = Math.min(ans, arr[pos] - d);
                        }
                        if (pos > 0) {
                            ans = Math.min(ans, d - arr[pos - 1]);
                        }
                    }
                }

                sb.append(ans + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int lower(long[] arr, long target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
