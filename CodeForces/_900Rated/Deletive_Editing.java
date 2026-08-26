package CodeForces._900Rated;

import java.util.HashMap;
import java.util.Scanner;

public class Deletive_Editing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            String t = sc.next();

            int i = s.length() - 1;
            int j = t.length() - 1;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int k = 0; k < t.length(); k++) {
                map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
            }

            boolean canMake = true;

            while (i >= 0 && j >= 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    char ch = s.charAt(i);
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    i--;
                    j--;
                } else {
                    if (map.containsKey(s.charAt(i))) {
                        canMake = false;
                        break;
                    }
                    i--;
                }
            }

            if (j >= 0) canMake = false;

            System.out.println(canMake ? "YES" : "NO");
        }
    }
}