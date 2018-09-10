package fxmlexample;

//import de.re.easymodbus.modbusclient.ModbusClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Controller  {


    /************** Cornect to camera **************/
    // port 502 is used for Modbus TCP/IP this protocol is MBAP
   // ModbusClient modbusClient = new ModbusClient("192.168.0.20", 502);

    /********* Temperature constants and variables **/
    private float KelvinConstant = (float) 273.15;
    private float result = 0;
    private float temp = 0;


    /********* Previos Stage variable **************/

    // Keep track on previous stage so it cant be closed when opening a new stage.

    Stage prevStage;

    public void set_Prev_Stage(Stage stage) {

        this.prevStage = stage;
    }

    /*********** Initialise Labels *****************/

    /********* Egg Temperature Variables ***********/


    @FXML
    public Label EggOne;

    @FXML
    private Label EggTwo;

    @FXML
    private Label EggTree;

    @FXML
    private Label Eggfour;


    /************ Selecting Scenes ******************/

    @FXML
    public void go_to_Calibration() throws Exception {
        Set_Screen_to("calibration");

    }

    @FXML
    public void gotoMain() throws Exception {
        Set_Screen_to("Main");
    }

    /************* Selecting Scene **************************/

    public void Set_Screen_to(String StageName) throws Exception {
        Stage stage = new Stage();

        if (StageName == "calibration") {

            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Calibration_Screen.fxml"));

            Pane myPane = myLoader.load();

            Controller controller = myLoader.getController();

            controller.set_Prev_Stage(stage);

            Scene myScene = new Scene(myPane);
            stage.setScene(myScene);

            prevStage.close();

            stage.show();
        }
        if (StageName == "Main") {

            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Main_Screen.fxml"));

            Pane myPane = myLoader.load();

            Controller controller = myLoader.getController();

            controller.set_Prev_Stage(stage);

            Scene myScene = new Scene(myPane);
            stage.setScene(myScene);

            prevStage.close();

            stage.show();

        }

    }

}
    /************ Update Temperature Readings ***************/

