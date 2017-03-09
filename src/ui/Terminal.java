package ui;

import java.util.Scanner;
import game.Game;

public class Terminal {

	private Game game;
	private Scanner scanner;

	public void run() {
		scanner = new Scanner(System.in);
		game = new Game();
		game.start();
		renderBoard(game);
		while (!game.isEnd()) {
			System.out.println(game.getCurrentPlayerName() + "'s turn.");
			System.out.print("Enter row: ");
			int row = scanner.nextInt();
			System.out.print("Enter column: ");
			int column = scanner.nextInt();
			System.out.println("Placing at (" + row + "," + column + ").");
			game.currentPlayerTakesAction(row-1, column-1);
			renderBoard(game);
		}
		System.out.println("The winner is " + game.getWinnerName() + "!");
	}

	private void renderBoard(Game game) {
		int size = game.getBoardSize();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				String s = game.getSymbolOnBoard(row, col);
				if(s == null) {
					s = "_";
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Terminal ui = new Terminal();
		ui.run();
	}

}
