package de.kleeraphie.gol.console;

import java.util.Scanner;

public class Main {

	private static char[][] field;
	private static int size, cycle;
	private static boolean allCellsDead;
	private static Scanner s;
	private static final char ALIVE = '*', DEAD = 'X';

	public static void main(String[] args) {
		size = 50;
		cycle = 0;
		field = new char[size][size];

		s = new Scanner(System.in);

		createDeadField();

//		Blinker funktioniet
//		field[1][2] = ALIVE;
//		field[2][2] = ALIVE;
//		field[3][2] = ALIVE;

//		1. anderes Objekt funktioniert
//		field[24][20] = ALIVE;
//		field[25][20] = ALIVE;
//		field[26][20] = ALIVE;
//		field[24][21] = ALIVE;
//		field[26][21] = ALIVE;
//		field[24][22] = ALIVE;
//		field[26][22] = ALIVE;
//
//		field[24][26] = ALIVE;
//		field[25][26] = ALIVE;
//		field[26][26] = ALIVE;
//		field[24][25] = ALIVE;
//		field[26][25] = ALIVE;
//		field[24][24] = ALIVE;
//		field[26][24] = ALIVE;

//		2 Würfel Blinker
//		field[5][5] = ALIVE;
//		field[5][6] = ALIVE;
//		field[6][5] = ALIVE;
//		field[6][6] = ALIVE;
//		
//		field[7][7] = ALIVE;
//		field[7][8] = ALIVE;
//		field[8][7] = ALIVE;
//		field[8][8] = ALIVE;

//		Glider
		field[5][5] = ALIVE;
		field[7][5] = ALIVE;
		field[6][6] = ALIVE;
		field[6][7] = ALIVE;
		field[7][6] = ALIVE;

		showField();

		while (true) {
			runCycle();
			if (allCellsDead)
				break; // TODO: doesn't show field, but still calculates it
			showField();

		}

	}

	private static void createDeadField() {

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				field[x][y] = DEAD;
			}
		}

	}

	private static void runCycle() {
		int livingNeighbors;
		char[][] newField;

		newField = new char[size][size];
		cycle++;
		allCellsDead = true;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				livingNeighbors = 0;

				// count living neighbors
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						try {
							if (field[i][j] == ALIVE) {
								livingNeighbors++;
								allCellsDead = false;
							}

						} catch (IndexOutOfBoundsException e) {
							continue;
						}

					}
				}

//				if (livingNeighbors > 0) {

					if (field[x][y] == ALIVE)
						livingNeighbors--;

					// check rules
					if (field[x][y] == DEAD && livingNeighbors == 3)
						newField[x][y] = ALIVE;

					else if (field[x][y] == ALIVE && livingNeighbors < 2)
						newField[x][y] = DEAD;

					else if (field[x][y] == ALIVE && (livingNeighbors == 2 | livingNeighbors == 3))
						newField[x][y] = ALIVE;

					else if (field[x][y] == ALIVE && livingNeighbors > 3)
						newField[x][y] = DEAD;
//				} 
				else
					newField[x][y] = DEAD;

			}
		}

		field = newField;

	}

	private static void showField() {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				System.out.print(field[x][y] + " ");
			}
			System.out.print("\n");
		}

		System.out.println();

	}

}
