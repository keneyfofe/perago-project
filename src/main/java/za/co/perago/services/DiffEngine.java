package za.co.perago.services;

import java.io.Serializable;

import za.co.perago.exceptions.DiffException;
import za.co.perago.model.Diff;
import za.co.perago.model.Person;

/**
 * The Diff Engine that can calculate and apply differences between objects.
 * 
 * Your diff service implementation must comply with this interface 
 *
 */
public interface DiffEngine {
	
	/**
	 * Apply a {@link Person} to an Object
	 * @param <T> The Object's Type to diff
	 * @param original The Object to apply the diff to
	 * @param diff The {@link Person} to apply
	 * @return The Object with the {@link Person} applied to it
	 * @throws DiffException when something goes wrong whilst applying the diff
	 */
	<T extends Serializable> T apply(T original, Diff<?> diff) throws DiffException;
	
	/**
	 * Calculate a {@link Diff} for an Object
	 * @param <T> The Object's Type to diff
	 * @param original The original Object
	 * @param modified The final / modified Object
	 * @return The {@link Person} calculated between the original and modified
	 * @throws DiffException when something goes wrong whilst calculating the diff
	 */
	<T extends Serializable> Diff<T> calculate(T original, T modified) throws DiffException;
}
