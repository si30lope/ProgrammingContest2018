import java.util.*;
public class PunchCard {
	
	static Scanner sc = new Scanner(System.in);
	
	public static boolean checkDeck(int[][][] deck, int deckSize) {
		
		for(int cardNum = 0; cardNum < deck.length; cardNum++ ) {
			for(int x = 0; x < deckSize; x++) {
				for(int y = 0; y < deckSize; y++) {
					deck[cardNum][x][y] = sc.nextInt();
				}
			}
		}
		
		int[][] baseCard = deck[0];
		ArrayList<Integer> holes = getHoles(baseCard);
		for (int i = 0; i < holes.size(); i+=2) {
			boolean found = true;
			int x = holes.get(i);
			int y = holes.get(i+1);
			int n = deckSize;
			
			
			for(int j = 1; j < deck.length; j++) {
				int[][] currentCard = deck[j];
					if(!(currentCard[x][y] == 0 || currentCard[x][n-1-y]==0 || currentCard[n-1-x][y] == 0 || currentCard[n-1-x][n-1-y] == 0 ||
				       currentCard[y][x] == 0 || currentCard[y][n-1-x]==0 || currentCard[n-1-y][x] == 0 || currentCard[n-1-y][n-1-x] == 0)) {
						found = false;
						break;
					}
			}
			if(found) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public static ArrayList<Integer> getHoles(int[][]deck){
		ArrayList<Integer> answer = new ArrayList<>();
		for(int x = 0; x < deck.length; x++)
		{
			for(int y = 0; y < deck.length; y++)
			{
				if(deck[x][y] == 0) {
					answer.add(x);
					answer.add(y);
				}
			}
		}
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int numDecks = sc.nextInt();
		for(int i = 0; i < numDecks; i++) {
			//int[] decks = new int[numDecks];
			int deckSize = sc.nextInt();
			int numCards = sc.nextInt();
			int[][][] currentDeck = new int[numCards][deckSize][deckSize];
			boolean found = checkDeck(currentDeck, deckSize);
			if(found)
			{
				System.out.println("TRUE");
			}
			else {
				System.out.println("FALSE");
			}
		}
	}
}
