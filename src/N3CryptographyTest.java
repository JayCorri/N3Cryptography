/*
 * **************************************************************************
 * 																			*
 * CISC 190 - 05/26/2017													*
 * Extra Credit																*
 * Douglas Corrigan - May 26, 2017											*
 * 																			*
 * 																			*
 * Brief Description:														*
 * This program takes a message, encodes it, decodes it, checks if the		*
 * decoded message matches the original message then deletes all the data.	*
 * 																			*
 * 																			*
 * Special Classes:															*
 * MatrixOperations, MessageEncoder											*
 * 																			*
 * 																			*
 * Detailed Notes on Code:													*
 * Extra Credit.															*
 * 																			*
 * 																			*
 * **************************************************************************
 */
public class N3CryptographyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MatrixOperations mOTest = new MatrixOperations();
		MessageEncoder mETest = new MessageEncoder();
		double[][] key = {{1, -2, 2},
				{-1, 1, 3},
				{1, -1, -4}};
		double[][] keyInverse = {{-1, -10, -8},
				{-1, -6, -5},
				{0, -1, -1}};
		double[][] keyInverseCheck = {{-1, -10, -8},
				{-1, -6, -5},
				{0, -1, -1}};
		boolean testn3Matrix = mETest.n3Matrix(key);
		boolean testInvertibleOps = mETest.checkInvertibleMatrix(key);
		System.out.println("Test key is a 3x3 matrix: " + testn3Matrix);
		System.out.println("Test key is invertible: " + testInvertibleOps);
		double[][]testInverseOps = mETest.getInverse(key);
		System.out.println("Test key is:");
		//test print matrix
		mETest.printMatrix(key);
		System.out.println("\nInverse of test key is:");
		mETest.printMatrix(testInverseOps);
		//test get inverse
		System.out.println("Is getInverse working?");
		boolean[][] trueInverseCheck = mETest.matrixEquals(testInverseOps, keyInverse);
		mETest.printMatrix(trueInverseCheck);
		//test print matrix equals
		System.out.println("Is matrixEquals working properly?");
		boolean[][] keyCheck = mETest.matrixEquals(keyInverseCheck, keyInverse);
		mETest.printMatrix(keyCheck);
		//test toCharArray
		String tester = "Hello Brave New World 1234567890!@#$%^&*()";
		char[] testerChar = tester.toCharArray();
		//mETest.printMatrix(testerChar); **does not function
		//test MessageEncoder.messageMatrix
		System.out.println("Is messageMatrix working?");
		char[][] testerD2Array = mETest.messageMatrix(tester);
		mETest.printMatrix(testerD2Array);
		//test asciiCodedMessage
		System.out.println("Is asciiCodedMessage working?");
		double[][] asciiCoded = mETest.asciiCodedMessage(testerD2Array);
		mETest.printMatrix(asciiCoded);
		//test is encodeMessage working
		System.out.println("Is encodeMessage working?");
		double[][] encode = mETest.encodeMessage(asciiCoded, key);
		mETest.printMatrix(encode);
		//test is decodeMessage working
		System.out.println("Is decodeMessage working?");
		double[][] decode = mETest.encodeMessage(encode, testInverseOps);
		mETest.printMatrix(decode);
		//test does the encryption return to the original message
		System.out.println("Are asciicoded and decode equal?\n" + mETest.matrixCompare(asciiCoded, decode));
		//test arrayToString
		//test the entire process
		System.out.println("Does the entire process return the original message?\nOriginal Message\n" + tester + "\nCiphered and Deciphered message\n" + mETest.arrayToString(decode));
		//test clearAll
		mETest.clearAll();
		System.out.println("Does clearALL work?\n" + mETest);
	}

}
