package String;

class Solution {
    char ch;
    boolean midEle = false;

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char alpa : s.toCharArray()) {
            freq[alpa - 'a']++;
        }

        if (n % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0)
                    continue;
                else if (freq[i] % 2 != 0)
                    return "";
            }
        } else {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0)
                    continue;
                else if (freq[i] % 2 != 0) {
                    count++;
                    freq[i]--;
                    ch = (char) (i+'a');
                    midEle = true;
                } 
                if (count > 1)
                    return "";
            }
        }
        int halflength = n / 2;
        char[] palindrome = new char[halflength];
        for(int i=0;i<halflength;i++){
            palindrome[i]='\0';
        }
        return solve(0, palindrome, s, target, halflength, freq);
    }

    public String solve(int i, char[] palindrome, String s, String target, int halflength, int[] freq) {
        if (i >= halflength) {

            String ss = new String(palindrome);
            String cs = completepalindrome(ss,freq);
            System.out.println(cs);
            if (cs.compareTo(target) > 0) {
                return cs;
            } else {
                return "";
            }

        }
        String res = "";
        if (s.charAt(i)==target.charAt(i) && freq[s.charAt(i) - 'a']>0) {
            palindrome[i] = s.charAt(i);
            freq[s.charAt(i) - 'a'] --;
            res= solve(i + 1, palindrome, s, target, halflength, freq);
            if (!res.equals("")) {
                return res;
            }
            palindrome[i] = '\0';
            freq[s.charAt(i) - 'a'] ++;
        }
            int start=(s.charAt(i)+1-'a');
            System.out.println(start);
            for (int j = start; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j]--;
                    palindrome[i] = (char) (j + 'a');
                    res = solve(i + 1, palindrome, s, target, halflength, freq);
                    if (!res.equals("")) {
                        return res;
                    }
                    freq[j]++;
                    palindrome[i] = '\0';
                }
            }
        return res;
    }

    private String completepalindrome(String ss,int[] freq) {
        StringBuilder sb = new StringBuilder(ss);
        if (midEle) {
            sb.append(ch);
        }
        System.out.println(sb.toString()+" "+ch);
        for (int i = ss.length() - 1; i >= 0; i--) {
            if (freq[ss.charAt(i) - 'a'] <= 0)
                return "";
            sb.append(ss.charAt(i));
            freq[ss.charAt(i) - 'a']--;
        }
        if (isPalindrome(sb.toString())) {
            return sb.toString();
        }else return "";
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.lexPalindromicPermutation("aabb", "aaaa"));
    }
}