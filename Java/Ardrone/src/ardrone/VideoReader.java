/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ardrone;

import com.codeminders.ardrone.video.*;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.net.*;
import com.codeminders.ardrone.ARDrone;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author Johnnatan
 */
public class VideoReader{ //implements Runnable {
/*
    private Logger log = Logger.getLogger(getClass().getName());
    private static final int BUFSIZE = 100 * 1024;
    private DatagramChannel channel;
    private Selector selector;
    private boolean done;
    private ARDrone drone;

    public VideoReader(ARDrone drone, InetAddress droneAddress, int videoPort) throws IOException {
        this.drone = drone;
        channel = DatagramChannel.open();
        channel.configureBlocking(false);
        channel.socket().setReuseAddress(true);
        channel.socket().bind(new InetSocketAddress(droneAddress, videoPort));

        selector = Selector.open();

        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    private void disconnect() {
        try {
            selector.close();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        try {
            channel.disconnect();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            ByteBuffer inbuf = ByteBuffer.allocate(BUFSIZE);
            done = false;
            while (!done) {
                selector.select();
                if (done) {
                    disconnect();
                    break;
                }

                Set readyKeys = selector.selectedKeys();
                Iterator iterator = readyKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    iterator.remove();

                }
            }
        } catch (Exception e) {
            drone.changeToErrorState(e);
            log.error(e.getMessage());

        }
    }

    public void stop() {
        done = true;
        selector.wakeup();
    }
    */
}
