public class Apartment {

    private int id;
    private int numberOfRoom;
    private int numberOfPersons;
    private int price;
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumberOfRoom() {
        return numberOfRoom;
    }
    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }
    public int getNumberOfPersons() {
        return numberOfPersons;
    }
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Apartment() {
    }

    public Apartment(int id, int numberOfRoom, int numberOfPersons, int price, String description) {
        this.id = id;
        this.numberOfRoom = numberOfRoom;
        this.numberOfPersons = numberOfPersons;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return " - "+ id +" - "+ numberOfRoom +" - "+ numberOfPersons +" - "+ price +" - "+ description +"";
    }

}
