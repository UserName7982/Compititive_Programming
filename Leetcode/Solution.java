package Leetcode;
class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        int[] prefix1 = new int[n];
        int[] suffix0 = new int[n];
        prefix1[0] = s.charAt(0) == '1' ? 1 : 0;
        suffix0[n - 1] = s.charAt(n - 1) == '0' ? 1 : 0;
        boolean[] arr=new boolean[strs.length];
        for (int i = 1; i < n; i++) {
            prefix1[i] = prefix1[i - 1] + ((s.charAt(i) == '1') ? 1 : 0);
            suffix0[n - i - 1] = suffix0[n - i] + (s.charAt(n - i - 1) == '0' ? 1 : 0);
        }
        for (int i = 0; i < strs.length; i++) {
            char[] st = strs[i].toCharArray();
            int total1 = 0;
            int total0 = 0;
            for (int j = 0; j < n; j++) {
                if (st[j] == '0')
                    total0++;
                else if (st[j] == '1')
                    total1++;
            }
            if(prefix1[n-1]<total1 || suffix0[0]<total0) {arr[i]=false; continue;}
            boolean can=true;
            for (int j = 0; j < n; j++) {
                if(st[j]=='?'){
                    if(suffix0[0]-total0>0) {total0++; st[j]='0';}
                    else if(prefix1[n-1]-total1>0){ total1++; st[j]='1';}
                }
            }
            int curr0=0;
            int curr1=0;
            for (int j = 0; j < n; j++) {
                if(st[j]=='1') curr1++;
                if(st[n-j-1]=='0') curr0++;
                if(prefix1[j]<curr1 || (suffix0[n-j-1]<curr0)){can=false; break;}
            }
            arr[i]=can;
        }
        return arr;
    }
}