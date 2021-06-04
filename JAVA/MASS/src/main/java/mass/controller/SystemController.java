package mass.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
		BufferedReader pr = null;
		String line, line2;
		
		String path = "D:\\컴퓨터공학\\java\\workspace\\mass\\src\\main\\resources\\static\\2.csv";
		String path2 = "D:\\컴퓨터공학\\java\\workspace\\mass\\src\\main\\resources\\static\\의료기관평가인증원_환자안전 사고데이터_20181231.csv";
		
		
		JsonObject jsonObject = new JsonObject();
		 
    
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			pr = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "UTF-8"));
			int rows = 54;
			int cols = 13;
			int rows2 = 9251;
			int cols2 = 20;

			int[] Hname = new int[7];// 0.병원 	1.상급종합병원	2.종합병원		3.요양병원		4.약국	5.불명확
			int[] ScaleCount = new int[3]; //0. 500이상 	1. 200~500 		2. 불명확 
			int[][] ms = new int[10][7];//
			String[] money = new String[10];
			String[][] matrix= new String[rows][cols];//csv 파일 넣을 배열 선언
			String[][] matrix2= new String[rows2][cols2];//csv 파일 넣을 배열 선언
			int row = 0;
			while((line = br.readLine()) != null) {				
				if (line.isEmpty()) {
			        continue;
			    }
				String[] temp = line.split(","); //  ,로 구분
			    for(int col= 0; col < cols; col++) {// 배열에 집어 넣기
			        matrix[row][col]= temp[col];
			    }
			    row++;
			}
			row = 0;
			while((line2 = pr.readLine()) != null) {				
				if (line2.isEmpty()) {
			        continue;
			    }
				String[] temp = line2.split(","); //  ,로 구분
			    for(int col= 0; col < cols2; col++) {// 배열에 집어 넣기
			        matrix2[row][col]= temp[col];
			    }
			    row++;
			}
			for(int i = 1; i < rows; i++)
			{
				for(int j = 3; j<6; j++)
				{
					
					if(matrix[i][j] == null)
						continue;
					if(matrix[i][2].contains("산부인과"))
					{ 	
						
						if(matrix[i][j].contains("사망"))
						{
							ms[0][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[0][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[0][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[0][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[0][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[0][5]++;
							break;
						}
						else
						{
							ms[0][6]++;
							break;
						}
					}
					else if(matrix[i][2].contains("정형외과"))
					{ 	
						if(matrix[i][j].contains("사망"))
						{
							ms[1][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[1][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[1][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[1][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[1][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[1][5]++;
							break;
						}
						else
						{
							ms[1][6]++;
							break;
						}
					}
					else if(matrix[i][2].contains("신경외과"))
					{ 	
						if(matrix[i][j].contains("사망"))
						{
							ms[2][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[2][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[2][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[2][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[2][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[2][5]++;
							break;
						}
						else
						{
							ms[2][6]++;
							break;
						}
					}
					else if(matrix[i][2].contains("내과"))
					{ 	
						if(matrix[i][2].contains("소화기"))
						{ 	
							if(matrix[i][j].contains("사망"))
							{
								ms[3][0]++;
								break;
							}
							else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
							{
								ms[3][1]++;
								break;
							}
							else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
							{
								ms[3][2]++;
								break;
							}
							else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
							{
								ms[3][3]++;
								break;
							}
							else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
							{
								ms[3][4]++;
								break;
							}
							else if(matrix[i][j].contains("재수술"))
							{
								ms[3][5]++;
								break;
							}
							else
							{
								ms[3][6]++;
								break;
							}
						}
						else if(matrix[i][2].contains("호흡기"))
						{ 	
							if(matrix[i][j].contains("사망"))
							{
								ms[4][0]++;
								break;
							}
							else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
							{
								ms[4][1]++;
								break;
							}
							else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
							{
								ms[4][2]++;
								break;
							}
							else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
							{
								ms[4][3]++;
								break;
							}
							else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
							{
								ms[4][4]++;
								break;
							}
							else if(matrix[i][j].contains("재수술"))
							{
								ms[4][5]++;
								break;
							}
							else
							{
								ms[4][6]++;
								break;
							}
						}
						else
						{
							if(matrix[i][j].contains("사망"))
							{
								ms[5][0]++;
								break;
							}
							else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
							{
								ms[5][1]++;
								break;
							}
							else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
							{
								ms[5][2]++;
								break;
							}
							else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
							{
								ms[5][3]++;
								break;
							}
							else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
							{
								ms[5][4]++;
								break;
							}
							else if(matrix[i][j].contains("재수술"))
							{
								ms[5][5]++;
								break;
							}
							else
							{
								ms[5][6]++;
								break;
							}
						}
					}
					else if(matrix[i][2].contains("안과"))
					{ 	
						if(matrix[i][j].contains("사망"))
						{
							ms[6][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[6][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[6][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[6][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[6][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[6][5]++;
							break;
						}
						else
						{
							ms[6][6]++;
							break;
						}
					}
					else if(matrix[i][2].contains("흉부외과"))
					{ 	
						if(matrix[i][j].contains("사망"))
						{
							ms[7][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[7][1]++;					
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[7][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[7][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[7][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[7][5]++;
							break;
						}
						else
						{
							ms[7][6]++;
							break;
						}
					}
					else if(matrix[i][2].contains("이비인후과"))
					{ 
						if(matrix[i][j].contains("사망"))
						{
							ms[8][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[8][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[8][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[8][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[8][4]++;
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{
							ms[8][5]++;
							break;
						}
						else
						{
							ms[8][6]++;
							break;
						}
					}
					else
					{ 	
						if(matrix[i][j].contains("사망"))
						{
							ms[9][0]++;
							break;
						}
						else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
						{
							ms[9][1]++;
							break;
						}
						else if(matrix[i][j].contains("마비") && matrix[i][j].contains("발생"))
						{
							ms[9][2]++;
							break;
						}
						else if(matrix[i][j].contains("장애") && matrix[i][j].contains("발생"))
						{
							ms[9][3]++;
							break;
						}
						else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
						{
							ms[9][4]++;							
							break;
						}
						else if(matrix[i][j].contains("재수술"))
						{							ms[9][5]++;
							
							break;
						}
						else
						{
							ms[9][6]++;
							break;
						}
					}
			
				}
			}
			
			
			for(int i = 1; i < rows; i++)
			{
				if(matrix[i][0] == null)
					continue;
				if(matrix[i][2].contains("산부인과"))
				{ 	
					money[0] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("정형외과"))
				{ 	
					money[1] += matrix[i][12];
				}
				else if(matrix[i][2].contains("신경외과"))
				{ 	
					money[2] += matrix[i][12];
				}
				else if(matrix[i][2].contains("내과"))
				{ 	
					if(matrix[i][2].contains("소화기"))
					{ 	
						money[3] += matrix[i][12] + "";
					}
					else if(matrix[i][2].contains("호흡기"))
					{ 	
						money[4] += matrix[i][12] + "";
					}
					else
					{
						money[5] += matrix[i][12] + "";
					}
				}
				else if(matrix[i][2].contains("안과"))
				{ 	
					money[6] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("흉부외과"))
				{ 	
					money[7] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("이비인후과"))
				{ 	
					money[8] += matrix[i][12] + "";
				}
				else
				{ 	
					money[9] += matrix[i][12] + "";
				}
			}

		
				
			
			for(int i = 1; i < rows2; i++)//0. 500이상 	1. 200~500 		2. 불명확 
			{
				if(matrix2[i][7].contains("500"))
					if(matrix2[i][7].contains("200"))
						ScaleCount[1]++;
					else ScaleCount[0]++;
				else ScaleCount[2]++;
					
			}
			
			for(int i = 1; i < rows2; i++)// 0.병원 	1.상급종합병원	2.종합병원		3.요양병원		4.약국	5.불명확
			{
				if(matrix2[i][6].contains("병원"))
					if(matrix2[i][6].contains("상급종합"))
						Hname[1]++;
					else if(matrix2[i][6].contains("요양"))
						Hname[3]++;
					else if(matrix2[i][6].contains("종합"))
						Hname[2]++;
					else
						Hname[0]++;
				else if(matrix2[i][6].contains("약국"))
					Hname[4]++;
				else
					Hname[5]++;
			}

			
		
			JsonArray HArray = new JsonArray();
	        JsonObject HInfo = new JsonObject();
	        HInfo.addProperty("location", "병원");
			HInfo.addProperty("count", Hname[0] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "종합병원");
			HInfo.addProperty("count", Hname[2] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "상급종합병원");
			HInfo.addProperty("count", Hname[1] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "약국");
			HInfo.addProperty("count", Hname[4] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "불명확");
			HInfo.addProperty("count", Hname[5] + "");
			HArray.add(HInfo);
			
			/* jsonObject.addProperty("Hospital", HArray); */
			mv.addObject("HArray", HArray.toString());
	                
			JsonArray SArray = new JsonArray();
			JsonObject SInfo = new JsonObject();
	        SInfo.addProperty("range", "500이상");
	        SInfo.addProperty("count", ScaleCount[0] + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "200이상 500미만");
	        SInfo.addProperty("count", ScaleCount[1] + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "불명확");
	        SInfo.addProperty("count", ScaleCount[2] + "");
	        SArray.add(SInfo);
	        
			/* jsonObject.addProperty("Scale", SArray); */
	        mv.addObject("SArray", SArray.toString());
	        
			
			//종합
			JsonArray OAGArray = new JsonArray();//산부인과
			JsonObject OAGInfo = new JsonObject();//산부인과
			JsonArray GastroenterologyArray = new JsonArray();//소화기내과
			JsonObject GastroenterologyInfo = new JsonObject();//소화기내과
			JsonArray OrthopedicsArray = new JsonArray();//정형외과
			JsonObject OrthopedicsInfo = new JsonObject();//정형외과
			JsonArray respiratoryArray = new JsonArray();//호흡기내과
			JsonObject respiratoryInfo = new JsonObject();//호흡기내과
			JsonArray neurosurgeryArray = new JsonArray();//신경외과
			JsonObject neurosurgeryInfo = new JsonObject();//신경외과
			JsonArray medicineArray = new JsonArray();//내과
			JsonObject medicineInfo = new JsonObject();//내과
			JsonArray OphthalmologyArray = new JsonArray();//안과
			JsonObject OphthalmologyInfo = new JsonObject();//안과
			JsonArray ThoracicArray = new JsonArray();//흉부외과
			JsonObject ThoracicInfo = new JsonObject();//흉부외과
			JsonArray OtorhinolaryngologyArray = new JsonArray();//이비인후과
			JsonObject OtorhinolaryngologyInfo = new JsonObject();//이비인후과
			JsonArray DentistArray = new JsonArray();//치과
			JsonObject DentistInfo = new JsonObject();//치과
			
			for(int i = 1; i < rows; i++)
				{
				if(matrix[i][2] == null)
					continue;
				if(matrix[i][2].contains("산부인과"))
				{ 	
					OAGInfo = new JsonObject();
					OAGInfo.addProperty("location", "산부인과");
					OAGInfo.addProperty("event", matrix[i][3] + "");
					OAGInfo.addProperty("hospital", matrix[i][8] + "");
					OAGInfo.addProperty("patient", matrix[i][7] + "");
					OAGInfo.addProperty("appraisal", matrix[i][9] + "");
					OAGInfo.addProperty("adjustment", matrix[i][10] + "");	
					OAGArray.add(OAGInfo);
				}
				else if(matrix[i][2].contains("정형외과"))
				{ 	
					OrthopedicsInfo = new JsonObject();
					OrthopedicsInfo.addProperty("location", "정형외과");
					OrthopedicsInfo.addProperty("event", matrix[i][3] + "");
					OrthopedicsInfo.addProperty("hospital", matrix[i][8] + "");
					OrthopedicsInfo.addProperty("patient", matrix[i][7] + "");
					OrthopedicsInfo.addProperty("appraisal", matrix[i][9] + "");
					OrthopedicsInfo.addProperty("adjustment", matrix[i][10] + "");	
					OrthopedicsArray.add(OrthopedicsInfo);
				}
				else if(matrix[i][2].contains("신경외과"))
				{ 	
					neurosurgeryInfo = new JsonObject();
					neurosurgeryInfo.addProperty("location", "신경외과");
					neurosurgeryInfo.addProperty("event", matrix[i][3] + "");
					neurosurgeryInfo.addProperty("hospital", matrix[i][8] + "");
					neurosurgeryInfo.addProperty("patient", matrix[i][7] + "");
					neurosurgeryInfo.addProperty("appraisal", matrix[i][9] + "");
					neurosurgeryInfo.addProperty("adjustment", matrix[i][10] + "");	
					neurosurgeryArray.add(neurosurgeryInfo);
				}
				else if(matrix[i][2].contains("내과"))
				{ 	
					if(matrix[i][2].contains("소화기"))
					{ 	
						GastroenterologyInfo = new JsonObject();
						GastroenterologyInfo.addProperty("location", "소화기내과");
						GastroenterologyInfo.addProperty("event", matrix[i][3] + "");
						GastroenterologyInfo.addProperty("hospital", matrix[i][8] + "");
						GastroenterologyInfo.addProperty("patient", matrix[i][7] + "");
						GastroenterologyInfo.addProperty("appraisal", matrix[i][9] + "");
						GastroenterologyInfo.addProperty("adjustment", matrix[i][10] + "");	
						GastroenterologyArray.add(GastroenterologyInfo);
					}
					else if(matrix[i][2].contains("호흡기"))
					{ 	
						respiratoryInfo = new JsonObject();
						respiratoryInfo.addProperty("location", "호흡기내과");
						respiratoryInfo.addProperty("event", matrix[i][3] + "");
						respiratoryInfo.addProperty("hospital", matrix[i][8] + "");
						respiratoryInfo.addProperty("patient", matrix[i][7] + "");
						respiratoryInfo.addProperty("appraisal", matrix[i][9] + "");
						respiratoryInfo.addProperty("adjustment", matrix[i][10] + "");	
						respiratoryArray.add(respiratoryInfo);
					}
					else
					{
						medicineInfo = new JsonObject();
						medicineInfo.addProperty("location", "내과");
						medicineInfo.addProperty("event", matrix[i][3] + "");
						medicineInfo.addProperty("hospital", matrix[i][8] + "");
						medicineInfo.addProperty("patient", matrix[i][7] + "");
						medicineInfo.addProperty("appraisal", matrix[i][9] + "");
						medicineInfo.addProperty("adjustment", matrix[i][10] + "");	
						medicineArray.add(medicineInfo);
					}
				}
				else if(matrix[i][2].contains("안과"))
				{ 	
					OphthalmologyInfo = new JsonObject();
					OphthalmologyInfo.addProperty("location", "안과");
					OphthalmologyInfo.addProperty("event", matrix[i][3] + "");
					OphthalmologyInfo.addProperty("hospital", matrix[i][8] + "");
					OphthalmologyInfo.addProperty("patient", matrix[i][7] + "");
					OphthalmologyInfo.addProperty("appraisal", matrix[i][9] + "");
					OphthalmologyInfo.addProperty("adjustment", matrix[i][10] + "");	
					OphthalmologyArray.add(OphthalmologyInfo);
				}
				else if(matrix[i][2].contains("흉부외과"))
				{ 	
					ThoracicInfo = new JsonObject();
					ThoracicInfo.addProperty("location", "흉부외과");
					ThoracicInfo.addProperty("event", matrix[i][3] + "");
					ThoracicInfo.addProperty("hospital", matrix[i][8] + "");
					ThoracicInfo.addProperty("patient", matrix[i][7] + "");
					ThoracicInfo.addProperty("appraisal", matrix[i][9] + "");
					ThoracicInfo.addProperty("adjustment", matrix[i][10] + "");	
					ThoracicArray.add(ThoracicInfo);
				}
				else if(matrix[i][2].contains("이비인후과"))
				{ 	
					OtorhinolaryngologyInfo = new JsonObject();
					OtorhinolaryngologyInfo.addProperty("location", "이비인후과");
					OtorhinolaryngologyInfo.addProperty("event", matrix[i][3] + "");
					OtorhinolaryngologyInfo.addProperty("hospital", matrix[i][8] + "");
					OtorhinolaryngologyInfo.addProperty("patient", matrix[i][7] + "");
					OtorhinolaryngologyInfo.addProperty("appraisal", matrix[i][9] + "");
					OtorhinolaryngologyInfo.addProperty("adjustment", matrix[i][10] + "");	
					OtorhinolaryngologyArray.add(OtorhinolaryngologyInfo);
				}
				else
				{ 	
					DentistInfo = new JsonObject();
					DentistInfo.addProperty("location", "치과");
					DentistInfo.addProperty("event", matrix[i][3] + "");
					DentistInfo.addProperty("hospital", matrix[i][8] + "");
					DentistInfo.addProperty("patient", matrix[i][7] + "");
					DentistInfo.addProperty("appraisal", matrix[i][9] + "");
					DentistInfo.addProperty("adjustment", matrix[i][10] + "");	
					OtorhinolaryngologyArray.add(DentistInfo);
				}
				
				}
			
			JsonArray OAGstatArray = new JsonArray();//산부인과
			JsonObject OAGstatInfo = new JsonObject();//산부인과
			JsonArray GastroenterologystatArray = new JsonArray();//소화기내과
			JsonObject GastroenterologystatInfo = new JsonObject();//소화기내과
			JsonArray OrthopedicsstatInfoArray = new JsonArray();//정형외과
			JsonObject OrthopedicsstatInfo = new JsonObject();//정형외과
			JsonArray respiratorystatArray = new JsonArray();//호흡기내과
			JsonObject respiratorystatInfo = new JsonObject();//호흡기내과
			JsonArray neurosurgerystatArray = new JsonArray();//신경외과
			JsonObject neurosurgerystatInfo = new JsonObject();//신경외과
			JsonArray medicinestatArray = new JsonArray();//내과
			JsonObject medicinestatInfo = new JsonObject();//내과
			JsonArray OphthalmologystatArray = new JsonArray();//안과
			JsonObject OphthalmologystatInfo = new JsonObject();//안과
			JsonArray ThoracicstatArray = new JsonArray();//흉부외과
			JsonObject ThoracicstatInfo = new JsonObject();//흉부외과
			JsonArray OtorhinolaryngologystatArray = new JsonArray();//이비인후과
			JsonObject OtorhinolaryngologystatInfo = new JsonObject();//이비인후과
			JsonArray DentiststatArray = new JsonArray();//치과
			JsonObject DentiststatInfo = new JsonObject();//치과

			
			
			for(int i = 1; i < rows; i++)
			{
			if(matrix[i][2] == null)
				continue;
			if(matrix[i][2].contains("산부인과"))
			{ 	
				OAGstatInfo = new JsonObject();
				OAGstatInfo.addProperty("location", "산부인과");
				OAGstatInfo.addProperty("Dead", ms[0][0] + "");
				OAGstatInfo.addProperty("syndrome", ms[0][1] + "");
				OAGstatInfo.addProperty("paralysis", ms[0][2] + "");
				OAGstatInfo.addProperty("obstacle", ms[0][3] + "");
				OAGstatInfo.addProperty("delay", ms[0][4] + "");
				OAGstatInfo.addProperty("revision", ms[0][5] + "");
				OAGstatInfo.addProperty("etc", ms[0][6] + "");
				OAGstatInfo.addProperty("money", money[0] + "");
				OAGstatArray.add(OAGstatInfo);
			}
			else if(matrix[i][2].contains("정형외과"))
			{ 	
				OrthopedicsstatInfo = new JsonObject();
				OrthopedicsstatInfo.addProperty("location", "정형외과");
				OrthopedicsstatInfo.addProperty("Dead", ms[1][0] + "");
				OrthopedicsstatInfo.addProperty("syndrome", ms[1][1] + "");
				OrthopedicsstatInfo.addProperty("paralysis", ms[1][2] + "");
				OrthopedicsstatInfo.addProperty("obstacle", ms[1][3] + "");
				OrthopedicsstatInfo.addProperty("delay", ms[1][4] + "");
				OrthopedicsstatInfo.addProperty("revision", ms[1][5] + "");
				OrthopedicsstatInfo.addProperty("etc", ms[1][6] + "");
				OrthopedicsstatInfo.addProperty("money", money[1] + "");
				OrthopedicsstatInfoArray.add(OrthopedicsstatInfo);
			}
			else if(matrix[i][2].contains("신경외과"))
			{ 	
				neurosurgerystatInfo = new JsonObject();
				neurosurgerystatInfo.addProperty("location", "신경외과");
				neurosurgerystatInfo.addProperty("Dead", ms[2][0] + "");
				neurosurgerystatInfo.addProperty("syndrome", ms[2][1] + "");
				neurosurgerystatInfo.addProperty("paralysis", ms[2][2] + "");
				neurosurgerystatInfo.addProperty("obstacle", ms[2][3] + "");
				neurosurgerystatInfo.addProperty("delay", ms[2][4] + "");
				neurosurgerystatInfo.addProperty("revision", ms[2][5] + "");
				neurosurgerystatInfo.addProperty("etc", ms[2][6] + "");
				neurosurgerystatInfo.addProperty("money", money[2] + "");
				neurosurgerystatArray.add(neurosurgerystatInfo);
			}
			else if(matrix[i][2].contains("내과"))
			{ 	
				if(matrix[i][2].contains("소화기"))
				{ 	
					GastroenterologystatInfo = new JsonObject();
					GastroenterologystatInfo.addProperty("location", "소화기내과");
					GastroenterologystatInfo.addProperty("Dead", ms[3][0] + "");
					GastroenterologystatInfo.addProperty("syndrome", ms[3][1] + "");
					GastroenterologystatInfo.addProperty("paralysis", ms[3][2] + "");
					GastroenterologystatInfo.addProperty("obstacle", ms[3][3] + "");
					GastroenterologystatInfo.addProperty("delay", ms[3][4] + "");
					GastroenterologystatInfo.addProperty("revision", ms[3][5] + "");
					GastroenterologystatInfo.addProperty("etc", ms[3][6] + "");
					GastroenterologystatInfo.addProperty("money", money[3] + "");
					GastroenterologystatArray.add(GastroenterologystatInfo);
				}
				else if(matrix[i][2].contains("호흡기"))
				{ 	
					respiratorystatInfo = new JsonObject();
					respiratorystatInfo.addProperty("location", "호흡기내과");
					respiratorystatInfo.addProperty("Dead", ms[4][0] + "");
					respiratorystatInfo.addProperty("syndrome", ms[4][1] + "");
					respiratorystatInfo.addProperty("paralysis", ms[4][2] + "");
					respiratorystatInfo.addProperty("obstacle", ms[4][3] + "");
					respiratorystatInfo.addProperty("delay", ms[4][4] + "");
					respiratorystatInfo.addProperty("revision", ms[4][5] + "");
					respiratorystatInfo.addProperty("etc", ms[4][6] + "");
					respiratorystatInfo.addProperty("money", money[4] + "");
					respiratorystatArray.add(respiratorystatInfo);
				}
				else
				{
					medicinestatInfo = new JsonObject();
					medicinestatInfo.addProperty("location", "내과");
					medicinestatInfo.addProperty("Dead", ms[5][0] + "");
					medicinestatInfo.addProperty("syndrome", ms[5][1] + "");
					medicinestatInfo.addProperty("paralysis", ms[5][2] + "");
					medicinestatInfo.addProperty("obstacle", ms[5][3] + "");
					medicinestatInfo.addProperty("delay", ms[5][4] + "");
					medicinestatInfo.addProperty("revision", ms[5][5] + "");
					medicinestatInfo.addProperty("etc", ms[5][6] + "");
					medicinestatInfo.addProperty("money", money[5] + "");
					medicinestatArray.add(medicinestatInfo);
				}
			}
			else if(matrix[i][2].contains("안과"))
			{ 	
				OphthalmologystatInfo = new JsonObject();
				OphthalmologystatInfo.addProperty("location", "안과");
				OphthalmologystatInfo.addProperty("Dead", ms[6][0] + "");
				OphthalmologystatInfo.addProperty("syndrome", ms[6][1] + "");
				OphthalmologystatInfo.addProperty("paralysis", ms[6][2] + "");
				OphthalmologystatInfo.addProperty("obstacle", ms[6][3] + "");
				OphthalmologystatInfo.addProperty("delay", ms[6][4] + "");
				OphthalmologystatInfo.addProperty("revision", ms[6][5] + "");
				OphthalmologystatInfo.addProperty("etc", ms[6][6] + "");
				OphthalmologystatInfo.addProperty("money", money[6] + "");
				OphthalmologystatArray.add(OphthalmologystatInfo);
			}
			else if(matrix[i][2].contains("흉부외과"))
			{ 	
				ThoracicstatInfo = new JsonObject();
				ThoracicstatInfo.addProperty("location", "흉부외과");
				ThoracicstatInfo.addProperty("Dead", ms[7][0] + "");
				ThoracicstatInfo.addProperty("syndrome", ms[7][1] + "");
				ThoracicstatInfo.addProperty("paralysis", ms[7][2] + "");
				ThoracicstatInfo.addProperty("obstacle", ms[7][3] + "");
				ThoracicstatInfo.addProperty("delay", ms[7][4] + "");
				ThoracicstatInfo.addProperty("revision", ms[7][5] + "");
				ThoracicstatInfo.addProperty("etc", ms[7][6] + "");
				ThoracicstatInfo.addProperty("money", money[7] + "");	
				ThoracicstatArray.add(ThoracicstatInfo);
			}
			else if(matrix[i][2].contains("이비인후과"))
			{ 	
				OtorhinolaryngologystatInfo = new JsonObject();
				OtorhinolaryngologystatInfo.addProperty("location", "이비인후과");
				OtorhinolaryngologystatInfo.addProperty("Dead", ms[8][0] + "");
				OtorhinolaryngologystatInfo.addProperty("syndrome", ms[8][1] + "");
				OtorhinolaryngologystatInfo.addProperty("paralysis", ms[8][2] + "");
				OtorhinolaryngologystatInfo.addProperty("obstacle", ms[8][3] + "");
				OtorhinolaryngologystatInfo.addProperty("delay", ms[8][4] + "");
				OtorhinolaryngologystatInfo.addProperty("revision", ms[8][5] + "");
				OtorhinolaryngologystatInfo.addProperty("revision", ms[8][6] + "");
				OtorhinolaryngologystatInfo.addProperty("money", money[8] + "");		
				OtorhinolaryngologystatArray.add(OtorhinolaryngologystatInfo);
			}
			else
			{ 	
				DentiststatInfo = new JsonObject();
				DentiststatInfo.addProperty("location", "치과");
				DentiststatInfo.addProperty("Dead", ms[9][0] + "");
				DentiststatInfo.addProperty("syndrome", ms[9][1] + "");
				DentiststatInfo.addProperty("paralysis", ms[9][2] + "");
				DentiststatInfo.addProperty("obstacle", ms[9][3] + "");
				DentiststatInfo.addProperty("delay", ms[9][4] + "");
				DentiststatInfo.addProperty("revision", ms[9][5] + "");
				DentiststatInfo.addProperty("revision", ms[9][6] + "");
				DentiststatInfo.addProperty("money", money[9] + "");		
				DentiststatArray.add(DentiststatInfo);
			}
			}
						
						
			mv.addObject("OAGArray", OAGArray.toString());
			mv.addObject("GastroenterologyArray", GastroenterologyArray.toString());
			mv.addObject("OrthopedicsArray", OrthopedicsArray.toString());
			mv.addObject("respiratoryArray", respiratoryArray.toString());
			mv.addObject("neurosurgeryArray", neurosurgeryArray.toString());
			mv.addObject("medicineArray", medicineArray.toString());
			mv.addObject("ThoracicArray", ThoracicArray.toString());
			mv.addObject("OtorhinolaryngologyArray", OtorhinolaryngologyArray.toString());
			mv.addObject("DentistArray", DentistArray.toString());
			
			
			mv.addObject("OAGstatArray", OAGstatArray.toString());
			mv.addObject("GastroenterologystatArray", GastroenterologystatArray.toString());
			mv.addObject("OrthopedicsstatArray", OrthopedicsstatInfoArray.toString());
			mv.addObject("respiratorystatArray", respiratorystatArray.toString());
			mv.addObject("neurosurgerystatArray", neurosurgerystatArray.toString());
			mv.addObject("medicinestatArray", medicinestatArray.toString());
			mv.addObject("ThoracicstatArray", ThoracicstatArray.toString());
			mv.addObject("OtorhinolaryngologystatArray", OtorhinolaryngologystatArray.toString());
			mv.addObject("DentiststatArray", DentiststatArray.toString());

						
			 String jsonInfo = jsonObject.toString();
		        
		        System.out.print(jsonInfo);
			
		 
		}catch (Exception e) {
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
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "종합병원");
			HInfo.addProperty("count", e + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "상급종합병원");
			HInfo.addProperty("count", b + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "약국");
			HInfo.addProperty("count", h + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "불명확");
			HInfo.addProperty("count", (f-1) + "");
			HInfo.addProperty("count", a + "");
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