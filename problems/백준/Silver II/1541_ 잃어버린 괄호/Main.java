import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var exp = st.nextToken();

        var minusSplit = exp.split("-");
        var sum = arraySum(minusSplit[0]);

        for(int i = 1; i < minusSplit.length; i++) {
            sum -= arraySum(minusSplit[i]);
        }

        System.out.println(sum);

    }

    private static int arraySum(String str) {
        var arr = str.split("\\+");
        return Arrays.stream(arr)
                .map(Integer::parseInt)
                .reduce((a, b) -> a + b)
                .get();
    }
}