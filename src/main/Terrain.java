package main;

import java.util.*;

public class Terrain {

	public double[] map;
	public int size;
	public int max;
	
	public Random rand;
	
	public Terrain(double detail) {
		rand = new Random();
		
		this.size = (int)Math.pow(2, detail) + 1; 
		this.max = this.size - 1;
		this.map = new double[(int)(this.size * this.size)];
	}
	
	public double get(int x, int y) {
		if (x<0 || x > this.max || y<0 || y > this.max) return -1;
		return this.map[(int)(x + this.size*y)];
	}
	
	public void set(int x, int y, double val) {
		this.map[(int)(x + this.size*y)] = val;
	}
	
	public void generate(int roughness) {
		this.set(0, 0, this.max);
		this.set(this.max, 0, (double)(this.max / 2));
		this.set(this.max, this.max, 0);
		this.set(0, this.max, (double)(this.max / 2));
		
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
	
	public void square(int x, int y, int half, int scale) {
		
	}
	
	public void diamond(int x, int y, int half, int scale) {
		
	}
}
