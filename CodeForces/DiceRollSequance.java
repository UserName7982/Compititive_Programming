package CodeForces;
import java.util.Scanner;

public class DiceRollSequance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();

            int[] arr=new int[n];

            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }

            int ans=0;

            for (int i = 1; i < n; i++) {
                if (arr[i-1]==arr[i] || arr[i]+arr[i-1]==7) {
                    ans++;
                    i++;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
