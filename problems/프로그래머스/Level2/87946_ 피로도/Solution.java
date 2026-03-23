class Solution {
    public int solution(int k, int[][] dungeons) {
        var visited = new boolean[dungeons.length];
        var result = new int[dungeons.length];
        var max = new int[1];
        solve(0, k, dungeons, visited, result, max);
        return max[0];
    }

    private void solve(int count, int k, int[][] dungeons, boolean[] visited, int[] result, int[] max) {
        if(count == dungeons.length) {
            var res = maximumDungeonExploration(k, dungeons, result);
            if(max[0] < res) {
                max[0] = res;
            }
            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[count] = i;

            solve(count + 1, k, dungeons, visited, result, max);

            visited[i] = false;
        }
    }

    private int maximumDungeonExploration(int k, int[][] dungeons, int[] result) {
        var count = 0;
        for(int i = 0; i < result.length; i++) {
            var min = dungeons[result[i]][0];
            var consume = dungeons[result[i]][1];
            if(k >= min) {
                k -= consume;
                ++count;
            }
        }
        return count;
    }
}