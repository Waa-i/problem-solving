import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Long.parseLong(st.nextToken());
        var target = Long.parseLong(st.nextToken());
        long[] dx = {2l, 1l};

        System.out.println(bfs(n, target, dx));
    }

    private static long bfs(long x, long target, long[] dx) {
        var queue = new ArrayDeque<long[]>();
        queue.offer(new long[]{x, 1l});

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur[0] == target) {
                return cur[1];
            }
            for(int i = 0; i < dx.length; i++) {
                long nx;
                if(i == 0) {
                    nx = cur[0] * dx[i];
                }
                else {
                    nx = Long.parseLong(cur[0] + String.valueOf(dx[i]));
                }
                if(isValid(nx, target)) {
                    queue.offer(new long[]{nx, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isValid(long x, long target) {
        return x >= 1 && x <= target;
    }
}