package CodeForces;
import java.util.*;

public class Simons_and_Beating_peaks {

   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            Stack<Integer> st=new Stack<>();
            int[] left=new int[n];
            int[] right=new int[n];

            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && st.peek()<arr[i]) {
                    st.pop();
                }
                left[i]=st.size();
                st.push(arr[i]);
            }
            st.clear();
            for (int i = n-1; i >=0; i--) {
                while (!st.isEmpty() && st.peek()<arr[i]) {
                    st.pop();
                }
                right[i]=st.size();
                st.push(arr[i]);
            }
            int ans=0;
            for (int i = 0; i < n; i++) {
                ans=Math.max(ans,1+left[i]+right[i]);
            }
            System.out.println(n-ans);
        }
   }
}