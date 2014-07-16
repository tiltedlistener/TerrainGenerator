package main;

import javax.swing.*;

public class TerrainGeneration extends JFrame {
	
	static final long serialVersionUID = 0;

	public static void main(String[] args) {
		new TerrainGeneration();
	}
	
	public TerrainGeneration() {
		super("Terrain!");
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
