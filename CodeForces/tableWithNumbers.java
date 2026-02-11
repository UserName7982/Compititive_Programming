package CodeForces;

import java.util.Scanner;

public class tableWithNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int h = sc.nextInt();
            int l = sc.nextInt();

            int[] arr = new int[n];
            int maxcount=0;
            int mincount=0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                if(Math.max(h,l)<arr[i]){
                    maxcount++;
                }
                if(Math.min(h,l)>=arr[i]){
                    mincount++;
                }
            }
            int ans=Integer.MAX_VALUE;
            int total=n-maxcount;
            if (total==mincount) {
                ans=total/2;
            }else{
                ans=Math.min(total-mincount, mincount);
            }
            System.out.println(ans);
        }

        }
    }

