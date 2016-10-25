package eddy.noss.client;

import org.springframework.stereotype.Component;

/**
 * Created by ubu on 25.10.16.
 */
public class SimpleServiceProviderImpl implements SimpleServiceProvider {

    @Override
    public String getFeignEndpoint() {
        return "oops";
    }
}
