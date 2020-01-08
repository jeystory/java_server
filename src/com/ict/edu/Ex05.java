package com.ict.edu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// �ڹ� ��� : ���� ���
// ��Ʈ : ���ο� �ܺθ� �����ϴ� ����Ʈ ��Ȱ
//			- 0-65535 , 0~1024�� ����ڰ� �������� ����.21:FTP, 23:TELNET, 80: HTTP, 8080 : ����Ŭ,��Ĺ
// �ڹ� ���� : ServerSocket, Socket Ŭ���� ���

public class Ex05 {
	ServerSocket ss = null;
	Socket s = null;

	public Ex05() {
		try {
			// 1 create server socket
			ss = new ServerSocket(7777);
			// 2. Ŭ���̾�Ʈ�� ������ ������ ���
			System.out.println("���� �����..");

			new Thread(new Runnable() {
				// Android ���� thread �����ϰ� ������ ��
				@Override
				public void run() {

					try {
						while (true) {
							s = ss.accept();
							// Ŭ���̾�Ʈ ����
							String ip = s.getInetAddress().getHostAddress();
							String name = s.getInetAddress().getHostName();

							System.out.println("name : " + name);
							System.out.println("IP : " + ip);
							System.out.println("bye");
						}
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}).start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Ex05();
	}
}
