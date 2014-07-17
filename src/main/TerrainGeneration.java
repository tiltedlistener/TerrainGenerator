package main;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TerrainGeneration extends JFrame {
	
	static final long serialVersionUID = 0;

	public static void main(String[] args) {
		new TerrainGeneration();
	}
	
	public ArrayList<Rectangle> rectList;
	
	public TerrainGeneration() {
		super("Terrain!");
		setSize(640,640);
		
		rectList = new ArrayList<Rectangle>();
		
		Terrain terrain = new Terrain(9, this);
		terrain.generate(0.7);
		terrain.draw(640, 640);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addRectangle(Rectangle rect){
		rectList.add(rect);
	}
	
	public void paint(Graphics g) {
		for(int i=0;i<rectList.size();i++) {
			Rectangle current = rectList.get(i);
			g.setColor(current.c);
			g.fillRect(current.xOrg(), current.yOrg(), current.width(), current.height());
		}
	}

}
