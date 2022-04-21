package de.kleeraphie.gol.console;

import java.util.Scanner;

public class Main {

	private static char[][] field;
	private static int size, cycle;
	private static boolean running;
	private static Scanner s;
	private static final char ALIVE = '*', DEAD = 'X';

	public static void main(String[] args) {
		size = 20;
		cycle = 0;
		running = true;
		field = new char[size][size];

		s = new Scanner(System.in);

		createDeadField();
		
//		Blinker funktioniet
//		field[1][2] = ALIVE;
//		field[2][2] = ALIVE;
//		field[3][2] = ALIVE;
		
//		1. anderes Objekt funktioniert nicht
//		field[24 + 20][20 + 20] = ALIVE;
//		field[25 + 20][20 + 20] = ALIVE;
//		field[26 + 20][20 + 20] = ALIVE;
//		field[24 + 20][21 + 20] = ALIVE;
//		field[26 + 20][21 + 20] = ALIVE;
//		field[24 + 20][22 + 20] = ALIVE;
//		field[26 + 20][22 + 20] = ALIVE;
//		
//		field[24 + 20][26 + 20] = ALIVE;
//		field[25 + 20][26 + 20] = ALIVE;
//		field[26 + 20][26 + 20] = ALIVE;
//		field[24 + 20][25 + 20] = ALIVE;
//		field[26 + 20][25 + 20] = ALIVE;
//		field[24 + 20][24 + 20] = ALIVE;
//		field[26 + 20][24 + 20] = ALIVE;
		
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
//		field[5][5] = ALIVE;
//		field[7][5] = ALIVE;
//		field[6][6] = ALIVE;
//		field[6][7] = ALIVE;
//		field[7][6] = ALIVE;
		
		showField();
		
		while (cycle < 10) {
			runCycle();
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

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				livingNeighbors = 0;

				// count living neighbors
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						try {
							if (field[i][j] == ALIVE)
								livingNeighbors++;
						} catch (IndexOutOfBoundsException e) {
							continue;
						}

					}
				}

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
				else
					newField[x][y] = field [x][y];

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
