package object.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import object.manager.ConsoleManager;
import object.model.Member;

public class CompareService {

	public void run() {
			
		Member member3 = new Member(3, "Mick", "Jagger");
		Member member2 = new Member(2, "John", "Doe");
		Member member1 = new Member(1, "Chanfi", "Elhadji");
		Member member4 = new Member(4, "Jane", "Doe");
		
		
		List<Member> members = new ArrayList<Member>(Arrays.asList(member3, member2, member1, member4));
		
		printMembers(members);
		Collections.sort(members, new MemberIdComparator());
		printMembers(members);
		Collections.sort(members, new MemberLastNameComparator());
		printMembers(members);
		Collections.sort(members, new MemberFirstNameComparator());
		printMembers(members);
	}
	
	public void printMembers(List<Member> members) {
		
		ConsoleManager.getInstance().consoleLineBreak();
		for(Member member : members) {
			ConsoleManager.getInstance().printToConsole(member.toString(), true);
		}
		
		ConsoleManager.getInstance().printLine();
		ConsoleManager.getInstance().consoleLineBreak();
	}
}
