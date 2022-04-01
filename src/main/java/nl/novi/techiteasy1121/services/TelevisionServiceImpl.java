package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.model.Television;
import nl.novi.techiteasy1121.repository.RemoteControllerRepository;
import nl.novi.techiteasy1121.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionServiceImpl  implements TelevisionService{

    @Autowired
    private TelevisionRepository televisionRepository;

    @Autowired
    RemoteControllerRepository remoteControllerRepository;

    @Override
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();
        for (Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    // Wat doet deze methode? (De data die in tvDto staat opslaan in television?? -> Is dit niet heel omslachtig?
    public TelevisionDto transferToDto(Television television) {
        var dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    @Override
    public TelevisionDto getTelevisionById(Long id) {
        if(televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();
            TelevisionDto dto = transferToDto(tv);
            return dto;
        }
        else {
            throw new RecordNotFoundException("Geen televisie gevonden");
        }
    }

    @Override
    public TelevisionDto addTelevision(TelevisionDto dto) {
        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);
        return dto;
    }

    public Television transferToTelevision(TelevisionDto dto) {
        var television = new Television();
        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;
    }

    @Override
    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    @Override
    public TelevisionDto updateTelevision(Long id, TelevisionDto dto) {
        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();
            tv.setId(tv.getId());
        }
        return dto;
    }


    // TelevisionRepository linken aan service laag?


    // RemoteController linken aan TV -- Deze methode nog een keer ZELF maken!!
    public void assignRemoteControllerToTelevision(Long id, Long remoteControllerId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemoteController = remoteControllerRepository.findById(remoteControllerId);

        if(optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            var television = optionalTelevision.get();
            var remoteController = optionalRemoteController.get();

            television.setRemoteController(remoteController);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
