package CodeForces._900Rated;

import java.util.Scanner;

public class Odd_Grasshopper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            long x=sc.nextLong();
            long move=sc.nextLong();

            long move_left=move-move%4;
            for (long i = move_left+1; i <=move; i++) {
                if (x % 2 == 0) {
                    x -= i;
                } else {
                    x += i;
                }
            }
            System.out.println(x);
        }
    }
}
