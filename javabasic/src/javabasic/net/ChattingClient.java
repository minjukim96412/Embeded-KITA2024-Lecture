package javabasic.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattingClient {

	public static void main(String[] args) {
		
		Socket s = null;
		try {
			s = new Socket("localhost", 9999);
//			s = new Socket("192.168.8.7", 9999);
//			s = new Socket("127.0.0.1", 9999); 
			if (s != null) {
				System.out.println("채팅서버에 연결되었습니다! " + s);
				OutputStream os = s.getOutputStream();
				OutputStreamWriter osw  = new OutputStreamWriter(os);
				osw.write("안녕하세용");
				osw.flush();
			}
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
	}//main
	
}//class
