package org.tosca.blueprint;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
class BPObject {

	public Map<String, Object> inputs;
}

public class BluePrint {

	public Map<String, Object> inputs;

	public BluePrint(String blueprintFilePath) throws Exception {

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		BPObject data = mapper.readValue(new File(blueprintFilePath), BPObject.class);
		this.inputs = data.inputs;
	}

	public Set<String> fetchInputFromBlueprint() {
		Set<String> bpInputs = new TreeSet<>();
		bpInputs.addAll(this.inputs.keySet());
		return bpInputs;
	}
}
