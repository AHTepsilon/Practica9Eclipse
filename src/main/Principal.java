package main;
import java.net.InetAddress;
import java.net.UnknownHostException;

import processing.core.PApplet;

public class Principal extends PApplet
{

	public static void main(String[] args) 
	{
		PApplet.main("main.Principal");
	}
	
	InetAddress ip;
	
	UDPConnection udp;
	
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
		
		udp = new UDPConnection();
		udp.start();
	}
	
	@Override
	public void draw() //void Update
	{		
		if(udp.getMsgNum() == 1)
		{
			fill(255, 0, 0);
			square(250, 250, 50);
		}
		if(udp.getMsgNum() == 2)
		{
			fill(255, 0, 0);
			square(250, 300, 50);
		}
		if(udp.getMsgNum() == 3)
		{
			fill(255, 0, 0);
			square(250, 200, 50);
		}
		if(udp.getMsgNum() == 4)
		{
			fill(255, 0, 0);
			square(200, 250, 50);
		}
	}

}
