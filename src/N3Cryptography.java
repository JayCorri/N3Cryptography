import java.util.Scanner;
public class N3Cryptography {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageEncoder Cipher = new MessageEncoder();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please type the message you would like to cipher");
		String message = keyboard.nextLine();
		int i = 0;
		double[][] key = new double[3][3];
		char chosen;
		while(i == 0)
		{
			System.out.println("Would you like to encode this message or decode this message?" 
					+ "\n(Type encode or decode)");
			String choice = keyboard.nextLine();
			choice.toLowerCase();
			chosen = choice.charAt(0);
			switch(chosen)
			{
			case 'e':
				System.out.println("Encode.  If that is correct type y, if not type n.");
				String correct = keyboard.nextLine();
				if(correct.charAt(0) == 'y');
				{
					for(int row = 0; row < 3; row++)
						{
						int rowPrint = row + 1;
						for(int col = 0; col < 3; col++) 	
						{
							int colPrint = col + 1;
							System.out.println("Please enter encoder key (" + rowPrint + "," + colPrint + ")"+ "\n(The program will check to see that your key is a 3x3 invertible matrix)");
							key[row][col] = keyboard.nextDouble();
							}
						}
				}
				break;
			case 'd':
				System.out.println("Decode.  If that is correct type y, if not type n.");
				correct = keyboard.nextLine();
				if(correct.charAt(0) == 'y');
				{
					for(int row = 0; row < 3; row++)
						{
						int rowPrint = row + 1;
						for(int col = 0; col < 3; col++) 	
						{
							int colPrint = col + 1;
							System.out.println("Please enter decoder key (" + rowPrint + "," + colPrint + ")"+ "\n(The program will check to see that your key is a 3x3 invertible matrix)");
							key[row][col] = keyboard.nextDouble();
							}
						}
				}
				break;
			default:
				System.out.println("Invalid entry. Try again.\n");
				break;
			}
		}
		keyboard.close();
		System.exit(0);
	}
}
