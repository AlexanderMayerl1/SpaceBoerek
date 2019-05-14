package at.htlle.gameobjects;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Rocket 
{
	private int y;
	private int x;
	private int speed;
	private String rocketString = ">==>";
	private int rheight;
	private int rwidth;
	
	/**
	 * 
	 * @param x = x -Koordinate
	 * @param y = y-Koordinate
	 * @param speed Geschwindigkeit
	 */
	public Rocket(int x, int y, int speed) {
		super();
		this.y = y;
		this.x = x;
		this.speed = speed;
	}
	
	public void move()
	{
		x = x + speed;
	}
	
	public String toString()
	{
		
		return "Rocket("+this.x+"|"+this.y+")";
	}
	
	public void paint(GraphicsContext gc)
	{
		this.rwidth= (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().computeStringWidth(rocketString, gc.getFont());
		this.rheight = (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().getFontMetrics(gc.getFont()).getLineHeight();
		
		gc.setFont(Font.font(10));
		gc.fillText(rocketString, this.x, this.y);
	}
	
	public boolean isVisible()
	{
		return(this.x<600);
		
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public Bounds getBounds()
	{
		Rectangle r = new Rectangle(this.x, this.y, rwidth, rheight);
		return r.getBoundsInLocal();
	}
	
}
