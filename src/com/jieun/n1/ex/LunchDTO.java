package com.jieun.n1.ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class LunchDTO {
	private int price;
	private String menu;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public ArrayList<LunchDTO> lunch() {
		File file = new File("c:\\test","lunch.txt");
		FileReader fr = null;
		BufferedReader br=null;
		ArrayList<LunchDTO> ar  = new ArrayList<>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(br.ready()) {
				LunchDTO lunchDTO = new LunchDTO();
				String str = br.readLine();
				str=str.replace(',','.').trim();//앞뒤 공백을제거
				StringTokenizer st = new StringTokenizer(str, ".");
				lunchDTO.setMenu(st.nextToken());
				lunchDTO.setPrice(Integer.parseInt(st.nextToken()));
				ar.add(lunchDTO);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
}
