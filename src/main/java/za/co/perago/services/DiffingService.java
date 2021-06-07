package za.co.perago.services;

import za.co.perago.model.Diff;
import za.co.perago.model.Person;

public interface DiffingService {
	Diff<Person> diffObject(Person original, Person modified);
}
