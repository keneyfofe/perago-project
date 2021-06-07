package za.co.perago;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.perago.model.Diff;
import za.co.perago.model.Person;
import za.co.perago.model.Pet;
import za.co.perago.exceptions.DiffException;
import za.co.perago.services.DiffEngine;

@SpringBootTest
public class ClassDiffingApplicationTests {
	@Autowired
    private DiffEngine diffEngine;

    Person original = null;
    Person modified = null;
    Pet pet = null;

    @BeforeEach
    public void setUp() throws Exception {
        original = new Person();
        original.setFirstName("Mike");
        original.setSurname("Tyson");

        pet = new Pet();
        pet.setName("Lucky");
        pet.setType("Dog");


        modified = new Person();
        modified.setFirstName("Donald");
        modified.setSurname("Trump");
        modified.setPet(pet);

    }

    @Test
    public void createNewObject() {
        Diff<Person> diff = null;
        try {
            diff = diffEngine.calculate(null, original);
            assertEquals(original, diff.getObj());
        } catch (DiffException ex) {
            Logger.getLogger(ClassDiffingApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Created: " + diff);
    }

    @Test
    public void updateObject() {
        Diff<Person> diff = null;
        try {
            diff = diffEngine.calculate(original, modified);
            assertNotEquals(original, diff.getObj());
        } catch (DiffException ex) {
            Logger.getLogger(ClassDiffingApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Updated: " + diff);
    }

    @Test
    public void deleteObject() {
        Diff<Person> diff = null;
        try {
            diff = diffEngine.calculate(original, null);
            assertEquals(null, diff.getObj());
        } catch (DiffException ex) {
            Logger.getLogger(ClassDiffingApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Deleted: " + diff);
    }
	

}
