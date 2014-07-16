package main;

import java.util.*;
import java.awt.Graphics2D;
import java.awt.Color;

public class Terrain {

	public int[] map;
	public int size;
	public int max;
	public Graphics2D g2d;
	
	public Random rand;
	
	public Terrain(double detail, Graphics2D _g2d) {
		rand = new Random();
		
		this.g2d = _g2d;
		this.size = (int)Math.pow(2, detail) + 1; 
		this.max = this.size - 1;
		this.map = new int[(this.size * this.size)];
	}
	
	public int get(int x, int y) {
		if (x<0 || x > this.max || y<0 || y > this.max) return -1;
		return this.map[(int)(x + this.size*y)];
	}
	
	public void set(int x, int y, int val) {
		this.map[(int)(x + this.size*y)] = val;
	}
	
	public void generate(int roughness) {
		this.set(0, 0, this.max);
		this.set(this.max, 0, (this.max / 2));
		this.set(this.max, this.max, 0);
		this.set(0, this.max, (this.max / 2));
		
		this.divide(this.max, roughness);
	}
	
	public void divide(int size, int roughness) {
		int x,y;
		int half = size/2;
		int scale = roughness * size;
		if (half < 1) return;
		
		for(y = half; y < this.max; y+= size) {
			for (x = half; x < this.max; x += size) {
				square(x,y,half, rand.nextInt() * scale * 2 - scale);
			}
		}
		
		for (y = 0; y <= this.max; y+=half) {
			for (x = (y+half) % size; x <= this.max; x += size) {
				diamond(x, y, half, rand.nextInt() * scale * 2 * - scale);
			}
		}
		
		this.divide(size / 2, roughness);
	}
	
	public int average(int[] values) {
		int length = values.length;
		
		List<Integer> valid = new ArrayList<Integer>();
		for(int i=0;i<length;i++) {
			if (values[i] != -1) {
				valid.add(values[i]);
			}
		}
		
		int sum = 0;
		for(int j=0;j<valid.size();j++) {
			sum+= valid.get(j);
		}
		
		return sum/valid.size();
	}
	
	public void square(int x, int y, int sze, int offset) {		
		int[] toAvg = {
		           this.get(x - sze, y - sze),   // upper left
		           this.get(x + sze, y - sze),   // upper right
		           this.get(x + sze, y + sze),   // lower right
		           this.get(x - sze, y + sze)    // lower left
		        };
		
		int ave = this.average(toAvg);
		this.set(x, y, ave + offset);
	}
	
	public void diamond(int x, int y, int sze, int offset) {
		int[] toAvg = {
		           this.get(x, y - sze),   // upper left
		           this.get(x + sze, y),   // upper right
		           this.get(x, y + sze),   // lower right
		           this.get(x - sze, y)    // lower left
		        };
		
		int ave = this.average(toAvg);
		this.set(x, y, ave + offset);
	}
	
	public void draw() {
		double waterVal = this.size * 0.3;
		
		 for (int y = 0; y < this.size; y++) {
		      for (int x = 0; x < this.size; x++) {
		        int val = this.get(x, y);
		        Point top = this.project(x, y, val);
		        Point bottom = this.project(x + 1, y, 0);
		        Point water = this.project(x, y, waterVal);
		        String style = this.brightness(x, y, this.get(x + 1, y) - val);
		
		        this.rect(top, bottom, style);
		        this.rect(water, bottom, "rgba(50, 150, 200, 0.15)");
		      }
		 }
	}
	
	public Point project(int flatX, int flatY, double flatZ) {
		
		
		return new Point();
	}
	
	public String brightness(int x, int y, int slope) {
		
		return " ";
	}
	
	public void rect(Point a, Point b, String style) {
		
	}
	
}
