import java.util.Scanner;

public class farmpiggieandSubsetSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i]=i+2;
            }
            arr[n-1]=1;
            for(int i=0;i<n;i++){
               System.out.print(arr[i]+" ");
            }
            System.out.println();
            
        }
    }
}
