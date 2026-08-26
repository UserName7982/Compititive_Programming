package CodeForces._900Rated;

import java.util.Scanner;
import java.util.Stack;

public class Specialty_String {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int n=sc.nextInt();
            String s =sc.next();
            boolean flag=false;
            Stack<Character> st=new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && st.peek()==s.charAt(i)) {
                    st.pop();
                    flag=true;
                }
                if(!flag){
                    st.push(s.charAt(i));
                }
                flag=false;
            }
            if (st.isEmpty()) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
