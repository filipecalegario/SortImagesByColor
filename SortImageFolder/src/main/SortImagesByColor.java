package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import model.PImageValue;
import processing.core.PApplet;
import processing.core.PImage;

public class SortImagesByColor extends PApplet{
	
	ArrayList<PImageValue> imgs;
	HashMap<String, Integer> map;
	
	public void settings() {
		  size(700, 700);
	}

	@Override
	public void setup() {
		colorMode(HSB);
		map = new HashMap<>();
		imgs = new ArrayList<>();
		File folder = new File("/Users/fcac/git/SortImagesByColor/SortImageFolder/src/data/imgs");
		String[] files = folder.list();
		for (int i = 0; i < files.length; i++) {
			if(files[i].contains(".png")){
				//System.out.println(files[i]);
				PImage img = loadImage("imgs/"+files[i]);
				Integer value = this.extractColorFromImage(img);
				PImageValue imgValue = new PImageValue(img, value);
				imgs.add(imgValue);
			}
		}
		Collections.sort(imgs);
		noLoop();
	}

	@Override
	public void draw() {
		background(255);
		Integer x = 0;
		Integer y = 0;
		Integer column = 15;
		for (int i = 0; i < imgs.size(); i++) {
			if(i != 0 && i%column == 0){
				y = y + 31;
				x = 0;
			}
			image(imgs.get(i).getImage(), x, y);
			x = x + 31;
		}
	}

	Integer extractColorFromImage(PImage img) {
	    img.loadPixels();
	    int r = 0, g = 0, b = 0;
	    for (int i=0; i<img.pixels.length; i++) {
	        Integer c = img.pixels[i];
	        r += c>>16&0xFF;
	        g += c>>8&0xFF;
	        b += c&0xFF;
	    }
	    r /= img.pixels.length;
	    g /= img.pixels.length;
	    b /= img.pixels.length;
	 
	    return color(r, g, b);
	}
	
	public static void main(String[] args) {
		String[] appletArgs = new String[] { "main.SortImagesByColor" };
		if (args != null) {
			PApplet.main(concat(appletArgs, args));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
