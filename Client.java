import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>(
        Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 1, 0)),
            new ArrayList<>(Arrays.asList(9, 0, 0, 1, 0, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2, 0, 0, 0)),
            new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1))
        )
    );

    public static void main(String[] args) {
        ArrayList<String> path = findPath(A, "A");
        printPath(path);
    }

    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> map, String name) {
        ArrayList<String> result = new ArrayList<>();
        int rows = map.size();
        int cols = map.get(0).size();
        return result;
    }

    private static boolean dfs(int r, int c,
                               ArrayList<ArrayList<Integer>> map,
                               boolean[][] visited,
                               ArrayList<String> path,
                               String name) {
        int rows = map.size();
        int cols = map.get(0).size();

        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if (visited[r][c] || map.get(r).get(c) != 1) return false;

        visited[r][c] = true;
        path.add(name + "[" + r + "][" + c + "]");

        int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        for (int[] d : dirs) {
            if (dfs(r + d[0], c + d[1], map, visited, path, name)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private static void printPath(ArrayList<String> path) {
        System.out.println(path);
    }
}
