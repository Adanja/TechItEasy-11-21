package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.IdInputDto;
import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.model.Television;
import nl.novi.techiteasy1121.services.TelevisionService;
import nl.novi.techiteasy1121.services.TelevisionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private TelevisionServiceImpl televisionService;

    @Autowired //Doet dit iets? > Communiceren met je service laag??
    // TelevisionService televisionService; Waarom kan ik dit niet toevoegen?
//    TelevisionDto televisionDto;
    public TelevisionsController(TelevisionServiceImpl televisionService){
        this.televisionService = televisionService;
    }




    // Get request for all
    @GetMapping()
    public List<TelevisionDto> getAllTVs(){
        List<TelevisionDto> dtos = televisionService.getAllTelevisions(); // Waarom bestaat getAllTelevisions niet? > Was niet goed aangemaakt in de TV-Controller
        return dtos; // Waarom wil hij Television en niet TelevisionDto
    }

// Get request voor één
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getOnetelevision(@PathVariable ("id") Long id) {
        TelevisionDto dto = televisionService.getTelevisionById(id);

        return ResponseEntity.ok(dto);
    }

    // Post request voor één > Maak 1 nieuwe TV aan
    @PostMapping("")
    public TelevisionDto addTV(@RequestBody TelevisionDto televisionDto) {
        var dto = televisionService.addTelevision(televisionDto);
        return dto;
    }

    //Put request: Tv vervangen voor een andere TV
    // Kun je de putmapping ook leeg laten (parameter)
    @PutMapping("/{id}")
    public TelevisionDto updateTV(@PathVariable ("id") Long id, @RequestBody TelevisionDto name) {
       var dto = televisionService.updateTelevision(id, name);

        return dto;
    }

    //Put Request voor RemoteController
    @PutMapping ("/{id}/remotecontroller")
    public TelevisionDto updateRemoteController(@PathVariable Television id, @RequestBody IdInputDto remoteControllerId) {
        var dto = updateRemoteController(id, remoteControllerId);
        return dto;
    }

    // Delete one TV:
    @DeleteMapping("/{id}")
    public void deleteTelevision(@PathVariable ("id") Long id) {
        televisionService.deleteTelevision(id);
    }

    @GetMapping("?branch={branch}")
    public TelevisionDto getAllTelevisions(@RequestParam String brand) {
        var dto = getAllTelevisions(brand);
        return dto;
    }



}
