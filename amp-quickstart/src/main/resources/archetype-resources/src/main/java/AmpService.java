package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cmf.eventing.IEventBus;

public class AmpService {

    private static Logger logger = LoggerFactory.getLogger(AmpService.class);

    private IEventBus eventBus;
    
    public AmpService(IEventBus eventBus) {
    	
        this.eventBus = eventBus;
    }
    
    public void start() {

        logger.debug("Starting the AmpService.");

        try {

        		// You can also define an IEventHandler<T> anonymously,
        		// but I find it's hard to test the implementation.
            eventBus.subscribe(new AmpStartupEventHandler());
        }
        catch (Exception ex) {
            
        		logger.error("Failed to subscribe to event.", ex);
        }
        
        try {

            eventBus.publish(new AmpStartupEvent());
            
        }
        catch(Exception ex) {
        	
        		logger.error("Failed to publish event.", ex);
        }
    }

    public void stop() {
    	
    		logger.debug("Stopping the AmpService.");
    	
        eventBus.dispose();
    }
}
