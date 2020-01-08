package com.ict.edu;

import java.net.ServerSocket;
import java.net.Socket;

// 자바 통신 : 소켓 통신
// 포트 : 내부와 외부를 연결하는 게이트 역활
//			- 0-65535 , 0~1024는 사용자가 지정하지 않음.21:FTP, 23:TELNET, 80: HTTP, 8080 : 오라클,톰캣
// 자바 서버 : ServerSocket, Socket 클래스 사용

public class Ex01 {
	public static void main(String[] args) {
		ServerSocket ss =null;
		Socket s = null;
		
		try {
			// 1 create server socket
			ss = new ServerSocket(7777);
			// 2. 클라이언트가 접속할 때까지 대기
			System.out.println("서버 대기중..");
			//3. 클라이언트가 접속을 하면 해당 클라이언트에 대한 담당 소켓을 만들어 배정
			//    s(담당소켓)는 클라이언트에 대한 정보를 가짐
			s = ss.accept();
			
			// 클라이언트 정보
			String ip = s.getInetAddress().getHostAddress();
			String name = s.getInetAddress().getHostName();
			
			System.out.println("name : " + name );
			System.out.println("IP : " + ip );
			System.out.println("bye");
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
