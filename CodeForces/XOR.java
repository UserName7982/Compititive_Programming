package CodeForces;

import java.util.HashMap;
import java.util.Scanner;

public class XOR {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n+1];
            HashMap<Integer,Integer> map=new HashMap<>();

            if ((n & (n-1)) == 0) {
                System.out.println(-1);
                continue;
            }
            for(int i=2; i<n; i++){
                arr[i]=i^1;
            }
           
            for(int i=2; i<=n; i++){
                if (arr[i]%2!=0 && (arr[i]^i)==1) {
                    arr[1]=i;
                    break;
                }
            }
            arr[n]=1;
            for (int i = 1; i <=n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }    
}
