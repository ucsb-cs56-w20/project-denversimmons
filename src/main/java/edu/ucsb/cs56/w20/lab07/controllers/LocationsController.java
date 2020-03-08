package edu.ucsb.cs56.w20.lab07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ucsb.cs56.w20.lab07.formbeans.LocSearch;
import edu.ucsb.cs56.w20.lab07.services.LocationQueryService;

import java.util.List;
import osm.PlaceCollection;
import osm.Place;

@Controller
public class LocationsController {

    @GetMapping("/locations/search")
    public String getLocationsSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
        return "locations/search";
    }

    @GetMapping("/locations/results")
    public String getLocationsResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
         LocationQueryService e = new LocationQueryService();
         model.addAttribute("locSearch", locSearch);
         String json = e.getJSON(locSearch.getLocation());
         model.addAttribute("json", json);
	 PlaceCollection pc = new PlaceCollection();
         List<Place> places = pc.listFromJSON(json);
         model.addAttribute("places",places);
         return "locations/results";
    }
}
