import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 2};
        var visited = new boolean[100001];
        var result = new int[1];

        bfs(n, k, dx, visited, result);

        System.out.println(result[0]);
    }

    private static void bfs(int n, int k, int[] dx, boolean[] visited, int[] result) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{n, 0});
        visited[n] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur[0] == k) {
                result[0] = cur[1];
            }
            for(int i = 0; i < 3; i++) {
                int nx;
                if(i != 2) {
                    nx = cur[0] + dx[i];
                }
                else {
                    nx = cur[0] * dx[i];
                }
                if(isValid(nx) && !visited[nx]) {
                    queue.offer(new int[]{nx, cur[1] + 1});
                    visited[nx] = true;
                }
            }
        }
    }

    private static boolean isValid(int x) {
        return x >= 0 && x <= 100000;
    }
}