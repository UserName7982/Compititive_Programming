package CodeForces._900Rated;
import java.util.Scanner;

public class Simons_and_Making_It_Beautiful {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            int max_index=0;
            int max=-1;
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
                if(max<arr[i]){
                    max=arr[i];
                    max_index=i;
                }
            }
            System.out.print(n+ " ");
            for (int i = 1; i < n; i++) {
                if (max_index==i) {
                    System.out.print(arr[0]+" ");
                    continue;
                }
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
