package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Foob 
{
	int x, y;
	PImage beer, hDog, sub, yogurt;
	
	UDPConnection udp;
	
	public Foob(PApplet app, int x, int y)
	{
		udp = new UDPConnection();
		
		this.x = x;
		this.y = y;
		
		beer = app.loadImage("beer.jpg");
		hDog = app.loadImage("dog.png");
		sub = app.loadImage("sub.jpg");
		yogurt = app.loadImage("yogurt.jpg");
	}
	
	public void drawImage(PApplet app)
	{
		if(udp.msgNum == 1)
		{
			app.image(beer, x, y);
			beer.resize(50, 50);
		}
		if(udp.msgNum  == 2)
		{
			app.image(sub, x, y);
			sub.resize(50, 50);
		}
		if(udp.msgNum  == 3)
		{
			app.image(yogurt, x, y);
			yogurt.resize(50, 50);
		}
		if(udp.msgNum  == 4)
		{
			app.image(hDog, x, y);
			hDog.resize(50, 50);
		}
	}
}
