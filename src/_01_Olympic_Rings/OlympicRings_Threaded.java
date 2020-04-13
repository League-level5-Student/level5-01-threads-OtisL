package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	
	public static void main(String[] args) {
		Robot a=new Robot();
		Robot b=new Robot();
		Robot c=new Robot();
		Robot d=new Robot();
		Robot e=new Robot();
		a.moveTo(100, 200);
		b.moveTo(164, 270);
		c.moveTo(228, 200);
		d.moveTo(292, 270);
		e.moveTo(356, 200);
		Thread r1 = new Thread(()->circle(a));
		Thread r2 = new Thread(()->circle(b));
		Thread r3 = new Thread(()->circle(c));
		Thread r4 = new Thread(()->circle(d));
		Thread r5 = new Thread(()->circle(e));
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}
	static void circle(Robot r) {
		r.penDown();
		r.setSpeed(10);
		for(int i=0; i<360; i++) {
			r.turn(1);
			r.move(1);
		}
		r.setAngle(0);
		r.setAngle(180);
		r.penUp();
		r.move(500);
		r.turn(180);
	}
}

