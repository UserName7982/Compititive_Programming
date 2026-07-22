package segmentTree;
import java.util.ArrayList;
import java.util.List;

class Solution {
    class SegmentTree {
        int[] arr;
        int n;

        SegmentTree(int n) {
            arr = new int[4 * n + 1];
            this.n = n;
        }

        void build(int i, int l, int r, int[] gain) {
            if (l == r) {
                arr[i] = gain[l];
                return;
            }

            int mid = (l + r) / 2;
            build(2 * i + 1, l, mid, gain);
            build(2 * i + 2, mid + 1, r, gain);
            arr[i] = Math.max(arr[2 * i + 1], arr[2 * i + 2]);
            return;
        }

        int query(int i, int l, int r, int ql, int qr) {

            if (ql > r || qr < l)
                return Integer.MIN_VALUE;

            if (l >= ql && r <= qr) {
                return arr[i];
            }
            int mid = (l + r) / 2;
            return Math.max(query(2 * i + 1, l, mid, ql, qr), query(2 * i + 2, mid + 1, r, ql, qr));
        }

        int query(int ql, int qr) {
            if (ql > qr || n == 0)
                return 0;
            return query(0, 0, n - 1, ql, qr);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        List<Integer> con_zero = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int totalone = 0;
        for(char ch: s.toCharArray()){
            if(ch=='1') totalone++;
        }
        for (int i = 0; i < n; i++) {
            int j = i;

            while (j < n && s.charAt(i) == s.charAt(j))
                j++;
            if (s.charAt(i) == '0') {
                con_zero.add(j - i);
                left.add(i);
                right.add(j - 1);
            }
            i = j-1;
        }

        int m = con_zero.size();
        List<Integer> ans = new ArrayList<>();
        if (m < 2){
            for(int i=0; i<queries.length; i++){
                ans.add(totalone);
            }
            return ans;
        }
            
        int[] gain = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            gain[i] = con_zero.get(i) + con_zero.get(i+1);
        }
        
        SegmentTree st = new SegmentTree(m - 1);
        st.build(0,0,m-2,gain);
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int firstln = lower(right, l);
            int lastln = upper(left, r)-1;

            if (firstln >= lastln || firstln >= m || lastln < 0) {
                ans.add(totalone);
                continue;
            }
            int firstZer = right.get(firstln) - Math.max(left.get(firstln), l) + 1;
            int lastZer = Math.min(right.get(lastln), r) - left.get(lastln) + 1;

            if (firstln + 1 == lastln) {
                ans.add(totalone + firstZer + lastZer);
                continue;
            }
            int best = 0;

            best = Math.max(best, firstZer + con_zero.get(firstln + 1));
            best = Math.max(best, lastZer + con_zero.get(lastln - 1));
            best = Math.max(best, st.query(firstln + 1, lastln - 2));
            ans.add(totalone + best);
        }
        return ans;
    }

    public int lower(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size();

        while (l < r) {
            int mid = l+(r-l) / 2;
            if (arr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int upper(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size();

        while (l < r) {
            int mid = l+(r-l) / 2;
            if (arr.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}