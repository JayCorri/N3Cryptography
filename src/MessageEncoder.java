/*
 * **************************************************************************
 * 																			*
 * CISC 190 - 05/26/2017													*
 * Extra Credit																*
 * Douglas Corrigan - May 26, 2017											*
 * 																			*
 * 																			*
 * Brief Description:														*
 * The MessageEncoder class is a extends MatrixOperations.  It converts a 	*
 * a string into a char[n][3], Convert a char[][] into it's int[][] ascii	*
 * counterpart, enciphers the message using the given encoder key and 		*
 * returns the result, deciphers the message according to a decoder key and *
 * returns the result.  Finally, it erases the sensitive information by		*
 * setting every message and key array to null.								*
 * 																			*
 * 																			*
 * Special Classes:															*
 * MatrixOperations															*
 * 																			*
 * 																			*
 * Detailed Notes on Code:													*
 * Extra Credit.															*
 * 																			*
 * 																			*
 * **************************************************************************
 */
/**
 * 
 * @author Douglas Corrigan
 *
 */
public class MessageEncoder extends MatrixOperations {

	private char[][] uncodedMessage;
	private double[][] asciiMessage;
	private double[][] encodedMessage;
	private double[][] decodedMessage;
	private double[][] encoderKey;
	private double[][] decoderKey;
	private MatrixOperations Cipher;
	
 	public MessageEncoder()
	{
		Cipher = new MatrixOperations();
	}
	/**
	 * Convert a string into a char[n][3]
	 * @param message String
	 * @return char[][]
	 */
	public char[][] messageMatrix(String message)
	{
		if(message.length() % 3 == 1)
			message = message + "  ";
		else if(message.length() % 3 == 2)
			message = message + " ";
		//set the number of matrices
		int n = message.length() / 3;
		//create char[]
		char[] messageArray = message.toCharArray();
		uncodedMessage = new char[n][3];
		for(int row = 0; row < uncodedMessage.length; row++)
		{
			for(int col = 0; col < uncodedMessage[0].length; col++)
			{
			uncodedMessage[row][col] = messageArray[col + row * 3];
			}
		}
		return uncodedMessage;
	}
	/**
	 * Convert a char[][] into it's int[][] ascii counterpart
	 * @param message - char[][]
	 * @return int[][]
	 */
	public double[][] asciiCodedMessage(char[][] message)
	{
		asciiMessage = new double[message.length][message[0].length];
		for(int row = 0; row < message.length; row++)
			for(int col = 0; col < message[0].length; col++)
				asciiMessage[row][col] = (double)((int)message[row][col]);
		return asciiMessage;
	}
	/**
	 * Enciphers the message using the given key and returns the result.
	 * @param message
	 * @param encoderKey
	 * @return
	 */
	public double[][] encodeMessage(double[][] message, double[][] encoderKey)
	{
		encodedMessage = Cipher.multiply(message, encoderKey);
		return encodedMessage;
	}
	/**
	 * Deciphers the message and returns the result
	 * @param message
	 * @param decoderKey
	 * @return
	 */
	public double[][] decipherMessage(double[][] message, double[][] decoderKey)
	{
		decodedMessage = Cipher.multiply(message, decoderKey);
		return decodedMessage;
	}
	
	public String arrayToString(double[][] array)
	{
		char[][] ch = new char[array.length][array[0].length];
		ch = Cipher.convertDoubleArrayToCharArray(array);
		String message = "";
		for(int row = 0; row < ch.length; row++)
			for(int col = 0; col < ch[0].length; col++)
				message = message + ch[row][col];
		return message;
	}
	/**
	 * Erases the sensitive information by setting every message and key array to null.
	 */
	public void clearAll()
	{
		uncodedMessage = null;
		asciiMessage = null;
		encodedMessage = null;
		decodedMessage = null;
		encoderKey = null;
		decoderKey = null;
		Cipher = null;
	}
	public String toString()
	{
		String s = uncodedMessage + "\n" + asciiMessage + "\n" + encodedMessage + "\n" 
	+ decodedMessage + "\n" + encoderKey + "\n" + decoderKey + "\n" + Cipher;
		return s;
	}
}
