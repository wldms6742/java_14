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
			
			//먼저 실행이 되어있어야함
				ss = new ServerSocket(8282);
				System.out.println("클라이언트의 요청을 기다리는 중");
				s = ss.accept();//클라이언트의 소켓정보를 받음

				InputStream is = s.getInputStream();//byte
				InputStreamReader ir = new InputStreamReader(is);//char
				BufferedReader br = new BufferedReader(ir);
				String str = br.readLine();
				//정보를 받아서 출력해줌
				System.out.println("Clinet Message: "+str);
				
			

		} catch (IOException e) {//위에서 접속이 실패하면 exception으로 처리된다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
