package org.tosca.blueprint;

import org.springframework.stereotype.Service;

@Service
public class BPEngine {

	public String getBPStatistics(String blueprintPath, String blueprintInputPath) throws Exception {
		StringBuffer sBuffer = new  StringBuffer();
		sBuffer.append("BPReview Started.\n");
		BluePrint bluePrint = new BluePrint(blueprintPath);
		bluePrint.fetchInputFromBlueprint();
		sBuffer.append("Blueprint Input Size : "+bluePrint.fetchInputFromBlueprint().size()).append("\n");
		sBuffer.append("Blueprint Input : "+bluePrint.fetchInputFromBlueprint()).append("\n");

		sBuffer.append("Inputs Review").append("\n");
		BluePrintInput bluePrintInput = new BluePrintInput(blueprintInputPath);
		sBuffer.append("Dev Input Size : "+bluePrintInput.getDevInputs().size()).append("\n");
		sBuffer.append("Dev Input : "+bluePrintInput.getDevInputs()).append("\n");

		sBuffer.append("SIT Input Size : "+bluePrintInput.getSITInputs().size()).append("\n");
		sBuffer.append("SIT Input : "+bluePrintInput.getSITInputs()).append("\n");

		
		sBuffer.append("BAT Input Size : "+bluePrintInput.getBATInputs().size()).append("\n");
		sBuffer.append("BAT Input : "+bluePrintInput.getBATInputs()).append("\n");

		
		sBuffer.append("PAT Input Size : "+bluePrintInput.getPATInputs().size()).append("\n");
		sBuffer.append("PAT Input : "+bluePrintInput.getPATInputs()).append("\n");

		
		sBuffer.append("PROD Input Size : "+bluePrintInput.getPRODInputs().size()).append("\n");
		sBuffer.append("PROD Input : "+bluePrintInput.getPRODInputs()).append("\n");

		
		sBuffer.append("BpReview Done.\n");
		return sBuffer.toString();
	}

}
