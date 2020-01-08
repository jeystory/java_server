package com.ict.edu2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 에코 서버 : 받은 내용 그대로 되돌려줌
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
			System.out.println("에코 서버 대기중");
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
				// 클라이언트의 글자 전송 . 서버에서 바이트 스트림 처리.
				in = s.getInputStream();
				bis = new BufferedInputStream(in);
				
				/*
				//  한글자씩 받아 출력하기
				// 한바이트씩 받아서 바로 보낼때 사용하는 경우.
				byte b;
				while((b=(byte)bis.read()) != -1) {
					System.out.println((char)b);
				}
				*/
				
				// 배열로 받아서 처리(크기에 대한 단점 존재)
				byte[] b = new byte[1024];
				bis.read(b);
				String msg = new String(b).trim();
				System.out.println("보낸 내용 : " + msg);
				
				// 받은 내용 클라이언트에 다시 보내기
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
