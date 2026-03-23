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

        var arr = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        var visited = new boolean[10001];
        var result = new int[m];
        var sb = new StringBuilder();

        solution(0, m, arr, visited, result, sb);

        System.out.println(sb);
    }

    private static void solution(int count, int condition, int[] arr, boolean[] visited, int[] result, StringBuilder sb) {
        if(count == condition) {
            resultAppender(result, sb);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[arr[i]]) continue;
            visited[arr[i]] = true;
            result[count] = arr[i];

            solution(count + 1, condition, arr, visited, result, sb);

            visited[arr[i]] = false;
        }
    }

    private static void resultAppender(int[] arr, StringBuilder sb) {
        for(var res : arr) {
            sb.append(res).append(" ");
        }
        sb.append("\n");
    }
}