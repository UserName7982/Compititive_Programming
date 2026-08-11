package CodeForces._1200Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Playing_in_a_Casino {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            long[][] arr=new long[m][n];
            for(int j=0; j<n; j++){
                for(int i=0; i<m; i++){
                    arr[i][j]=sc.nextLong();
                }
            }
            long ans=0;
            for(int i=0; i<m; i++){
                Arrays.sort(arr[i]);
            }

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    ans+=arr[i][j]*j;
                    ans-=arr[i][j]*(n-j-1);
                }
            }
            System.out.println(ans);
        }
    }
}
