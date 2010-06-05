package org.pititom.core.stream.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.InetSocketAddress;

import org.pititom.core.stream.UdpIpInputStream;
import org.pititom.core.stream.editor.StreamControllerConnection;

/**
 * 
 * @author Thomas Pérennou
 */
public class Reception {

	public static void main(String[] arguments) throws Exception {
		final PipedOutputStream pipedOut = new PipedOutputStream();
		final StreamControllerConnection connection = new StreamControllerConnection(new UdpIpInputStream(new InetSocketAddress("230.2.15.2", 5200), null, true, true, 64), pipedOut, new Decoder());
		final PipedInputStream pipedIn = new PipedInputStream(pipedOut);
		connection.connect();

		final ObjectInputStream inputStream = new ObjectInputStream(pipedIn);
		while (true) {
			try {
				System.out.println("Object recieved from reception: " + inputStream.readObject());
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				exception.printStackTrace();
			}
		}
	}

}
