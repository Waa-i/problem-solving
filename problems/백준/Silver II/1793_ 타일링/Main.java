import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null) {
            var st = new StringTokenizer(line);
            var n = Integer.parseInt(st.nextToken());
            BigInteger[] dp = new BigInteger[n + 1];
            dp[0] = BigInteger.valueOf(1);
            if(n >= 1) {
                dp[1] = BigInteger.valueOf(1);
            }
            if(n >= 2) {
                dp[2] = BigInteger.valueOf(3);
            }
            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
            }
            System.out.println(dp[n]);
        }
    }
}