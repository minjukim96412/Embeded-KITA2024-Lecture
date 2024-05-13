package javabasic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer {

	public static final int SERVERSOCKET_PORT = 9999;
	
	public static void main(String[] args) {

		ServerSocket ss = null; 

		try {
			ss = new ServerSocket(SERVERSOCKET_PORT);

			if (ss != null) {
				System.out.println("ServerSocket 생성됨!");
			}
			// 클라이언트가 접속을 종료할때 까지 계속 대기?
			// 반환타입:socket 클라이언트와 교신 할 서버의 소켓
			while(true) {
			Socket svSocket = ss.accept();
			if (svSocket != null) {
				System.out.println("서비 측 Socket 생성됨!" + svSocket);
				}
			InputStream is = svSocket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			System.out.println(br.readLine());
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}// main

}// class
