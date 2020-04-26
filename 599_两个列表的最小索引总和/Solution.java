import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String>res = new ArrayList<>();
        if(list1.length>list2.length){ //保证list1最短，用最短的做hashmap
            String[] t = list1;
            list1  = list2;
            list2 = t;
        }
        for(int i = 0;i<list1.length;i++){
            map.put(list1[i], i);
        }
        int min_v = Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            Integer index = map.get(list2[i]);
            if(index!=null){ //找到
                min_v = Math.min(min_v, i+index);
            }
        }
        for(int i=0;i<list2.length;i++){
            Integer index = map.get(list2[i]);
            if(index!=null && i+index==min_v){ //找到
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[]{});
    }
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(new Solution().findRestaurant(list1, list2)[0]);

    }
}