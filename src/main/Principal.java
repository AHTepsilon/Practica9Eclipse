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

	}

}
