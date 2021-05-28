package mass.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/mass")
public class SystemController {
	// main index
	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/main_index");
		
		return mv;
	}
	
	// sub page
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView sub() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/sub_page");
		
		BufferedReader br = null;
		String line;
		String path = "D:\\컴퓨터공학\\java\\workspace\\mass\\src\\main\\resources\\static\\의료기관평가인증원_환자안전 사고데이터_20181231.csv";
		
		JsonObject jsonObject = new JsonObject();
		 
		JsonArray HArray = new JsonArray();
 
		JsonObject HInfo = new JsonObject();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			int rows = 9251;
			int cols = 20;
			int c= 0;
			int mc = 0;
			int n = 0;
			int a = 0;
			int b = 0;
			int d = 0;
			int f = 0;
			int e = 0;
			int h = 0;
			String[][] matrix= new String[rows][cols];
			int row = 0;
			while((line = br.readLine()) != null) {
				if ( line.isEmpty() ) {
			        continue;
			    }
				String[] temp = line.split(","); // 탭으로 구분
				
			    for(int col= 0; col < cols; col++) {
			        matrix[row][col]= temp[col];
			    }
			    row++;
			}
			for(int i = 0; i < rows; i++)
			{
				if(matrix[i][7].contains("500"))
					if(matrix[i][7].contains("200"))
						c++;
					else mc++;
				else n++;
					
			}
			for(int i = 0; i < rows; i++)
			{
				if(matrix[i][6].contains("병원"))
					if(matrix[i][6].contains("상급종합"))
						b++;
					else if(matrix[i][6].contains("요양"))
						d++;
					else if(matrix[i][6].contains("종합"))
						e++;
					else
						a++;
				else if(matrix[i][6].contains("약국"))
					h++;
				else
					f++;
					
			}
			
			HInfo.addProperty("location", "병원");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "종합병원");
			HInfo.addProperty("count", e + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "상급종합병원");
			HInfo.addProperty("count", b + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "약국");
			HInfo.addProperty("count", h + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "불명확");
			HInfo.addProperty("count", (f-1) + "");
			HArray.add(HInfo);
			
			/* jsonObject.addProperty("Hospital", HArray); */
			mv.addObject("HArray", HArray.toString());
			
			JsonArray SArray = new JsonArray();
			 
			JsonObject SInfo = new JsonObject();
	        SInfo.addProperty("range", "500이상");
	        SInfo.addProperty("count", mc + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "200이상 500미만");
	        SInfo.addProperty("count", c + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "불명확");
	        SInfo.addProperty("count", (n-1) + "");
	        SArray.add(SInfo);
	        
			/* jsonObject.addProperty("Scale", SArray); */
	        mv.addObject("SArray", SArray.toString());
	        
	        String jsonInfo = jsonObject.toString();
	        
	        System.out.print(jsonInfo);
			
			/*System.out.println("병원" + a);
			System.out.println("상급종합병원 " + b);
			System.out.println("종합병원" + e);
			System.out.println("요양병원" + d);
			System.out.println("약국" + h);
			System.out.println("불명확" + (f-1));
			
			System.out.println("200 ~ 500 병상규모 :" + c);
			System.out.println("500이상 병상 규모 : " + mc);
			System.out.println("불명확한 병상 규모 :" + (n-1));*/
			/* for(int i = 0; i < rows; i++)
			 {
				 for(int j = 0; j < cols; j++)
					 System.out.print(matrix[i][j]);
				 System.out.println();
			 }*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	// sub release
	@GetMapping("/sub2")
	public ModelAndView sub2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/sub_release");
			
		return mv;
	}

	// about us
	@GetMapping("/aboutus")
	public ModelAndView aboutus() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/sub_about_us");

		return mv;
	}
	
	
	
	@RequestMapping(value = "/aa", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/JSONparse2");
		//상위 오브젝트 생성
		JsonObject obj1 = new JsonObject();
		//data: 뒤에 들어갈 값인 jArray 생성
		JsonArray jArray = new JsonArray();
		
		//배열생성, jArray의 0번째 배열에 쭈루룩, 1번째 배열에 쭈루룩~
		for(int i=0; i<10; i++){
		
			JsonObject obj2 = new JsonObject();
			//obj2는 반드시 for문 안에 놓아야 한다. 그래야 중복이 안생긴다.
			
			obj2.addProperty("name",i + "name");
			obj2.addProperty("position",i + "position");
			obj2.addProperty("salary",i + "salary");
			obj2.addProperty("start_date",i + "start_date");
			obj2.addProperty("office",i + "office");
			obj2.addProperty("extn",i + "extn");
			
			jArray.add(obj2);

		}
		
		//마지막으로 최상위의 jsonObject에 data와 jArry를 넣어준다.
		
		System.out.println(jArray.toString());
		mv.addObject("jObject", jArray.toString());
		
		return mv;
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView json() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/JSONparse2");
		BufferedReader br = null;
		String line;
		String path = "D:\\컴퓨터공학\\java\\workspace\\mass\\src\\main\\resources\\static\\의료기관평가인증원_환자안전 사고데이터_20181231.csv";
		
		JsonObject jsonObject = new JsonObject();
		 
		JsonArray HArray = new JsonArray();
 
		JsonObject HInfo = new JsonObject();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			int rows = 9251;
			int cols = 20;
			int c= 0;
			int mc = 0;
			int n = 0;
			int a = 0;
			int b = 0;
			int d = 0;
			int f = 0;
			int e = 0;
			int h = 0;
			String[][] matrix= new String[rows][cols];
			int row = 0;
			while((line = br.readLine()) != null) {
				if ( line.isEmpty() ) {
			        continue;
			    }
				String[] temp = line.split(","); // 탭으로 구분
				
			    for(int col= 0; col < cols; col++) {
			        matrix[row][col]= temp[col];
			    }
			    row++;
			}
			for(int i = 0; i < rows; i++)
			{
				if(matrix[i][7].contains("500"))
					if(matrix[i][7].contains("200"))
						c++;
					else mc++;
				else n++;
					
			}
			for(int i = 0; i < rows; i++)
			{
				if(matrix[i][6].contains("병원"))
					if(matrix[i][6].contains("상급종합"))
						b++;
					else if(matrix[i][6].contains("요양"))
						d++;
					else if(matrix[i][6].contains("종합"))
						e++;
					else
						a++;
				else if(matrix[i][6].contains("약국"))
					h++;
				else
					f++;
					
			}
			
			HInfo.addProperty("location", "병원");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "종합병원");
			HInfo.addProperty("count", e + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "상급종합병원");
			HInfo.addProperty("count", b + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "약국");
			HInfo.addProperty("count", h + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "불명확");
			HInfo.addProperty("count", (f-1) + "");
			HArray.add(HInfo);
			
			/* jsonObject.addProperty("Hospital", HArray); */
			mv.addObject("HArray", HArray.toString());
			
			JsonArray SArray = new JsonArray();
			 
			JsonObject SInfo = new JsonObject();
	        SInfo.addProperty("range", "500이상");
	        SInfo.addProperty("count", mc + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "200이상 500미만");
	        SInfo.addProperty("count", c + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "불명확");
	        SInfo.addProperty("count", (n-1) + "");
	        SArray.add(SInfo);
	        
			/* jsonObject.addProperty("Scale", SArray); */
	        mv.addObject("SArray", SArray.toString());
	        
	        String jsonInfo = jsonObject.toString();
	        
	        System.out.print(jsonInfo);
			
			/*System.out.println("병원" + a);
			System.out.println("상급종합병원 " + b);
			System.out.println("종합병원" + e);
			System.out.println("요양병원" + d);
			System.out.println("약국" + h);
			System.out.println("불명확" + (f-1));
			
			System.out.println("200 ~ 500 병상규모 :" + c);
			System.out.println("500이상 병상 규모 : " + mc);
			System.out.println("불명확한 병상 규모 :" + (n-1));*/
			/* for(int i = 0; i < rows; i++)
			 {
				 for(int j = 0; j < cols; j++)
					 System.out.print(matrix[i][j]);
				 System.out.println();
			 }*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
}
