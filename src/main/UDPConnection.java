package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConnection extends Thread 
{

	private DatagramSocket socket;
	public static int msgNum;
	private int numberOfOrders;
	
	private Principal main;
	
	public void setObserver(Principal main)
	{
		this.main = main;
	}
	
	public void run()
	{
		try {
			socket = new DatagramSocket(2000);
			
			
			while(true)
			{
				byte[] buffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("Awaiting for datagram...");
				socket.receive(packet);
				
				String message = new String(packet.getData()).trim();
				
				System.out.println("Datagram Received: " + message);
				
				main.createClock();
				
				numberOfOrders++;
				
				msgNum = Integer.parseInt(message);
				System.out.println(msgNum);
				System.out.println(numberOfOrders);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg)
	{
		
		new Thread(
				()->
				{
					try {
						InetAddress ip;
						ip = InetAddress.getByName("192.168.1.34");
						DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 3000);
						socket.send(packet);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			).start();
	}

	public int getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(int msgNum) {
		this.msgNum = msgNum;
	}

	public int getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}
	
	
}
