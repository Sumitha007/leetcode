import java.util.*;

class Solution {

    static class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        int litterCount = 0;

        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(id[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int maskCount = 1 << litterCount;
        int fullMask = maskCount - 1;

        int totalStates =
                m * n * (energy + 1) * maskCount;

        boolean[] visited = new boolean[totalStates];

        Queue<State> queue = new ArrayDeque<>();

        queue.offer(new State(
                startR,
                startC,
                energy,
                0
        ));

        int startIndex =
                (((startR * n + startC) * (energy + 1))
                        + energy) * maskCount;

        visited[startIndex] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                State cur = queue.poll();

                if (cur.mask == fullMask) {
                    return moves;
                }

                if (cur.energy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'X') {
                        continue;
                    }

                    int newEnergy = cur.energy - 1;
                    int newMask = cur.mask;

                    if (cell == 'L') {
                        int litterId = id[nr][nc];

                        newMask |= (1 << litterId);
                    }

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    if (newMask == fullMask) {
                        return moves + 1;
                    }

                    int index =
                            (((nr * n + nc) * (energy + 1))
                                    + newEnergy) * maskCount
                                    + newMask;

                    if (!visited[index]) {

                        visited[index] = true;

                        queue.offer(new State(
                                nr,
                                nc,
                                newEnergy,
                                newMask
                        ));
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}