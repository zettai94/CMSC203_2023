

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		char letter;
		int convert;
		for(int i = 0; i < plainText.length(); i++)
		{
			//take letter at plainText and assign to convert of type int
			letter = plainText.charAt(i);
			convert = letter;
			
			//if convert is smaller than 32 and larger than 95, return false
			if(convert < LOWER_RANGE || convert > UPPER_RANGE)
			{
				//System.out.println(convert);
				return false;
			}
			//System.out.println(convert);
		}
		return true;
	}


	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		char letter;
		int convert, addConvert;
		int withinASCIIRange = 128;
		
		//return string indicating out of bound
		if (!plainText.equals(plainText.toUpperCase()))
		{
			String negative = "The selected string is not in bounds, Try again.";
			return negative;
		}
		
		//initialize an accumulator string
		String encryptLine= "";
		for (int i = 0; i < plainText.length(); i++)
		{
			convert = plainText.charAt(i);
			addConvert = convert + key;
			if(addConvert > 127)
			{
				letter = (char) (addConvert - withinASCIIRange);
			}
			else
			{
				letter = (char)addConvert;
			}
			//convert int addConvert to data type char, assign to letter
			encryptLine += letter;
			
		}
		return encryptLine;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		int convertCombine;
		char letter;
		String encryptBell = "";
		int withinASCIIRange = 128;
		
		//if bellasoStr is longer than plainText
		if (bellasoStr.length() > plainText.length())
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				convertCombine = (int) (plainText.charAt(i) + bellasoStr.charAt(i));
				if (convertCombine > withinASCIIRange)
				{
					convertCombine -= RANGE;
				}
				
				if (convertCombine > UPPER_RANGE)
				{
					convertCombine -= RANGE;
				}

				letter = (char) convertCombine;

				encryptBell += letter;
			}
		}
		
		//if plainText longer than bellasoStr
		else if (plainText.length() > bellasoStr.length())
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				convertCombine = (int) (plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length()));
				if (convertCombine > withinASCIIRange)
				{
					convertCombine -= RANGE;
				}
				
				if (convertCombine > UPPER_RANGE)
				{
					convertCombine -= RANGE;
				}
				letter = (char) convertCombine;
				encryptBell += letter;
			}
		}
		else
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				convertCombine = (int) (plainText.charAt(i) + bellasoStr.charAt(i));
				letter = (char) (convertCombine - RANGE);
				encryptBell += letter;
			}
		}
		
		return encryptBell;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		char letter;
		int convert;
		//mke line a String accumulator
		String line = "";
		int withinASCIIRange = 128;
		
		for (int i = 0; i < encryptedText.length(); i++)
		{
			convert = (int) encryptedText.charAt(i) - key;
			//if convert is less than 0, add 128 to make it within ASCII range
			while (convert < 0)
			{
				convert +=  withinASCIIRange;
			}
			
			//if convert is more than UPPER_RANGE, deduct RANGE
			if (convert > UPPER_RANGE)
			{
				convert -= RANGE;
			}
			//if convert is less than LOWER_RANGE, add Range
			else if(convert < LOWER_RANGE)
			{
				convert+= RANGE;
			}
			letter = (char) convert;
			line += letter;
		}
		return line;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		int convertCombine;
		char letter;
		//initialize an accumulator String
		String decryptBell = "";
		
		if (encryptedText.length() > bellasoStr.length())
		{
			for (int i = 0; i < encryptedText.length(); i++)
			{
				convertCombine = (int) (encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length()));
				//while convertCombine less than LOWER_RANGE, add RANGE
				while (convertCombine < LOWER_RANGE)
				{
					convertCombine += RANGE;
				}
				letter = (char) convertCombine;
				decryptBell += letter;
			}
		}
		else if (bellasoStr.length() > encryptedText.length())
		{
			for (int i = 0; i < encryptedText.length(); i++)
			{
				convertCombine = (int) (encryptedText.charAt(i) - bellasoStr.charAt(i));
				//while convertCombine less than LOWER_RANGE, add RANGE
				while (convertCombine < LOWER_RANGE)
				{
					convertCombine += RANGE;
				}
				
				letter = (char) convertCombine;
				decryptBell += letter;
			}
		}
		return decryptBell;
	}
}
