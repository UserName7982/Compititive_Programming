package CodeForces;

import java.util.Scanner;

public class Crucial_Equation {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int[] xy = new int[3];
            int g = gcd(a, b, xy);
            boolean can = (c % g != 0) ? false : true;
            int x = xy[0] * (c / g);
            int y = xy[1] * (c / g);
            if (can) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    static int gcd(int a, int b, int[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }

        int[] temp = new int[2];
        int g = gcd(b, a % b, temp);
        xy[0] = temp[1];
        xy[1] = temp[0] - (a / b) * temp[1];

        return g;
    }
}
