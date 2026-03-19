package segmentTree;

import java.util.Arrays;

public class LeftmostBuildingQueries {
    public class SegTree {
        private int[] seg;
        private int[] arr;

        public SegTree(int[] arr) {
            int n = arr.length;
            this.arr = arr;
            this.seg = new int[4 * n];
            build(0, 0, n - 1);
        }

        private void build(int i, int l, int r) {
            if (l == r) {
                seg[i] = l;  
                return;
            }

            int mid = l + (r - l) / 2;
            build(2 * i + 1, l, mid);
            build(2 * i + 2, mid + 1, r);

            int leftIdx = seg[2 * i + 1];
            int rightIdx = seg[2 * i + 2];
            seg[i] = (arr[leftIdx] >= arr[rightIdx]) ? leftIdx : rightIdx;
        }

        public int query(int i, int start, int end, int l, int r) {
            if (start > r || end < l) {
                return -1;
            }

            if (l <= start && end <= r) {
                return seg[i];
            }

            int mid = start + (end - start) / 2;
            int left = query(2 * i + 1, start, mid, l, r);
            int right = query(2 * i + 2, mid + 1, end, l, r);

            if (left == -1) return right;
            if (right == -1) return left;

            return arr[left] >= arr[right] ? left : right;
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        SegTree st = new SegTree(heights);

        for (int j = 0; j < m; j++) {
            int a = queries[j][0];
            int b = queries[j][1];

            int l = Math.min(a, b);
            int r = Math.max(a, b);

            if (l == r) {
                ans[j] = l;
                continue;
            }

            if (heights[l] < heights[r]) {
                ans[j] = r;
                continue;
            }

            int target = heights[l];
            int low = r + 1, high = n - 1;
            int result = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int idx = st.query(0, 0, n - 1, r + 1, mid);

                if (idx != -1 && heights[idx] > target) {
                    result = idx;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans[j] = result;
        }

        return ans;
    }
}