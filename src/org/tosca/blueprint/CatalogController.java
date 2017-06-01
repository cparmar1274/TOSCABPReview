package org.tosca.blueprint;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tosca.pojos.Catalog;
import org.tosca.pojos.EnvironmentData;
import org.tosca.pojos.GitData;

import com.google.gson.Gson;

@Controller
@RequestMapping(value={"/catalog","/catalog/"})
public class CatalogController {
	
	@RequestMapping(value={"/",""})
	public String getMessage(HttpServletRequest request){
		return "catalog";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody String getCatalogfile(HttpServletRequest request){
		String catalogName = request.getParameter("catalog_name");
		String tag = request.getParameter("tag_name");
		return new Gson().toJson(new Catalog(catalogName,new GitData("bp_url",tag),"blueprnt_name","documentation",new ArrayList<EnvironmentData>()));
	}

}
