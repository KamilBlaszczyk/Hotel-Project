import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;


public class Hotel {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:hotel.db";

    private Connection conn;
    private Statement stat;

    public Hotel() {
        try {
            Class.forName(Hotel.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        createTables();
    }

    public boolean createTables() {
        String createGuests = "CREATE TABLE IF NOT EXISTS guests (id_guest INTEGER PRIMARY KEY AUTOINCREMENT, nameOfGuest varchar(255), surname varchar(255), pesel int)";
        String createApartments = "CREATE TABLE IF NOT EXISTS apartments (id_apartment INTEGER PRIMARY KEY AUTOINCREMENT, numberOfRoom int, numberOfPersons int, price int, description varchar(255))";
        String createEmployees = "CREATE TABLE IF NOT EXISTS employees (id_employee INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255))";
        String createLeases = "CREATE TABLE IF NOT EXISTS leases (id_lease INTEGER PRIMARY KEY AUTOINCREMENT, id_guest int, id_apartment int)";
        try {
            stat.execute(createGuests);
            stat.execute(createEmployees);
            stat.execute(createApartments);
            stat.execute(createLeases);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertGuest(String imie, String nazwisko, String pesel) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into guests values (NULL, ?, ?, ?);");
            prepStmt.setString(1, imie);
            prepStmt.setString(2, nazwisko);
            prepStmt.setString(3, pesel);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu goscia");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertEmployee(String nick) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into employees values (NULL, ?);");
            prepStmt.setString(1, nick);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu pracownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertApartment(int numberOfRoom, int numberOfPersons, int price, String description) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into apartments values (NULL, ?, ?, ?, ?);");
            prepStmt.setInt(1, numberOfRoom);
            prepStmt.setInt(2, numberOfPersons);
            prepStmt.setInt(3, price);
            prepStmt.setString(4, description);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu apartamentu");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Guest> selectGuest() {
        List<Guest> guests = new LinkedList<Guest>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM guests");
            int id;
            String imie, nazwisko, pesel;
            while(result.next()){
                id = result.getInt("id_guest");
                imie = result.getString("nameOfGuest");
                nazwisko = result.getString("surname");
                pesel = result.getString("pesel");
                guests.add(new Guest(id, imie, nazwisko, pesel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return guests;
    }

    public List<Employee> selectEmployee() {
        List<Employee> employee = new LinkedList<Employee>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM employees");
            int id;
            String nick;
            while(result.next()){
                id = result.getInt("id_employee");
                nick = result.getString("nick");
                employee.add(new Employee(id, nick));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employee;
    }

    public List<Apartment> selectApartment() {
        List<Apartment> apartments = new LinkedList<Apartment>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM apartments");
            int id, numberOfRoom, numberOfPersons, price;
            String description;
            while(result.next()){
                id = result.getInt("id_apartment");
                numberOfRoom = result.getInt("numberOfRoom");
                numberOfPersons = result.getInt("numberOfPersons");
                price = result.getInt("price");
                description = result.getString("description");
                apartments.add(new Apartment(id, numberOfRoom, numberOfPersons, price, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return apartments;
    }

//    public boolean insertLease(int idGuest, int idApartment) {
//        try {
//            PreparedStatement prepStmt = conn.prepareStatement(
//                    "insert into leases values (NULL, ?, ?);");
//            prepStmt.setInt(1, idGuest);
//            prepStmt.setInt(2, idApartment);
//        } catch (SQLException e) {
//            System.err.println("Blad przy wstawianiu wynajmu");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
