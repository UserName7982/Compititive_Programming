package Tree;

import java.util.Scanner;

public class Sereja_Brackets {
    public static class info {
        int open;
        int close;
        int full;

        info(int open, int close, int full) {
            this.open = open;
            this.close = close;
            this.full = full;
        }
    }

    static info merge(info left, info right) {
        int full = left.full + right.full + Math.min(left.open, right.close);
        int open = left.open + right.open - Math.min(left.open, right.close);
        int close = left.close + right.close - Math.min(left.open, right.close);
        return new info(open, close, full);
    }

    static void Build(int indx, int low, int high, Character[] arr, info[] seg) {
        if (low == high) {
            int open = (arr[low] == '(') ? 1 : 0;
            int close = (arr[low] == ')') ? 1 : 0;
            seg[indx] = new info(open, close, 0);
            return;
        }
        int mid = low + (high - low) / 2;
        Build(2 * indx + 1, low, mid, arr, seg);
        Build(2 * indx + 2, mid + 1, high, arr, seg);
        seg[indx] = merge(seg[2 * indx + 1], seg[2 * indx + 2]);
    }

    static info query(int indx, int low, int high, Character[] arr, info[] seg, int l, int r) {

        if (r < low || l > high) {
            return new info(0, 0, 0);
        }
        if (l <= low && r >= high) {
            return seg[indx];
        }
        int mid = low + (high - low) / 2;
        info left = query(2 * indx + 1, low, mid, arr, seg, l, r);
        info right = query(2 * indx + 2, mid + 1, high, arr, seg, l, r);
        return merge(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        Character[] arr = new Character[n];
        int i = 0;
        for (char br : s.toCharArray()) {
            arr[i] = br;
            i++;
        }

        info[] seg = new info[4 * n];
        Build(0, 0, n - 1, arr, seg);
        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            info bracket = query(0, 0, n - 1, arr, seg, l, r);
            System.out.println(bracket.full * 2);
        }
        sc.close();
    }
}
