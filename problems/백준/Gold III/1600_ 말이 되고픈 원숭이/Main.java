import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());
        var k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        var w = Integer.parseInt(st.nextToken());
        var h = Integer.parseInt(st.nextToken());

        var arr = new int[h][w];
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};
        var visited = new boolean[h][w][k + 1];

        System.out.println(bfs(0, 0, dx, dy, hx, hy, arr, visited, k));
    }

    private static int bfs(int x, int y, int[] dx, int[] dy, int[] hx, int[] hy, int[][] arr, boolean[][][] visited, int k) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y, 0, 0});
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur[0] == arr.length - 1 && cur[1] == arr[0].length - 1) {
                return cur[3];
            }
            for (int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if (isValid(nx, ny, arr) && !visited[nx][ny][cur[2]]) {
                    queue.offer(new int[]{nx, ny, cur[2], cur[3] + 1});
                    visited[nx][ny][cur[2]] = true;
                }
            }
            if(cur[2] < k) {
                for (int i = 0; i < 8; i++) {
                    var nx = cur[0] + hx[i];
                    var ny = cur[1] + hy[i];
                    if (isValid(nx, ny, arr) && !visited[nx][ny][cur[2] + 1]) {
                        queue.offer(new int[]{nx, ny, cur[2] + 1, cur[3] + 1});
                        visited[nx][ny][cur[2] + 1] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0)) {
            return true;
        }
        return false;
    }
}