package week3Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List l = new ArrayList(Arrays.asList(200,10,56,85,36,97,100));
		
		int size = l.size();
		System.out.println("Before Sorting: "+l);
		Collections.sort(l);
		System.out.println("After Sorting: "+l);
		System.out.println("The second largest element is: "+l.get(size-2));				
	}

}
