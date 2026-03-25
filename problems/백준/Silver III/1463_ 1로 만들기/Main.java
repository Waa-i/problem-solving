import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if(n >= 2) {
            dp[2] = 1;
        }
        if(n >= 3) {
            dp[3] = 1;
        }
        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}