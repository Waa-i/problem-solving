class Solution {
    public boolean isRobotBounded(String instructions) {
        // 로봇은 항상 초기에 (0, 0) 위치에서 북쪽을 바라보고 있습니다.
        // instructions: G, L, R 조합의 문자열
        // G: 현재 보고 있는 방향으로 한 칸 전진
        // L: 왼쪽으로 90도 회전
        // R: 오른쪽으로 90도 회전
        // 주어진 instructions를 무한히 수행했을 때 (0,0)으로 돌아오면 true
        // 그렇지 않으면 false

        // 북(0), 동(1), 남(2), 서(3)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        var pos = new int[]{0, 0, 0};
        for(int i = 0; i < instructions.length(); i++) {
            var curX = pos[0];
            var curY = pos[1];
            var curD = pos[2];
            if(instructions.charAt(i) == 'G') {
                var nextX = curX + dx[curD];
                var nextY = curY + dy[curD];
                pos[0] = nextX;
                pos[1] = nextY;
            }
            if(instructions.charAt(i) == 'L') {
                curD = (curD + 3) % 4;
                pos[2] = curD;
            }
            if(instructions.charAt(i) == 'R') {
                curD = (curD + 1) % 4;
                pos[2] = curD;
            }
        }
        if(pos[0] == 0 && pos[1] == 0) {
            return true;
        }
        if(pos[2] != 0) {
            return true;
        }
        return false;
    }
}