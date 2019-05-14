package at.htlle.gameobjects;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SpaceShip {
	private String shipString = "=[]8>";
	private int x;
	private int y;
	private int swidth;
	private int sheight;
	
	
	public SpaceShip(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Raumschiff bewegt sich nach oben
	 * @param delta
	 */
	public void moveUp(int delta)
	{
		this.y -= delta;
	}
	
	/**
	 * Raumschiff bewegt sich nach unten
	 * @param delta
	 */
	public void moveDown(int delta)
	{
		this.y += delta;
	}
	
	
	/**
	 * Raumschiff bewegt sich nach links
	 * @param delta
	 */
	public void moveLeft(int delta)
	{
		this.x -= delta;
	}
	
	/**
	 * Raumschiff bewegt sich nach rechts
	 * @param delta
	 */
	public void moveRight(int delta)
	{
		this.x += delta;
	}
	
	public String toString()
	{
		return "SpaceShip("+this.x+"|"+this.y+")";
	}
	
	public void paint(GraphicsContext gc)
	{
		this.swidth= (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().computeStringWidth(shipString, gc.getFont());
		this.sheight = (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().getFontMetrics(gc.getFont()).getLineHeight();
		
		gc.setFont(Font.font(20));
		gc.fillText(shipString, this.x, this.y);
		
	}
	
	/*
	 * Erzeugt eine Rakete an der Positiond des Raumschiffs
	 */
	public Rocket fire()
	{
		Rocket r = new Rocket(this.x, this.y, 2);
		return r;
	}
	
	public void damage()
	{
		this.shipString = "-]>";
	}
	
	public Bounds getBounds()
	{
		
		
		Rectangle r = new Rectangle(this.x, this.y, this.swidth, this.sheight);
		return r.getBoundsInLocal();
	}
}
