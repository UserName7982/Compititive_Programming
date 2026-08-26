package CodeForces;

import java.util.Scanner;

public class binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String ans = sc.next();

            if (ans.length() != n) {   // safety
                System.out.println("NO");
                continue;
            }

            // Your early conditions
            if (n % 2 != 0 && ans.charAt(0) == 'b') {
                System.out.println("NO");
                continue;
            }
            if (n % 2 == 0 && ans.charAt(0) == ans.charAt(1)) {
                System.out.println("NO");
                continue;
            }

            // This was checking 's', but that never makes sense since s is alternating.
            // If you meant to ensure 'ans' doesn't contain 3 same in a row, check ans instead:
            for (int i = 0; i + 2 < n; i++) {
                if (ans.charAt(i) == ans.charAt(i + 1) && ans.charAt(i) == ans.charAt(i + 2)) {
                    System.out.println("NO");
                    // don't exit all tests
                    continue;
                }
            }

            System.out.println("YES");
        }

        sc.close();
    }
}