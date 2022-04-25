package de.kleeraphie.gol.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	public JButton[][] field;
	private int size, cycle;
	private boolean allCellsDead;
	public final Color ALIVE = Color.WHITE, DEAD = Color.BLACK;
	private JFrame window;

	public GUI(int size) {
		this.size = size;
		cycle = 0;
		field = new JButton[this.size][this.size];

		createWindow();
		updateWindow(); // creates field with dead cells
	}
	
	public void start(int maxCycle) {
		while (true) {
			runCycle();
			if (allCellsDead || cycle == maxCycle) {
				System.out.println(cycle);
				break; // TODO: doesn't show field, but still calculates it
			}
			updateWindow();

		}
	}

	private void createWindow() {
		window = new JFrame();
		window.setTitle("Game of Life");
		window.setLocationRelativeTo(null);
		window.requestFocus();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 1200);

		window.setVisible(true);
	}

	private void runCycle() {
		int livingNeighbors;
		JButton[][] newField;
		JButton cell;

		newField = new JButton[size][size];
		cycle++;
		allCellsDead = true;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				cell = new JButton();
				cell.setBackground(DEAD);

				newField[x][y] = cell;
			}
		}

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				livingNeighbors = 0;

				// count living neighbors
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						try {
							if (field[i][j].getBackground() == ALIVE) {
								livingNeighbors++;
								allCellsDead = false;
							}

						} catch (IndexOutOfBoundsException e) {
							continue;
						}

					}
				}

//				if (livingNeighbors > 0) {

				if (field[x][y].getBackground() == ALIVE)
					livingNeighbors--;

				// check rules
				if (field[x][y].getBackground() == DEAD && livingNeighbors == 3)
					newField[x][y].setBackground(ALIVE);

				else if (field[x][y].getBackground() == ALIVE && livingNeighbors < 2)
					newField[x][y].setBackground(DEAD);

				else if (field[x][y].getBackground() == ALIVE && (livingNeighbors == 2 | livingNeighbors == 3))
					newField[x][y].setBackground(ALIVE);

				else if (field[x][y].getBackground() == ALIVE && livingNeighbors > 3)
					newField[x][y].setBackground(DEAD);
//				} 
				else
					newField[x][y].setBackground(DEAD);

			}
		}

		//check if field has changed; if not allCellsDead remains true so that the program will stop
		allCellsDead = true;
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				if (field[x][y].getBackground() != newField[x][y].getBackground())
					allCellsDead = false;
			}
		}
		
		field = newField;
		

	}

	private void updateWindow() {
		JPanel result;
		JButton cell;

		result = new JPanel(new GridLayout(size, size));

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				cell = new JButton();
				if (field[x][y] == null) {
					cell.setBackground(DEAD);
					field[x][y] = cell;
				} else
					cell.setBackground(field[x][y].getBackground());

				result.add(cell);
			}
		}
		window.setContentPane(result);
		window.repaint();
		window.revalidate();
	}
	
	public int getCycle() {
		return cycle;
	}

}
