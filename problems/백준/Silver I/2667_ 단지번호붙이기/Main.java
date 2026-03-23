import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());

        var arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            var rows = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(rows[j]);
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        var visited = new boolean[n][n];

        var count = 0;
        var result = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    ++count;
                    result.add(dfs(i, j, dx, dy, arr, visited));
                }
            }
        }

        System.out.println(count);

        result.stream().sorted().forEach(System.out::println);
    }

    private static int dfs(int x, int y, int[] dx, int[] dy, int[][] arr, boolean[][] visited) {
        visited[x][y] = true;
        int count = 1;

        for(int i = 0; i < 4; i++) {
            var nx = x + dx[i];
            var ny = y + dy[i];
            if(isValid(nx, ny, arr) && !visited[nx][ny]) {
                count += dfs(nx, ny, dx, dy, arr, visited);
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 1)) {
            return true;
        }
        return false;
    }
}