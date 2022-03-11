package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class TelevisionServiceImpl  implements TelevisionService{
@Autowired
    TelevisionRepository televisionRepository;

    @Override
    public List<TelevisionDto> getAllTelevisions() {
        return null;
    }

    @Override
    public TelevisionDto getTelevisionById(Long id) {
        return null;
    }

    @Override
    public TelevisionDto addTelevision(TelevisionDto dto) {
        return null;
    }

    @Override
    public void deleteTelevision(Long id) {

    }

    @Override
    public TelevisionDto updateTelevision(Long id, TelevisionDto dto) {
        return null;
    }
}
