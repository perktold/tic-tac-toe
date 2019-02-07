package player;
import main.Grid;

public abstract class Player {
	private String name;
	protected boolean won;
	char symbol;
	
	Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		this.won = false;
	}
	
	boolean checkWon(Grid grid) {
		boolean hasWon = false;
		
		//vertical
		for(int i = 0; i < grid.getWidth(); i++) {
			hasWon = true;
			for(int j = 0; j < grid.getHeight(); j++) {
				if(grid.getGrid()[i][j] != this.symbol) {
					hasWon = false;
				}
			}
			if(hasWon) {
				return true;
			}
		}
		
		//horizontal
		for(int i = 0; i < grid.getHeight(); i++) {
			hasWon = true;
			for(int j = 0; j < grid.getWidth(); j++) {
				if(grid.getGrid()[j][i] != this.symbol) {
					hasWon = false;
				}
			}
			if(hasWon) {
				return true;
			}
		}
		
		//diagonal
		if(grid.getHeight() == grid.getWidth()) {
			//bottom left to top right
			hasWon = true;
			for(int i = 0; i < grid.getWidth(); i++) {
				if(grid.getGrid()[i][(grid.getHeight()-1)-i] != this.symbol) {
					hasWon = false;
				}
			}
			if(hasWon) {
				return true;
			}
			
			//top left to bottom right
			hasWon = true;
			for(int i = 0; i < grid.getWidth(); i++) {
				if(grid.getGrid()[(grid.getHeight()-1)-i][(grid.getHeight()-1)-i] != this.symbol){
					hasWon = false;
				}
			}
			if(hasWon) {
				return true;
			}
		}
		
		return false;
	}
	public char getSymbol() {
		return symbol;
	}
	public String getName() {
		return name;
	}
	public boolean getWon() {
		return won;
	}
	public abstract Grid move(Grid grid);
}
