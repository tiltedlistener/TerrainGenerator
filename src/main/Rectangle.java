package main;

import java.awt.Color;

public class Rectangle {

	public Point a;
	public Point b;
	public Color c;
	
	public Rectangle(Point _a, Point _b, Color _c) {
		this.a = _a;
		this.b = _b;
		this.c = _c;
	}
	
	public double xOrg() {
		return a.x;
	}
	
	public double yOrg() {
		return a.y;
	}
	
	public double width() {
		return b.x - a.x;
	}
	
	public double height() {
		return b.y - a.y;
	}
	
}
