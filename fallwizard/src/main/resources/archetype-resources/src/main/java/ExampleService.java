package ${package};

import com.bericotech.fallwizard.FallwizardService;
import com.yammer.dropwizard.config.Bootstrap;

public class ExampleService extends FallwizardService<ExampleConfiguration> {

	public static void main( String[] args ) throws Exception
	{
		new ExampleService().run(args);
	}
	    
	@Override
	public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
	
		super.initialize(bootstrap);
	
		System.out.println("Initializing Example Service!");
	}	
}