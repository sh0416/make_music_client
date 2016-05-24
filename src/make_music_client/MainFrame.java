package make_music_client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	enum State {HOST, PARTICIPANT};
	
	public static MainFrame frame;
	public static RoomInterface sock;
	public static ServerInterface server;
	public static Boolean sendFlag;
	public static State state;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		frame = new MainFrame();
		
		sendFlag = new Boolean(true);
		server = new ServerInterface("119.202.82.153", 10002, sendFlag);
		server.sendMessageToServer(InetAddress.getLocalHost().getHostAddress());
	}
	
	public MainFrame() {
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		MainPanel main = new MainPanel();
		
		getContentPane().add(main.panel);
		setVisible(true);
	}
}

