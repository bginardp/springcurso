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
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@Test
	public void getPeopleTest(){
		int size = personService.getPeople().size();
		personService.save(new PersonDto(2l,"José","Arrecio"));
		Assert.assertTrue(personService.getPeople().size()
				== size + 1 );
	}
	
	/**
	 * Consulta de persona por ID
	 */
	@Test
	public void getPersonTest(){
		Assert.assertTrue(
				personService.getPerson(1l)!=null
		);
	}
	
	/**
	 * Guardado de persona con el mismo ID
	 */
	@Test
	public void savePersonTest(){
		int size = personService.getPeople().size();
		personService.save(new PersonDto(1l,"José","Arrecio"));
		Assert.assertTrue(personService.getPeople().size()
				== size );
		Assert.assertTrue(
				personService.getPerson(1l).getName()
				.equals("José")
		);
	}
	
	@Test
	public void removePersonTest(){
		int size = personService.getPeople().size();
		personService.save(new PersonDto(3l,"José","Arrecio"));
		personService.remove(3l);
		Assert.assertTrue(
				personService.getPeople().size()
				== size
		);
	}
	
	
	
}
