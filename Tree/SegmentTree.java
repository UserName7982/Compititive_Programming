package Tree;

public class SegmentTree {
    int[] seg;
    public SegmentTree(int size) {
        this.seg=new int[4*size];
    }

    public void Build(int indx,int low,int high,int l,int r,int[] arr) {
        if (low==high) {
            seg[indx]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        Build(2*indx+1,low,mid,l,r,arr);
        Build(2*indx+2,mid+1,high,l,r,arr);
        seg[indx]=Math.min(seg[2*indx+1],seg[2*indx+2]);
    }   

    int query(int indx,int low,int high,int l,int r) {
        if (r<low || l>high) {
            return Integer.MAX_VALUE;
        }
        if (l<=low && r>=high) {
            return seg[indx];
        }
        int mid=(low+high)/2;
        int left=query(2*indx+1,low,mid,l,r);
        int right=query(2*indx+2,mid+1,high,l,r);
        return Math.min(left,right);
    }

    public int update(int indx,int low,int high,int pos,int val) {
        if (low==high) {
            seg[indx]=val;
            return val;
        }
        int mid=(low+high)/2;
        if (pos<=mid) {
            update(2*indx+1,low,mid,pos,val);
        } else {
            update(2*indx+2,mid+1,high,pos,val);
        }
        seg[indx]=Math.min(seg[2*indx+1],seg[2*indx+2]);
        return seg[indx];
    }

    public static void main(String[] args) {
        
        int arr[]={1,3,2,7,9,11};
        int n=arr.length;
        SegmentTree st=new SegmentTree(n);
        st.Build(0,0,n-1,0,n-1,arr);
        int l=1;
        int r=5;
        System.out.println(st.query(0,0,n-1,l,r));
        int pos=1;
        int val=0;
        st.update(0,0,n-1,pos,val);
        arr[pos]=val;
        System.out.println(st.query(0,0,n-1,l,r));
    }
}
