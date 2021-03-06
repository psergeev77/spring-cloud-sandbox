package su.psergeev77.service.facade.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="client-service", path="/client")
public interface ClientRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    Client getClient(@PathVariable("userName") String userName);
}
