package ModularArithmetic;

import BinaryExpoentiation.iterative;

public class ModularMultiplicativeInverse {
    int MOD=1000000007;
    // Mod==prime
    public int modInverse(int a, int m) {
        iterative it=new iterative();
        return (int)it.binaryExpoentiation(a, m-2, MOD);
    }
    public static void main(String[] args) {
        ModularMultiplicativeInverse obj=new ModularMultiplicativeInverse();
        System.out.println(obj.modInverse(2, 13453456));
    }
}