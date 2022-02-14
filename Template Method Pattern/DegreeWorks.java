package assignment01;

import static assignment01.Gened.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
	

public abstract class DegreeWorks {
	public boolean genedAudit(List<Course> courses) {
		boolean satisfied = false;
		// check A, C, G, H, L, M, N, O, P, S, Y
		//satisfied = satisfied && foreignLanguageAudit(courses);
		satisfied = foreignLanguageAudit(courses);
		satisfied =checkCO(courses) && satisfied;
		
		var iter = courses.iterator();
		while(iter.hasNext()){
			var course = iter.next();
			course.geneds().remove(C);
			course.geneds().remove(O);
			course.geneds().remove(J);
			course.geneds().remove(FL1);
			course.geneds().remove(FL2);
			course.geneds().remove(FL3);
			if(course.geneds().size() == 0) iter.remove();
			// you get a concurrent modification Exception if you loop through the 
			// ArrayList instead of using an Iterator
		}
		courses.sort(Comparator.comparingInt(course -> course.geneds().size()));
		
		var genedGroupList = new ArrayList<TreeSet<Gened>>(); // work with a list of sets of Geneds
		var t = new TreeSet<Gened>(); // make an empty set of Geneds to start with
		genedGroupList.add(t); // add it to genedGroupList
		for (var course: courses) {
			var newList = new ArrayList<TreeSet<Gened>>();
			for (var grp : genedGroupList) {
				for (var g : course.geneds()) {
					TreeSet<Gened> grp1 = (TreeSet<Gened>)grp.clone();
					grp1.add(g);
					newList.add(grp1);
				}
				genedGroupList = newList;
				//System.out.println(genedGroupList);
			}
		}
		
		return checkGened(genedGroupList) &&  satisfied;
	}
	public abstract boolean foreignLanguageAudit(List<Course> courses);


	public boolean checkCO(List<Course> courses) {
		for (var c : courses)
			if (c.geneds().contains(C) || c.geneds().contains(O) && c.geneds().contains(J))
				return true;
			System.out.println("Still need Course C or J or O");
		return false;
		
	}
	
	public boolean checkGened(List<TreeSet<Gened>> genedGroupList) {
		for (var grp : genedGroupList) {
			if (grp.contains(B)) {
				grp.add(S);
				grp.add(Y);
				grp.remove(B);
			}
		}
		for (var grp: genedGroupList) {
			if (grp.size()==9)
				return true;
		}
		for(var g : Set.of(A, G, H, L, M, N, P, S, Y)) {
			boolean hasG = false;
			for(var grp : genedGroupList) {
				if(grp.contains(g)) hasG = true;
			}
			if(!hasG) System.out.println("still need " + g + " course");
		}
		return false;

	}
	
}

	
