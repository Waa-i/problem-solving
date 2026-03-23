import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        var list = initStudentAnswers();
        var count = new int[3];
        for(int i = 0; i < 3; i++) {
            var studentAnswers = list.get(i);
            for(int j = 0; j < answers.length; j++) {
                if(studentAnswers.get(j % studentAnswers.size()) == answers[j]) {
                    ++count[i];
                }
            }
        }
        var max = count[0];
        for(int i = 1; i < count.length; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }

        var result = new ArrayList<Integer>();
        for(int i = 0; i < count.length; i++) {
            if(max == count[i]) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<List<Integer>> initStudentAnswers() {
        var result = new ArrayList<List<Integer>>();
        result.add(List.of(1, 2, 3, 4, 5));
        result.add(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        result.add(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        return result;
    }

    public static Map<Integer, Integer> countMap() {
        var result = new HashMap<Integer, Integer>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);

        return result;
    }
}