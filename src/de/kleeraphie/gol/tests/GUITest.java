package de.kleeraphie.gol.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.kleeraphie.gol.gui.GUI;

class GUITest {

	GUI g;

	@BeforeEach
	public void setup() {
		g = new GUI(50);
	}

	@Test
	void testBlinker() {
		g.field[1][2].setBackground(g.ALIVE);
		g.field[2][2].setBackground(g.ALIVE);
		g.field[3][2].setBackground(g.ALIVE);

		g.start(1);
		assertTrue(g.field[2][1].getBackground() == g.ALIVE);
		assertTrue(g.field[2][2].getBackground() == g.ALIVE);
		assertTrue(g.field[2][3].getBackground() == g.ALIVE);

		assertTrue(g.field[1][2].getBackground() == g.DEAD);
		assertTrue(g.field[3][2].getBackground() == g.DEAD);

		// check if getting back works too because I got some errors there before
		g.start(2);
		assertTrue(g.field[1][2].getBackground() == g.ALIVE);
		assertTrue(g.field[2][2].getBackground() == g.ALIVE);
		assertTrue(g.field[3][2].getBackground() == g.ALIVE);

		assertTrue(g.field[2][1].getBackground() == g.DEAD);
		assertTrue(g.field[2][3].getBackground() == g.DEAD);
	}

	@Test
	void testFirstOtherObject() {
		g.field[24][20].setBackground(g.ALIVE);
		g.field[25][20].setBackground(g.ALIVE);
		g.field[26][20].setBackground(g.ALIVE);
		g.field[24][21].setBackground(g.ALIVE);
		g.field[26][21].setBackground(g.ALIVE);
		g.field[24][22].setBackground(g.ALIVE);
		g.field[26][22].setBackground(g.ALIVE);

		g.field[24][26].setBackground(g.ALIVE);
		g.field[25][26].setBackground(g.ALIVE);
		g.field[26][26].setBackground(g.ALIVE);
		g.field[24][25].setBackground(g.ALIVE);
		g.field[26][25].setBackground(g.ALIVE);
		g.field[24][24].setBackground(g.ALIVE);
		g.field[26][24].setBackground(g.ALIVE);

		g.start(60); // maxCycle higher than expected cycle

		assertTrue(g.getCycle() == 55);
	}

	@Test
	void testSquareBlinker() {
		g.field[5][5].setBackground(g.ALIVE);
		g.field[5][6].setBackground(g.ALIVE);
		g.field[6][5].setBackground(g.ALIVE);
		g.field[6][6].setBackground(g.ALIVE);

		g.field[7][7].setBackground(g.ALIVE);
		g.field[7][8].setBackground(g.ALIVE);
		g.field[8][7].setBackground(g.ALIVE);
		g.field[8][8].setBackground(g.ALIVE);

		g.start(1);
		assertTrue(g.field[6][6].getBackground() == g.DEAD);
		assertTrue(g.field[7][7].getBackground() == g.DEAD);

		g.start(2);
		assertTrue(g.field[6][6].getBackground() == g.ALIVE);
		assertTrue(g.field[7][7].getBackground() == g.ALIVE);
	}

	@Test
	void testGlider() {
		g.field[5][5].setBackground(g.ALIVE);
		g.field[7][5].setBackground(g.ALIVE);
		g.field[6][6].setBackground(g.ALIVE);
		g.field[6][7].setBackground(g.ALIVE);
		g.field[7][6].setBackground(g.ALIVE);

		g.start(173); // 172 is enough but with 173 you can see it in the console

		assertTrue(g.field[48][48].getBackground() == g.ALIVE);
		assertTrue(g.field[48][49].getBackground() == g.ALIVE);
		assertTrue(g.field[49][48].getBackground() == g.ALIVE);
		assertTrue(g.field[49][49].getBackground() == g.ALIVE);
	}

}
