package za.co.perago.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.perago.model.*;
import za.co.perago.services.DiffEngine;
import za.co.perago.services.DiffingService;
import za.co.perago.exceptions.DiffException;


@Service
public class DiffingServiceImpl implements DiffingService{
	
	 @Autowired
	    private DiffEngine diffEngine;

	    @Override
	    public Diff<Person> diffObject(Person original, Person modified) {
	        Diff<Person> diff = null;
	        try {
	            diff = diffEngine.calculate(original, modified);
	        } catch (DiffException ex) {
	            Logger.getLogger(DiffingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return diff;
	    }


}
