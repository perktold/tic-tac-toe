package player;

import java.util.Scanner;
import main.*;

public class HumanPlayer extends Player{
	Scanner in = new Scanner (System.in);
	
	public HumanPlayer(String name, char symbol) {
		super(name, symbol);
	}
	
	public Grid move(Grid grid) {
		int x = 0;
		int y = 0;
		boolean moveDone = false;
		while(!moveDone) {
			x = getNumber("X") - 1;
			y = getNumber("Y") - 1;
			try {
				grid.add(this.symbol, x, y);
				moveDone = true;
			} catch (Exception e) {
				System.out.println("Eingabe nicht gültig");
				moveDone = false;
				continue;
			}
		}
		
		if(super.checkWon(grid)) this.won = true;
		
		return grid;
	}
	
	
	int getNumber(String name) {
		int number = 0;
		boolean b = true;
		do {
			try {
				System.out.print(name + ": ");
				number = Integer.parseInt(in.next());
				b = false;
			} catch (Exception e) {
				System.out.println("Eingabe nicht gültig");
				b = true;
			}
		} while(b);
		return number;
	}
}
