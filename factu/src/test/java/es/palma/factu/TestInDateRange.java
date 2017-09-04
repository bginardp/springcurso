package es.palma.factu;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestInDateRange {
	 
    private static Validator validator;
    
    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void testDateRange() {
        SomeBean test = new SomeBean();
        LocalDate localDate = LocalDate.now();
        test.setDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        Set<ConstraintViolation<SomeBean>> validate = validator.validate(test);
        System.out.println(validate);
        assertEquals(1, validate.size());
        assertEquals("date", validate.iterator().next().getPropertyPath().toString());
    }
}
