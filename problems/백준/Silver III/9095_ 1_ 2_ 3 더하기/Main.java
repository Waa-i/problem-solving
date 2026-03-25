import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            var target = Integer.parseInt(st.nextToken());
            long[] dp = new long[target + 1];
            dp[1] = 1;
            if(target >= 2) {
                dp[2] = 2;
            }
            if(target >= 3) {
                dp[3] = 4;
            }
            for(int j = 4; j <= target; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[target]);
        }
    }
}