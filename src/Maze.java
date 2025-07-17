public class Maze {
    boolean[][] maze;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;

    public Maze(boolean[][] maze) {
        this.maze = maze;
        this.startRow = 0;
        this.startCol = 0;
        this.endRow = maze.length - 1;
        this.endCol = maze[0].length - 1;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] ? " - " : " *");
            }
            System.out.println();
        }
    }

    
}