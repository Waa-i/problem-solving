import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var p = new int[n + 1];
        var t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        // dp[i]: i일 부터 퇴사일까지 벌 수 있는 최대 금액
        // 1. i일에 상담 하는 경우 얻는 수익 p[i] + d[i + t[i]];
        // 2. i일에 상담 하지 않는 경우 수익 dp[i + 1]
        var dp = new int[n + 2];
        dp[n + 1] = 0;
        for(int i = n; i > 0; i--) {
            if(i + t[i] <= n + 1) {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            }
            else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[1]);
    }
}