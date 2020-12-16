package object.service;

import java.util.Comparator;


import object.model.Member;

public class MemberLastNameComparator implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		
		return o1.getLastName().compareTo(o2.getLastName());
	}
}