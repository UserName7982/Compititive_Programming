package Tree;

public class SegmentTree {

    public void Build(int indx,int low,int high,int l,int r,int[] arr,int seg[]) {
        if (low==high) {
            seg[indx]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        Build(2*indx+1,low,mid,l,r,arr,seg);
        Build(2*indx+2,mid+1,high,l,r,arr,seg);
        seg[indx]=Math.min(seg[2*indx+1],seg[2*indx+2]);
    }   

    int query(int indx,int low,int high,int l,int r,int seg[]) {
        if (r<low || l>high) {
            return Integer.MAX_VALUE;
        }
        if (l<=low && r>=high) {
            return seg[indx];
        }
        int mid=(low+high)/2;
        int left=query(2*indx+1,low,mid,l,r,seg);
        int right=query(2*indx+2,mid+1,high,l,r,seg);
        return Math.min(left,right);
    }

    public int update(int indx,int low,int high,int pos,int val,int seg[]) {
        if (low==high) {
            seg[indx]=val;
            return val;
        }
        int mid=(low+high)/2;
        if (pos<=mid) {
            update(2*indx+1,low,mid,pos,val,seg);
        } else {
            update(2*indx+2,mid+1,high,pos,val,seg);
        }
        seg[indx]=Math.min(seg[2*indx+1],seg[2*indx+2]);
        return seg[indx];
    }

    public static void main(String[] args) {
        SegmentTree st=new SegmentTree();
        int arr[]={1,3,2,7,9,11};
        int n=arr.length;
        int seg[]=new int[4*n];
        st.Build(0,0,n-1,0,n-1,arr,seg);
        int l=1;
        int r=5;
        System.out.println(st.query(0,0,n-1,l,r,seg));
        int pos=1;
        int val=0;
        st.update(0,0,n-1,pos,val,seg);
        arr[pos]=val;
        System.out.println(st.query(0,0,n-1,l,r,seg));
    }
}
