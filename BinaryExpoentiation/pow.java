package BinaryExpoentiation;

public class pow {
    public int power(int a,int[] num,int mod) {
        int number=0;
        for(int i=0; i<num.length; i++) {
            number=(number*10+num[i])%1140;
        }
        iterative it=new iterative();
        int ans=(int)it.binaryExpoentiation(a, number,1337)%mod;
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        pow p=new pow();
        System.out.println(p.power(2,nums,1337));
    }
}
