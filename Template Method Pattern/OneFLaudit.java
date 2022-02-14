package assignment01;

import static assignment01.Gened.*;

import java.util.List;

public class OneFLaudit extends DegreeWorks {

	@Override
	public boolean foreignLanguageAudit(List<Course> courses) {
		// TODO
		// Loop through the Course c in courses, if c.geneds() contains
		// FL1 or FL2 or FL3 return true;
		for (var course: courses) {
			if (course.geneds().contains(FL3) || course.geneds().contains(FL2) || course.geneds().contains(FL1) )
				System.out.println("Has a:"+Resource.languageOf(course));
				return true;
		}

		return false;
	}

}
