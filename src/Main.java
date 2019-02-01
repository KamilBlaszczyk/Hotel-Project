import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

//        TextField nameInput = new TextField();

//        button = new Button("Click Me");
//        button.setOnAction( e -> isInt(nameInput, nameInput.getText()) );

//        VBox layout = new VBox(10);
//        layout.setPadding(new Insets(20, 20, 20, 20));
//        layout.getChildren().addAll(nameInput, button);

//        scene = new Scene(layout, 300, 250);
//        window.setScene(scene);
//        window.show();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setTitle("Application Hotel");
        primaryStage.show();
    }

//    private boolean isInt(TextField input, String message) {
//        try{
//            int age = Integer.parseInt(input.getText());
//            System.out.println("User is: " + age);
//            return true;
//        }catch(NumberFormatException e){
//            System.out.println("Error " + message + " is not a number");
//            return false;
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}



