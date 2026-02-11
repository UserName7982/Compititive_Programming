package CodeForces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Monster {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int str[]=new int[n];
            
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0; i<n; i++){
                str[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int prefix[]=new int[n];
            prefix[0]=str[0];
            for (int i = 1; i < prefix.length; i++) {
                prefix[i]=prefix[i-1]+str[i];
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < str.length; i++) {
                map.putIfAbsent(arr[i], i);
            }
            int l = str[0], r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] <= mid)
                l = mid + 1;
            else
                r = mid;
        }
        }

    }

    static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

}
