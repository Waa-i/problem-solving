import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());

        var arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        var b = Integer.parseInt(st.nextToken());
        var c = Integer.parseInt(st.nextToken());

        var origin = c;
        var count = 0L;
        for(int i = 0; i < n; i++) {
            var diff = arr[i] - b;
            ++count;
            if(diff > 0) {
                count += (diff + c - 1L) / c;
            }
        }
        System.out.println(count);
    }
}