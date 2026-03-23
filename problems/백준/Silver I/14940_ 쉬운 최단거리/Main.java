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
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        var visited = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        var target = searchTargetPosition(arr, 2);

        bfs(target[0], target[1], dx, dy, arr, visited);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!(i == target[0] && j == target[1]) && arr[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = -1;
                }
            }
        }

        for(var row : visited) {
            for(var e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y, int[] dx, int[] dy, int[][] arr, int[][] visited) {
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{x, y});
        visited[x][y] = 0;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if(isValid(nx, ny, arr) && visited[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
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

    private static int[] searchTargetPosition(int[][] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}