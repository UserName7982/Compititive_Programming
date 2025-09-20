package InclusionExclusion;

import java.util.*;

public class Question {

    static List<String> subset(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        int subset_cnt = 1 << n;
        for (int i = 0; i < subset_cnt; i++) {
            StringBuilder subset = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.append(str.charAt(j));
                }
            }
            list.add(subset.toString());
        }
        return list;
    }

    static long comb3(long x) {
        if (x < 3) return 0;
        return x * (x - 1) * (x - 2) / 6;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                HashSet<Character> distinctVowels = new HashSet<>();
                for (char ch : s.toCharArray()) {
                    if ("aeiou".indexOf(ch) >= 0) distinctVowels.add(ch);
                }

                List<Character> vowels = new ArrayList<>(distinctVowels);
                Collections.sort(vowels);
                StringBuilder sb = new StringBuilder();
                for (char ch : vowels) sb.append(ch);
                String ss = sb.toString();

                List<String> list = subset(ss);
                for (String str : list) {
                    if (str.isEmpty()) continue; // skip empty subset
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }

            long ans = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                int cnt = e.getValue();
                if (cnt < 3) continue;
                int len = e.getKey().length();
                long ways = comb3(cnt);
                if ((len % 2) == 1) ans += ways;
                else ans -= ways;
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
