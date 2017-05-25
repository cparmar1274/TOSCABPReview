package org.tosca.blueprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;

public class BluePrintInput {

	public Map<String, List<String>> bpInput = new HashMap<String, List<String>>();

	public BluePrintInput(String blueprintInputPath) {

		if (BPUtil.checkDirectory(blueprintInputPath + "\\DEV")) {
			bpInput.put("DEV", BPUtil.getListOfFiles(blueprintInputPath + "\\DEV"));
		}else {
			bpInput.put("DEV",new ArrayList<>());
		}

		if (BPUtil.checkDirectory(blueprintInputPath + "\\BAT")) {
			bpInput.put("BAT", BPUtil.getListOfFiles(blueprintInputPath + "\\BAT"));
		}else {
			bpInput.put("BAT",new ArrayList<>());
		}

		if (BPUtil.checkDirectory(blueprintInputPath + "\\SIT")) {
			bpInput.put("SIT", BPUtil.getListOfFiles(blueprintInputPath + "\\SIT"));
		}else {
			bpInput.put("SIT",new ArrayList<>());
		}

		if (BPUtil.checkDirectory(blueprintInputPath + "\\SYS")) {
			bpInput.put("SIT", BPUtil.getListOfFiles(blueprintInputPath + "\\SYS"));
		}else {
			bpInput.put("SIT",new ArrayList<>());
		}

		if (BPUtil.checkDirectory(blueprintInputPath + "\\PAT")) {
			bpInput.put("PAT", BPUtil.getListOfFiles(blueprintInputPath + "\\PAT"));
		}else {
			bpInput.put("PAT",new ArrayList<>());
		}

		if (BPUtil.checkDirectory(blueprintInputPath + "\\PROD")) {
			bpInput.put("PROD", BPUtil.getListOfFiles(blueprintInputPath + "\\PROD"));
		}else {
			bpInput.put("PROD",new ArrayList<>());
		}

	}

	public Set<String> getDevInputs() {
		return getInputs("DEV");
	}

	public Set<String> getSITInputs() {
		return getInputs("SIT");
	}

	public Set<String> getPATInputs() {
		return getInputs("PAT");
	}

	public Set<String> getPRODInputs() {
		return getInputs("PROD");
	}

	public Set<String> getBATInputs() {
		return getInputs("BAT");
	}
	
	private Set<String> getInputs(String type) {
		Set<String> input = new TreeSet<>();
		Gson gson = new Gson();
		for (String jsonString : this.bpInput.get(type)) {
			HashMap<String, String> fileData = gson.fromJson(jsonString, HashMap.class);
			input.addAll(fileData.keySet());
		}
		return input;
	}
}
