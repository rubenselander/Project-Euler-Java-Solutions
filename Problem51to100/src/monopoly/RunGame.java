package monopoly;

import java.util.*;

public class RunGame {
	private HashMap<String, Integer> squareIndex = new HashMap<>();
	private Chest chest = new Chest();
	private Chance chance = new Chance();
	private int position = 0;
	private int[] timesAtSquare = new int[40];
	private Random rand = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunGame run = new RunGame();
		run.start();
	}

	private void start() {
		for(int i = 0; i <= 100000000; i++) {
			nextRound();
			if(i % 500 == 0) {
				chest.shuffle();
				chance.shuffle();
			}
		}
		int total = 0;
		
		for(int i = 0; i <= 39; i++) {
			total += timesAtSquare[i];
		}
		
		for(int i = 0; i <= 39; i++) {
			double result = (double)timesAtSquare[i] / (double) total;
			double result2 = result * 10000;
			int result3 = (int) result2;
			System.out.println(i + ": " + result3);
		}
		
		
		
	}

	private void nextRound() {
		int doubleRollCount = 0;
		boolean doubleRoll = true;

		while (doubleRoll) {
			int[] roll = roll();
			int step = roll[0] + roll[1];
			walk(step);
			checkAction();
			doubleRoll = roll[0] == roll[1];
			if (doubleRoll) doubleRollCount++;
			if (doubleRollCount == 3) {
				// position = JAIL
				position = 10;
				break;
			}
		}
		timesAtSquare[position]++;
	}

	private int[] roll() {
		int[] dices = { rand.nextInt(4) + 1, rand.nextInt(4) + 1 };
		return dices;
	}

	private void walk(int step) {
		if (position + step <= 39) {
			position += step;
		}
		else {
			int nextLap = position + step - 40;
			position = nextLap;
		}
	}

	private void checkAction() {
		if(position == 2 || position == 17 || position == 33) {
			drawChest();
		}
		else if(position == 7 || position == 22 || position == 36) {
			drawChance();
		}
		else if(position == 30) {
			position = 10; //landed on go to jail
		}
	}

	private void drawChest() {
		String card = chest.next();
		if(card.equals("JAIL")) {
			position = 10;
		}
		else if(card.equals("GO")) {
			position = 0;
		}
	}

	private void drawChance() {
		String card = chance.next();
		if(card.equals("BLANK")) return;
		
		if(card.equals("JAIL")) {
			position = 10;
		}
		else if(card.equals("GO")) {
			position = 0;
		}
		else if(card.equals("C1")) {
			position = 11;
		}
		else if(card.equals("E3")) {
			position = 24;
		}
		else if(card.equals("H2")) {
			position = 39;
		}
		else if(card.equals("R1")) {
			position = 5;
		}
		else if(card.equals("BACK3")) {
			if(position <= 2) position = 0;
			else {
				position = position - 3;
				checkAction();
			}
		}
		else if(card.equals("nextR")) {
			nextR();
		}
		else if(card.equals("nextU")) {
			nextU();
		}
	}
	
	
	private void nextR() {
		if(position < 5) position = 5;
		else if(position < 15) position = 15;
		else if(position < 25) position = 25;
		else if(position < 25) position = 25;
		else if(position < 35) position = 35;
		else position = 5;
	}
	
	private void nextU() {
		if(position > 28 || position < 12) position = 12;
		else position = 28;
	}

}
//cards.add("C1");
//cards.add("E3");
//cards.add("H2");
//cards.add("R1");
//cards.add("nextR");
//cards.add("nextR");
//cards.add("nextU");
//cards.add("BACK3");