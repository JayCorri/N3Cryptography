/*
 * **************************************************************************
 * 																			*
 * CISC 190 - 05/26/2017													*
 * Extra Credit																*
 * Douglas Corrigan - May 26, 2017											*
 * 																			*
 * 																			*
 * Brief Description:														*
 * The MatrixOperations class contains different calculations for arrays.	*
 * Note the terms matrix and array are interchangeable.						*
 * 																			*
 * The operations include:													*
 * Determine if a 3x3 matrix is invertible									*
 * Return the inverse of a 3x3 matrix										*
 * Print a 3x3 matrix														*
 * Compare two matrices														*
 * 																			*
 * 																			*
 * Special Classes:															*
 * none																		*
 * 																			*
 * 																			*
 * Detailed Notes on Code:													*
 * Extra Credit.															*
 * 																			*
 * 																			*
 * **************************************************************************
 */
/**
 * The MatrixOperations class contains different calculations for arrays.<br>*Note the terms matrix and array are interchangeable.<br>
 * <br>
 * The operations include:<ul>Determine if a 3x3 matrix is invertible<br>Return the inverse of a 3x3 matrix (still under construction)<br>Print a 3x3 matrix<br>Compare two matrices</ul>
 * @author Douglas Corrigan
 *
 */
public class MatrixOperations {

	boolean result;
	double determinant;
	char charArray[][];
	public MatrixOperations()
	{
		determinant = 0;
	}
	/**
	 * Returns true if key is a double[3][3]
	 * @param key
	 * @return
	 */
	public boolean n3Matrix(double[][] key)
	{
		if(key.length == 3)
			if(key[0].length == 3)
				result = true;
			else result = false;
		return result;
	}
	/**
	 * Returns true if the key is an invertible 3x3 matrix
	 * @param key
	 * @return
	 */
	public boolean checkInvertibleMatrix(double[][] key)
	{
		double det = key[0][0] * (key[1][1] * key[2][2] - key[2][1] * key[1][2])
						- key[0][1] * (key[1][0] * key[2][2] - key[2][0] * key[1][2])
						+ key[0][2] * (key[1][0] * key[2][1] - key[2][0] * key[1][1]);
		if(det != 0)
			return true;
		else return false;
	}
	/**
	 * Returns the determinant of a 3x3 matrix
	 * @param key - double[3][3]
	 * @return
	 */
	public double determinant(double[][] key)
	{
		determinant = key[0][0] * (key[1][1] * key[2][2] - key[2][1] * key[1][2])
				- key[0][1] * (key[1][0] * key[2][2] - key[2][0] * key[1][2])
				+ key[0][2] * (key[1][0] * key[2][1] - key[2][0] * key[1][1]);
		return determinant;
	}
	public double[][] getInverse(double[][] key)
	{
		determinant = determinant(key);
		double[][] keyInverse = new double[3][3];
		double m11 = key[0][0];
		double m12 = key[0][1];
		double m13 = key[0][2];
		double m21 = key[1][0];
		double m22 = key[1][1];
		double m23 = key[1][2];
		double m31 = key[2][0];
		double m32 = key[2][1];
		double m33 = key[2][2];
		keyInverse[0][0] = (1/determinant) * (m22 * m33 - m32 * m23); 
		keyInverse[0][1] = (1/determinant) * (m13 * m32 - m33 * m12);
		keyInverse[0][2] = (1/determinant) * (m12 * m23 - m22 * m13);
		keyInverse[1][0] = (1/determinant) * (m23 * m31 - m33 * m21);
		keyInverse[1][1] = (1/determinant) * (m11 * m33 - m31 * m13);
		keyInverse[1][2] = (1/determinant) * (m13 * m21 - m23 * m11);
		keyInverse[2][0] = (1/determinant) * (m21 * m32 - m31 * m22);
		keyInverse[2][1] = (1/determinant) * (m12 * m31 - m32 * m11);
		keyInverse[2][2] = (1/determinant) * (m11 * m22 - m21 * m12);
		return keyInverse;
	}
	/**
	 * Return boolean[][] testing each element of first == its respective element in second.	
	 * @param first
	 * @param second
	 * @return
	 */
	public boolean[][] matrixEquals(double[][] first, double[][] second)
	{
		int[] dim = new int[2];
		if(first.length == second.length)
			if(first[0].length == second[0].length)
			{
				dim[0] = first.length;
				dim[1] = first[0].length;
			}
			else return null;
		boolean[][] keyCheck = new boolean[dim[0]][dim[1]];
		for(int row = 0; row < first.length; row++)
		{
			for(int col = 0; col < first[0].length; col++)
			{
				if(first[row][col] == second[row][col])
					keyCheck[row][col] = true;
				else keyCheck[row][col] = false;
			}
		}
		return keyCheck;
	}
	/**
	 * Return boolean testing each element of first == its respective element in second.	
	 * @param first
	 * @param second
	 * @return
	 */
	public boolean matrixCompare(double[][] first, double[][] second)
	{
		int[] dim = new int[2];
		if(first.length == second.length)
			if(first[0].length == second[0].length)
			{
				dim[0] = first.length;
				dim[1] = first[0].length;
			}
			else return null != null;
		for(int row = 0; row < first.length; row++)
		{
			for(int col = 0; col < first[0].length; col++)
			{
				if(first[row][col] == second[row][col]);
				else return false;
			}
		}
		return true;
	}
	/**
	 * Check if matrix multiplication is possible.
	 * @param first
	 * @param second
	 * @return
	 */
	public boolean canMultiply(double[][] first, double[][] second)
	{
		if(first[0].length == second.length)
			return true;
		else
			return false;
	}
	/**
	 * Performs matrix multiplication and returns the results.
	 * @param first
	 * @param second
	 * @return
	 */
	public double[][] multiply(double[][] first, double[][] second)
	{
		if(canMultiply(first, second) == false)
			return null;
		int n = first.length;
		int index = first[0].length;
		int m = second[0].length;
		double[][] newMatrix = new double[n][m];
		for(int row = 0; row < n; row++)
			for(int col = 0; col < m; col++)
			{
				for(int i = 0; i < index; i++)
					newMatrix[row][col] = newMatrix[row][col] + first[row][i] * second[i][col];
			}
		return newMatrix;
	}
	public char[][] convertDoubleArrayToCharArray(double[][] d)
	{
		charArray = new char[d.length][d[0].length];
		for(int row = 0; row < d.length; row++)
			for(int col = 0; col < d[0].length; col++)
			{
				int j = (int)d[row][col];
				charArray[row][col] = (char)j;
			}
		return charArray;
	}
	
	public void printMatrix(double[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(int[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(long[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(boolean[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(short[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(String[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(char[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(byte[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
	public void printMatrix(float[][] matrix)
	{
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				if( col == matrix[0].length - 1)
					System.out.print(matrix[row][col]);
				else System.out.print(matrix[row][col] + ", ");
			}
			System.out.println();
		}
	}
}