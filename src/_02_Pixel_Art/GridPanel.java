package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JPanel;

public class GridPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;
	private static final String DATA_FILE = "stuff.dat";
	//1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] pixels;
	private Color color;
	
	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		
		//2. Initialize the pixel array using the rows and cols variables.
		pixels = new Pixel[rows][cols];
		
		//3. Iterate through the array and initialize each element to a new pixel.
		for(int a = 0; a < pixels.length; a++) {
			for(int b = 0; b < pixels[a].length; b++) {
				pixels[a][b] = new Pixel(pixelWidth, pixelHeight);
			}
		}
		
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {
		//5. Use the mouseX and mouseY variables to change the color
		//   of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		pixels[mouseX/pixelWidth][mouseY/pixelHeight].color = this.color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//4. Iterate through the array.
		//   For every pixel in the list, fill in a rectangle using the pixel's color.
		//   Then, use drawRect to add a grid pattern to your display.
		for(int a = 0; a < pixels.length; a++) {
			for(int b = 0; b < pixels[a].length; b++) {
				g.setColor(pixels[a][b].color);
				g.fillRect(a * pixelWidth,b * pixelHeight, pixelWidth, pixelHeight);
				g.drawRect(a * pixelWidth,b * pixelHeight, pixelWidth, pixelHeight);
			}
		}
	}
	public void savethepic() {
		save(new SerializedClass(pixels));
	}
	
	private static void save(SerializedClass p) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
