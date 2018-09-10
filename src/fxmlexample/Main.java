package fxmlexample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Main_Screen.fxml"));

        Pane myPane = myLoader.load();

        Controller controller = myLoader.getController();
        
        controller.set_Prev_Stage(primaryStage);

        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
        new Thread(new ModbusThread(controller.EggOne)).start();
    }

    public static void main(String[] args) {
        //Thread reading = new Thread(new Controller());
        //reading.start();
        launch(args);
        

    }
}
