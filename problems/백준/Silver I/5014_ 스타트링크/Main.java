import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        // 건물 높이
        var height = Integer.parseInt(st.nextToken());
        // 현재 위치
        var cur = Integer.parseInt(st.nextToken());
        // 목표 위치
        var target = Integer.parseInt(st.nextToken());
        // 위로 u층 가는 버튼
        var u = Integer.parseInt(st.nextToken());
        // 아래로 d층 가는 버튼
        var d = Integer.parseInt(st.nextToken());

        int[] dy = {u, -d};
        var visited = new boolean[height + 1];

        System.out.println(bfs(cur, height, target, dy, visited));
    }

    private static Object bfs(int start, int height, int target, int[] dy, boolean[] visited) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur[0] == target) {
                return cur[1];
            }
            for(int i = 0; i < dy.length; i++) {
                var ny = cur[0] + dy[i];
                if(isValid(ny, height) && !visited[ny]) {
                    queue.offer(new int[]{ny, cur[1] + 1});
                    visited[ny] = true;
                }
            }
        }
        return "use the stairs";
    }

    private static boolean isValid(int y, int height) {
        return y >= 1 && y <= height;
    }
}