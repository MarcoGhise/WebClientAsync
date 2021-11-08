package it.blog.webclientasync;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.blog.webclientasync.bean.CustomerProfile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	CustomerClient client;
	
	@GetMapping(value = "/reactive", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<CustomerProfile> getReactive() throws InterruptedException {

		Mono<CustomerProfile> customerProfile = client.getReactiveCustomerProfile();		
		return customerProfile;
	}	
	
	@GetMapping(value = "/async", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerProfile getAsync() throws InterruptedException, ExecutionException {

		return client.getAsyncCustomerProfile();		
	}	
}