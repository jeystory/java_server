package com.ict.edu2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// ���� ���� : ���� ���� �״�� �ǵ�����
public class Ex01 implements Runnable{
	ServerSocket ss;
	Socket s;
	InputStream in;
	BufferedInputStream bis;
	
	OutputStream out;
	BufferedOutputStream bos;
	
	public Ex01() {
		
		
		try {
			ss= new ServerSocket(7779);
			System.out.println("���� ���� �����");
			new Thread(this).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Ex01();
		
		
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				s = ss.accept();
				// Ŭ���̾�Ʈ�� ���� ���� . �������� ����Ʈ ��Ʈ�� ó��.
				in = s.getInputStream();
				bis = new BufferedInputStream(in);
				
				/*
				//  �ѱ��ھ� �޾� ����ϱ�
				// �ѹ���Ʈ�� �޾Ƽ� �ٷ� ������ ����ϴ� ���.
				byte b;
				while((b=(byte)bis.read()) != -1) {
					System.out.println((char)b);
				}
				*/
				
				// �迭�� �޾Ƽ� ó��(ũ�⿡ ���� ���� ����)
				byte[] b = new byte[1024];
				bis.read(b);
				String msg = new String(b).trim();
				System.out.println("���� ���� : " + msg);
				
				// ���� ���� Ŭ���̾�Ʈ�� �ٽ� ������
				out= s.getOutputStream();
				bos = new BufferedOutputStream(out);
				bos.write(msg.getBytes());
				bos.flush();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				ss.close();
				bos.close();
				bis.close();
				in.close();
				out.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	}
}
