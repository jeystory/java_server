package com.ict.edu2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 에코서버 : 받은 내용 그대로 되돌려 준다. 
public class Ex02 implements Runnable{
	ServerSocket ss;
	Socket s;
	
	InputStream in ;
	InputStreamReader isr ;
    BufferedReader br ;
    
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;
	
	public Ex02() {
		try {
			ss = new ServerSocket(7779);
			System.out.println("에코 서버 대기 중 ... ");
			new Thread(this).start();
		}catch (Exception e) {
		}
	}
	@Override
	public void run() {
		while (true) {
			try {
				   s =  ss.accept();
				   // 클라이언트가 글자를 보내왔다. 서버에서 바이트 스트림 처리 해야 한다.
				   in = s.getInputStream();
				   isr = new InputStreamReader(in);
				   br = new BufferedReader(isr);
				   
				   // 한 줄씩 읽을때 
				   String msg = br.readLine();
				   System.out.println("보낸 내용 : " +  msg);
				   
				   // 출력
				   out = s.getOutputStream();
				   osw = new OutputStreamWriter(out);
				   bw = new BufferedWriter(osw);
				   
				   msg += System.getProperty("line.separator");
				   bw.write(msg);
				   bw.flush();
				   
				
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					isr.close();
					osw.close();
					out.close();
					in.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Ex02();
	}
}
