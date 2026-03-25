class Solution {
    public void rotate(int[][] matrix) {
        var n = matrix.length;
        for(int row = 0; row < n; row++) {
            for(int col = row + 1; col < n; col++) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        for(int row = 0; row < n; row++) {
            var left = 0;
            var right = n - 1;
            while(left < right) {
                var tmp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = tmp;
                ++left;
                --right;
            }
        }
    }
}