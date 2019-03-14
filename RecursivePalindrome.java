import java.util.*;
public class RecursivePalindrome {
	
	
	
	static HashMap<String, Boolean> set = new HashMap();
	
	
	public static void main(String[]args)
	{
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int num = sc. nextInt();
		for(int i = 0; i < num; i++)
		{
			String toTest = sc.next();
			//toTest = removeSpaces(toTest);
			if(toTest.length() < 7 && isQuasiPalindrome(toTest)) {
				System.out.println("YES");
			}
			else {
				boolean pal = isRecQp(toTest);
				
				set.put(toTest, pal);
			
				if(pal) {System.out.println("YES");}
				else {System.out.println("NO");}
			}
		}
		sc.close();
	}
	
	public static String reverse(String str)
	{
		String answer = "";
		for(int i = str.length() - 1; i >=0; i--)
		{
			answer += str.substring(i, i+1);
		}
		return answer;
	}
	
	public static String removeSpaces(String str)
	{
		String answer = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) != ' ') {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
	
	public static boolean isQuasiPalindrome(String str) {
		boolean found = true;
		int differences = 0;
		for(int i = 0; i < (str.length() / 2); i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				if(differences == 0)
					differences += 1;
				else {
					found = false;
					break;
				}	
			}
		}
		return found;
	}
	
	
	public static boolean isRecQp(String str) {
		
		if(str.length() < 25) {
		if(set.containsKey(str)) {
			return set.get(str);
		}
		}
		
		
		if(str.length() < 1) {
			return false;
		}
		
		if(str.length() < 4) {return true;}
		
		if(!isQuasiPalindrome(str))
		{return false;}
		
		if(str.length() < 7) {
			return true;
		}
		for(int i =1; i < str.length(); i++) {
			if(isRecQp(str.substring(0,i)) && isRecQp(str.substring(i))) {
				
				return true;
			}
		}
		
		return false;
		
	}
	
}
