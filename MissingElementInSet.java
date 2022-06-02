package week3Day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MissingElementInSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer [] arr = {4,6,7,2,3,1,9,10,8,8,6,2};
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));
		System.out.println(s);
		
		System.out.println("The missing No is: ");
		
		// Creating an instance of Iterator
	    Iterator<Integer> iterate = s.iterator();
	    System.out.println("Iterating over Set:");
	    while(iterate.hasNext()) {
	      
	    	for(int i=0;i<s.size();i++) {
	    	if((iterate.next())!=i+1) {
	    		System.out.println(i+1); 
	    		break;	
	    	}
	    	
	     }
	    	break;

	   }
		 
	}
}
