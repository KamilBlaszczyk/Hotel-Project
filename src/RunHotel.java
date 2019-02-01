//import java.util.List;
//import java.util.Scanner;
//
//public class RunHotel {
//
//    public static void main(String[] args) {
//
//        Scanner load =  new Scanner(System.in);
//        Hotel h = new Hotel();
//
//        int end=0;
//
//        while(end !=1) {
//
//            System.out.println("\nBy dodać goscia 1:");
//            System.out.println("By dodać pokój 2:");
//            System.out.println("By dodać pracownika 3:");
//            System.out.println("By wyświetlić listę gości 4:");
//            System.out.println("By wyświetlić listę pracowników 5:");
//            System.out.println("By wyświetlić listę pokoi 6:");
//            System.out.println("ZAKOŃCZ 7:");
//
//            int chose = load.nextInt();
//
//            switch(chose) {
//                case 1:
//                    System.out.println("Podaj imię: ");
//                    load.nextLine();
//                    String imie = load.nextLine();
//
//                    System.out.println("Podaj nazwisko: ");
//                    String nazwisko = load.nextLine();
//
//                    System.out.println("Podaj pesel:");
//                    String pesel = load.nextLine();
//
//                    h.insertGuest(imie, nazwisko, pesel);
//                    break;
//                case 2:
//                    System.out.println("Podaj numer: ");
//                    int numberOfRoom = load.nextInt();
//
//                    System.out.println("Podaj ilosc osob: ");
//                    int numberOfPersons = load.nextInt();
//
//                    System.out.println("Podaj cena:");
//                    int prices = load.nextInt();load.nextLine();
//
//                    System.out.println("Podaj Opis:");
//                    String description = load.nextLine();
//
//                    h.insertApartment(numberOfRoom, numberOfPersons, prices, description);
//                    break;
//                case 3:
//                    System.out.println("Podaj imię Pracownika:");
//                    load.nextLine();
//                    String nick = load.nextLine();
//
//                    h.insertEmployee(nick);
//                    break;
//                case 4:
//                    List<Guest> guests = h.selectGuest();
//                    System.out.println("Lista gości: ");
//                    for(Guest x:guests)
//                        System.out.println(x);
//                    break;
//                case 5:
//                    List<Employee> employee = h.selectEmployee();
//                    System.out.println("Lista pracowników:");
//                    for(Employee y: employee)
//                        System.out.println(y);
//                    break;
//                case 6:
//                    List<Apartment> apartments = h.selectApartment();
//                    System.out.println("Lista apartamentów:");
//                    for(Apartment z: apartments)
//                        System.out.println(z);
//                    break;
//                case 7:
//                    end = 1;
//                    break;
//                case 8:
//                    break;
//            }
//        }
//        h.closeConnection();
//    }
//}
