package main;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet
{

	public static void main(String[] args) 
	{
		PApplet.main("main.Principal");
	}
	
	InetAddress ip;
	
	UDPConnection udp;
	
	PImage beer, hDog, sub, yogurt;
	
	int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
	
	ArrayList<Foob> foodArrList;
	
	@Override
	public void settings() //void Awake
	{
		size(500, 500);
	}
	
	@Override
	public void setup() //void Start
	{
		try {
			ip = InetAddress.getLocalHost();
			
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beer = loadImage("beer.jpg");
		hDog = loadImage("dog.png");
		sub = loadImage("sub.jpg");
		yogurt = loadImage("yogurt.jpg");
		
		foodArrList = new ArrayList<Foob>();
		
		udp = new UDPConnection();
		udp.start();
	}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		//System.out.println(mouseX + ", " + mouseY);
		fill(0);
		
		imageMode(CENTER);
		
		switch(udp.getNumberOfOrders())
		{
		case 0:
			break;
		case 1:
			checkImage(50, 50);
			text(hour() + ":" + minute(), 80, 55);
			break;
		case 2:
			checkImage(50, 100);
			text(hour() + ":" + minute(), 80, 100);
			break;
		case 3:
			checkImage(50, 150);
			text(hour() + ":" + minute(), 80, 150);
			break;
		case 4:
			checkImage(50, 200);
			text(hour() + ":" + minute(), 80, 200);
			break;
		case 5:
			checkImage(50, 250);
			text(hour() + ":" + minute(), 80, 250);
			break;
		}
		
		/*if(udp.getNumberOfOrders() == 0)
		{
			
		}
		else if(udp.getNumberOfOrders() == 1)
		{
			checkImage(50, 50);
			text(hour() + ":" + minute(), 80, 55);
		}
		else if(udp.getNumberOfOrders() == 2)
		{
			checkImage(50, 100);
			text(hour() + ":" + minute(), 80, 105);
		}
		else if(udp.getNumberOfOrders() == 3)
		{
			checkImage(50, 150);
			text(hour() + ":" + minute(), 80, 155);
		}
		else if(udp.getNumberOfOrders() == 4)
		{
			checkImage(50, 200);
			text(hour() + ":" + minute(), 80, 205);
		}
		else if(udp.getNumberOfOrders() == 5)
		{
			checkImage(50, 250);
			text(hour() + ":" + minute(), 80, 255);
		}*/
	}
	
	public void checkImage(int x, int y)
	{
		if(udp.getMsgNum() == 1)
		{
			image(beer, x, y);
			beer.resize(50, 50);
		}
		if(udp.getMsgNum() == 2)
		{
			image(sub, x, y);
			sub.resize(50, 50);
		}
		if(udp.getMsgNum() == 3)
		{
			image(yogurt, x, y);
			yogurt.resize(50, 50);
		}
		if(udp.getMsgNum() == 4)
		{
			image(hDog, x, y);
			hDog.resize(50, 50);
		}
	}
	
	public void mousePressed()
	{
		if(dist(mouseX, mouseY, 50, 50) < 25 && udp.getNumberOfOrders() >= 1)
		{
			udp.sendMessage("1");
			System.out.println("ENV 1");
		}
		if(dist(mouseX, mouseY, 50, 100) < 25 && udp.getNumberOfOrders() >= 2)
		{
			udp.sendMessage("1");
			System.out.println("ENV 2");
		}
		if(dist(mouseX, mouseY, 50, 150) < 25 && udp.getNumberOfOrders() >= 3)
		{
			udp.sendMessage("1");
			System.out.println("ENV 3");
		}
		if(dist(mouseX, mouseY, 50, 200) < 25 && udp.getNumberOfOrders() >= 4)
		{
			udp.sendMessage("1");
			System.out.println("ENV 4");
		}
		if(dist(mouseX, mouseY, 50, 250) < 25 && udp.getNumberOfOrders() >= 5)
		{
			udp.sendMessage("1");
			System.out.println("ENV 5");
		}
	}

}
