import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());

        var arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            var rows = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(rows[j]);
            }
        }

        var visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        bfs(0, 0, arr, visited, dx, dy);
    }

    private static void bfs(int x, int y, int[][] arr, boolean[][] visited, int[] dx, int[] dy) {
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(isArrived(arr.length - 1, arr[0].length - 1, cur)) {
                System.out.println(cur[2]);
            }
            for(int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if(isValid(nx, ny, arr) && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 1)) {
            return true;
        }
        return false;
    }

    private static boolean isArrived(int x, int y, int[] arr) {
        return (x == arr[0]) && (y == arr[1]);
    }
}