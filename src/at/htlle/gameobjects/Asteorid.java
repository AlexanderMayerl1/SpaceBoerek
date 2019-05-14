package at.htlle.gameobjects;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class Asteorid 
{
	private int y;
	private int x;
	private int speed;
	
	public Asteorid(int x, int y, int speed) {
		super();
		this.y = y;
		this.x = x;
		this.speed = speed;
	}
	
	public void move()
	{
		x = x - speed;
	}
	
	public String toString()
	{
		return "Asteorid("+this.x+"|"+this.y+")";
	}
	
	public void paint(GraphicsContext gc)
	{
		gc.fillText("*", this.x, this.y);
	}
	
	public boolean isVisible()
	{
		return(this.x>0);
		
	}
	
	public void reposition(int width, int height)
	{
		Random rdm = new Random();
		
		this.x = width + rdm.nextInt(width/2);
		this.y = rdm.nextInt(height);
		this.speed = 2 + rdm.nextInt(5);
	}
	
	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public Bounds getBounds() {
		Circle c = new Circle(this.x, this.y, 10);
		return c.getBoundsInLocal();
	}
}
