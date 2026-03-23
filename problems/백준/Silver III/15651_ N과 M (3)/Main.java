import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        // 선택된 수열 결과 배열
        var result = new int[m];
        // 출력 문자열 저장
        var sb = new StringBuilder();

        solution(0, n, m, result, sb);

        System.out.println(sb);
    }

    private static void solution(int count, int n, int m, int[] result, StringBuilder sb) {
        if(count == m) {
            resultAppender(result, sb);
            return;
        }

        for(int i = 1; i <= n; i++) {
            result[count] = i;
            solution(count + 1, n, m, result, sb);
        }
    }

    private static void resultAppender(int[] arr, StringBuilder sb) {
        for(var res : arr) {
            sb.append(res).append(" ");
        }
        sb.append("\n");
    }
}