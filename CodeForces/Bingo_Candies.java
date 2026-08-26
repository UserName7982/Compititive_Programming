package CodeForces;

import java.util.Scanner;

public class Bingo_Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-->0) {
            int n = sc.nextInt();
            int[] arr=new int[n*n+1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = sc.nextInt();
                    arr[x]++;
                }
            }
            boolean possible=true;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]> (n-1)*(n)) {
                    possible=false;
                    break;
                }
            }
            if(possible && n>1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
