import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            var st = new StringTokenizer(br.readLine().trim());
            var k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            var arr = new int[k];
            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            var res = new int[6];
            var sb = new StringBuilder();
            solve(0, 0, arr, res, sb);
            System.out.println(sb);
        }
    }

    static void solve(int count, int pos, int[] arr, int[] result, StringBuilder sb) {
        if(count == 6) {
            resultAppender(result, sb);
            return;
        }
        for(int i = pos; i < arr.length; i++) {
            result[count] = arr[i];
            solve(count + 1, i + 1, arr, result, sb);
        }
    }

    static void resultAppender(int[] arr, StringBuilder sb) {
        for (var i : arr) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}