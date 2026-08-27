class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        return solve(0, s, target, new StringBuilder(), freq);
    }

    String solve(int i,String s, String target,StringBuilder ch,int[] freq){
        if(i>=s.length()){
            if(target.compareTo(ch.toString())<0) return ch.toString();
            else return "";
        }
        char t=target.charAt(i);
        String ss="";
        for(char c=t; c<='z'; c++){
            if(freq[c-'a']>0){
                freq[c-'a']--;
                ch.append(c);
                if(c==target.charAt(i)){
                ss=solve(i+1,s,target,ch,freq);
                if(ss.length()==s.length() && ss.compareTo(target)>0) return ss;
                }else{
                    for(char j='a'; j<='z'; j++){
                        while(freq[j-'a']-->0) ch.append(j);
                    }
                    return ch.toString();
                }
                freq[c-'a']++;
                ch.deleteCharAt(ch.length()-1);
            }
        }
        return ch.toString();
    }
}