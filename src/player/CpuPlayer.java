package player;

import main.*;

public class CpuPlayer extends Player {

	public CpuPlayer(String name, char symbol) {
		super(name, symbol);
	}
	
	public Grid move(Grid grid){
		int x = 1;
		int y = 1;
		
		while(grid.fieldTaken(x, y)) {
			x = (int)(Math.random() * grid.getWidth());
			y = (int)(Math.random() * grid.getHeight());
		}
		try {
			grid.add(this.symbol, x, y);
		} catch (FieldTakenException e) {
			e.printStackTrace();
			System.exit(0);
		}
		if(super.checkWon(grid)) this.won = true;
		
		return grid;
	}
}
