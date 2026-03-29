import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        // 동전의 개수가 최소가 되도록 2원과 5원을 이용해 거슬러 주어야 합니다.
        // 5원과 2원으로 거슬러 줄 수 없는 경우 -1을 반환합니다.

        var n = Integer.parseInt(st.nextToken());

        var count = new int[2];

        var numOfFives = n / 5;

        while(numOfFives >= 0) {
            var remain = n - (numOfFives * 5);
            if(remain % 2 == 0) {
                System.out.println(numOfFives + remain / 2);
                return;
            }
            numOfFives--;
        }
        System.out.println(-1);
    }
}