import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author katja
 *
 */
public class game {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		newGame(reader);
		String answer = "";
		do{
			System.out.println("Do you want to play again? [y/n]");
			answer = reader.next();
			if (answer.equals("y")) {
				newGame(reader);
			}else if (answer.equals("n")){
				System.out.println("Thank you for playing.");
				reader.close();
				break;
			} else {
				System.out.println("Not a valid answer. Please enter y for yes and n for no.");
			}
		}while(true);
	}
	
	private static void newGame(Scanner reader){
	//	Scanner reader = new Scanner(System.in);
		board myboard = new board();
		Stone player = myboard.whosTurn();
		System.out.println("Player " + player + " starts.");
		
		Random random = new Random();
		int x = 0;
		int y = 0;
		for (int i= 1; i< 100; i++){
			x = random.nextInt(5);
			y = random.nextInt(5);
			System.out.println("Player " + player.toString() + " puts his stone into (" + (x+1) + ", " + (y+1) + ")");
			if (myboard.setStone(x, y, player).equals(player)){
				System.out.println("Game ends.");
				break;
			}
			myboard.print();
			player = player.switchColor();

			System.out.println("Enter row:");
			x = reader.nextInt()-1;
			System.out.println("Enter column:");
			y = reader.nextInt()-1;
			System.out.println("Player " + player.toString() + " puts his stone into (" + (x+1) + ", " + (y+1) + ")");
			if (myboard.setStone(x, y, player).equals(player)){
				System.out.println("Game ends.");
				break;
			}
			myboard.print();
			player = player.switchColor();
		}
	}

}
