import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

public class StackingRings {
	
 	private static ArrayList<Ring> rings = new ArrayList<>();
 	

	private static class Ring implements Comparable<Ring> {
		
		double d;
		double hex;
		
		public Ring() {}
		public static Ring makeRing() {
			return new Ring();
		}

		public int compareTo (Ring other) {
			if (this.d < other.d){return -1;}
			if (this.d > other.d){return 1;}
			return 0;
		}
		@Override
		public String toString() {
			return d + "\t" + hex + "\n";
		}
	}	
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseCount = sc.nextInt();
		
		
		for(int i = 0; i < caseCount; i++){
		
			int ringCount = sc.nextInt();

			rings = new ArrayList<>();
			
			for (int j = 0; j < ringCount; j++) {
				
				double num = sc.nextDouble();
				
				//System.out.println("READ  " +num);
				
				String heck = sc.next();
				
				//System.out.println("READ " + heck);

				Ring r = Ring.makeRing();;
				r.d = num;
				r.hex = getHue(heck);

				rings.add(r);

			}

			Collections.sort(rings);
		
			boolean isSorted=true;
			for(int k = 1; k < rings.size(); k++) {
				if(rings.get(k-1).hex > rings.get(k).hex) {
					isSorted = false;
					break;
				}
			}
			
			if(isSorted) {System.out.println("RAINBOW ORDER");}
			else {System.out.println("NOT RAINBOW ORDER");}
			
			//System.out.println(rings);
		
		}
		sc.close();
		
	}
	

	 static double getHue(String h){
		String x = h.substring(1,3);
		String y = h.substring(3,5);
		String z = h.substring(5,7);

		int r = hexToNum(x);
		int g = hexToNum(y);
		int b = hexToNum(z);

		//System.out.println(r);
		//System.out.println(g);
		//System.out.println(b);
		
		double large =(double) Math.max(Math.max(r,g),b);
		double small = (double)Math.min(Math.min(r,g),b );

		//System.out.println("large: " + large);
		//System.out.println("small: " + small);
		
		if(r == large){
			return (60*(g-b)/(large-small) + 720) % 360;
		}
		if(g == large) {
			return (60*(2+(b-r)/(large-small)) + 720)%360;
		}
		
		return (60*(4+(r-g)/(large-small)) + 720)%360;
		

		
	}

	 static int hexToNum(String h) {

		int val;

		char big = h.charAt(0);
		if(big >= 'A'){
			val = (big-'A' + 10);

		}
		else{
			val = (big - '0');
		}

		val*=16;


		int sal;
		char small = h.charAt(1);
		if(small >= 'A'){
			sal = (small-'A' + 10);

		}
		else{
			sal = (small) - '0';
		}

		val+=sal;

		return val;



	}

	
}