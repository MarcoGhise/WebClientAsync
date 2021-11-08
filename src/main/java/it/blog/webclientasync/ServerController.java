package it.blog.webclientasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/")
public class ServerController {

	@Autowired
	ObjectMapper objectMapper;

	@GetMapping(value = "/personal", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPersonalData() throws InterruptedException {
		String json = """
				{
				   "name":"John",
				   "surname":"Smith",
				   "company":"Fisher Car Wash"
				}
					              """;
		Thread.sleep(2000);
	
		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	@GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getLocationData() throws InterruptedException {
		String json = """
				{
				   "city":"Dublin",
				   "address":"UNIT 33 Slaney Rd"
				}
									              """;
		Thread.sleep(2000);
		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	@GetMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getContantData() throws InterruptedException {
		String json = """
				{
					"phone":"00353 123123123",
					"email":"info@fishercarwash.ie"
				}

				""";
		Thread.sleep(2000);
		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	@GetMapping(value = "/preference", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOtherPreference() throws InterruptedException {
		String json = """
				{
				   "openinghours":"00353 123123123",
				   "accessible":"yes"
				}

								""";
		Thread.sleep(2000);
		return new ResponseEntity<>(json, HttpStatus.OK);
	}

}
