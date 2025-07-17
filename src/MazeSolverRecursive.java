import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursive implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(grid,start,end,path)) {
            return path;
        }
        return new ArrayList<>();

    }
    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
       int row=start.row;
       int col=start.col;       

        // Base Cases: Out of bounds or blocked
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        // Base Case: Reached the end
        if (row == end.row && col == end.col) {
            path.add(start);
            return true;
        }

        // Mark current cell as visited (temporarily)
        grid[row][col] = false; 
        path.add(start);

        // Explore adjacent cells: Down, Up, Right, Left
        if (findPath(grid, new Cell(row + 1, col), end, path) ||
            findPath(grid, new Cell(row - 1, col), end, path) ||
            findPath(grid, new Cell(row, col + 1), end, path) ||
            findPath(grid, new Cell(row, col - 1), end, path)) {
            return true;
        }

        // Backtrack: If no path found, unmark the cell and remove from path
        grid[row][col] = true;
        path.remove(path.size() - 1);
        return false;
    }
}