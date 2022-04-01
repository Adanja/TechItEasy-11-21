package nl.novi.techiteasy1121.model;

import javax.persistence.OneToMany;

public class CIModule {
    Long id;
    String name;
    String type;
    Double price;


    @OneToMany
    Television television;

    public CIModule() {

    }

    public CIModule(Long id, String name, String type, Double price, Television television) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.television = television;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }

}
