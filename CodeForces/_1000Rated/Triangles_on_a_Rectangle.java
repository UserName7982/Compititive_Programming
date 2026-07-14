package CodeForces._1000Rated;

import java.util.Scanner;

public class Triangles_on_a_Rectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int w=sc.nextInt();
            int h=sc.nextInt();
            int x1=sc.nextInt();
            
            int[] x1point=new int[x1];
            for(int i=0; i<x1; i++){
                x1point[i]=sc.nextInt();
            }
            int x2=sc.nextInt();
            int[] x2point=new int[x2];
            for(int i=0; i<x2; i++){
                x2point[i]=sc.nextInt();
            }
            int y1=sc.nextInt();
            int[] y1point=new int[y1];
            for(int i=0; i<y1; i++){
                y1point[i]=sc.nextInt();
            }
            int y2=sc.nextInt();
            int[] y2point=new int[y2];
            for(int i=0; i<y2; i++){
                y2point[i]=sc.nextInt();
            }

            long width1=x1point[x1-1]-x1point[0];
            long height1=h;
            long max=1L*width1*height1;

            long width3=x2point[x2-1]-x2point[0];
            long height3=h;
            max=Math.max(max, width3*height3);

            long width2=1L*y1point[y1-1]-y1point[0];
            long height2=w;
            max=Math.max(max, width2*height2);

            long width4=1L*y2point[y2-1]-y2point[0];
            long height4=w;
            max=Math.max(max, width4*height4);

            System.out.println(max);

        }
    }
}
