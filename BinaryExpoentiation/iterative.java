package BinaryExpoentiation;

public class iterative {
    
    public long binaryExpoentiation(long a,long b,int mod){
        long ans=1;
        while(b>0){
            if((b&1)==1){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            b=b>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        iterative obj=new iterative();
        System.out.println(obj.binaryExpoentiation(2,60,1337));
    }
}
