package it.blog.webclientasync;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.blog.webclientasync.bean.Contact;
import it.blog.webclientasync.bean.Location;
import it.blog.webclientasync.bean.Personal;
import it.blog.webclientasync.bean.Preference;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ReactiveClient extends GenericClient{

	@Autowired
	ObjectMapper objectMapper;	
	
	@Autowired
	WebClient webClient;
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
	public Mono<Personal> getReactivePersonalData() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlPersonal);
			
		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		log.info("Starting Reactive Method!");
		Mono<Personal> personal = webClient.get().uri(uri).retrieve().bodyToMono(Personal.class)
				.log()
				.onErrorResume(e -> {
					log.error(e.getMessage());
					return Mono.just(new Personal());					
				});

		return personal;
	}
	
	public Mono<Location> getReactiveLocation() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlLocation);
			
		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		log.info("Starting Reactive Method!");
		Mono<Location> location = webClient.get().uri(uri).retrieve().bodyToMono(Location.class)
				.log()
				.onErrorResume(e -> {
					log.error(e.getMessage());
					return Mono.just(new Location());					
				});

		return location;
	}
	
	public Mono<Contact> getReactiveContact() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlContact);
			
		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		log.info("Starting Reactive Method!");
		Mono<Contact> contact = webClient.get().uri(uri).retrieve().bodyToMono(Contact.class)
				.log()
				.onErrorResume(e -> {
					log.error(e.getMessage());
					return Mono.just(new Contact());					
				});

		return contact;
	}
	
	public Mono<Preference> getReactivePreference() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlPreference);
			
		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		log.info("Starting Reactive Method!");
		Mono<Preference> preference = webClient.get().uri(uri).retrieve().bodyToMono(Preference.class)
				.log()
				.onErrorResume(e -> {
					log.error(e.getMessage());
					return Mono.just(new Preference());					
				});

		return preference;
	}
	
	
}