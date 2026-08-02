import java.util.Arrays;
import java.util.Scanner;

public class Dora_and_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }

            int i=0;
            int j=n-1;
            int x=-1;
            int y=-1;
            int min=1;
            int max=n;
            while (i<j) {
                if(arr[i]!=min && arr[i]!=max && arr[j]!=min && arr[j]!=max){
                    x=i+1;
                    y=j+1;
                    break;
                }
                if(arr[i]==min){
                    min++;
                    i++;
                }else if (arr[i]==max) {
                    max--;
                    i++;
                }
                if (arr[j]==min) {
                    j--;
                    min++;
                }else if (arr[j]==max) {
                    max--;
                    j--;
                }
            }
            if(x==-1 || y==-1){
                System.out.println(-1);
            }else{
                System.out.println(x+" "+y);
            }
        }
    }
}
