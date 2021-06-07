package za.co.perago.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.perago.exceptions.DiffException;
import za.co.perago.model.Diff;
import za.co.perago.model.Person;

//this service must implements DiffRenderer interface.
@Service
public class DiffRendererService implements DiffRenderer {
	
	@Autowired
	private DiffRenderer diffRenderer;

	@Override
	public String render(Diff<?> diff) throws DiffException {
		// TODO Auto-generated method stub
		return null;
	}

}
