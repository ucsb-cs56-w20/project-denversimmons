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
	 json = "[{\"place_id\":234684554,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":112224,\"boundingbox\":[\"34.336029\",\"34.463922\",\"-119.859791\",\"-119.639946\"],\"lat\":\"34.4221319\",\"lon\":\"-119.7026673\",\"display_name\":\"Santa Barbara, Santa Barbara County, California, United States of America\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.7840479382888756,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":235518086,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":396510,\"boundingbox\":[\"33.4083677\",\"35.114665\",\"-120.734382\",\"-118.9633999\"],\"lat\":\"34.7136533\",\"lon\":\"-119.9858232\",\"display_name\":\"Santa Barbara County, California, United States of America\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.7546072318185604,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":235563714,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":315081,\"boundingbox\":[\"-20.218\",\"-19.889\",\"-43.696\",\"-43.209\"],\"lat\":\"-19.959444\",\"lon\":\"-43.415278\",\"display_name\":\"Santa Bárbara, Microrregião Itabira, Mesorregião Metropolitana de Belo Horizonte, Minas Gerais, Southeast Region, Brazil\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.6056061793661807,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":233728321,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":345497,\"boundingbox\":[\"40.6994483\",\"40.7480755\",\"0.4274295\",\"0.5417515\"],\"lat\":\"40.7145779\",\"lon\":\"0.4927561\",\"display_name\":\"Santa Bàrbara, Montsià, Tarragona, Catalonia, 43570, Spain\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.55638098836872,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":233772007,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":362549,\"boundingbox\":[\"-12.063\",\"-11.806\",\"-39.076\",\"-38.897\"],\"lat\":\"-11.9543757\",\"lon\":\"-38.9736385\",\"display_name\":\"Santa Bárbara, Microrregião de Feira de Santana, Região Metropolitana de Feira de Santana, Mesorregião do Centro-Norte baiano, Bahia, Northeast Region, Brazil\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.5553222462708347,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":235410365,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":1307234,\"boundingbox\":[\"5.7229867\",\"6.0215927\",\"-75.6504107\",\"-75.5328605\"],\"lat\":\"5.87213125\",\"lon\":\"-75.57777661034017\",\"display_name\":\"Santa Bárbara, Suroeste, Antioquia, Colombia\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.55,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":236007590,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":4627395,\"boundingbox\":[\"14.6426721\",\"15.5472873\",\"-88.7592934\",\"-87.9771042\"],\"lat\":\"15.0944971\",\"lon\":\"-88.37232178296776\",\"display_name\":\"Santa Bárbara, Honduras\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.5360469573626718,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"},{\"place_id\":196738996,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"way\",\"osm_id\":516368762,\"boundingbox\":[\"42.8480093\",\"42.8480114\",\"-2.3862\",\"-2.386062\"],\"lat\":\"42.8480114\",\"lon\":\"-2.3861137\",\"display_name\":\"Santa Barbara, Agurain/Salvatierra, Arabako lautada/Llanada Alavesa, Álava, Basque Country, 01200, Spain\",\"class\":\"waterway\",\"type\":\"stream\",\"importance\":0.525},{\"place_id\":195471214,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"way\",\"osm_id\":516369089,\"boundingbox\":[\"42.8334159\",\"42.8352354\",\"-2.3757085\",\"-2.3741966\"],\"lat\":\"42.8351081\",\"lon\":\"-2.375358\",\"display_name\":\"Santa Barbara, Agurain/Salvatierra, Arabako lautada/Llanada Alavesa, Álava, Basque Country, 01207, Spain\",\"class\":\"waterway\",\"type\":\"stream\",\"importance\":0.525},{\"place_id\":235368749,\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\"osm_type\":\"relation\",\"osm_id\":1343685,\"boundingbox\":[\"6.8458793\",\"7.0804558\",\"-72.9937754\",\"-72.8368911\"],\"lat\":\"6.9632242\",\"lon\":\"-72.90556454913832\",\"display_name\":\"Santa Bárbara, Santander, Colombia\",\"class\":\"boundary\",\"type\":\"administrative\",\"importance\":0.49343083031807433,\"icon\":\"https://nominatim.openstreetmap.org/images/mapicons/poi_boundary_administrative.p.20.png\"}]"
	 model.addAttribute("json", json);
	 PlaceCollection pc = new PlaceCollection();
         List<Place> places = pc.listFromJSON(json);
         model.addAttribute("places",places);
         return "locations/results";
    }
}
