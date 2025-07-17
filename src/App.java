import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
        //runMaze();
    }

    public static void runEjerciciosPD() {
        System.out.println("NOMBRE: Fernando Martinez");
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Fibonacci Recursivo: ");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();
        long duration1 = end - start;
        System.out.println("Resultado =" + resultado + " en: " + duration1);
        
        System.out.println("Fibonacci Recursivo Caching: ");
        long start2 = System.nanoTime();
        long resultado2 = ejerciciosPD.getFibonacciPD(50);
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;
        System.out.println("Resultado =" + resultado2 + " en: " + duration2);

    }
    private static void runMaze(){
        boolean[][] predefinedMaze={
            {true,true,true,true},
            {false,true,true,false},
            {true,true,false,false},
            {true,true,true,true}
        };
        Maze maze=new Maze(predefinedMaze);
        System.out.println("Laberinto Cargado: ");
        maze.printMaze();

        Cell start=new Cell(0,0);
        Cell end=new Cell(3,3);
        List<MazeSolver> solvers= Arrays.asList(new MazeSolverRecursive(),new MazeSolverRecursivoCuatro());
        MazeSolver solver=solvers.get(0);
        List<Cell> path;
        MazeSolver solver2=solvers.get(1);
        List<Cell> path2;
        path2=solver2.getPath(maze.maze, start, end);

        // Creamos una copia del laberinto para no modificar el original.
        // El solver modifica el grid que recibe para marcar celdas visitadas.
        boolean[][] gridForSolver = new boolean[predefinedMaze.length][];
        for (int i = 0; i < predefinedMaze.length; i++) {
            gridForSolver[i] = Arrays.copyOf(predefinedMaze[i], predefinedMaze[i].length);
        }
        path=solver.getPath(gridForSolver, start, end);
        System.out.println("Camino encontrado: ");
        System.out.println(path);

        System.out.println("Camino encontrado con otro metodo: ");
        System.out.println(path2.reversed());



    }
}