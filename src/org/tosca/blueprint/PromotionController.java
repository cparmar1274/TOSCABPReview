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

}
