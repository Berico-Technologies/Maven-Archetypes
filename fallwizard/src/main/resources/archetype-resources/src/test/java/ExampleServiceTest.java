package ${package};

import org.junit.Before;
import org.junit.Test;

import ${package}.health.ExampleHealthCheck;
import ${package}.resources.ExampleResource;
import ${package}.tasks.ExampleTask;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.FilterBuilder;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ExampleServiceTest {

    // If you want to verify Spring Security, you need to mock the FilterBuilder
    // since the SpringSecurityAuthProvider will need to set the name of the
    // Filter to the "springSecurityFilterChain", allowing the DelegatingFilterProxy
    // to interact with the Filter Chain.
    private final FilterBuilder mockFilterBuilder = mock(FilterBuilder.class);
    private final Environment environment = mock(Environment.class);
    private final ExampleService service = new ExampleService();
    private final ExampleConfiguration config = new ExampleConfiguration();

    @Before
    public void setup() throws Exception {

        // Ensure the Environment mock returns the mock FilterBuilder or you will get a NullReferenceException.
        when(environment.addFilter(eq(DelegatingFilterProxy.class), anyString())).thenReturn(mockFilterBuilder);

        config.setExampleProperty("Example");

        config.getSpringConfiguration().setShouldUseSpringSecurity(true);

        config.getSpringConfiguration().setApplicationContext(new String[]{
            "conf/applicationContext.xml",
            "conf/basicAuthSecurityContext.xml"
        });
    }
    
    @Test
    public void ensure_my_stuff_was_added() throws Exception {
    	
        service.run(config, environment);

        // This allows you to verify that your Spring managed Dropwizard components
        // were registered with Dropwizard without having to initialize the Dropwizard runtime.
        verify(environment).addResource(any(ExampleResource.class));
        verify(environment).addTask(any(ExampleTask.class));
        verify(environment).addHealthCheck(any(ExampleHealthCheck.class));
    }
}
