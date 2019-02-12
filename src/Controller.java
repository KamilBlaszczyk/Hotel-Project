import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Apartment;
import model.Employee;
import model.Guest;
import additives.ConfirmBox;

import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable {

    public TextField input;
    public Label lblinput;

    //publiczne pola tekstowe
    public TextField tfnumberOfRoom;
    public TextField tfnumberOfPersons;
    public TextField tfprice;
    public TextField tfdescription;

    public TextField tfname;
    public TextField tfsurname;
    public TextField tfpesel;

    public TextField tfnameOfEmployee;

    //publiczne listy do wyświetlania danych
    public ListView<Guest> listview;
    public ListView<Employee> listview2;
    public ListView<Apartment> listview3;


    Scanner load =  new Scanner(System.in);
    Hotel h = new Hotel();

    //Metoda initialize wykonywana jest przy inicjalizacji programu, jego startu
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void menuFileCloseClicked(){
        Platform.exit();
    }

    public void buttonCloseProgram(){
        Boolean answer = ConfirmBox.display("Tytuł","Czy na pewno chcesz wyjść?");
        if(answer)
            Platform.exit();
    }

    public void buttonShowEmployee() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(h.selectEmployee());
        listview2.setItems(employees);
        System.out.println("Employees were showed");
    }

    public void buttonShowGuest() {
        ObservableList<Guest> guests = FXCollections.observableArrayList(h.selectGuest());
        listview.setItems(guests);
        System.out.println("Guests were showed");
    }

    public void buttonShowApartment() {
        ObservableList<Apartment> apartments = FXCollections.observableArrayList(h.selectApartment());
        listview3.setItems(apartments);
        System.out.println("Apartments were showed");
    }

    public void buttonAddApartment(javafx.event.ActionEvent actionEvent) {
        int numberOfRoom = Integer.parseInt(Normalizer.normalize(tfnumberOfRoom.getText(), Normalizer.Form.NFD));
        int numberOfPersons = Integer.parseInt(Normalizer.normalize(tfnumberOfPersons.getText(), Normalizer.Form.NFD));
        int price = Integer.parseInt(Normalizer.normalize(tfprice.getText(), Normalizer.Form.NFD));
        String description = Normalizer.normalize(tfdescription.getText(), Normalizer.Form.NFD);
        h.insertApartment(numberOfRoom, numberOfPersons, price, description);

        tfnumberOfPersons.clear();
        tfnumberOfRoom.clear();
        tfprice.clear();
        tfdescription.clear();
        System.out.println("Wpisałeś: " + numberOfRoom + numberOfPersons + price + description);
    }

    public void buttonAddGuest(javafx.event.ActionEvent actionEvent) {
        String name = Normalizer.normalize(tfname.getText(), Normalizer.Form.NFD);
        String surname = Normalizer.normalize(tfsurname.getText(), Normalizer.Form.NFD);
        String pesel = Normalizer.normalize(tfpesel.getText(), Normalizer.Form.NFD);
        h.insertGuest(name, surname, pesel);

        tfname.clear();
        tfsurname.clear();
        tfpesel.clear();
        System.out.println("Wpisałeś: " + name + surname + pesel);
    }

    public void buttonAddEmployee() {
        String name = Normalizer.normalize(tfnameOfEmployee.getText(), Normalizer.Form.NFD);
        h.insertEmployee(name);

        tfnameOfEmployee.clear();
        System.out.println("Dodałeś: " + name);
    }

    public void buttonEditLabel(javafx.event.ActionEvent actionEvent) {
        lblinput.setText(input.getText());
        System.out.println("label has been edited");
    }






//    public void buttonShowGuest() {
//        ObservableList<model.Guest> guests = FXCollections.observableArrayList(h.selectGuest());
//        listview.setItems(guests);
//        System.out.println("Guests were showed");
//        //Wyświetlanie w konsoli
//        System.out.println("Lista gości: ");
//        for(model.Guest x:guests)
//            System.out.println(x);
//    }

//    public void buttonEditLabel(javafx.event.ActionEvent actionEvent) {
//        lblinput.setText(input.getText());
//        String editLabel = Normalizer.normalize(input.getText(), Normalizer.Form.NFD);
//        editLabel = editLabel.replaceAll("[^\\p{ASCII}]", "");
//        System.out.println("Wpisałeś: " + editLabel);
//    }
//


//
//    Nieudana proba wyswietlenia zawartosci listy w tablicy
//
//    public TableView<model.Product> table;
//    public TextField nameInput,priceInput, quantityInput;
//
//    public TableColumn<model.Product, String> nameColumn;
//    public TableColumn<model.Product, Double> priceColumn;
//    public TableColumn<model.Product, String> quantityColumn;
//    public TableView<model.Guest> table;
//    public TableColumn<model.Product, String> nameColumn;
//
//    public void tableShowGuest(javafx.event.ActionEvent actionEvent) {
//        table = new TableView<>();
//        table.setItems(getProduct());
//        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
//    }
//
//
//    public void buttonTest() {
//        Nieudana próba utworzenia tabeli wypelnionej listą
//        table.setItems(guests);
//        table.setItems(getProduct());
//    }
//
//    public void addButtonClicked() {
//        model.Product product = new model.Product();
//        product.setName(nameInput.getText());
//        product.setPrice(Double.parseDouble(priceInput.getText()));
//        product.setQuantity(Integer.parseInt(quantityInput.getText()));
//        table.getItems().add(product);
//        nameInput.clear();
//        priceInput.clear();
//        quantityInput.clear();
//    }
//
//    public ObservableList<model.Product> getProduct(){
//        ObservableList<model.Product> products = FXCollections.observableArrayList();
//        products.add(new model.Product("Playstation 4", 999.99, 5));
//        products.add(new model.Product("Iphone X", 1345.75, 99));
//        products.add(new model.Product("Ham 1kg", 35.25, 516));
//        products.add(new model.Product("Laptop", 735.35, 28));
//        products.add(new model.Product("Corn", 1.49, 856));
//        return products;
//    }

}
