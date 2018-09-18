package es.palmademallorca.factu.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.palmademallorca.factu.beans.SimpleReportFiller;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private SimpleReportFiller simpleReportFiller;

	@RequestMapping(value = "/facturas/{idinici}/{idfinal}", method = RequestMethod.GET)
	@ResponseBody
	public void listadoFacturas(HttpServletResponse response,@PathVariable(value="idinici") Long idinici, @PathVariable (value="idfinal") Long idfinal) {
		
// https://github.com/eugenp/tutorials/blob/master/spring-all/src/main/java/org/baeldung/jasperreports/Main.java
		
// 1 compilem subreport i report
		simpleReportFiller.setReportFileName("detall.jrxml");
	    simpleReportFiller.compileReport();
        simpleReportFiller.setReportFileName("factura.jrxml");
        simpleReportFiller.compileReport();
// 2 afegim els paràmetres
        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("title", "Employee Report Example");
//        parameters.put("minSalary", 15000.0);
//        parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

        parameters.put("p_idinici", idinici);
        parameters.put("p_idfinal", idfinal);
        simpleReportFiller.setParameters(parameters);
// 3 executem el report        
        JasperPrint jasperPrint= simpleReportFiller.fillReport();
        
       // simpleExporter.exportToPdf("employeeReport.pdf", "baeldung");
        
       
//            JasperReport jasperReport = JasperCompileManager.compileReport(RESULTS_PDF_REPORT_PATH);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);

// 4 exportem en format pdf el report i el tornem al client
        
        String filename = "factura.pdf";

        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=" +filename);
        OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		} catch (IOException | JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

         
        
        
	}


	


}
