package String;

import java.util.Scanner;

public class YesORYes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int county=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'Y') {
                    county++;
                }
                
            }
            if (county>1) {
                System.out.println("NO");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
