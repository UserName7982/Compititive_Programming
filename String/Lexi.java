package String;
class Solution {
    char ch;
    boolean midEle=false;
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        int[] freq=new int[26];
        for(char alpa: s.toCharArray()){
            freq[alpa-'a']++;
        }
      
        if(n%2==0){
            for(int i=0; i<26; i++){
                if(freq[i]==0) continue;
                else if (freq[i]%2!=0) return "";
            }
        }else{
            int count=0;
            for(int i=0; i<26; i++){
                if(freq[i]==0) continue;
                else if (freq[i]%2!=0) {
                    count++;
                    freq[i]--;
                }else{
                    ch=(char) ((char)i+'a');
                    midEle=true;
                }
                if (count > 1) return "";
            }
        }
        StringBuilder sb=new StringBuilder();
        int halflength=n/2;
        char[] palindrome=new char[halflength];
        return solve(0,palindrome,s,target,halflength,freq);
    }
    public String solve(int i,char[] palindrome,String s,String target,int halflength,int[] freq){
        if(i>=halflength){
            String ss=new String(palindrome);
            String cs=completepalindrome();
            if(cs.compareTo(ss)>0){
                return cs;
            }else{
                return "";
            }


        }
    }
    private String completepalindrome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completepalindrome'");
    }
    
}