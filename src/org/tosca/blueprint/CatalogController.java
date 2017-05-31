package org.tosca.blueprint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xml.internal.resolver.Catalog;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {
	
	@RequestMapping(value="/")
	public String getMessage(HttpServletRequest request){
		return "catalog";
	}
	
	@RequestMapping(value="/create")
	public @ResponseBody Catalog getCatalogfile(HttpServletRequest request){
		return new Catalog();
	}

}
