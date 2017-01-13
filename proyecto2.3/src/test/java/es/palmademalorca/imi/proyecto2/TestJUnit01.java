package es.palmademalorca.imi.proyecto2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.imi.proyecto2.SpringBoot;
import es.palmademallorca.imi.proyecto2.dto.PersonDto;
import es.palmademallorca.imi.proyecto2.service.PersonService;


@SpringBootTest(classes=SpringBoot.class)
@RunWith(SpringRunner.class)
public class TestJUnit01 {

	@Autowired
	private PersonService personService;
	
	@Test
	public void test01(){
		org.junit.Assert.assertTrue(
				personService.getPeople().size()
				==1);
	}
	
	@Test
	public void nullAvoidTest(){
		try {
			int size = personService.getPeople().size();
			personService.save(null);
			Assert.assertTrue(size == personService.
										getPeople().size());
		} catch (NullPointerException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void addRemovePersonTest(){
		int sizePrev = personService.getPeople().size();
		PersonDto person = new PersonDto(2l,"José","Arrecio");
		
		personService.save(person);
		Assert.assertTrue(personService.getPeople().size()>sizePrev);
		
		personService.remove(person.getId());
		Assert.assertTrue(personService.getPeople().size()==sizePrev);
	}
	
	
	
	
	
	
	
}
