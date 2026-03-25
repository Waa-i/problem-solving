import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        // 청소기는 바라보는 방향이 있으며 방향은 동,서,남,북 중 하나
        // 청소기가 바라보는 방향 d=0(북), d=1(동), d=2(남), d=3(서)

        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());

        var pos = getStartPositionAndDirection(br);
        var arr = getRoom(n, m, br);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        var count = 0;
        A:while(true) {
            var curX = pos[0];
            var curY = pos[1];
            var curD = pos[2];
            // step1. arr[x][y] == 0 이면 현재 칸 청소
            if(arr[curX][curY] == 0) {
                arr[curX][curY] = 2;
                ++count;
            }
            for(int i = 0; i < 4; i++) {
                // step3-1. 반시계 방향으로 90도 회전
                curD = (curD + 3) % 4;
                var nextX = curX + dx[curD];
                var nextY = curY + dy[curD];
                // step3-2. 청소기가 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                if(isValid(nextX, nextY, arr) && arr[nextX][nextY] == 0) {
                    pos[0] = nextX;
                    pos[1] = nextY;
                    pos[2] = curD;
                    // step3-3. step1 부터 다시 수행
                    continue A;
                }
            }
            // step2. 현재 칸의 주변 4칸 중 arr[x][y] == 0인 칸이 없는 경우
            var nextX = pos[0] + dx[(curD + 2) % 4];
            var nextY = pos[1] + dy[(curD + 2) % 4];
            // step2-1. 청소기가 바라보는 방향을 유지한 채 한 칸 후진 후 step1 부터 다시 수행
            if(isValid(nextX, nextY, arr) && arr[nextX][nextY] != 1) {
                pos[0] = nextX;
                pos[1] = nextY;
                pos[2] = curD;
            }
            // step2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동 종료(break)
            else {
                break;
            }
        }
        System.out.println(count);
    }

    private static int[] getStartPositionAndDirection(BufferedReader br) throws IOException {
        var result = new int[3];
        var st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }

    private static int[][] getRoom(int n, int m, BufferedReader br) throws IOException {
        var result = new int[n][m];
        for(int i = 0; i < n; i++) {
            var st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return result;
    }

    private static boolean isValid(int x, int y, int[][] arr) {
        return (x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length);
    }
}