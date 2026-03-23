import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        var visited = new boolean[maps.length][maps[0].length];

        return bfs(0, 0, dx, dy, maps, visited);
    }

    private static int bfs(int x, int y, int[] dx, int[] dy, int[][] maps, boolean[][] visited) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(isArrived(maps.length - 1, maps[0].length - 1, cur)) {
                return cur[2];
            }
            for(int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if(isValid(nx, ny, maps) && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int[][] maps) {
        if((x >= 0 && x < maps.length) && (y >= 0 && y < maps[x].length) && (maps[x][y] == 1)) {
            return true;
        }
        return false;
    }

    private static boolean isArrived(int x, int y, int[] arr) {
        return x == arr[0] && y == arr[1];
    }
}