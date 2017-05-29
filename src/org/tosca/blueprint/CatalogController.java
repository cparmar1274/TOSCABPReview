package org.tosca.blueprint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {
	
	@RequestMapping(value="/")
	public String getMessage(HttpServletRequest request){
		return "catalog";
	}

}
