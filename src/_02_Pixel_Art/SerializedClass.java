package _02_Pixel_Art;

import java.io.Serializable;

public class SerializedClass implements Serializable{
public final Pixel[][] pixels;
public SerializedClass(Pixel[][] pixels) {
	this.pixels = pixels;
}
}
