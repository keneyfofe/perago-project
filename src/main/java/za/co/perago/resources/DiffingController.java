package za.co.perago.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.perago.exceptions.DiffException;
import za.co.perago.model.Diff;
import za.co.perago.model.Person;
import za.co.perago.services.DiffingService;

@RestController
@RequestMapping("/api/diffing/v1")
public class DiffingController {

	@Autowired
	private DiffingService diffingService;

	@PostMapping("/diff")
	public Diff<Person> createObject(@RequestBody List<Person> objects) {
		if (objects.size() < 2 || objects.size() > 2) {
			throw new DiffException();
		}
		return diffingService.diffObject(objects.get(0), objects.get(1));
	}

}
