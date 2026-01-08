import java.util.*;
 
public class man {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int k= sc.nextInt();
            int[] a = new int[n];
            int[] freq=new int[n+1];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if(a[i]<n){
                    freq[a[i]]++;
                }
            }
            int m=0;
            while (freq[m]>0){
                m++;
            }
            int ans=m;
            if(ans>k-1){
                ans=k-1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}