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

        var visited = new boolean[n][m][2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        System.out.println(bfs(0, 0, dx, dy, arr, visited));
    }

    private static int bfs(int x, int y, int[] dx, int[] dy, int[][] arr, boolean[][][] visited) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y, 0, 1});
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(isTarget(arr.length - 1, arr[0].length - 1, cur)) {
                return cur[3];
            }
            for(int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if(isValid(nx, ny, arr)) {
                    if(arr[nx][ny] == 0) {
                        if(!visited[nx][ny][cur[2]]) {
                            queue.offer(new int[]{nx, ny, cur[2], cur[3] + 1});
                            visited[nx][ny][cur[2]] = true;
                        }
                    }
                    else {
                        if(cur[2] == 0 && !visited[nx][ny][1]) {
                            queue.offer(new int[]{nx, ny, 1, cur[3] + 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        return (x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length);
    }

    private static boolean isTarget(int x, int y, int[] arr) {
        return x == arr[0] && y == arr[1];
    }
}