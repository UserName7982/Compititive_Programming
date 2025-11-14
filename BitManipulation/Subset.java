package BitManipulation;
import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subset(int nums[]) {
        List<List<Integer>> list=new ArrayList<>();
        int subset_cnt=1<<nums.length;
        for(int i=0;i<subset_cnt;i++){
            List<Integer> subset=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    subset.add(nums[j]);
                }
            }
            list.add(subset);
        }
        return list;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        Subset s=new Subset();
        System.out.println(s.subset(nums));
    }
}
