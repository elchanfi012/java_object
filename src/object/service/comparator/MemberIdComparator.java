package object.service.comparator;

import java.util.Comparator;

import object.model.Member;

public class MemberIdComparator implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		
		return o1.getId().compareTo(o2.getId());
	}

	
}
