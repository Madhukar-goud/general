package com.madhukar;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madhukar.model.FlickrResponse;

@SpringBootApplication
@RestController
public class WksTestApplication {

	public static String FLICKR_URL = "https://api.flickr.com/services/feeds/photos_public.gne";

	@RequestMapping("/flickr/{searchKey}")
	public FlickrResponse getFlickrImageResponse(@PathVariable String searchKey) {
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		FlickrResponse flickrResponse = new FlickrResponse();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FLICKR_URL)
				.queryParam("tags", searchKey)
				.queryParam("format", "json");

		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<String> response = restTemplate.exchange(
				builder.build().encode().toUri(), 
				HttpMethod.GET, 
				entity, 
				String.class);
		
		//TODO Clean this up
		System.out.println(response.getBody().substring(15, response.getBody().length()-1));
		String json = response.getBody().substring(15, response.getBody().length()-1);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);	

		try {
			flickrResponse = objectMapper.readValue(json, FlickrResponse.class);
			System.out.println(flickrResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flickrResponse;
	}

	public static void main(String[] args) {
		SpringApplication.run(WksTestApplication.class, args);
	}
}
