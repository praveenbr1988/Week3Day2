package week3Day2;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesUsingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "We learn java basics as part of java sessions in java week1";
		int count;
		String [] stringarr = s.split(" ");
		List<String> list = new ArrayList<String>();
		for (String string : stringarr) {
			list.add(string);
		}
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			count=0;
			for(int j=0; j<stringarr.length;j++) {
				if(list.get(i).equals(stringarr[j])) {
					count++;
				}
			}
			
			if(count>1) {
				
				s = s.replace(list.get(i), "");
			}
			
			System.out.println(i+ " "+list.get(i)+ " Count: "+count);
			
		}
		
		System.out.println(s);
		
	}

}
