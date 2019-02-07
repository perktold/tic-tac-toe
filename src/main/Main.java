package main;
import player.*;

public class Main {

	public static void main(String[] args) {
		Player[] players;
		Grid grid;
		if(args.length >= 4) {
			int [] intArgs = new int[] {
					3, 3, 1
			};
			for(int i = 0; i < intArgs.length; i++) {
				try {
					intArgs[i] = Integer.parseInt(args[i]);
				} catch (Exception e) {
				}
			}
			// | arg |          0 |           1 |                  2 |             3 |             4 | x             |
			// | use | grid width | grid height | amount cpu players | name player 1 | name player 2 | name player x |
			
			grid = new Grid(intArgs[0], intArgs[1]);
			String [] playerNames = new String[args.length -3];
			for(int i = 3; i < args.length; i++) {
				playerNames[i - 3] = args[i];
			}
			players = getPlayers(intArgs[2], playerNames);
		} else {	
			grid = new Grid(16, 16);
			players = new Player[] {
				new CpuPlayer("cpu", 'X'),
				new HumanPlayer("you", 'O')
			};
		}
		while(noneWon(players)) {
			
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
	
	static Player[] getPlayers(int amountCpuPlayers, String[] playerNames) {
		Player[] players = new Player [amountCpuPlayers + playerNames.length];
		//cpu players
		for(int i = 0; i < amountCpuPlayers; i++) {
			players[i] = new CpuPlayer("cpu"+i, (i+"").toCharArray()[0]);
		}
		
		//human players
		for(int i = 0; i < playerNames.length; i++) {
			//TODO anderes symbol für menschliche spieler
			char symbol = ((amountCpuPlayers + i)+"").toCharArray()[0];
			players[i+amountCpuPlayers] = new HumanPlayer(playerNames[i], symbol);
		}
		return players;
	}
	
			static boolean noneWon(Player [] players) {
		boolean noneWon = true;
		for(int i = 0; i < players.length; i++) {
			if(players[i].getWon()) noneWon = false;
		}
		return noneWon;
	}
}
