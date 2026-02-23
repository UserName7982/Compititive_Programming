package CodeForces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class String_rotation_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            HashSet<Character> set = new HashSet<>();
            n = s.length();
            
            int groups = 1;
            for (int i = 1; i < n; i++) {
                set.add(s.charAt(i));
                if (s.charAt(i) != s.charAt(i - 1)) groups++;
            }
        }
        sc.close();
    }
}
