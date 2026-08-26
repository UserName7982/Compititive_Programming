package CodeForces;
import java.util.Arrays;
import java.util.Scanner;

public class ElatyhGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            Arrays.sort(a);

            long ans = 1;
            int[] prefix=new int[n];
            prefix[0]=b[0];
            for (int i = 1; i < n; i++) {
                prefix[i]=prefix[i-1]+b[i];
            }
            int j=n-1;
            for (int k = 0; k < n; k++) {       
                
                while (j>=0&&prefix[j]>(n-k)) {
                    j--;
                }
                if (j>=0) {
                ans=Math.max(ans, 1L*a[k]*(j+1));
                }
            }
            System.out.println(ans);
        }
    }
}
