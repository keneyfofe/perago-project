package za.co.perago.services.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import za.co.perago.exceptions.DiffException;
import za.co.perago.model.Diff;
import za.co.perago.services.DiffEngine;

@Service
public class DiffEngineService implements DiffEngine{

	@Override
    public <T extends Serializable> T apply(T original, Diff<?> diff) throws DiffException {

        if (diff == null || (diff.getObj() == null)) {
            return null;
        }

        T clone = original == null ? (T) diff.getObj() : original;

        for (String field : diff.getFields()) {
            try {
                if (original != null) {
                    Field field1 = original.getClass().getDeclaredField(field);
                    field1.setAccessible(true);
                    field1.set(clone, field1.get(diff.getObj()));
                } else {
                    throw new ReflectiveOperationException();
                }

            } catch (ReflectiveOperationException e) {
                throw new DiffException();
            }
        }
        return clone;
    }

    @Override
    public <T extends Serializable> Diff<T> calculate(T original, T modified) throws DiffException {

        List<String> fields = new ArrayList<>();
        Diff<T> diff = null;

        int index = 1;
        String value = null;

        if (original == null && modified != null) {
            diff = new Diff<>();
            diff.setObj(modified);

            List<Field> fieldList = Arrays.asList(modified.getClass().getDeclaredFields());
            for (Field field : fieldList) {
                value = index++ + " Created : " + field.getName();
                diff.setParent(field.getName());
                fields.add(value);
                value = modified.getClass().getName();
            }
            fields.add(0, value);
            diff.setFields(fields);

            return diff;
        }

        if (original != null && modified != null) {
            List<Field> originalFieldList = Arrays.asList(original.getClass().getDeclaredFields());
            List<Field> modifiedFieldList = Arrays.asList(modified.getClass().getDeclaredFields());

            int indexPosition = 0;
            for (Field field : originalFieldList) {
                try {
                    field.setAccessible(true);
                    Field modifiedFiled = modifiedFieldList.get(indexPosition);
                    modifiedFiled.setAccessible(true);
                    
                    Object a = field.get(original);
                    Object b = modifiedFiled.get(modified);
                    if (a != b) {
                        diff = new Diff<>();
                        diff.setObj(modified);
                        value = "Updated " + original.getClass().getName();
                        diff.setParent(value);

                        Object object = original;

                        System.out.println("Oirginal Object :" + object.toString());
                        break;

                    }
                    indexPosition++;
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(DiffEngineService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



            return diff;
        }

        if (original != null && modified == null) {

            diff = new Diff<>();
            //diff.setObj(original);
            value = "Deleted " + original.getClass().getName();
            diff.setParent(value);

            return diff;
        }
        return diff;
    }

}
