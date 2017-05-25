package org.tosca.blueprint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlueprintReview {

	@Autowired(required = true)
	public BPEngine bpEngineService;

	@RequestMapping(value = "/")
	public  String landingPage(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value="/blueprintStats",method=RequestMethod.POST)
	public @ResponseBody String getBlueprintReviewStats(HttpServletRequest request){
		String message = "";
		String blueprint = request.getParameter("bp_path");
		String blueprintPath = blueprint+"\\blueprint.yaml"; //"C:\\Users\\PARMC23\\Documents\\BluePrints\\warehouse\\TECM-4470\\CTS_ESWeb_FACTORY_17_3_PAT_2017_0518_FINAL\\blueprint.yaml";
		String blueprintInputPath =blueprint+"\\inputs"; //"C:\\Users\\PARMC23\\Documents\\BluePrints\\warehouse\\TECM-4470\\CTS_ESWeb_FACTORY_17_3_PAT_2017_0518_FINAL\\inputs";

		try {
			message = bpEngineService.getBPStatistics(blueprintPath, blueprintInputPath);
		} catch (Exception e) {
			message = e.getMessage() + "\n"+e.getLocalizedMessage();
		}
		return message;
	}

}
