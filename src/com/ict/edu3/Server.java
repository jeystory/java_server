package com.ict.edu3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {
	ServerSocket ss;
	Socket s;
	
	// 여러명의 접속자 정보를 받아서 처리하기 위한 컬렉션
	ArrayList<Player> list;
	public Server() {
		try {
			list = new ArrayList<Player>();
			ss = new ServerSocket(7780);
			System.out.println("멀티 서버 대기 중 ...");
			new Thread(this).start();
		} catch (Exception e) {
		}
	}
	@Override
	public void run() {
		while (true) {
			try {
				s = ss.accept();
				Player player = new Player(s,this);
				list.add(player);
				new Thread(player).start();
			} catch (Exception e) {
				System.out.println("1" + e);
			} finally {
				try {
				} catch (Exception e2) {
					System.out.println("2" +e2);
				}
			}
		}
	}
	
	// 메세지를 리스트 전체에게 전달 메소드
	 public void sendMsg(String msg) {
		 try {
			 msg += System.getProperty("line.separator");
			 for (Player k : list) {
				k.bw.write(msg);
				k.bw.flush();
			}
		} catch (Exception e) {
		}
	 }
	// 리스트에서 객체 삭제 메소드
	public void delPlayer(Player player) {
		list.remove(player);
		sendMsg(player.ip+": 퇴장");
	}
	public static void main(String[] args) {
		new Server();
	}
}
