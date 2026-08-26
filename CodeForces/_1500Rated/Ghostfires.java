package CodeForces._1500Rated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Ghostfires {

    public static class pair {
        String key;
        int freq;
        pair(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int r=sc.nextInt();
            int g=sc.nextInt();
            int b=sc.nextInt();
            StringBuilder ans=new StringBuilder();
            int n=0;
            List<pair> ls=new ArrayList<>();
            ls.add(new pair("R", r));
            ls.add(new pair("G", g));
            ls.add(new pair("B", b));
            
            while (true) {
                Collections.sort(ls, (x, y) -> y.freq - x.freq);
                int pick=-1;
                for(int i=0; i<ls.size(); i++) {
                    pair p=ls.get(i);
                    if(p.freq<=0) continue;
                    if(n>=1 && p.key.equals(ans.charAt(n-1)+"")) continue;
                    if (pick==-1) {
                        pick=i;
                        continue;
                    }
                    if(n>=2 && pick!=-1 && ls.get(pick).freq==p.freq && p.key.equals(ans.charAt(n-2)+"")){
                        pick=i;
                    }
                }
                if (pick==-1) {
                    break;
                }
                ans.append(ls.get(pick).key);
                ls.get(pick).freq--;
                n++;
            }
            System.out.println(ans);
        }
    }
}
