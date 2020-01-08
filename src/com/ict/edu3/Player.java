package com.ict.edu3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Player implements Runnable {
	Socket s;
	Server server;
	BufferedReader br;
	BufferedWriter bw;

	String msg;
	String ip;

	public Player() {
	}

	public Player(Socket s, Server server) {
		this.s = s;
		this.server = server;
		// 입출력 준비
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {
			System.out.println(1);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				msg = br.readLine();
				if (msg.equalsIgnoreCase("exit")) {
					String str = "bye~~";
					str += System.getProperty("line.separator");
					bw.write(str);
					bw.flush();
					// 리스트에서 자기 자신 지우는 메소드 (server)
					server.delPlayer(this);
					break;
				} else {
					// 리스트에서 메세지 전달
					server.sendMsg(ip + ":" + msg);
				}
			}
		} catch (Exception e) {
			System.out.println("3" + e);
		} finally {
			try {
				bw.close();
				br.close();
			} catch (Exception e2) {
				System.out.println("4" + e2);
			}
		}

	}
}
