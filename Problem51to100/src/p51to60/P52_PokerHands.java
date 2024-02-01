package p51to60;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P52_PokerHands {
	static ArrayList<String[]> player1 = new ArrayList<>();
	static ArrayList<String[]> player2 = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		getWords();
		int player1win = 0;
		int player2win = 0;
		
		for(int i = 0; i < 1000; i++) {
			int[] score1 = getRank(player1.get(i));
			int[] score2 = getRank(player2.get(i));
			
			if(compareScores(score1, score2)) {
				player1win++;
			}
			else {
				player2win++;
			}
		}
		System.out.println("Player 1 won " + player1win + " hands");
		System.out.println("Player w won " + player2win + " hands");
	}

	// will return true if player1 has the better hand otherwise false
	private static boolean compareScores(int[] score1, int[] score2) {
		int scoreIndex = 0;
		while (score1[scoreIndex] == score2[scoreIndex]) {
			scoreIndex++;
		}
		return (score1[scoreIndex] > score2[scoreIndex]);
	}

	private static void rankTest() {
		// pair = 2
		// two pair = 3
		// 3 of a kind = 4
		// Straight = 5
		// flush = 6
		// Full House: = 7
		//// Four of a Kind: = 8
		// Straight Flush: = 9
		// ROYAL flush = 10
		// 13
		// 3
		//

		String[] H1 = { "8C", "TS", "KC", "9H", "4S" }; // High Card (King)
		String[] H2 = { "5C", "AD", "5D", "AC", "9C" }; // Two Pairs (Aces and Fives)
		String[] H3 = { "3H", "7H", "6S", "KC", "JS" }; // High Card (King)
		String[] H4 = { "TH", "8H", "5C", "QS", "TC" }; // One Pair (Tens)
		String[] H5 = { "7C", "5H", "KC", "QH", "JD" }; // High Card (King)
		String[] H6 = { "5H", "KS", "9C", "7D", "9H" }; // One Pair (Nines)
		String[] H7 = { "6H", "4H", "5C", "3H", "2H" }; // Straight (2 to 6)
		String[] H8 = { "TD", "8C", "4H", "7C", "TC" }; // One Pair (Tens)
		String[] H9 = { "7C", "9C", "6D", "KD", "3H" }; // High Card (King)
		String[] H10 = { "JC", "6S", "5H", "2H", "2D" }; // One Pair (Twos)

		// Royal Flush: Ten, Jack, Queen, King, Ace, in same suit. = 10
		String[] H11 = { "2D", "3D", "4D", "5D", "6D" }; // Straight Flush (2 to 6) = 6
		String[] H12 = { "KS", "KH", "KD", "KC", "9S" }; // Four of a Kind (Kings) = 8
		String[] H13 = { "AS", "AC", "AD", "2C", "2D" }; // Full House (Aces and Twos) = 7
		String[] H14 = { "6H", "8H", "TH", "QH", "KH" }; // Flush (Hearts) = 6
		String[] H15 = { "3S", "4C", "5H", "6S", "7D" }; // Straight (3 to 7) = 5 WRONG gave 1
		String[] H16 = { "7D", "7H", "7S", "9C", "TD" }; // Three of a Kind (Sevens) = 4
		String[] H17 = { "JC", "JD", "TS", "9S", "9C" }; // Two Pairs (Jacks and Nines) = 3
		String[] H18 = { "8S", "8D", "4H", "QS", "AD" }; // One Pair (Eights)= 2
		String[] H19 = { "2C", "5C", "9D", "JS", "AH" }; // High Card (Ace)= 1
		String[] H20 = { "KC", "QD", "JC", "TD", "9H" }; // Straight = 5 WRONG gave 1

//		System.out.println(getRank(H11)[0]);
//		System.out.println(getRank(H12)[0]);
//		System.out.println(getRank(H13)[0]);
//		System.out.println(getRank(H14)[0]);
		System.out.println(getRank(H15)[0]);
//		System.out.println(getRank(H16)[0]);
//		System.out.println(getRank(H17)[0]);
//		System.out.println(getRank(H18)[0]);
//		System.out.println(getRank(H19)[0]);
		System.out.println(getRank(H20)[0]);

	}

	private static int[] getRank(String[] hand) {
		int[] score = new int[10];
		ArrayList<Integer> cardValues = new ArrayList<>();
		ArrayList<String> cardSuites = new ArrayList<>();
		int[] v = new int[5];
		String[] s = new String[5];

		for (int i = 0; i < hand.length; i++) {
			String card = hand[i];
			cardValues.add(getValue(card.charAt(0)));
			cardSuites.add(card.charAt(1) + "");
		}
		Collections.sort(cardValues);
		Collections.sort(cardSuites);

		for (int i = 0; i < 5; i++) {
			v[i] = cardValues.get(i);
			s[i] = cardSuites.get(i);
		}

		if (royalFlush(v, s)) {
			score[0] = 10;
			return score;
		}

		if (s[0].equals(s[4])) {
			if (v[0] == v[1] + 1 && v[0] == v[2] + 2) {
				if (v[0] == v[3] + 3 && v[0] == v[4] + 4) {
					score[0] = 9; // straightFlush
					score[1] = v[4];
					return score;
				}
			}
		}

		if (v[0] == v[3]) {
			score[0] = 8; // four of a kind
			score[1] = v[0];
			score[2] = v[4];
			return score;
		}

		if (v[1] == v[4]) {
			score[0] = 8; // four of a kind
			score[1] = v[1];
			score[2] = v[0];
			return score;
		}

		if (v[0] == v[2]) {
			if (v[3] == v[4]) {
				score[0] = 7; // full house
				score[1] = v[0];
				score[2] = v[3];
				return score;
			}
		}

		if (v[2] == v[4]) {
			if (v[0] == v[1]) {
				score[0] = 7; // full house
				score[1] = v[2];
				score[2] = v[0];
				return score;
			}
		}

		if (s[0].equals(s[4])) {
			score[0] = 6; // flush
			score[1] = v[4];
			score[2] = v[3];
			score[3] = v[2];
			score[4] = v[1];
			score[5] = v[0];
			return score;
		}

		if (v[0] == (v[1] - 1) && v[1] == (v[2] - 1)) {
			if (v[2] == (v[3] - 1) && v[3] == (v[4] - 1)) {
				score[0] = 5; // straight
				score[1] = v[4];
				return score;
			}
		}

		if (cardValues.get(0) == cardValues.get(2)) {
			score[0] = 4; // Three of a Kind
			score[1] = v[0];
			score[2] = v[4];
			score[3] = v[3];
			return score;
		}
		else if (cardValues.get(1) == cardValues.get(3)) {
			score[0] = 4; // Three of a Kind
			score[1] = v[1];
			score[2] = v[4];
			score[3] = v[0];
			return score;
		}
		else if (cardValues.get(2) == cardValues.get(4)) {
			score[0] = 4; // Three of a Kind
			score[1] = v[0];
			score[2] = v[1];
			score[3] = v[0];
			return score;
		}

		if (cardValues.get(0) == cardValues.get(1)) {
			if (cardValues.get(2) == cardValues.get(3)) {
				score[0] = 3; // two pair
				score[1] = v[3];
				score[2] = v[0];
				score[3] = v[4];
				return score;
			}
			if (cardValues.get(3) == cardValues.get(4)) {
				score[0] = 3; // two pair
				score[1] = v[4];
				score[2] = v[0];
				score[3] = v[2];
				return score;
			}
			score[0] = 2;// just a pair
			score[1] = v[0]; // value of the pair
			score[2] = v[4]; // highest value outside pair
			score[3] = v[3];
			score[3] = v[2];
			return score;
		}

		if (cardValues.get(1) == cardValues.get(2)) {
			if (cardValues.get(3) == cardValues.get(4)) {
				score[0] = 3; // two pair add value later
				score[1] = v[4]; // value of bigger pair
				score[2] = v[4]; // value of smaller pair
				score[3] = v[0];// highest value outside pairs
				return score;
			}
			score[0] = 2;// just a pair add value later
			score[1] = v[2]; // value of the pair
			score[2] = v[4]; // highest value outside pair
			score[3] = v[3];
			score[3] = v[0];
			return score;
		}
		if (cardValues.get(2) == cardValues.get(3)) {
			score[0] = 2; // just a pair
			score[1] = v[3]; // value of the pair
			score[2] = v[4]; // highest value outside pair
			score[3] = v[1];
			score[3] = v[0];
			return score;
		}
		if (cardValues.get(3) == cardValues.get(4)) {
			score[0] = 2; // just a pair
			score[1] = v[4]; // value of the pair
			score[2] = v[2]; // highest value outside pair
			score[3] = v[1];
			score[3] = v[0];
			return score;
		}

		if (score[0] == 0) {
			score[0] = 1; // no ranks
			score[1] = v[4]; // highest value
			score[2] = v[3];
			score[3] = v[2];
			score[3] = v[1];
			score[3] = v[0];
			return score;
		}

		return score; // highest value
	}

	private static void getWords() throws IOException {

		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p054_poker.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String line;
		while ((line = br.readLine()) != null) {
			String[] hand = line.split("\\s+");
			player1.add(Arrays.copyOfRange(hand, 0, 5));
			player2.add(Arrays.copyOfRange(hand, 5, hand.length));
		}

		br.close();
	}

	private static int getValue(char c) {
		HashMap<Character, Integer> valueMap = new HashMap<Character, Integer>() {
			{
				put('2', 2);
				put('3', 3);
				put('4', 4);
				put('5', 5);
				put('6', 6);
				put('7', 7);
				put('8', 8);
				put('9', 9);
				put('T', 10);
				put('J', 11);
				put('Q', 12);
				put('K', 13);
				put('A', 14);
			}
		};
		return valueMap.getOrDefault(c, 0);
	}

	private static boolean royalFlush(int[] v, String[] s) {
		String stringValues = "" + v[0] + v[1] + v[2] + v[3] + v[4];
		String stringSuites = s[0] + s[1] + s[2] + s[3] + s[4];

		if (stringValues.equals("1011121314")) {
			if (stringSuites.equals("HHHH") || stringSuites.equals("DDDD")) {
				return true;
			}
			if (stringSuites.equals("HHHH") || stringSuites.equals("DDDD")) {
				return true;
			}
		}
		return false;
	}

}
//	"\\s+(?=[^\\s]*$)"

//\\s+    - whitspace for 1 or more characters
//(?=  )  - a group that is not included. will not be used up by the split
//[^\\s]* - not whitespace for any amount of characters
//$       - end of line

//In the card game poker, 
//a hand consists of five cards and are ranked, 
//from lowest to highest, in the following way:
//
//High Card: Highest value card.
//One Pair: Two cards of the same value.
//Two Pairs: Two different pairs.
//Three of a Kind: Three cards of the same value.
//Straight: All cards are consecutive values.
//Flush: All cards of the same suit.
//Full House: Three of a kind and a pair.
//Four of a Kind: Four cards of the same value.
//Straight Flush: All cards are consecutive values of same suit.
//Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

//The cards are valued in the order:
//2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
//
//If two players have the same ranked hands then the rank made up of the highest value wins; 
//for example, a pair of eights beats a pair of fives (see example 1 below). 
//But if two ranks tie, for example, both players have a pair of queens, 
//then highest cards in each hand are compared (see example 4 below); 
//if the highest cards tie then the next highest cards are compared, and so on.