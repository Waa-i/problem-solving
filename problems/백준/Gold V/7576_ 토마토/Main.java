import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var m = Integer.parseInt(st.nextToken());
        var n = Integer.parseInt(st.nextToken());

        var arr = new int[n][m];
        var count = 0;
        var positions = new ArrayList<int[]>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    ++count;
                }

                if(arr[i][j] == 1) {
                    positions.add(new int[]{i, j});
                }
            }
        }

        // 익지 않은 토마토가 없는 경우
        if(count == 0) {
            System.out.println(0);
            return;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        bfs(positions, dx, dy, arr);

        var max = arr[0][0];
        for(var row : arr) {
            for(var e : row) {
                if(e == 0) {
                    System.out.println(-1);
                    return;
                }
                if(max < e) {
                    max = e;
                }
            }
        }
        System.out.println(max - 1);
    }

    private static void bfs(List<int[]> positions, int[] dx, int[] dy, int[][] arr) {
        var queue = new ArrayDeque<int[]>();
        for(var position : positions) {
            queue.offer(new int[]{position[0], position[1]});
        }

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                var nx = cur[0] + dx[i];
                var ny = cur[1] + dy[i];
                if(isValid(nx, ny, arr)) {
                    queue.offer(new int[]{nx, ny});
                    arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0)) {
            return true;
        }
        return false;
    }
}