package CodeForces._900Rated;

import java.util.HashMap;
import java.util.Scanner;

public class Deletive_Editing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while (t-->0) {
           String[] word=sc.nextLine().split(" ");
            System.out.println(word[0]+" "+word[1]+" "+1);
            int n=word[0].length();
            int m=word[1].length();
            int i=n-1;
            int j=m-1;
            HashMap<Character,Integer> map=new HashMap<>();
            for (int k = 0; k < m; k++) {
                map.put(word[1].charAt(k), map.getOrDefault(word[1].charAt(k), 0)+1);
            }
            boolean canMake=true;
            while (j>=0 && i>=0) {
                while (word[0].charAt(i)!=word[1].charAt(j)) {
                    if (map.containsKey(word[0].charAt(i))) {
                        canMake=false;
                        break;
                    }
                    i++;
                }
                if (canMake) {
                    map.put(word[0].charAt(i), map.get(word[0].charAt(i))-1);
                    if (map.get(word[0].charAt(i))<=0) {
                        map.remove(word[0].charAt(i));
                    }  
                }
                j++;
            }
            System.out.println(canMake? "YES":"NO");
        }
    }
}
