import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var isbn = st.nextToken();

        var sum = 0;
        var idx = -1;
        for(int i = 0; i < isbn.length(); i++) {
            if('*' != isbn.charAt(i)) {
                if(i % 2 == 0) {
                    sum += (isbn.charAt(i) - '0');
                }
                else {
                    sum += 3 * (isbn.charAt(i) - '0');
                }
            }
            else {
                idx = i;
            }
        }

        for(int i = 0; i <= 9; i++) {
            if(idx % 2 == 0) {
                if((sum + i) % 10 == 0) {
                    System.out.println(i);
                }
            }
            else {
                if((sum + 3 * i) % 10 == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}