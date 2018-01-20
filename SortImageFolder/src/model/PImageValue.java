package model;

import processing.core.PImage;

public class PImageValue implements Comparable<PImageValue>{
	
	private PImage image;
	private Integer value;
	
	public PImageValue(PImage image, Integer value) {
		super();
		this.image = image;
		this.value = value;
	}

	public PImage getImage() {
		return image;
	}

	public void setImage(PImage image) {
		this.image = image;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public int compareTo(PImageValue o) {
		Integer result = 0;
		if(o.getValue() > this.getValue()){
			result = -1;
		} else if(o.getValue() < this.getValue()){
			result = 1;
		}
		return result;
	}
	
}
