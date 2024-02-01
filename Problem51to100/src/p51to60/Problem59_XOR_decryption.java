package p51to60;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;

public class Problem59_XOR_decryption {

//	nbrs = getNumbers();
//	System.out.println(nbrs);
	public static void main(String[] args) throws IOException {
		ArrayList<String> commonWords = getCommonWords();
		ArrayList<String> encryptedText = getNumbers();

		byte[] encryptedBytes = convertListToBytes(encryptedText);
		byte[] byteWords = convertListToBytes(commonWords);

		int[] key = {12, 94, 48};
		tryKey(key, encryptedBytes);
//		List<int[]> keys = findEncryptionKey(commonWords, encryptedBytes);
//		System.out.println(keys.size());
//		for(int[] key: keys) {
//			System.out.println(key[0] + ", " + key[1] + ", " + key[2]);
//			 tryKey(key, encryptedBytes);
//		}
		
		//int[] key = findEncryptionKey(commonWords, encryptedBytes);
		//System.out.println(key[0] + ", " + key[1] + ", " + key[2]);

	}

	private static void tryKey(int[] key, byte[] encrypted) {
		// Decryption
		byte[] decrypted = decrypt(encrypted, key);
		//System.out.println("Decrypted bytes (ASCII values): " + Arrays.toString(decrypted));

		// Convert decrypted bytes back to text and print
		String decryptedText = new String(decrypted);
		System.out.println("Decrypted text: " + decryptedText);
	}

	private static void example() {
		String plainText = "Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.";
		int[] key = { 50, 70, 90 }; // Key is made up of 3 ASCII character numbers between 33 and 126
		System.out.println("Original text: " + plainText);

		// Convert plain text to bytes and print the corresponding ASCII values
		byte[] bytes = plainText.getBytes();
		System.out.println("Original bytes (ASCII values): " + Arrays.toString(bytes));

		// Encryption
		byte[] encrypted = encrypt(bytes, key);
		System.out.println("Encrypted bytes (ASCII values): " + Arrays.toString(encrypted));

		// Decryption
		byte[] decrypted = decrypt(encrypted, key);
		System.out.println("Decrypted bytes (ASCII values): " + Arrays.toString(decrypted));

		// Convert decrypted bytes back to text and print
		String decryptedText = new String(decrypted);
		System.out.println("Decrypted text: " + decryptedText);
	}

	public static byte[] encrypt(byte[] input, int[] key) {
		byte[] output = new byte[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = (byte) (input[i] ^ key[i % key.length]);
		}
		return output;
	}

	public static byte[] decrypt(byte[] input, int[] key) {
		return encrypt(input, key); // XOR encryption is symmetric, so decryption is the same as encryption
	}

	private static ArrayList<String> getCommonWords() throws IOException {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\100_common_words";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<String> commonWords = new ArrayList<>();

		while ((line = br.readLine()) != null) {
			String[] nbrArray = line.split(",");
			commonWords.addAll(Arrays.asList(nbrArray));
		}

		br.close();
		return commonWords;
	}

	private static ArrayList<String> getNumbers() throws IOException {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p059_cipher.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<String> numberStrings = new ArrayList<>();

		while ((line = br.readLine()) != null) {
			String[] nbrArray = line.split(",");
			numberStrings.addAll(Arrays.asList(nbrArray));
		}
		br.close();

		String encryptedText = "";
		for (String nbr : numberStrings) {
			encryptedText += nbr;
		}

		return numberStrings;
	}

	public static byte[] convertToByteArray(ArrayList<String> asciiValues) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		for (String asciiValue : asciiValues) {
			byte b = Byte.parseByte(asciiValue);
			byteArrayOutputStream.write(b);
		}
		return byteArrayOutputStream.toByteArray();
	}

	public static byte[] convertListToBytes(ArrayList<String> words) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				outputStream.write((byte) word.charAt(i));
			}
			outputStream.write(' '); // Add space character between words
		}

		return outputStream.toByteArray();
	}

	private static List<int[]> findEncryptionKey(ArrayList<String> commonWords, byte[] encryptedText) {
		int[] bestKey = new int[3];
		List<int[]> keys = new ArrayList<>();
		int maxWords = 0;

		for (int i = 20; i <= 150; i++) {
			for (int j = 20; j <= 150; j++) {
				for (int k = 20; k <= 150; k++) {
					int[] key = { i, j, k };
					byte[] decrypted = decrypt(encryptedText, key);
					int wordCount = countCommonWords(commonWords, decrypted);

					if (wordCount > maxWords) {
						maxWords = wordCount;
						keys.add(key);
						bestKey = key.clone();
					}
				}
			}
		}

		return keys;
	}

	private static int countCommonWords(ArrayList<String> commonWords, byte[] decryptedText) {
		String text = new String(decryptedText);
		int count = 0;

		for (String word : commonWords) {
			if (text.contains(word)) {
				count++;
			}
		}

		return count;
	}
	
	public static List<int[]> findEncryptionKeys(byte[] encryptedText) {
	    List<int[]> keys = new ArrayList<>();

	    for (int i = 33; i <= 126; i++) {
	        for (int j = 33; j <= 126; j++) {
	            for (int k = 33; k <= 126; k++) {
	                int[] key = { i, j, k };
	                byte[] decrypted = decrypt(encryptedText, key);
	                int spaceCount = countSpaces(decrypted);
	                int charCount = decrypted.length;
	                double ratio = (double) spaceCount / charCount;

	                if (ratio >= 0.25 && ratio <= 0.7) {
	                    keys.add(key);
	                }
	            }
	        }
	    }

	    return keys;
	}

	
	private static int countSpaces(byte[] decryptedText) {
	    int count = 0;

	    for (byte b : decryptedText) {
	        if (b == ' ') {
	            count++;
	        }
	    }

	    return count;
	}


}

//Each character on a computer is assigned a unique code and the preferred standard 
//is ASCII (American Standard Code for Information Interchange). 
//For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
//
//A modern encryption method is to take a text file, 
//convert the bytes to ASCII, then XOR each byte with a given value, 
//taken from a secret key. 

//The advantage with the XOR function is that using the same encryption key on the cipher text, 
//restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
//
//For unbreakable encryption, the key is the same length as the plain text message, 
//and the key is made up of random bytes.
//The user would keep the encrypted message and the encryption key in different locations, 
//and without both "halves", it is impossible to decrypt the message.
//
//Unfortunately, this method is impractical for most users, 
//so the modified method is to use a password as a key. 
//If the password is shorter than the message, which is likely, 
//the key is repeated cyclically throughout the message. 
//The balance for this method is using a sufficiently long password key for security, 
//but short enough to be memorable.
//
//Your task has been made easy, as the encryption key consists of three lower case characters.
//Using p059_cipher.txt (right click and 'Save Link/Target As...'),
//a file containing the encrypted ASCII codes, 
//and the knowledge that the plain text must contain common English words,
//decrypt the message and find the sum of the ASCII values in the original text.
