import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());

        var ropes = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            ropes[i] = Integer.parseInt(st.nextToken());
        }
        var sortedRopes = Arrays.stream(ropes)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();


        var sum = sortedRopes[0];
        var max = sortedRopes[0];
        for(int i = 1; i < sortedRopes.length; i++) {
            var weight = sortedRopes[i] * (i + 1);
            if(max < weight) {
                max = weight;
            }
        }
        System.out.println(max);
    }
}