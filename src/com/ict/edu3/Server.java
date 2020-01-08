package com.ict.edu3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {
	ServerSocket ss;
	Socket s;
	
	// �������� ������ ������ �޾Ƽ� ó���ϱ� ���� �÷���
	ArrayList<Player> list;
	public Server() {
		try {
			list = new ArrayList<Player>();
			ss = new ServerSocket(7780);
			System.out.println("��Ƽ ���� ��� �� ...");
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
	
	// �޼����� ����Ʈ ��ü���� ���� �޼ҵ�
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
	// ����Ʈ���� ��ü ���� �޼ҵ�
	public void delPlayer(Player player) {
		list.remove(player);
		sendMsg(player.ip+": ����");
	}
	public static void main(String[] args) {
		new Server();
	}
}
