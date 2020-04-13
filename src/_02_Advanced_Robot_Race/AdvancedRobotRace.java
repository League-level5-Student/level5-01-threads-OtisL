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
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.

		Random randy = new Random();
		Thread r1 = new Thread(() -> robots[0].move(randy.nextInt(50)));
		Thread r2 = new Thread(() -> robots[1].move(randy.nextInt(50)));
		Thread r3 = new Thread(() -> robots[2].move(randy.nextInt(50)));
		Thread r4 = new Thread(() -> robots[3].move(randy.nextInt(50)));
		Thread r5 = new Thread(() -> robots[4].move(randy.nextInt(50)));
		boolean finished = false;
		int winner = -1;
		while (!finished) {
			r1.start();
			r2.start();
			r3.start();
			r4.start();
			r5.start();
			for (int i = 0; i < robots.length; i++) {
				if(robots[i].getY()<0) {
					finished = true;
					winner=i;
				}
			}
		}
		robots[winner].setAngle(180);
		robots[winner].move(900);
		robots[winner].turn(540);
		robots[winner].move(450);
		robots[winner].turn(1000);
		robots[winner].setAngle(0);
	}
	static void move(Robot r) {
		
	}
}
