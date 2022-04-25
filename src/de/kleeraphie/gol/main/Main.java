package de.kleeraphie.gol.main;

import de.kleeraphie.gol.gui.GUI;

public class Main {

	public static void main(String[] args) {
		GUI g = new GUI(50);
		
//		Blinker funktioniet
//		g.field[1][2].setBackground(g.ALIVE);
//		g.field[2][2].setBackground(g.ALIVE);
//		g.field[3][2].setBackground(g.ALIVE);

//		1. anderes Objekt funktioniert
//		g.field[24][20].setBackground(g.ALIVE);
//		g.field[25][20].setBackground(g.ALIVE);
//		g.field[26][20].setBackground(g.ALIVE);
//		g.field[24][21].setBackground(g.ALIVE);
//		g.field[26][21].setBackground(g.ALIVE);
//		g.field[24][22].setBackground(g.ALIVE);
//		g.field[26][22].setBackground(g.ALIVE);
//
//		g.field[24][26].setBackground(g.ALIVE);
//		g.field[25][26].setBackground(g.ALIVE);
//		g.field[26][26].setBackground(g.ALIVE);
//		g.field[24][25].setBackground(g.ALIVE);
//		g.field[26][25].setBackground(g.ALIVE);
//		g.field[24][24].setBackground(g.ALIVE);
//		g.field[26][24].setBackground(g.ALIVE);

//		2 Würfel Blinker
//		g.field[5][5].setBackground(g.ALIVE);
//		g.field[5][6].setBackground(g.ALIVE);
//		g.field[6][5].setBackground(g.ALIVE);
//		g.field[6][6].setBackground(g.ALIVE);
//		
//		g.field[7][7].setBackground(g.ALIVE);
//		g.field[7][8].setBackground(g.ALIVE);
//		g.field[8][7].setBackground(g.ALIVE);
//		g.field[8][8].setBackground(g.ALIVE);
		
//		Glider
		g.field[5][5].setBackground(g.ALIVE);
		g.field[7][5].setBackground(g.ALIVE);
		g.field[6][6].setBackground(g.ALIVE);
		g.field[6][7].setBackground(g.ALIVE);
		g.field[7][6].setBackground(g.ALIVE);
		
		g.start(200);
	}

}
