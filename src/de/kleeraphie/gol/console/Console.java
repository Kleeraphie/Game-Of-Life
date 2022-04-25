package de.kleeraphie.gol.console;

public class Console {
	public char[][] field;
	private int size, cycle;
	private boolean allCellsDead;
	public final char ALIVE = '*', DEAD = 'X';
	
	public Console(int size) {
		this.size = size;
		cycle = 0;
		field = new char[size][size];

		createDeadField();
		
	}
	
	public void start(int maxCycle) {
		while (true) {
			runCycle();
			if (allCellsDead || cycle == maxCycle)
				break; // TODO: doesn't show field, but still calculates it
			showField();

		}
	}
	
	private void createDeadField() {

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				field[x][y] = DEAD;
			}
		}

	}

	private void runCycle() {
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

	private void showField() {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				System.out.print(field[x][y] + " ");
			}
			System.out.print("\n");
		}

		System.out.println();

	}

	public char[][] getField() {
		return field;
	}

	public int getCycle() {
		return cycle;
	}

	public boolean isAllCellsDead() {
		return allCellsDead;
	}

}
