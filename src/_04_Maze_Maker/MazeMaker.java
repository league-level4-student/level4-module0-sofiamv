package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){

		System.out.println("athwra");
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		
		
		//5. call selectNextPath method with the randomly selected cell
		int s = randGen.nextInt(maze.cells.length);
		Cell g = maze.cells[s][s];
		selectNextPath(g);
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {

		System.out.println("hgaw");
		//A. mark cell as visited
		currentCell.setBeenVisited(true);

		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		
		//C. if has unvisited neighbors,
		if(getUnvisitedNeighbors(currentCell).size() > 0) {	
			System.out.println("gah");
			//C1. select one at random.
			Cell h = getUnvisitedNeighbors(currentCell).get(randGen.nextInt(getUnvisitedNeighbors(currentCell).size()));
			//C2. push it to the stack
			uncheckedCells.push(h);
			//C3. remove the wall between the two cells
			removeWalls(h, currentCell);
			System.out.println("yip");
			//C4. make the new cell the current cell and mark it as visited
			currentCell = h;
			h.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		if(getUnvisitedNeighbors(currentCell).size() == 0) {	
			//D1. if the stack is not empty
			if(uncheckedCells.size() > 0) {
				// D1a. pop a cell from the stack
				currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}	
		}
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX() + 1 == c2.getX()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
			System.out.println("yeehaw");
		}
		if(c1.getX() - 1 == c2.getX()) {
			c1.setWestWall(false);
			c2.setEastWall(false);
			System.out.println("yeehaw");
		}if(c1.getY() + 1 == c2.getY()) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
			System.out.println("yeehaw");
		}if(c1.getY() - 1 == c2.getY()) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
			System.out.println("yeehaw");
		}		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> gg = new ArrayList();
		int cx = c.getX();
		int cy = c.getY();
		if(c.getX() > 0) {
			if(!maze.cells[cx - 1][cy].hasBeenVisited()) {
				gg.add(maze.cells[cx - 1][cy]);
			}
			
		}
		if(c.getX() < maze.cells.length-1) {
			if(!maze.cells[cx + 1][cy].hasBeenVisited()) {
				gg.add(maze.cells[cx + 1][cy]);
			}
			
		}
		if(c.getY() > 0) {
			if(!maze.cells[cx][cy - 1].hasBeenVisited()) {
				gg.add(maze.cells[cx][cy - 1]);
			}
			
		}
		if(c.getY() < maze.cells.length-1) {
			if(!maze.cells[cx][cy + 1].hasBeenVisited()) {
				gg.add(maze.cells[cx][cy + 1]);
			}
			
		}
			
		return gg;
	}
}
