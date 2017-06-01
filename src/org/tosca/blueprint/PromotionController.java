package org.tosca.blueprint;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.tosca.pojos.GitFile;

import com.google.gson.Gson;

@Controller
@RequestMapping(value={"/promotion","/promotion/"})
public class PromotionController {
	
	@RequestMapping(value={"/",""})
	public String getPromotion(HttpServletRequest request){
		return "promotion";
	}

	@RequestMapping(value="/getBlueprintContent",method=RequestMethod.POST)
	public @ResponseBody String getBlueprint(HttpServletRequest request){
		
		String token = request.getParameter("token_name");
		String blueprintName = request.getParameter("blueprint_name");
		String bpUrl = "http://git.cloud.td.com/api/v3/projects/3868/repository/files?private_token="+token+"&file_path="+blueprintName+"&ref=master";
		RestTemplate template = new RestTemplate();
		GitFile data = template.getForObject(bpUrl, GitFile.class);
		return new Gson().toJson(data);
	}
	// GET Request
	//GET FILES
	//http://git.cloud.td.com/api/v3/projects/3868/repository/files?private_token=PrNXRjuVSzjNB7tmoXYJ&file_path=CTS_ALRT_P1_EAP/inputs/DEV/inputs1_alrt_batch.json&ref=master
}
