package com.jieun.n1.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket s = null;
		ArrayList<LunchDTO> ar_l = new ArrayList<>();
		ArrayList<DinnerDTO> ar_d = new ArrayList<>();
		Random r = new Random();
		String menu = null;
		
		LunchDTO lunchDTO = null;
		DinnerDTO dinnerDTO = null;
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
			int select = Integer.parseInt(str.trim());
			
			if(select==1) {
				lunchDTO = new LunchDTO();
				ar_l = lunchDTO.lunch();
				int i = r.nextInt(6);
				LunchDTO st =ar_l.get(i);
				menu = st.getMenu()+"\n금액:"+st.getPrice();
				
			}else if(select==2) {
				dinnerDTO = new DinnerDTO();
				ar_d = dinnerDTO.dinner();
				int i = r.nextInt(6);
				DinnerDTO st = ar_d.get(i);
				menu = st.getMenu()+"\n금액:"+st.getPrice();
				
			}
			System.out.println("메뉴 :" + menu+"\n");
			

		} catch (IOException e) {//위에서 접속이 실패하면 exception으로 처리된다.
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
