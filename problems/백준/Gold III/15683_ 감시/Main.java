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
        var cctvs = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, arr[i][j]});
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] min = {Integer.MAX_VALUE};

        dfs(0, dx, dy, arr, cctvs, min);

        System.out.println(min[0]);
    }

    private static void dfs(int count, int[] dx, int[] dy, int[][] arr, List<int[]> cctvs, int[] min) {
        if(count == cctvs.size()) {
            min[0] = Math.min(min[0], count(arr));
            return;
        }
        var cctv = cctvs.get(count);
        if(cctv[2] == 1) {
            for(int i = 0; i < 4; i++) {
                var cctvPosX = cctv[0];
                var cctvPosY = cctv[1];
                var copy = copy2DArray(arr);
                watch(cctvPosX, cctvPosY, dx, dy, copy, i);
                dfs(count + 1, dx, dy, copy, cctvs, min);
            }
        }
        else if(cctv[2] == 2) {
            for(int i = 0; i < 2; i++) {
                var cctvPosX = cctv[0];
                var cctvPosY = cctv[1];
                var copy = copy2DArray(arr);
                watch(cctvPosX, cctvPosY, dx, dy, copy, i);
                watch(cctvPosX, cctvPosY, dx, dy, copy, i + 2);
                dfs(count + 1, dx, dy, copy, cctvs, min);
            }
        }
        else if(cctv[2] == 3) {
            for(int i = 0; i < 4; i++) {
                var cctvPosX = cctv[0];
                var cctvPosY = cctv[1];
                var copy = copy2DArray(arr);
                watch(cctvPosX, cctvPosY, dx, dy, copy, (i + 3) % 4);
                watch(cctvPosX, cctvPosY, dx, dy, copy, i);
                dfs(count + 1, dx, dy, copy, cctvs, min);
            }
        }
        else if(cctv[2] == 4) {
            for(int i = 0; i < 4; i++) {
                var cctvPosX = cctv[0];
                var cctvPosY = cctv[1];
                var copy = copy2DArray(arr);
                watch(cctvPosX, cctvPosY, dx, dy, copy, (i + 2) % 4);
                watch(cctvPosX, cctvPosY, dx, dy, copy, (i + 3) % 4);
                watch(cctvPosX, cctvPosY, dx, dy, copy, i);
                dfs(count + 1, dx, dy, copy, cctvs, min);
            }
        }
        else {
            var cctvPosX = cctv[0];
            var cctvPosY = cctv[1];
            var copy = copy2DArray(arr);
            watch(cctvPosX, cctvPosY, dx, dy, copy, 0);
            watch(cctvPosX, cctvPosY, dx, dy, copy, 1);
            watch(cctvPosX, cctvPosY, dx, dy, copy, 2);
            watch(cctvPosX, cctvPosY, dx, dy, copy, 3);
            dfs(count + 1, dx, dy, copy, cctvs, min);
        }
    }

    private static void watch(int x, int y, int[] dx, int[] dy, int[][] arr, int dir) {
        var nx = x + dx[dir];
        var ny = y + dy[dir];
        while(isValid(nx, ny, arr)) {
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] != 6)) {
            return true;
        }
        return false;
    }

    private static int[][] copy2DArray(int[][] arr) {
        var copy = new int[arr.length][];
        for(int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    private static int count(int[][] arr) {
        var count = 0;
        for(var row : arr) {
            for(var e : row) {
                if(e == 0) {
                    ++count;
                }
            }
        }
        return count;
    }
}