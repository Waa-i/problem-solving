import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        var visited = new boolean[n + 1];
        var arr = new int[m];
        solve(0, n, m ,visited, arr);
        System.out.println(sb);
    }

    static void solve(int count, int n, int m, boolean[] visited, int[] arr) {
        if(count == m) {
            result(arr);
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[count] = i;
            solve(count + 1, n, m, visited, arr);
            visited[i] = false;
        }
    }

    static void result(int[] arr) {
        for (var i : arr) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}