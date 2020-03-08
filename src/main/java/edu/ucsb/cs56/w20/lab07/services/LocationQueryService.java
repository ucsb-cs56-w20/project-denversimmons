package edu.ucsb.cs56.w20.lab07.services;
import java.util.Arrays;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

public class LocationQueryService {

    private Logger logger = LoggerFactory.getLogger(LocationQueryService.class);

    public String getJSON(String location){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        String url = "https://nominatim.openstreetmap.org/search/";
	String[] splited = location.split("\\s+");
	for(int i = 0; i < splited.length; i++){
	    url += splited[i];
	    if(i != (splited.length -1)){
		url+= "%20";
	    }
	}

        url += "?format=json";
	
        logger.info("url=" + url);

        String retVal="";
        try {   
            ResponseEntity<String> re = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            MediaType contentType = re.getHeaders().getContentType();
            HttpStatus statusCode = re.getStatusCode();
            retVal = re.getBody();
        } catch (HttpClientErrorException e) {
            retVal = "{\"error\": \"401: Unauthorized\"}";
        }
        logger.info("from LocationQueryService.getJSON: " + retVal);
	return url;
    }

} 
 
