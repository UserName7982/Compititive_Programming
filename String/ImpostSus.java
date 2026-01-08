package String;

import java.util.Scanner;

public class ImpostSus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int i=1;
            int j=0;
            int ans=0;
            while (i<s.length()-1 && j<s.length()-1) {
                int countu=0;
                while (j<s.length()-1 && i<s.length()-1&&s.charAt(j)=='u') {
                    countu++;
                    j++;
                }
                countu=j-i;
                ans+=countu/2;
                countu=0;
                i=j;
                i++;
                j=i;
            }
            ans+= (s.charAt(0)=='u')?1:0;
            ans+=(s.charAt(s.length()-1)=='u')?1:0;
            System.out.println(ans);
        }
    }
}
