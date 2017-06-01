package org.tosca.pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Catalog {

	@JsonProperty(value="name")
	public String name;
	
	@JsonProperty(value="git")
	public GitData git;
	
	@JsonProperty(value="blueprint")
	public String blueprint;
	
	@JsonProperty(value="documentation")
	public String documentation;
	
	@JsonProperty(value="environment")
	public List<EnvironmentData> environment;
	
	public Catalog(String name, GitData git, String blueprint, String documentation,
			List<EnvironmentData> environment) {
		super();
		this.name = name;
		this.git = git;
		this.blueprint = blueprint;
		this.documentation = documentation;
		this.environment = environment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GitData getGit() {
		return git;
	}

	public void setGit(GitData git) {
		this.git = git;
	}

	public String getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(String blueprint) {
		this.blueprint = blueprint;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public List<EnvironmentData> getEnvironment() {
		return environment;
	}

	public void setEnvironment(List<EnvironmentData> environment) {
		this.environment = environment;
	}
	
	
	
}

