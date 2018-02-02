package su.psergeev77.service.facade.client;


import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(url = "http://localhost:9010/client", name = "client" )
public interface ClientRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    Resource<Client> getClient(@PathVariable("userName") String userName);
}
