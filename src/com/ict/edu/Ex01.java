package com.ict.edu;

import java.net.ServerSocket;
import java.net.Socket;

// �ڹ� ��� : ���� ���
// ��Ʈ : ���ο� �ܺθ� �����ϴ� ����Ʈ ��Ȱ
//			- 0-65535 , 0~1024�� ����ڰ� �������� ����.21:FTP, 23:TELNET, 80: HTTP, 8080 : ����Ŭ,��Ĺ
// �ڹ� ���� : ServerSocket, Socket Ŭ���� ���

public class Ex01 {
	public static void main(String[] args) {
		ServerSocket ss =null;
		Socket s = null;
		
		try {
			// 1 create server socket
			ss = new ServerSocket(7777);
			// 2. Ŭ���̾�Ʈ�� ������ ������ ���
			System.out.println("���� �����..");
			//3. Ŭ���̾�Ʈ�� ������ �ϸ� �ش� Ŭ���̾�Ʈ�� ���� ��� ������ ����� ����
			//    s(������)�� Ŭ���̾�Ʈ�� ���� ������ ����
			s = ss.accept();
			
			// Ŭ���̾�Ʈ ����
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
