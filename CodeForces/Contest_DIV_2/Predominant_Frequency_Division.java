package CodeForces.Contest_DIV_2;
import java.util.Scanner;

public class Predominant_Frequency_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

        
            int[] pref1 = new int[n + 1];

    
            int[] pref2 = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                pref1[i] = pref1[i - 1];
                pref2[i] = pref2[i - 1];

                if (a[i - 1] == 1)
                    pref1[i]++;
                else
                    pref1[i]--;

                if (a[i - 1] == 3)
                    pref2[i]--;
                else
                    pref2[i]++;
            }

            int[] suffixMax = new int[n + 1];

            suffixMax[n - 1] = pref2[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                suffixMax[i] = Math.max(pref2[i], suffixMax[i + 1]);
            }

            boolean ok = false;

            for (int i = 1; i <= n - 2; i++) {

                if (pref1[i] < 0)
                    continue;

                if (suffixMax[i + 1] >= pref2[i]) {
                    ok = true;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}