package week3Day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindIntersectionUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(3,2,11,4,6,7));
		Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(1,2,8,4,9,7));
		
		System.out.println("Set1 contains: "+s1);
		System.out.println("Set2 contains: "+s2);
		System.out.println("Intersecting elements are: ");
		
		for (Integer integer1 : s1) {
			
			for (Integer integer2 : s2) {
				
				if(integer1==integer2) {
					
					System.out.print(integer1+",");
				}
				
			}
			
		}
		
	}
}
