package com.jieun.n1.ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DinnerDTO {
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
public ArrayList<DinnerDTO> dinner(){
	File file  = new File("c:\\test","dinner.txt");
	FileReader fr = null;
	BufferedReader br  = null;
	ArrayList<DinnerDTO> ar  = new ArrayList<>();
	
	try {
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		while(br.ready()) {
			DinnerDTO dinnerDTO = new DinnerDTO();
			String str = br.readLine();
			str=str.replace(',','.').trim();//앞뒤 공백을제거
			StringTokenizer st = new StringTokenizer(str, ".");
			dinnerDTO.setMenu(st.nextToken());
			dinnerDTO.setPrice(Integer.parseInt(st.nextToken()));
			ar.add(dinnerDTO);
		}
	} catch (IOException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return ar;
}

}
