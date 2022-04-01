package nl.novi.techiteasy1121.dtos;

import nl.novi.techiteasy1121.model.RemoteController;

public class RemoteControllerInputDto {
    private Long id;
    private String compatibleWith;
    private String brand;
    private Double price;
    private Integer originalStock;

    public RemoteController remoteController () {
        var remoteController = new RemoteController();
        remoteController.setId(id);
        return remoteController; // Wat?
    }
}
