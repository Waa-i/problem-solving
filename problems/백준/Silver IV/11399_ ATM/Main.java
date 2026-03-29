import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var numOfPeople = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        var times = new int[numOfPeople];
        for(int i = 0; i < numOfPeople; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        var arr = Arrays.stream(times)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        var sum = new int[numOfPeople];
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        var total = Arrays.stream(sum)
                .reduce((a, b) -> a + b)
                .getAsInt();
        System.out.println(total);
    }
}