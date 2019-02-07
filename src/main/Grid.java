package main;

public class Grid {
	private char [][] grid;
	
	Grid(int x, int y){
		grid = new char [x][y];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = ' ';
			}
		}
	}

	//TODO clean this up
	public void show() {
		System.out.print("   ");
		for(int x = 0; x < this.grid.length; x++) {
			System.out.printf("%4d",(x+1));
		}
		System.out.println("   X");
		System.out.print("    +");
		for(int i = 0; i < this.grid.length; i++) {
			System.out.print("---+");
		}
		System.out.println();
		for(int y = 0; y < this.grid[0].length; y++) {
			System.out.printf("%4d",(y+1));
			System.out.print("|");
			for(int x = 0; x < this.grid.length; x++) {
				System.out.print(" "+ this.grid[x][y] + " |");
			}
			System.out.println();
			System.out.print("    +");
			for(int x = 0; x < this.grid.length; x++) {
				System.out.printf("---+");
			}
			System.out.println();
		}
		System.out.println('Y');
	}
	
	public void add(char symbol, int x, int y) throws FieldTakenException {
		if(!fieldTaken(x,y)) {
			this.grid[x][y] = symbol;
		} else {
			throw new FieldTakenException();
		}
	}
	boolean full() {
		boolean full = true;
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if(this.grid[i][j] == ' ') {
					full = false;
				}
			}
		}
		return full;
	}
	public boolean fieldTaken(int x, int y) {
		return this.grid[x][y] != ' ';
	}
	public char[][] getGrid() {
		return grid;
	}
	public int getWidth() {
		return this.grid.length;
	}
	public int getHeight() {
		return this.grid[0].length;
	}
}
