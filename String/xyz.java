package String;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort(Comparator.comparingInt(a -> Integer.parseInt(a.get(1))));
        int[] ans = new int[numberOfUsers];
        Set<Integer> online = new HashSet<>();
        Map<Integer,Integer> offline = new HashMap<>();

        for (int i = 0; i < numberOfUsers; i++) {
            online.add(i);
        }

        for (List<String> num : events) {
            int timestmp = Integer.parseInt(num.get(1));
            if (!offline.isEmpty()) {
                Iterator<Map.Entry<Integer, Integer>> it = offline.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    if (entry.getValue()+60<=timestmp) {
                        it.remove();
                        online.add(entry.getKey());
                    }
                }
            }
            List<String> list = Arrays.asList(num.get(2).split(" "));
            if(num.get(0).equals("OFFLINE")){
                for(String id: list){
                    offline.put(Integer.parseInt(id),Integer.parseInt(num.get(1)));
                    if(online.contains(Integer.parseInt(id))) online.remove(id);
                }
            }else{
                if(num.get(2).equals("ALL")){
                    for(int i=0; i<numberOfUsers; i++){
                        ans[i]++;
                    }
                }else if(num.get(2).equals("HERE")){
                    for(int id: online){
                        ans[id]++;
                    }
                }else{
                    for(String id: list){
                        int ids=id.charAt(2)-'0';
                        ans[ids]++;
                    }
                }
            }
        }
        return ans;
    }
}