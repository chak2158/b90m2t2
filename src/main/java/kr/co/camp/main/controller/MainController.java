package kr.co.camp.main.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.camp.repository.vo.SearchDetailVO;
import kr.co.camp.repository.vo.SearchVO;

@RestController
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/searchCamp.do")
	public String searchCamp(SearchVO search) throws Exception {
		
		System.out.println(search.getSearchWord());
		
		String text = URLEncoder.encode(search.getSearchWord(), "UTF-8");
		String apiUrl = "https://maps.googleapis.com/maps/api/place/textsearch/json?query="+text+"&language=ko&types=campground|rv_park&key=AIzaSyBkd_UadYzaVrZo1iLoAVTLtV3iSkl_MwI";
		
		URL url = new URL(apiUrl);
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);	
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer sb = new StringBuffer();
		
		while(true){
			String line = br.readLine();
			if(line == null) break;
			sb.append(line+"\n");
		}
		System.out.println(sb.toString());
		
		return sb.toString();
		
		
	}
	
	@RequestMapping("/searchDetail.do")
	public String searchImg(SearchDetailVO search) throws Exception {
		
		System.out.println(search.getPlaceId());
		
		String src = URLEncoder.encode(search.getPlaceId(), "UTF-8");
		
		String apiUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+src+"&key=AIzaSyBkd_UadYzaVrZo1iLoAVTLtV3iSkl_MwI";
		
		URL url = new URL(apiUrl);
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);	
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		
		while(true){
			String line = br.readLine();
			if(line == null) break;
			sb.append(line);
		}
		System.out.println(sb.toString());
		
		return sb.toString();
		
		
	}
	
//	public void imgLoading() throws UnsupportedEncodingException{
//			
//			try {
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
}
