package CodeForces._1000Rated;

import java.util.Scanner;

public class Swap_and_Delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int count0 = 0;
            int count1 = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') count0++;
                else count1++;
            }

            boolean printed = false;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0' && count1 > 0) {
                    count1--;
                } else if (s.charAt(i) == '1' && count0 > 0) {
                    count0--;
                } else {
                    System.out.println(s.length() - i);
                    printed = true;
                    break;
                }
            }

            if (!printed) {
                System.out.println(0);
            }
        }
    }
}