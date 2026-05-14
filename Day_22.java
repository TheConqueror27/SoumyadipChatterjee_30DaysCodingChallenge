import java.util.*;

public class Day_22 {

    static class Node {
        int x, y, moves;

        Node(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));

        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.x == goalX && current.y == goalY) {
                return current.moves;
            }

            // Move in all 4 directions
            for (int d = 0; d < 4; d++) {

                int nx = current.x;
                int ny = current.y;

                // Keep moving until blocked or out of bounds
                while (true) {

                    nx += dx[d];
                    ny += dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n ||
                            grid[nx].charAt(ny) == 'X') {
                        break;
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, current.moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine();
        }

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);

        sc.close();
    }
}