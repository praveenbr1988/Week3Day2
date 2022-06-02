package week3Day2;

import java.util.HashSet;
import java.util.Set;



public class PrintOnlyUniqueCharsUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="babu";
		char[] chararr = s.toCharArray();
		Set stringset = new HashSet();
		System.out.println(chararr);
		for (char c : chararr) {
			if(!stringset.contains(c)) 
				stringset.add(c);
			else
				stringset.remove(c);
		}
		System.out.println(stringset);
	}
}
