import java.io.*;
import java.net.*;

public class ChatClientReader extends Thread {

	private Socket socket = null;
	BufferedReader in;
	
	public ChatClientReader(Socket s) {
		super ("ChatClientReader");
		socket = s;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // constructor
	
	public void run() {
		
		String fromServer = "";

		while (!socket.isClosed()) {
			try {
				while ((fromServer = in.readLine()) != null)
					System.out.println("CCR " + fromServer);
			} catch (IOException e) {
				System.out.println("Buffer input error. Exiting.");
				e.printStackTrace();
				System.exit(-1);
			} // inner loop
		} // outer loop
		
	} // run
	
} // ClientMsgReader