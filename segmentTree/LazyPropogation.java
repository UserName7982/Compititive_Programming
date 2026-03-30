package segmentTree;

import java.util.HashMap;

public class LazyPropogation {
    public class segmentTree {
        int[] lazy;
        int[] segMax;
        int[] segMin;
        public segmentTree(int size) {
            lazy = new int[4 * size];
            segMax = new int[4 * size];
            segMin = new int[4 * size];
        }

    public void propogate(int i,int start,int end) {
        if (lazy[i] != 0) {
            segMax[i] += lazy[i];
            segMin[i] += lazy[i];
            if (start != end) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }
    }

    public void update_Range(int start ,int end,int val,int i,int l,int r) {
        propogate(i, l, r);

        if (start > r || end < l) {
            return;
        }

        if (start <= l && r <= end) {
            lazy[i] += val;
            propogate(i, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        update_Range(start, end, val, 2 * i + 1, l, mid);
        update_Range(start, end, val, 2 * i + 2, mid + 1, r);
        segMax[i]=Math.max(segMax[2*i+1],segMax[2*i+2]);
        segMax[i]=Math.max(segMax[i],segMin[2*i+1]+segMin[2*i+2]);
    }

    public int leftmostZero(int i, int l, int r) {
        propogate(i, l, r);
        if (segMax[i]<0 || segMin[i]>0) {
            return -1;
        }

        if (l == r) {
            return l;
        }

        int mid = l + (r - l) / 2;
        int left = leftmostZero(2 * i + 1, l, mid);
        if(left!=-1) return left;
        int right = leftmostZero(2 * i + 2, mid + 1, r);
        return right;

    }
        
    }
    public int longestBalanced(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        segmentTree st=new segmentTree(nums.length);
        for(int r=0; r<nums.length; r++){
            
            int prev=map.containsKey(nums[r])?map.get(nums[r]):-1;
            if(prev!=-1){
                st.update_Range(0, prev, -1, 0, 0, nums.length-1);
            }
            st.update_Range(0, r, 1, 0, 0, nums.length-1);

            int l=st.leftmostZero(0, 0, nums.length-1);
            map.put(nums[r], r);
            if(l==-1) continue;
            ans=Math.max(ans, r-l+1);
            
        }
        return ans;
    }
}
