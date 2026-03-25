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
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        var visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        var count = 0;
        var list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    list.add(dfs(i, j, dx, dy, arr, visited));
                    ++count;
                }
            }
        }
        System.out.println(count);
        System.out.println(max(list));
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
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y]) == 1) {
            return true;
        }
        return false;
    }

    private static int max(List<Integer> list) {
        if(list.isEmpty()) {
            return 0;
        }

        int max = list.get(0);
        for(var num : list) {
            if(max < num) {
                max = num;
            }
        }
        return max;
    }
}