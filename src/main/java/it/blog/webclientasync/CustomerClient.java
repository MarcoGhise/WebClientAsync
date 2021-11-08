package it.blog.webclientasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.blog.webclientasync.bean.Contact;
import it.blog.webclientasync.bean.CustomerProfile;
import it.blog.webclientasync.bean.Location;
import it.blog.webclientasync.bean.Personal;
import it.blog.webclientasync.bean.Preference;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class CustomerClient {

	@Autowired
	ReactiveClient rClient;
	
	@Autowired
	AsyncClient aClient;

	public Mono<CustomerProfile> getReactiveCustomerProfile() {

		Mono<Personal> personal = rClient.getReactivePersonalData().subscribeOn(Schedulers.boundedElastic());
		Mono<Location> location = rClient.getReactiveLocation().subscribeOn(Schedulers.boundedElastic());
		Mono<Contact> contact = rClient.getReactiveContact().subscribeOn(Schedulers.boundedElastic());
		Mono<Preference> preference = rClient.getReactivePreference().subscribeOn(Schedulers.boundedElastic());

		Mono<CustomerProfile> profile = Mono.zip(personal, location, contact, preference).map(tupla -> {
			CustomerProfile p = new CustomerProfile();
			p.setPersonal(tupla.getT1());
			p.setLocation(tupla.getT2());
			p.setContact(tupla.getT3());
			p.setPreference(tupla.getT4());
			return p;
		}).log();

		return profile;
	}
	
	public CustomerProfile getAsyncCustomerProfile() throws InterruptedException, ExecutionException {

		CompletableFuture<Personal> personal = aClient.getAsyncPersonalData();
		CompletableFuture<Location> location = aClient.getAsyncLocation();
		CompletableFuture<Contact> contact = aClient.getAsyncContact();
		CompletableFuture<Preference> preference = aClient.getAsyncPreference();
		
		// Wait until they are all done
		CompletableFuture.allOf(personal, location, contact, preference).join();
		
		CustomerProfile profile = new CustomerProfile();
		profile.setPersonal(personal.get());
		profile.setLocation(location.get());
		profile.setContact(contact.get());
		profile.setPreference(preference.get());
		
		return profile;
		
	}

}