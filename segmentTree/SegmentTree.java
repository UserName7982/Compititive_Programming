package segmentTree;

public class SegmentTree {
    int[] seg;

    public SegmentTree(int size) {
        this.seg = new int[4 * size];
    }

    public void Build(int indx, int low, int high, int l, int r, int[] arr) {
        if (low == high) {
            seg[indx] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        Build(2 * indx + 1, low, mid, l, r, arr);
        Build(2 * indx + 2, mid + 1, high, l, r, arr);
        seg[indx] = Math.min(seg[2 * indx + 1], seg[2 * indx + 2]);
    }

    int query(int indx, int low, int high, int l, int r) {
        if (r < low || l > high) {
            return Integer.MAX_VALUE;
        }
        if (l <= low && r >= high) {
            return seg[indx];
        }
        int mid = (low + high) / 2;
        int left = query(2 * indx + 1, low, mid, l, r);
        int right = query(2 * indx + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    public int update(int indx, int low, int high, int pos, int val) {
        if (low == high) {
            seg[indx] = val;
            return val;
        }
        int mid = (low + high) / 2;
        if (pos <= mid) {
            update(2 * indx + 1, low, mid, pos, val);
        } else {
            update(2 * indx + 2, mid + 1, high, pos, val);
        }
        seg[indx] = Math.min(seg[2 * indx + 1], seg[2 * indx + 2]);
        return seg[indx];
    }

    public static void main(String[] args) {

        int arr[] = { 1, 3, 2, 7, 9, 11 };
        int n = arr.length;
        SegmentTree st = new SegmentTree(n);
        st.Build(0, 0, n - 1, 0, n - 1, arr);
        int l = 1;
        int r = 5;
        System.out.println(st.query(0, 0, n - 1, l, r));
        int pos = 1;
        int val = 0;
        st.update(0, 0, n - 1, pos, val);
        arr[pos] = val;
        System.out.println(st.query(0, 0, n - 1, l, r));
    }

    class Solution {
        int K;

        class Node {
            int product;
            int[] freqk;

            Node(int product) {
                this.product = product;
                this.freqk = new int[K];
            }
        }

        class Segment {
            Node[] seg;

            Segment(int n) {
                this.seg = new Node[4 * n];
            }

            void build(int i, int l, int r, int[] nums) {
                if (l == r) {
                    seg[i] = new Node(nums[l] % K);
                    seg[i].freqk[nums[l] % K]++;
                    return;
                }
                int mid = (l + r) / 2;
                build(2 * i + 1, l, mid, nums);
                build(2 * i + 1, mid + 1, r, nums);
                seg[i] = merge(seg[2 * i + 1], seg[2 * i + 2]);
            }

            void update(int i, int l, int r, int[] nums, int indx, int val) {
                if (l == r) {
                    seg[i] = new Node(val % K);
                    seg[i].freqk[val % K]++;
                    return;
                }
                int mid = (l + r) / 2;
                if (mid <= indx)
                    update(2 * i + 1, l, mid, nums, indx, val);
                else
                    update(2 * i + 1, mid + 1, r, nums, indx, val);
                seg[i] = merge(seg[2 * i + 1], seg[2 * i + 2]);
            }

            Node query(int i, int l, int r, int[] nums, int ql, int qr) {
                if (l > qr || r < ql)
                    return new Node(1);
                if (l >= ql && r <= qr)
                    return seg[i];
                int mid = (l + r) / 2;
                Node left = query(2 * i + 1, l, mid, nums, ql, qr);
                Node right = query(2 * i + 2, mid + 1, r, nums, ql, qr);
                return merge(left, right);
            }

            public Node merge(Node L, Node R) {
                Node res = new Node((L.product * R.product) % K);
                System.arraycopy(L.freqk, 0, res.freqk, 0, K);
                for (int r = 0; r < K; r++) {
                    if (R.freqk[r] != 0) {
                        int ntr = (L.product * r) % K;
                        res.freqk[ntr] += R.freqk[r];
                    }
                }
                return res;
            }
        }

        public int[] resultArray(int[] nums, int k, int[][] queries) {
            this.K = k;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                nums[i] %= k;
            }
            Segment sg = new Segment(n);
            sg.build(0, 0, n - 1, nums);
            int[] ans = new int[queries.length];
            int i = 0;
            for (int[] q : queries) {
                int idx = q[0], val = q[1], start = q[2], x = q[3];
                sg.update(0, 0, n - 1, nums, idx, val);
                Node res = sg.query(0, 0, n - 1, nums, start, n - 1);
                ans[i++] = res.freqk[x];
            }
            return ans;
        }
    }
}
