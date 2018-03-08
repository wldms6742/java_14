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

public class Server {
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket s = null;
		try {
			boolean check = true;
			while(check) {
				ss = new ServerSocket(8282);
				System.out.println("클라이언트의 요청을 기다리는 중");
				s = ss.accept();

				InputStream is = s.getInputStream();//byte
				InputStreamReader ir = new InputStreamReader(is);//char
				BufferedReader br = new BufferedReader(ir);
				String str = br.readLine();

				System.out.println("Clinet Message: "+str);

				OutputStream os = s.getOutputStream();
				OutputStreamWriter ow = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(ow);
				System.out.println("서버로 보낼 메세지 입력");
				Scanner sc = new Scanner(System.in);
				str = sc.next();
				bw.write(str);
				bw.flush();
				if(str.equals("exit")) {
					check = false;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
