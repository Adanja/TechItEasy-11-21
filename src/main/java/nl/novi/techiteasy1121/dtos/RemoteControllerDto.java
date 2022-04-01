package nl.novi.techiteasy1121.dtos;

public class RemoteControllerDto {
    private Long id;
    private String compatibleWith;
    private String brand;
    private Double price;
    private Integer originalStock;

    public RemoteControllerDto() {
    }

    public RemoteControllerDto(Long id, String compatibleWith, String brand, Double price, Integer originalStock) {
        this.id = id;
        this.compatibleWith = compatibleWith;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
}
