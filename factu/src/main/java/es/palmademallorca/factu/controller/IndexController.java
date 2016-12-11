package es.palmademallorca.factu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
//    	System.out.println("######IndexController######### estic a index");
    	return "redirect:/factu";
    }

    
}
