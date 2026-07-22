package CodeForces._1200Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Three_Activities {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[][] arr=new int[n][1];
            int[][] arr1=new int[n][1];
            int[][] arr2=new int[n][1];

            for(int i=0; i<n; i++){
                arr[i]=new int[]{sc.nextInt(),i};
            }
            for(int i=0; i<n; i++){
                arr1[i]=new int[]{sc.nextInt(),i};
            }
            for(int i=0; i<n; i++){
                arr2[i]=new int[]{sc.nextInt(),i};
            }
            Arrays.sort(arr,(a,b)->b[0]-a[0]);
            Arrays.sort(arr1,(a,b)->b[0]-a[0]);
            Arrays.sort(arr2,(a,b)->b[0]-a[0]);

            int max=0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k<3; k++){
                        if(arr[i][1]==arr1[j][1] || arr1[j][1]==arr2[k][1] || arr2[k][1]==arr[i][1]){
                            continue;
                        }
                        max=Math.max(max,arr[i][0]+arr1[j][0]+arr2[k][0]);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
