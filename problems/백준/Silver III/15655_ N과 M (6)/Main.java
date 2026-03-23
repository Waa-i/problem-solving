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
        var result = new int[m];
        var sb = new StringBuilder();

        solution(0, 0, m, arr, result, sb);

        System.out.println(sb);
    }

    private static void solution(int count, int start, int condition, int[] arr, int[] result, StringBuilder sb) {
        if(count == condition) {
            resultAppender(result, sb);
            return;
        }

        for(int i = start; i < arr.length; i++) {
            result[count] = arr[i];
            solution(count + 1, i + 1, condition, arr, result, sb);
        }
    }

    private static void resultAppender(int[] arr, StringBuilder sb) {
        for(var res : arr) {
            sb.append(res).append(" ");
        }
        sb.append("\n");
    }
}