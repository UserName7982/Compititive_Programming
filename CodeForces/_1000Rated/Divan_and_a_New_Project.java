package CodeForces._1000Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Divan_and_a_New_Project {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[][] arr=new int[n][1];
            for(int i=0; i<n; i++){
                arr[i]=new int[]{sc.nextInt(),i+1};
            }
            Arrays.sort(arr,(a,b)->b[0]-a[0]);
            long ans=0;
            int x=1;
            int xi[]=new int[n+1];
            xi[0]=0;
            for(int i=0; i<n; i++){
                ans+=(2*x*arr[i][0]);
                xi[arr[i][1]]=x;
                if(i+1<n)
                {
                    i++;
                    ans+=(2*x*arr[i][0]);
                    xi[arr[i][1]]=-x;
                }
                x++;
            }
            System.out.println(ans);
            for(int i=0; i<=n; i++){
                System.out.print(xi[i]+" ");
            }
            System.out.println();
        }
    }
}
