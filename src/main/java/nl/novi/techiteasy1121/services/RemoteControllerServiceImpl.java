package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.model.RemoteController;
import nl.novi.techiteasy1121.model.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerServiceImpl implements RemoteControllerService {
    @Autowired
    public RemoteControllerServiceImpl(Television television, RemoteController remoteController) {

    }
}
