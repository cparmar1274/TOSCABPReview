package org.tosca.blueprint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/promotion")
public class PromotionController {
	
	@RequestMapping(value="/")
	public String getPromotion(HttpServletRequest request){
		return "promotion";
	}

	
	// GET Request
	//GET FILES
	//http://git.cloud.td.com/api/v3/projects/3868/repository/files?private_token=PrNXRjuVSzjNB7tmoXYJ&file_path=CTS_ALRT_P1_EAP/inputs/DEV/inputs1_alrt_batch.json&ref=master
}
