package kr.co.camp.main.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;


public class MainController {

	public void imgLoading() throws UnsupportedEncodingException{
			String text = URLEncoder.encode("캠핑장", "UTF-8");
			String apiUrl = "https://maps.googleapis.com/maps/api/place/textsearch/json?query="+text+"&key=AIzaSyBkd_UadYzaVrZo1iLoAVTLtV3iSkl_MwI";
			
			try {
				URL url = new URL(apiUrl);
				InputStream in = url.openStream();
				InputStreamReader isr = new InputStreamReader(in);	
				BufferedReader br = new BufferedReader(isr);
				while(true){
					String line = br.readLine();
					if(line == null) break;
					System.out.println(line);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
