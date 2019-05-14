package at.htlle.shooter;



import java.util.ArrayList;
import java.util.List;

import at.htlle.gameobjects.Asteorid;
import at.htlle.gameobjects.Rocket;
import at.htlle.gameobjects.SpaceShip;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Starter extends Application implements EventHandler<KeyEvent>{

		SpaceShip yasersUntergang = new SpaceShip(100,100);
		List<Asteorid> asteoriden = new ArrayList<Asteorid>();
		List<Rocket> rockets = new ArrayList<Rocket>();
		
		final int WIDTH = 600;
		final int HEIGHT = 400;
		
		
	public static void main(String[] args)
	{
		Application.launch(Starter.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SpaceShooter - Mayerl");
		
		Group root = new Group();
		
		Canvas canvas = new Canvas(WIDTH,HEIGHT);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
		
		yasersUntergang.paint(canvas.getGraphicsContext2D());
	
		//Asteoriden erzeugen
		for(int i = 0; i <17; i++)
		{
			Asteorid a = new Asteorid(0, 0, 0);
			a.reposition(WIDTH, HEIGHT);
			asteoriden.add(a);
		}
		

		new AnimationTimer()
		{

			@Override
			public void handle(long arg0) {
				canvas.getGraphicsContext2D().clearRect(0, 0, 600, 400);
				yasersUntergang.paint(canvas.getGraphicsContext2D());
				
				//Asteoriden handling
				for(Asteorid a : asteoriden)
				{
					a.paint(canvas.getGraphicsContext2D());
					a.move();
					
					if(!a.isVisible())
					{
						a.reposition(WIDTH, HEIGHT);

					}
					
					
				}

				for(Asteorid a : asteoriden)
				{
					if(a.getBounds().intersects(yasersUntergang.getBounds()))
					{
						yasersUntergang.damage();
						a.reposition(WIDTH, HEIGHT);
					}
				}
				
				List<Rocket> delRo = new ArrayList<Rocket>();
				//Raketen handling
				for(Rocket r : rockets)
				{
					r.paint(canvas.getGraphicsContext2D());
					r.move();
					
					if(r.isVisible() == false)
					{
						r = null;
						delRo.add(r);
					}
					
				}
				rockets.removeAll(delRo);

				for(Rocket r: rockets)
				{
					for(Asteorid a : asteoriden)
					{
						if(r.getBounds().intersects(a.getBounds()))
						{
							
							a.reposition(WIDTH, HEIGHT);
						}
					}
				}
			}
			
		}.start();
		
	}

	@Override
	public void handle(KeyEvent evnt) {
		System.out.println(evnt.getCode().getName());
		
		int accelerator = 1;
		
		if(evnt.isShiftDown() == true)
		{
			accelerator = 2;
		}
		
		switch(evnt.getCode().getName())
		{
			case "Up":
				yasersUntergang.moveUp(10 * accelerator);
				break;
				
			case "Down":
				yasersUntergang.moveDown(10 * accelerator);
				break;
				
			case "Left":
				yasersUntergang.moveLeft(10 * accelerator);
				break;
				
			case "Right":
				yasersUntergang.moveRight(10 * accelerator);
				break;
				
			case "Space":
				Rocket r = yasersUntergang.fire();
				rockets.add(r);
				break;
		}
	}

}
