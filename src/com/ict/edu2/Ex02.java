package com.ict.edu2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// ���ڼ��� : ���� ���� �״�� �ǵ��� �ش�. 
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
			System.out.println("���� ���� ��� �� ... ");
			new Thread(this).start();
		}catch (Exception e) {
		}
	}
	@Override
	public void run() {
		while (true) {
			try {
				   s =  ss.accept();
				   // Ŭ���̾�Ʈ�� ���ڸ� �����Դ�. �������� ����Ʈ ��Ʈ�� ó�� �ؾ� �Ѵ�.
				   in = s.getInputStream();
				   isr = new InputStreamReader(in);
				   br = new BufferedReader(isr);
				   
				   // �� �پ� ������ 
				   String msg = br.readLine();
				   System.out.println("���� ���� : " +  msg);
				   
				   // ���
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
