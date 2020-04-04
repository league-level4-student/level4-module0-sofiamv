package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

public class SerializedClass implements Serializable{
public final Pixel[][] pixels;
public final int w;
public final int h;
public final int pw;
public final int ph;
public final int r;
public final int c;
public SerializedClass(Pixel[][] pixels, int w, int h, int r, int c, int pw, int ph) {
	this.pixels = pixels;
	this.pw = pw;
	this.ph = ph;
	this.w = w;
	this.h = h;
	this.r = r;
	this.c = c;
	for(int i = 0; i < pixels.length; i++) {
		for(int j = 0; j < pixels[i].length; j++) {
			this.pixels[i][j].color = pixels[i][j].color;
		}
	}
}
}
