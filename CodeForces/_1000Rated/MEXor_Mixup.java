// package CodeForces._1000Rated;

import java.util.Scanner;

public class MEXor_Mixup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int XOR = 0;
            if ((a-1) % 4 == 0)
                XOR = a - 1;
            else if ((a-1 )% 4 == 1)
                XOR = 1;
            else if ((a-1) % 4 == 2)
                XOR = a;
            else
                XOR = 0;
            if (XOR == b) {
                System.out.println(a);
                continue;
            }
            int x = XOR ^ b;
            int ans = a + 1;
            if (x == a && x != 0)
                ans++;
            System.out.println(ans);
        }
    }
}
