/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ardrone;

import com.codeminders.ardrone.ARDrone;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author Johnnatan
 */
public class Controle {

    public ARDrone drone;
    private Sensores sensores;
    private static String nameFile;
    

    public Controle() throws UnknownHostException, IOException {
        init();
    }

    private void init() throws UnknownHostException, IOException {
        drone = new ARDrone();
        
        drone.connect();
       // drone.waitForReady(30000);
        drone.playAnimation(10, 10);
       
        
        sensores = new Sensores(nameFile);
        drone.addNavDataListener(sensores);
    }

    public static void setNameFile(String name) {
        nameFile = name;
    }

    public String getSensores() {
        return sensores.getData();
    }

    public void hover() throws IOException {
        drone.hover();
    }

    public void moveUp() throws IOException {
        drone.move(0f, 0f, 1f, 0f);
    }

    public void moveDown() throws IOException {
        drone.move(0f, 0f, -1f, 0f);
    }

    public void moveFront() throws IOException {
        drone.move(0f, -1f, 0f, 0f);
    }

    public void moveBack() throws IOException {
        drone.move(0f, 1f, 0f, 0f);
    }

    public void moveRight() throws IOException {
        drone.move(1f, 0f, 0f, 0f);
    }

    public void moveLeft() throws IOException {
        drone.move(-1f, 0f, 0f, 0f);
    }

    public void moveYawRight() throws IOException {
        drone.move(0f, 0f, 0f, -1f);
    }

    public void moveYawLeft() throws IOException {
        drone.move(0f, 0f, 0f, 1f);
    }

    public void takeOff() throws IOException {
        if (drone.isEmergencyMode()) {
            drone.clearEmergencySignal();
        }
        drone.trim();
        drone.takeOff();
    }

    public void land() throws IOException {
        drone.land();
    }

    public void disconnect() throws IOException {
        sensores.closeFile();
        drone.removeNavDataListener(sensores);
        drone.disconnect();
    }

    public ARDrone getDrone() {
        return drone;
    }

    public void executeSequence2() throws InterruptedException, IOException {
/*
        takeOff();
        Thread.sleep(3000);
        for (int i = 0; i < 15; i++) {
            moveFront();
            Thread.sleep(150);
            moveFront();
            Thread.sleep(150);
        }
        Thread.sleep(3000);

        land();

        Thread.sleep(3000);

        disconnect();
        * */
    }
    
     public void executeSequence3() throws IOException, InterruptedException {
     /*
         takeOff();
         Thread.sleep(20000);
         drone.land();
         Thread.sleep(3000);
         drone.disconnect();
         */
     }

    public void executeSequence1() throws IOException, InterruptedException {
       /*
        takeOff();
        Thread.sleep(3000);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);

        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);

        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);

        Thread.sleep(2000);



        moveYawRight();
        Thread.sleep(150);
        moveYawRight();
        moveYawRight();
        Thread.sleep(150);
        moveYawRight();

        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);
        moveFront();
        Thread.sleep(150);

        moveFront();
        Thread.sleep(150);



        land();

        Thread.sleep(3000);

        disconnect();
*/
    }
}
