package com.careerdevs.CovidData.controllers;


import com.careerdevs.CovidData.models.CovidTrackingData;
import com.careerdevs.CovidData.models.CovidTrackingReport;
import com.careerdevs.CovidData.repositories.CovidTrackingDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/covid")
public class CovidTrackingDataController {

    private final String BASE_URL ="https://www.cyberpurge.com/api/covid/";
    @Value("${CV_API_KEY}")
    private String apiKey;

    @Autowired
    private CovidTrackingDataRepo covidTrackingDataRepo;

    //    Get the list of countries with Name & ISO Alpha-2
    //    GET/api/covid/countries
    @GetMapping("/countries")

    public ResponseEntity<?> getCovidTrackingListAllCountries (RestTemplate restTemplate) {

        try {


            String covidTrackingURL = BASE_URL + "countries";
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);



            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    //    Upload Database
    //    Get the list of countries with Name & ISO Alpha-2
    //    GET/api/covid/countries
    @PostMapping("/countries")

    public ResponseEntity<?> uploadCovidTrackingListAllCountries (RestTemplate restTemplate) {

        try {


            String covidTrackingURL = BASE_URL + "countries";
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);
//            System.out.println(response.getBody());
            System.out.println(true);
            CovidTrackingData ctRes =restTemplate.getForObject(covidTrackingURL,CovidTrackingData.class);
            assert ctRes !=null;

            //upload database
            CovidTrackingData CovidTrackingData = covidTrackingDataRepo.save(ctRes);

            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
        //  Get country name for its equivalent ISO Alpha-2 code
        //  GET/api/covid/countryNameByCode/:code
        @GetMapping("/country/{countryName}")
    public ResponseEntity<?> getCovidTrackingByCountries (RestTemplate restTemplate, @PathVariable String countryName) {


        try{

            String queryString =  "countryNameByCode/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity,String.class);

            //upload database
//            CovidTrackingData CovidTrackingReport = covidTrackingDataRepo.save(ctRes);

            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }


    @PostMapping("/country/{countryName}")
    public ResponseEntity<?> UploadCovidTrackingByCountries (RestTemplate restTemplate, @PathVariable String countryName) {


        try{

            String queryString =  "countryNameByCode/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity,String.class);



            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }
    //    Get regional case counts categorized under Total, Recovered,
    //    and Deceased for a country its ISO Alpha-2 Code
    //    GET/api/covid/regionalDataByCountry/:code

    @GetMapping("/regionalDataByCountry/{countryName}")

    public ResponseEntity<?> getCovidTrackingByRegionalDataByCountry(RestTemplate restTemplate ,@PathVariable String countryName) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");



            String queryString =  "regionalDataByCountry/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
//            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }



    }
}
