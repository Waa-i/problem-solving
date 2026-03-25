import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new LinkedList<Integer>();
        var top = 0;
        var bottom = matrix.length - 1;
        var left = 0;
        var right = matrix[0].length - 1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if(top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            if(left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }

        return result;
    }
}