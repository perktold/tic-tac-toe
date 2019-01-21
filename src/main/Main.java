package main;
import player.*;

public class Main {

	public static void main(String[] args) {
		Grid grid = new Grid(2,2);
		Player [] players = new Player [] {
				new CpuPlayer("cpu0", '0'),
				//new CpuPlayer("cpu1", '1'),
				//new CpuPlayer("cpu2", '2'),
				//new HumanPlayer("Moritz", 'O'),
				new HumanPlayer("Felix", '#')
		};
	
		while(noneWon(players)) {
			
			grid.show();
			for(int i = 0; i < players.length; i++) {
				players[i].move(grid);
				if(players[i].getWon()) {
					break;
				}
				grid.show();
				System.out.println();
				if(grid.full()) {
					System.out.println("Unentschieden!");
					System.exit(0);
				}
			}
		}
		grid.show();
		System.out.println("Spiel vorbei!");
		for(int i = 0; i < players.length; i++) {
			if(players[i].getWon()) {
				System.out.println("Der Gewinner ist " + players[i].getName());
			}
		}
	}
	
	static boolean noneWon(Player [] players) {
		boolean noneWon = true;
		for(int i = 0; i < players.length; i++) {
			if(players[i].getWon()) noneWon = false;
		}
		return noneWon;
	}
}
