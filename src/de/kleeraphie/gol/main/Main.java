package de.kleeraphie.gol.main;

import de.kleeraphie.gol.gui.GUI;

public class Main {

	public static void main(String[] args) {
		GUI g = new GUI();
		g.initialize(32);
		g.start();
	}

}
