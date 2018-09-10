package fxmlexample;

import javafx.scene.control.Label;

public class ModbusThread implements Runnable{
	private Label EggOne;

	public ModbusThread(Label EggOne) {
		this.EggOne = EggOne;
	}

    // Use the Runnable implementation.
    public void run() {

            while (true) {

                // Wait 2 sec before next reading
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                //    modbusClient.Connect();

                  //  if (modbusClient.isConnected()) {

                        // Read Float Value from Holding register 25 and 26 "401025 and 401026"

                        // startingAddress - Fist Address to read; Shifted by -1
                        // quantity - Number of Inputs to read

                        //box 1 1025 - 1026 register
                //        temp = ModbusClient.ConvertRegistersToFloat(modbusClient.ReadHoldingRegisters(1024, 2));
                        double result = -271.3; //(temp - KelvinConstant);
                        String str = String.format("%.4f", result) + " deg" + " Averager Temperauter box 1";
                        System.out.println(String.format("%.4f", result) + " deg" + " Averager Temperauter box 1");
                        if (EggOne == null) {
                            System.out.println("EggOne is Null");
                        } else {
                            EggOne.setText(str);
                            System.out.println("EggOne is "+String.valueOf(result));
                        }


//                    } else {
//                        System.out.println("modbus is unreacable");
//                    }


                } catch (Exception e) {
                    System.out.println(e.toString());
                }


            }

            //EggTwo.setText(String.valueOf(TempDataReceived[1]));
            //EggTree.setText(String.valueOf(TempDataReceived[2]));
            //Eggfour.setText(String.valueOf(TempDataReceived[3]));

        }

}



