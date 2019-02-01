public class Guest {

    private int id;
    private String imie;
    private String surname;
    private String pesel;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Guest() {}

    public Guest(int id, String imie, String surname, String pesel) {
        this.id = id;
        this.imie = imie;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "["+id+"] - "+ imie +" "+surname+" - "+pesel;
    }
}
