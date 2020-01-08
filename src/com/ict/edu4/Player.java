package com.ict.edu4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Player implements Runnable {
	Socket s;
	Server server;
	
	// ��ü �����
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String ip;

	public Player() {}
	public Player(Socket s, Server server) {
		this.s = s;
		this.server = server;
		// ����� �غ�
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {
			System.out.println(1);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				// ������ �������� �����̴�.
				VO vo = (VO)ois.readObject();
				switch (vo.getNo()) {
					case 100 : 
					case 200 :  vo.setMsg(ip+":" + vo.getMsg()); 
					            server.sendMsg(vo); break;
					            
					case 300 :  server.delPlayer(this); break;
				}
			}
		} catch (Exception e) {
			System.out.println("3" + e);
		} finally {
			try {
			} catch (Exception e2) {
				System.out.println("4" + e2);
			}
		}

	}
}
