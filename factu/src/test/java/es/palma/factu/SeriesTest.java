package es.palma.factu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.net.SyslogOutputStream;
import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.service.FactuService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=FactuApp.class)
public class SeriesTest {
	@Autowired
	FactuService factuService;
	
	@Test
	public void test() {
       
       List<SerieDto> series = factuService.findAllSeries(new Long(1));
       series.forEach(e->System.out.println(e));
    	assert(series.size()>0);


		// fail("Not yet implemented");
	}

}
