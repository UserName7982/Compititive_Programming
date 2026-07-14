package CodeForces.Contest_DIV_2;

import java.util.Scanner;

public class Bigrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int k=sc.nextInt();
            int[] arr=new int[k];
            for (int i = 0; i < k; i++) {
                arr[i]=sc.nextInt();
            }
            int count2=0;
            boolean can=false;
            for (int i = 0; i < k; i++) {
                if(arr[i]>=2){
                    count2++;
                }
                if (arr[i]>2) {
                    can=true;
                }
            }
            if (can) {
                System.out.println("YES");
            }else if (count2>=2) {
                System.out.println("YES");
            }else {
                System.out.println("NO");

            }
        }
    }
}
