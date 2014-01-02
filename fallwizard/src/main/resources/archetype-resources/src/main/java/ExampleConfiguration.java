package ${package};

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bericotech.fallwizard.configuration.FallwizardConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleConfiguration extends FallwizardConfiguration {

	@Valid
	@NotNull
	@JsonProperty("exampleProperty")
	private String exampleProperty;
	
	public void setExampleProperty(String value){
		
		this.exampleProperty = value;
	}
	
	public String getExampleProperty(){
		
		return this.exampleProperty;
	}
}
