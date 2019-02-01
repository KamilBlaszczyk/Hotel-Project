public class Lease {

    private int idGuest;
    private int idApartment;

    public int getIdGuest() {
        return idGuest;
    }
    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }
    public int getIdApartment() {
        return idApartment;
    }
    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public Lease() {
    }

    public Lease(int idGuest, int idApartment) {
        this.idGuest = idGuest;
        this.idApartment = idApartment;
    }
}
