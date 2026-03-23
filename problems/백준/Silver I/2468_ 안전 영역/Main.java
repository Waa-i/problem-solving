import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var arr = new int[n][n];
        var max = arr[0][0];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        var result = 0;
        for(int height = 0; height < max; height++) {
            var count = 0;
            var visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] > height && !visited[i][j]) {
                        dfs(height, i, j, dx, dy, arr, visited);
                        ++count;
                    }
                }
            }
            if(result < count) {
                result = count;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int height, int x, int y, int[] dx, int[] dy, int[][] arr, boolean[][] visited) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            var nx = x + dx[i];
            var ny = y + dy[i];
            if(isValid(nx, ny, height, arr) && !visited[nx][ny]) {
                dfs(height, nx, ny, dx, dy, arr, visited);
            }
        }
    }

    private static boolean isValid(int x, int y, int height, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] > height)) {
            return true;
        }
        return false;
    }
}