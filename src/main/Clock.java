package main;

import processing.core.PApplet;

public class Clock 
{
	int hourOf, minuteOf;

	public Clock(PApplet app, int hour, int minute)
	{
		this.hourOf = hour;
		this.minuteOf = minute;
	}
	
	public void buildClock(PApplet app, int x, int y)
	{
		app.text(hourOf + ":" + minuteOf, x, y);
	}
	
}
