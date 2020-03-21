package _02_Pixel_Art;

import java.io.Serializable;

public class SerializedClass implements Serializable{
public final Pixel[][] pixels;
public final int w;
public final int h;
public final int r;
public final int c;
public SerializedClass(Pixel[][] pixels, int w, int h, int r, int c) {
	this.pixels = pixels;
	this.w = w;
	this.h = h;
	this.r = r;
	this.c = c;
}
}
