package es.palma.factu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.TipivaDetDto;
import es.palmademallorca.factu.service.FactuService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=FactuApp.class)
public class TiIvaVigentTest {
	
	@Autowired
	FactuService factuService;
	
	@Test
	public void test() throws ParseException {
		String tipivaId="3";  //2 o 3
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Date fecha = df.parse("10-NOV-2017");
		TipivaDetDto tipiva=factuService.getTipivaDetVigent(tipivaId, fecha);
        System.out.println("### Tipus iva vigent a:10-NOV-2017"+"  -->"+tipiva);
		assert(tipiva!=null);
	}
	
	@Test
	public void test1() throws ParseException {
		String tipivaId="3";  //2 o 3
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Date fecha = df.parse("10-OCT-2015");
		TipivaDetDto tipiva=factuService.getTipivaDetVigent(tipivaId, fecha);
		System.out.println("### Tipus iva vigent a:10-OCT-2015"+"  -->"+tipiva);
		assert(tipiva!=null);
	}
	
	@Test
	public void test2() throws ParseException {
		String tipivaId="3";  //2 o 3
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Date fecha = df.parse("10-OCT-2011");
		TipivaDetDto tipiva=factuService.getTipivaDetVigent(tipivaId, fecha);
		  System.out.println("### Tipus iva vigent a:10-OCT-2011"+"  -->"+tipiva);
		assert(tipiva!=null);
	}
	
	@Test
	public void test3() throws ParseException {
		String tipivaId="3";  //2 o 3
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Date fecha = df.parse("10-OCT-2009");
		TipivaDetDto tipiva=factuService.getTipivaDetVigent(tipivaId, fecha);
		  System.out.println("### Tipus iva vigent a:10-OCT-2009"+"  -->"+tipiva);
		assert(tipiva!=null);
	}


}
