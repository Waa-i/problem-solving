import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        var countMap = new HashMap<String, Integer>();
        for(var order : orders) {
            var arr = order.toCharArray();
            Arrays.sort(arr);
            order = new String(arr);
            dfs(0 , 0, order, "", countMap);
        }
        var maxArr = new int[11];
        for(var c : course) {
            Optional<Integer> optMax = countMap.entrySet().stream()
                    .filter(entry -> entry.getKey().length() == c)
                    .map(Map.Entry::getValue)
                    .max(Integer::compareTo);
            if(optMax.isEmpty()) {
                maxArr[c] = -1;
            }
            else {
                maxArr[c] = optMax.get();
            }
        }
        var result = new ArrayList<String>();
        for(var n : course) {
            for(var entry : countMap.entrySet()) {
                if(entry.getKey().length() == n) {
                    if(maxArr[n] >= 2 && entry.getValue() == maxArr[n]) {
                        result.add(entry.getKey());
                    }
                }
            }
        }

        return result.stream().sorted().toArray(String[]::new);
    }

    public static void dfs(int count, int pos, String order, String res, Map<String, Integer> countMap) {
        if(res.length() > 0 &&  res.length() <= order.length()) {
            countMap.compute(res, (k, v) -> {
                if(v == null) return 1;
                else return v + 1;
            });
        }

        for(int i = pos; i < order.length(); i++) {
            dfs(count + 1, i + 1, order, res + order.charAt(i), countMap);
        }
    }
}