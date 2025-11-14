package Tree;

import java.util.Scanner;

public class Xenia_Bitoperation {
    static void Build(int indx, int low, int high, int[] arr, int[] seg, boolean or) {
        if (low == high) {
            seg[indx] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        Build(2 * indx + 1, low, mid, arr, seg, !or);
        Build(2 * indx + 2, mid + 1, high, arr, seg, !or);

        if (or) {
            seg[indx] = seg[2 * indx + 1] | seg[2 * indx + 2];
        } else {
            seg[indx] = seg[2 * indx + 1] ^ seg[2 * indx + 2];
        }
    }

    static void update(int indx, int low, int high, int[] arr, int[] seg, boolean or, int pos, int val) {
        if (low == high) {
            seg[indx] = val;
            return;
        }
        int mid = low + (high - low) / 2;

        if (pos <= mid) {
            update(2 * indx + 1, low, mid, arr, seg, !or, pos, val);
        } else {
            update(2 * indx + 2, mid + 1, high, arr, seg, !or, pos, val);
        }

        if (or) {
            seg[indx] = seg[2 * indx + 1] | seg[2 * indx + 2];
        } else {
            seg[indx] = seg[2 * indx + 1] ^ seg[2 * indx + 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int elm = 1 << n;
        int[] arr = new int[elm];
        for (int i = 0; i < elm; i++) arr[i] = sc.nextInt();

        int[] seg = new int[4 * elm];

        boolean root_or = (n % 2 == 1);

        Build(0, 0, elm - 1, arr, seg, root_or);

        while (q-- > 0) {
            int pos = sc.nextInt() - 1;
            int val = sc.nextInt();

            update(0, 0, elm - 1, arr, seg, root_or, pos, val);
            System.out.println(seg[0]);
        }

        sc.close();
    }
}
