package com.ict.edu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// �ڹ� ��� : ���� ���
// ��Ʈ : ���ο� �ܺθ� �����ϴ� ����Ʈ ��Ȱ
//			- 0-65535 , 0~1024�� ����ڰ� �������� ����.21:FTP, 23:TELNET, 80: HTTP, 8080 : ����Ŭ,��Ĺ
// �ڹ� ���� : ServerSocket, Socket Ŭ���� ���

public class Ex02 implements Runnable {
	static ServerSocket ss =null;
	Socket s = null;
	
	public static void main(String[] args) {
		
		
		try {
			// 1 create server socket
			ss = new ServerSocket(7777);
			// 2. Ŭ���̾�Ʈ�� ������ ������ ���
			System.out.println("���� �����..");
			
			new Thread(new Ex02()).start();
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}

	@Override
	public void run() {
		//3. Ŭ���̾�Ʈ�� ������ �ϸ� �ش� Ŭ���̾�Ʈ�� ���� ��� ������ ����� ����
		//    s(������)�� Ŭ���̾�Ʈ�� ���� ������ ����
		try {
			s = ss.accept();
			// Ŭ���̾�Ʈ ����
			String ip = s.getInetAddress().getHostAddress();
			String name = s.getInetAddress().getHostName();
			
			System.out.println("name : " + name );
			System.out.println("IP : " + ip );
			System.out.println("bye");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
