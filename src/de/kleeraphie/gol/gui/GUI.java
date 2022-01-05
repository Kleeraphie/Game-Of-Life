package de.kleeraphie.gol.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GUI extends JFrame {
	private static final long serialVersionUID = 8704766206531965016L;
	private boolean running;
	private int size;
	private JButton[][] btns;
	int zyklus = 0;

	public void initialize(int size) {
		this.size = size;

		setTitle("Game of Life");
		setLocationRelativeTo(null);
		requestFocus();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 1200);
		setContentPane(createPanel());

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	public void start() {
		running = true;
//		#1
//		btns[5][5].setBackground(Color.WHITE);
//		btns[5][6].setBackground(Color.WHITE);
//		btns[5][7].setBackground(Color.WHITE);
//		btns[6][5].setBackground(Color.WHITE);
//		btns[7][5].setBackground(Color.WHITE);
//		btns[6][7].setBackground(Color.WHITE);
//		btns[7][7].setBackground(Color.WHITE);
//		
//		btns[11][5].setBackground(Color.WHITE);
//		btns[11][6].setBackground(Color.WHITE);
//		btns[11][7].setBackground(Color.WHITE);
//		btns[10][5].setBackground(Color.WHITE);
//		btns[9][5].setBackground(Color.WHITE);
//		btns[10][7].setBackground(Color.WHITE);
//		btns[9][7].setBackground(Color.WHITE);
		
//		#2
//		btns[5][5].setBackground(Color.WHITE);
//		btns[5][6].setBackground(Color.WHITE);
//		btns[6][6].setBackground(Color.WHITE);
//		btns[4][6].setBackground(Color.WHITE);
//		btns[4][7].setBackground(Color.WHITE);
		
		run();
	}

	public void stop() {
		running = false;// sets a run boolean to false that is checked after each life cycle
	}

	private JPanel createPanel() {
		JPanel result;

		btns = new JButton[size][size];

		result = new JPanel(new GridLayout(size, size));
		result.setBackground(Color.BLACK);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				JButton btn = new JButton();
				btn.setBackground(Color.BLACK);
//				btn.setPreferredSize(new Dimension(10, 10));
				btn.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
				btn.addMouseListener(mouseListener);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (btn.getBackground() == Color.BLACK)
							btn.setBackground(Color.WHITE);
						else
							btn.setBackground(Color.BLACK);

					}
				});
				btns[i][j] = btn;

				result.add(btn);
			}
		}

		return result;
	}

	private void run() {
		int livingNeighbours;
		JButton[][] newBtns = new JButton[size][size];

		while (running) {
			
			System.out.println("Zyklus: " + ++zyklus);

			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					newBtns[i][j] = btns[i][j];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					livingNeighbours = 0;

					if (i == 0 && j == 0) {

						if (btns[i + 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;

					} else if (i == 0) {
						
						if (j < size - 1) {

						if (btns[i][j - 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j - 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						
						} else {
							
							if (btns[i][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i + 1][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i + 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							
						}

					} else if (j == 0) {
						
						if (i < size - 1) {

						if (btns[i - 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i - 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						
						} else {
							
							if (btns[i - 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i - 1][j + 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i][j + 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							
						}

					} else {
						
						if (i < size - 1 && j < size - 1) {

						if (btns[i - 1][j - 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i][j - 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j - 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i - 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i - 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						if (btns[i + 1][j + 1].getBackground() == Color.WHITE)
							livingNeighbours++;
						
						} else if (i == size - 1 && j == size - 1) {
							
							if (btns[i - 1][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i - 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							
						} else if (i == size - 1) {
							
							if (btns[i - 1][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i - 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i - 1][j + 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i][j + 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							
						} else if (j == size - 1) {
							
							if (btns[i - 1][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i + 1][j - 1].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i - 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							if (btns[i + 1][j].getBackground() == Color.WHITE)
								livingNeighbours++;
							
						}

					}

					if (btns[i][j].getBackground() == Color.WHITE) {

						if (livingNeighbours < 2)
							newBtns[i][j].setBackground(Color.BLACK);

						if (livingNeighbours > 3)
							newBtns[i][j].setBackground(Color.BLACK);
						
						if (livingNeighbours == 2 || livingNeighbours == 3)
							newBtns[i][j].setBackground(Color.WHITE);

					} else {

						if (livingNeighbours == 3)
							newBtns[i][j].setBackground(Color.WHITE);

					}

				}
			}

			btns = newBtns;

		}

	}
	
	MouseListener mouseListener = new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
            int modifiers = mouseEvent.getModifiers();
            if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
                // Mask may not be set properly prior to Java 2
                // See SwingUtilities.isLeftMouseButton() for workaround
                System.out.println("Left button pressed.");
            }
            if ((modifiers & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK) {
                System.out.println("Middle button pressed.");
            }
            if ((modifiers & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
                System.out.println("Right button pressed.");
//                run();
            }
        }

        public void mouseReleased(MouseEvent mouseEvent) {
            if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                System.out.println("Left button released.");
            }
            if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
                System.out.println("Middle button released.");
            }
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                System.out.println("Right button released.");
            }
            System.out.println();
        }
    };

}
