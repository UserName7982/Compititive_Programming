package CodeForces._900Rated;
import java.util.Scanner;

public class Permutation_Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = Math.abs(arr[0] - 1);;
            for (int i = 1; i < n; i++) {
                if ((i+1) != arr[i]) {
                    ans = gcd(ans, Math.abs((i + 1) - arr[i]));
                }
                
            }
            System.out.println(ans);
        }
    }

    public static int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
