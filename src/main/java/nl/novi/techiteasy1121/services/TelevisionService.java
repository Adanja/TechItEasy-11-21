package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.model.RemoteController;
import nl.novi.techiteasy1121.repository.RemoteControllerRepository;
import nl.novi.techiteasy1121.repository.TelevisionRepository;
import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.model.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TelevisionService {

    // CRUD methode
    List<TelevisionDto> getAllTelevisions();
    TelevisionDto getTelevisionById(Long id);
    TelevisionDto addTelevision(TelevisionDto dto);
    void deleteTelevision(Long id);
    TelevisionDto updateTelevision(Long id, TelevisionDto dto);

    void assignRemoteControllerToTelevision(Long id, Long ciModuleId); //void vergeten toe te voegen! En ciModule ID vergeten toe te voegen!
}
