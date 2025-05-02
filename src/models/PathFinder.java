package models;

import java.util.*;

public class PathFinder {

    public static List<Tile> findPath(Tile[][] map, Tile start, Tile goal) {
        int width = map.length;
        int height = map[0].length;

        boolean[][] visited = new boolean[width][height];
        HashMap<Object, Object> cameFrom = new HashMap<>();

        Queue<Tile> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Tile current = queue.poll();

            if (current.equals(goal)) {
                List<Tile> path = new ArrayList<>();
                Tile step = goal;
                while (step != null && !step.equals(start)) {
                    path.add(step);
                    step = (Tile) cameFrom.get(step);
                }
                Collections.reverse(path);
                return path;
            }

            for (Tile neighbor : getNeighbors(map, current)) {
                int x = neighbor.getX();
                int y = neighbor.getY();
                if (!visited[x][y] && neighbor.isWalkable()) {
                    visited[x][y] = true;
                    cameFrom.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return null;
    }

    public static Tile findNearestReachable(Tile[][] map, Tile start, Tile blockedTarget) {
        int width = map.length;
        int height = map[0].length;

        Set<Tile> visited = new HashSet<>();
        Queue<Tile> queue = new LinkedList<>();
        queue.add(blockedTarget);

        while (!queue.isEmpty()) {
            Tile current = queue.poll();
            if (current.isWalkable()) {
                List<Tile> path = findPath(map, start, current);
                if (path != null) return current;
            }

            for (Tile neighbor : getNeighbors(map, current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return null;
    }

    private static List<Tile> getNeighbors(Tile[][] map, Tile tile) {
        List<Tile> neighbors = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                neighbors.add(map[nx][ny]);
            }
        }
        return neighbors;
    }
}
