package it.blog.webclientasync;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import it.blog.webclientasync.bean.Contact;
import it.blog.webclientasync.bean.Location;
import it.blog.webclientasync.bean.Personal;
import it.blog.webclientasync.bean.Preference;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncClient extends GenericClient {

	@Autowired
	@Lazy
	RestTemplate restTemplateAsync;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Async
	public CompletableFuture<Personal> getAsyncPersonalData() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlPersonal);

		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		try {

			ResponseEntity<Personal> personal = restTemplateAsync.getForEntity(uri, Personal.class);

			log.info("Response:{}", personal.getBody().toString());
			return CompletableFuture.completedFuture(personal.getBody());
		} catch (ResourceAccessException resourceAccessException) {
			log.error("ResourceAccess Exception", resourceAccessException);

			return CompletableFuture.completedFuture(new Personal());

		} catch (HttpClientErrorException | HttpServerErrorException httpException) {
			log.error("Request Exception", httpException);

			return CompletableFuture.completedFuture(new Personal());
		}
	}
	
	@Async
	public CompletableFuture<Location> getAsyncLocation() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlLocation);

		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		try {

			ResponseEntity<Location> location = restTemplateAsync.getForEntity(uri, Location.class);

			log.info("Response:{}", location.getBody().toString());
			return CompletableFuture.completedFuture(location.getBody());
		} catch (ResourceAccessException resourceAccessException) {
			log.error("ResourceAccess Exception", resourceAccessException);

			return CompletableFuture.completedFuture(new Location());

		} catch (HttpClientErrorException | HttpServerErrorException httpException) {
			log.error("Request Exception", httpException);

			return CompletableFuture.completedFuture(new Location());
		}
	}
	
	@Async
	public CompletableFuture<Contact> getAsyncContact() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlContact);

		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		try {

			ResponseEntity<Contact> contact = restTemplateAsync.getForEntity(uri, Contact.class);

			log.info("Response:{}", contact.getBody().toString());
			return CompletableFuture.completedFuture(contact.getBody());
		} catch (ResourceAccessException resourceAccessException) {
			log.error("ResourceAccess Exception", resourceAccessException);

			return CompletableFuture.completedFuture(new Contact());

		} catch (HttpClientErrorException | HttpServerErrorException httpException) {
			log.error("Request Exception", httpException);

			return CompletableFuture.completedFuture(new Contact());
		}
	}
	
	@Async
	public CompletableFuture<Preference> getAsyncPreference() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlPreference);

		URI uri = builder.build(true).toUri();
		log.info("Url to call:{}", uri.toString());

		try {

			ResponseEntity<Preference> preference = restTemplateAsync.getForEntity(uri, Preference.class);

			log.info("Response:{}", preference.getBody().toString());
			return CompletableFuture.completedFuture(preference.getBody());
		} catch (ResourceAccessException resourceAccessException) {
			log.error("ResourceAccess Exception", resourceAccessException);

			return CompletableFuture.completedFuture(new Preference());

		} catch (HttpClientErrorException | HttpServerErrorException httpException) {
			log.error("Request Exception", httpException);

			return CompletableFuture.completedFuture(new Preference());
		}
	}
}
