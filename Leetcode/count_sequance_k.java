package Leetcode;

import java.util.HashMap;

public class count_sequance_k {
     public int countSequences(int[] nums, long k) {
        HashMap<String,Integer> dp=new HashMap<>();
        return solve(0,1L,1L,nums,k,dp);
    }
    public int solve(int index,long num,long deno,int[] nums,long k,HashMap<String,Integer> dp){
        if(index==nums.length){
            return (num==k*deno)?1 :0;
        }
        long g=gcd(num,deno);
        num/=g;
        deno/=g;
        if(dp.containsKey(num+" "+deno+" "+index)) return dp.get(num+" "+deno+" "+index);
        int count=0;

        count+=solve(index+1,num*nums[index],deno,nums,k,dp);
        count+=solve(index+1,num,deno*nums[index],nums,k,dp);
        count+=solve(index+1,num,deno,nums,k,dp);
        dp.put(num+" "+deno+" "+index,count);
        return count;
    }

    public long gcd(long a, long b){
        return b==0? a : gcd(b,a%b);
    }
}
