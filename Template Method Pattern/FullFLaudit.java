 package assignment01;

import static assignment01.Gened.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FullFLaudit extends DegreeWorks {

	@Override
	public boolean foreignLanguageAudit(List<Course> courses) {
		// TODO 
		// Loop through the Course c in courses, if c.geneds() contains
		// FL3 return true;
		for (var course: courses) {
			if (course.geneds().contains(FL3))
				return true;
		}
		Set<String> langNames = new TreeSet<>();
		for (var course: courses) {
			if (course.geneds().contains(FL2)) {
				Resource.languageOf(course);
			}
		}
		if (langNames.size() > 1) 
			return true;
		
		// continuing we know that we did not find FL3:
		// Create Set<String> langNames = new TreeSet<>();
		// Loop through the Course c in courses, if c.geneds() contains
		// FL2 add Resource.languageOf(c) to langNames
		// if langNames.size() > 1 return true;
		return false; // this line stays at the end
	}

}
