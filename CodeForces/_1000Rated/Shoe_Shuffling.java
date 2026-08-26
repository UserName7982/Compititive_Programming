package CodeForces._1000Rated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shoe_Shuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
            int[] ans = new int[n];
            boolean can = true;
            for (List<Integer> ls : map.values()) {
                if (ls.size() < 2) {
                    can = false;
                    break;
                }
            }
            if (!can) {
                System.out.println(-1);
                continue;
            }
            for (int key : map.keySet()) {
                List<Integer> ls = map.get(key);
                int sz=ls.size();
                for (int i = 0; i < sz; i++) {
                
                    ans[ls.get(i)] = ls.get((sz + i + 1) % sz);
                }
            }

            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + 1 + " ");
            }
            System.out.println();
        }
    }
}
