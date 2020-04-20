package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] robots = new Robot[5];
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robots.length; i++) {
			// 4. make each robot start at the bottom of the screen, side by side, facing up
			robots[i] = new Robot();
			robots[i].moveTo(i * 90 + 50, 900);
			robots[i].setSpeed(10);
			robots[i].setAngle(1);
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.

		
		Thread r1 = new Thread(() -> move(robots[0]));
		Thread r2 = new Thread(() -> move(robots[1]));
		Thread r3 = new Thread(() -> move(robots[2]));
		Thread r4 = new Thread(() -> move(robots[3]));
		Thread r5 = new Thread(() -> move(robots[4]));
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}
	static void move(Robot r) {
		Random randy = new Random();
		boolean finished = false;
		while (!finished) {
			r.move(randy.nextInt(100));
			if(r.getY()<0) {
				finished=true;
			}
		}
		r.setAngle(181);
		r.move(900);
		r.turn(540);
		r.move(450);
		r.turn(1000);
		r.setAngle(0);
	}
}
