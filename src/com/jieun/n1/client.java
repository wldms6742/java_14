package com.jieun.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		Socket sc=null;
		ServerSocket ss = null;
		try {
			boolean check = true;
			while(check) {
				sc = new Socket("192.168.20.22", 8282);
				OutputStream os = sc.getOutputStream();//byte
				OutputStreamWriter ow = new OutputStreamWriter(os);//char
				BufferedWriter bw = new BufferedWriter(ow);
				System.out.println("서버로 보낼 메세지 입력");
				Scanner s = new Scanner(System.in);
				String str = s.next();
				bw.write(str);
				bw.flush();
				
				sc = ss.accept();
				InputStream is = sc.getInputStream();//byte
				InputStreamReader ir = new InputStreamReader(is);//char
				BufferedReader br = new BufferedReader(ir);
				str = br.readLine();

				System.out.println("Clinet Message: "+str); 

				if(str.equals("exit")) {
					check = false;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
