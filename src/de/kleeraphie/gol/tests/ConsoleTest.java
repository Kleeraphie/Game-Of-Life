package de.kleeraphie.gol.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.kleeraphie.gol.console.Console;

class ConsoleTest {
	Console c;

	@BeforeEach
	public void setup() {
		c = new Console(50);
	}

	@Test
	void testBlinker() {
		c.field[1][2] = c.ALIVE;
		c.field[2][2] = c.ALIVE;
		c.field[3][2] = c.ALIVE;

		c.start(1);
		assertTrue(c.field[2][1] == c.ALIVE);
		assertTrue(c.field[2][2] == c.ALIVE);
		assertTrue(c.field[2][3] == c.ALIVE);

		assertTrue(c.field[1][2] == c.DEAD);
		assertTrue(c.field[3][2] == c.DEAD);

		// check if getting back works too because I got some errors there before
		c.start(2);
		assertTrue(c.field[1][2] == c.ALIVE);
		assertTrue(c.field[2][2] == c.ALIVE);
		assertTrue(c.field[3][2] == c.ALIVE);

		assertTrue(c.field[2][1] == c.DEAD);
		assertTrue(c.field[2][3] == c.DEAD);
	}

	@Test
	void testFirstOtherObject() {
		c.field[24][20] = c.ALIVE;
		c.field[25][20] = c.ALIVE;
		c.field[26][20] = c.ALIVE;
		c.field[24][21] = c.ALIVE;
		c.field[26][21] = c.ALIVE;
		c.field[24][22] = c.ALIVE;
		c.field[26][22] = c.ALIVE;

		c.field[24][26] = c.ALIVE;
		c.field[25][26] = c.ALIVE;
		c.field[26][26] = c.ALIVE;
		c.field[24][25] = c.ALIVE;
		c.field[26][25] = c.ALIVE;
		c.field[24][24] = c.ALIVE;
		c.field[26][24] = c.ALIVE;

		c.start(60); // maxCycle higher than expected cycle

		assertTrue(c.getCycle() == 55);
	}

	@Test
	void testSquareBlinker() {
		c.field[5][5] = c.ALIVE;
		c.field[5][6] = c.ALIVE;
		c.field[6][5] = c.ALIVE;
		c.field[6][6] = c.ALIVE;

		c.field[7][7] = c.ALIVE;
		c.field[7][8] = c.ALIVE;
		c.field[8][7] = c.ALIVE;
		c.field[8][8] = c.ALIVE;

		c.start(1);
		assertTrue(c.field[6][6] == c.DEAD);
		assertTrue(c.field[7][7] == c.DEAD);

		c.start(2);
		assertTrue(c.field[6][6] == c.ALIVE);
		assertTrue(c.field[7][7] == c.ALIVE);
	}

	@Test
	void testGlider() {
		c.field[5][5] = c.ALIVE;
		c.field[7][5] = c.ALIVE;
		c.field[6][6] = c.ALIVE;
		c.field[6][7] = c.ALIVE;
		c.field[7][6] = c.ALIVE;

		c.start(173); // 172 is enough but with 173 you can see it in the console

		assertTrue(c.field[48][48] == c.ALIVE);
		assertTrue(c.field[48][49] == c.ALIVE);
		assertTrue(c.field[49][48] == c.ALIVE);
		assertTrue(c.field[49][49] == c.ALIVE);
	}

}
