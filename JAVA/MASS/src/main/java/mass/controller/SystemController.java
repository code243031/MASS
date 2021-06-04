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
		
		String path = "C:\\Users\\USER\\Documents\\mass3\\JAVA\\MASS\\src\\main\\resources\\static\\2.csv";
		String path2 = "C:\\Users\\USER\\Documents\\mass3\\JAVA\\MASS\\src\\main\\resources\\static\\의료기관평가인증원_환자안전 사고데이터_20181231.csv";
		
		
		JsonObject jsonObject = new JsonObject();
		 
    
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			pr = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "UTF-8"));
			int rows = 54;
			int cols = 13;
			int rows2 = 9251;
			int cols2 = 20;

			int[] Hname = new int[7];// 0.蹂묒썝 	1.�긽湲됱쥌�빀蹂묒썝	2.醫낇빀蹂묒썝		3.�슂�뼇蹂묒썝		4.�빟援�	5.遺덈챸�솗
			int[] ScaleCount = new int[3]; //0. 500�씠�긽 	1. 200~500 		2. 遺덈챸�솗 
			int[][] ms = new int[10][7];//
			String[] money = new String[10];
			String[][] matrix= new String[rows][cols];//csv �뙆�씪 �꽔�쓣 諛곗뿴 �꽑�뼵
			String[][] matrix2= new String[rows2][cols2];//csv �뙆�씪 �꽔�쓣 諛곗뿴 �꽑�뼵
			int row = 0;
			while((line = br.readLine()) != null) {				
				if (line.isEmpty()) {
			        continue;
			    }
				String[] temp = line.split(","); //  ,濡� 援щ텇
			    for(int col= 0; col < cols; col++) {// 諛곗뿴�뿉 吏묒뼱 �꽔湲�
			        matrix[row][col]= temp[col];
			    }
			    row++;
			}
			row = 0;
			while((line2 = pr.readLine()) != null) {				
				if (line2.isEmpty()) {
			        continue;
			    }
				String[] temp = line2.split(","); //  ,濡� 援щ텇
			    for(int col= 0; col < cols2; col++) {// 諛곗뿴�뿉 吏묒뼱 �꽔湲�
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
					if(matrix[i][2].contains("�궛遺��씤怨�"))
					{ 	
						
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[0][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[0][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[0][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[0][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[0][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�젙�삎�쇅怨�"))
					{ 	
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[1][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[1][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[1][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[1][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[1][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�떊寃쎌쇅怨�"))
					{ 	
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[2][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[2][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[2][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[2][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[2][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�궡怨�"))
					{ 	
						if(matrix[i][2].contains("�냼�솕湲�"))
						{ 	
							if(matrix[i][j].contains("�궗留�"))
							{
								ms[3][0]++;
								break;
							}
							else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[3][1]++;
								break;
							}
							else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[3][2]++;
								break;
							}
							else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[3][3]++;
								break;
							}
							else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
							{
								ms[3][4]++;
								break;
							}
							else if(matrix[i][j].contains("�옱�닔�닠"))
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
						else if(matrix[i][2].contains("�샇�씉湲�"))
						{ 	
							if(matrix[i][j].contains("�궗留�"))
							{
								ms[4][0]++;
								break;
							}
							else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[4][1]++;
								break;
							}
							else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[4][2]++;
								break;
							}
							else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[4][3]++;
								break;
							}
							else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
							{
								ms[4][4]++;
								break;
							}
							else if(matrix[i][j].contains("�옱�닔�닠"))
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
							if(matrix[i][j].contains("�궗留�"))
							{
								ms[5][0]++;
								break;
							}
							else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[5][1]++;
								break;
							}
							else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[5][2]++;
								break;
							}
							else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
							{
								ms[5][3]++;
								break;
							}
							else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
							{
								ms[5][4]++;
								break;
							}
							else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�븞怨�"))
					{ 	
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[6][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[6][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[6][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[6][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[6][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�쓨遺��쇅怨�"))
					{ 	
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[7][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[7][1]++;					
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[7][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[7][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[7][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
					else if(matrix[i][2].contains("�씠鍮꾩씤�썑怨�"))
					{ 
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[8][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[8][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[8][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[8][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[8][4]++;
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
						if(matrix[i][j].contains("�궗留�"))
						{
							ms[9][0]++;
							break;
						}
						else if(matrix[i][j].contains("利앺썑援�") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[9][1]++;
							break;
						}
						else if(matrix[i][j].contains("留덈퉬") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[9][2]++;
							break;
						}
						else if(matrix[i][j].contains("�옣�븷") && matrix[i][j].contains("諛쒖깮"))
						{
							ms[9][3]++;
							break;
						}
						else if(matrix[i][j].contains("吏꾨떒") && matrix[i][j].contains("吏��뿰"))
						{
							ms[9][4]++;							
							break;
						}
						else if(matrix[i][j].contains("�옱�닔�닠"))
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
				if(matrix[i][2].contains("�궛遺��씤怨�"))
				{ 	
					money[0] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("�젙�삎�쇅怨�"))
				{ 	
					money[1] += matrix[i][12];
				}
				else if(matrix[i][2].contains("�떊寃쎌쇅怨�"))
				{ 	
					money[2] += matrix[i][12];
				}
				else if(matrix[i][2].contains("�궡怨�"))
				{ 	
					if(matrix[i][2].contains("�냼�솕湲�"))
					{ 	
						money[3] += matrix[i][12] + "";
					}
					else if(matrix[i][2].contains("�샇�씉湲�"))
					{ 	
						money[4] += matrix[i][12] + "";
					}
					else
					{
						money[5] += matrix[i][12] + "";
					}
				}
				else if(matrix[i][2].contains("�븞怨�"))
				{ 	
					money[6] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("�쓨遺��쇅怨�"))
				{ 	
					money[7] += matrix[i][12] + "";
				}
				else if(matrix[i][2].contains("�씠鍮꾩씤�썑怨�"))
				{ 	
					money[8] += matrix[i][12] + "";
				}
				else
				{ 	
					money[9] += matrix[i][12] + "";
				}
			}

		
				
			
			for(int i = 1; i < rows2; i++)//0. 500�씠�긽 	1. 200~500 		2. 遺덈챸�솗 
			{
				if(matrix2[i][7].contains("500"))
					if(matrix2[i][7].contains("200"))
						ScaleCount[1]++;
					else ScaleCount[0]++;
				else ScaleCount[2]++;
					
			}
			
			for(int i = 1; i < rows2; i++)// 0.蹂묒썝 	1.�긽湲됱쥌�빀蹂묒썝	2.醫낇빀蹂묒썝		3.�슂�뼇蹂묒썝		4.�빟援�	5.遺덈챸�솗
			{
				if(matrix2[i][6].contains("蹂묒썝"))
					if(matrix2[i][6].contains("�긽湲됱쥌�빀"))
						Hname[1]++;
					else if(matrix2[i][6].contains("�슂�뼇"))
						Hname[3]++;
					else if(matrix2[i][6].contains("醫낇빀"))
						Hname[2]++;
					else
						Hname[0]++;
				else if(matrix2[i][6].contains("�빟援�"))
					Hname[4]++;
				else
					Hname[5]++;
			}

			
		
			JsonArray HArray = new JsonArray();
	        JsonObject HInfo = new JsonObject();
	        HInfo.addProperty("location", "蹂묒썝");
			HInfo.addProperty("count", Hname[0] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "醫낇빀蹂묒썝");
			HInfo.addProperty("count", Hname[2] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "�긽湲됱쥌�빀蹂묒썝");
			HInfo.addProperty("count", Hname[1] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "�빟援�");
			HInfo.addProperty("count", Hname[4] + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "遺덈챸�솗");
			HInfo.addProperty("count", Hname[5] + "");
			HArray.add(HInfo);
			
			/* jsonObject.addProperty("Hospital", HArray); */
			mv.addObject("HArray", HArray.toString());
	                
			JsonArray SArray = new JsonArray();
			JsonObject SInfo = new JsonObject();
	        SInfo.addProperty("range", "500�씠�긽");
	        SInfo.addProperty("count", ScaleCount[0] + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "200�씠�긽 500誘몃쭔");
	        SInfo.addProperty("count", ScaleCount[1] + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "遺덈챸�솗");
	        SInfo.addProperty("count", ScaleCount[2] + "");
	        SArray.add(SInfo);
	        
			/* jsonObject.addProperty("Scale", SArray); */
	        mv.addObject("SArray", SArray.toString());
	        
			
			//醫낇빀
			JsonArray OAGArray = new JsonArray();//�궛遺��씤怨�
			JsonObject OAGInfo = new JsonObject();//�궛遺��씤怨�
			JsonArray GastroenterologyArray = new JsonArray();//�냼�솕湲곕궡怨�
			JsonObject GastroenterologyInfo = new JsonObject();//�냼�솕湲곕궡怨�
			JsonArray OrthopedicsArray = new JsonArray();//�젙�삎�쇅怨�
			JsonObject OrthopedicsInfo = new JsonObject();//�젙�삎�쇅怨�
			JsonArray respiratoryArray = new JsonArray();//�샇�씉湲곕궡怨�
			JsonObject respiratoryInfo = new JsonObject();//�샇�씉湲곕궡怨�
			JsonArray neurosurgeryArray = new JsonArray();//�떊寃쎌쇅怨�
			JsonObject neurosurgeryInfo = new JsonObject();//�떊寃쎌쇅怨�
			JsonArray medicineArray = new JsonArray();//�궡怨�
			JsonObject medicineInfo = new JsonObject();//�궡怨�
			JsonArray OphthalmologyArray = new JsonArray();//�븞怨�
			JsonObject OphthalmologyInfo = new JsonObject();//�븞怨�
			JsonArray ThoracicArray = new JsonArray();//�쓨遺��쇅怨�
			JsonObject ThoracicInfo = new JsonObject();//�쓨遺��쇅怨�
			JsonArray OtorhinolaryngologyArray = new JsonArray();//�씠鍮꾩씤�썑怨�
			JsonObject OtorhinolaryngologyInfo = new JsonObject();//�씠鍮꾩씤�썑怨�
			JsonArray DentistArray = new JsonArray();//移섍낵
			JsonObject DentistInfo = new JsonObject();//移섍낵
			
			for(int i = 1; i < rows; i++)
				{
				if(matrix[i][2] == null)
					continue;
				if(matrix[i][2].contains("�궛遺��씤怨�"))
				{ 	
					OAGInfo = new JsonObject();
					OAGInfo.addProperty("location", "�궛遺��씤怨�");
					OAGInfo.addProperty("event", matrix[i][3] + "");
					OAGInfo.addProperty("hospital", matrix[i][8] + "");
					OAGInfo.addProperty("patient", matrix[i][7] + "");
					OAGInfo.addProperty("appraisal", matrix[i][9] + "");
					OAGInfo.addProperty("adjustment", matrix[i][10] + "");	
					OAGArray.add(OAGInfo);
				}
				else if(matrix[i][2].contains("�젙�삎�쇅怨�"))
				{ 	
					OrthopedicsInfo = new JsonObject();
					OrthopedicsInfo.addProperty("location", "�젙�삎�쇅怨�");
					OrthopedicsInfo.addProperty("event", matrix[i][3] + "");
					OrthopedicsInfo.addProperty("hospital", matrix[i][8] + "");
					OrthopedicsInfo.addProperty("patient", matrix[i][7] + "");
					OrthopedicsInfo.addProperty("appraisal", matrix[i][9] + "");
					OrthopedicsInfo.addProperty("adjustment", matrix[i][10] + "");	
					OrthopedicsArray.add(OrthopedicsInfo);
				}
				else if(matrix[i][2].contains("�떊寃쎌쇅怨�"))
				{ 	
					neurosurgeryInfo = new JsonObject();
					neurosurgeryInfo.addProperty("location", "�떊寃쎌쇅怨�");
					neurosurgeryInfo.addProperty("event", matrix[i][3] + "");
					neurosurgeryInfo.addProperty("hospital", matrix[i][8] + "");
					neurosurgeryInfo.addProperty("patient", matrix[i][7] + "");
					neurosurgeryInfo.addProperty("appraisal", matrix[i][9] + "");
					neurosurgeryInfo.addProperty("adjustment", matrix[i][10] + "");	
					neurosurgeryArray.add(neurosurgeryInfo);
				}
				else if(matrix[i][2].contains("�궡怨�"))
				{ 	
					if(matrix[i][2].contains("�냼�솕湲�"))
					{ 	
						GastroenterologyInfo = new JsonObject();
						GastroenterologyInfo.addProperty("location", "�냼�솕湲곕궡怨�");
						GastroenterologyInfo.addProperty("event", matrix[i][3] + "");
						GastroenterologyInfo.addProperty("hospital", matrix[i][8] + "");
						GastroenterologyInfo.addProperty("patient", matrix[i][7] + "");
						GastroenterologyInfo.addProperty("appraisal", matrix[i][9] + "");
						GastroenterologyInfo.addProperty("adjustment", matrix[i][10] + "");	
						GastroenterologyArray.add(GastroenterologyInfo);
					}
					else if(matrix[i][2].contains("�샇�씉湲�"))
					{ 	
						respiratoryInfo = new JsonObject();
						respiratoryInfo.addProperty("location", "�샇�씉湲곕궡怨�");
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
						medicineInfo.addProperty("location", "�궡怨�");
						medicineInfo.addProperty("event", matrix[i][3] + "");
						medicineInfo.addProperty("hospital", matrix[i][8] + "");
						medicineInfo.addProperty("patient", matrix[i][7] + "");
						medicineInfo.addProperty("appraisal", matrix[i][9] + "");
						medicineInfo.addProperty("adjustment", matrix[i][10] + "");	
						medicineArray.add(medicineInfo);
					}
				}
				else if(matrix[i][2].contains("�븞怨�"))
				{ 	
					OphthalmologyInfo = new JsonObject();
					OphthalmologyInfo.addProperty("location", "�븞怨�");
					OphthalmologyInfo.addProperty("event", matrix[i][3] + "");
					OphthalmologyInfo.addProperty("hospital", matrix[i][8] + "");
					OphthalmologyInfo.addProperty("patient", matrix[i][7] + "");
					OphthalmologyInfo.addProperty("appraisal", matrix[i][9] + "");
					OphthalmologyInfo.addProperty("adjustment", matrix[i][10] + "");	
					OphthalmologyArray.add(OphthalmologyInfo);
				}
				else if(matrix[i][2].contains("�쓨遺��쇅怨�"))
				{ 	
					ThoracicInfo = new JsonObject();
					ThoracicInfo.addProperty("location", "�쓨遺��쇅怨�");
					ThoracicInfo.addProperty("event", matrix[i][3] + "");
					ThoracicInfo.addProperty("hospital", matrix[i][8] + "");
					ThoracicInfo.addProperty("patient", matrix[i][7] + "");
					ThoracicInfo.addProperty("appraisal", matrix[i][9] + "");
					ThoracicInfo.addProperty("adjustment", matrix[i][10] + "");	
					ThoracicArray.add(ThoracicInfo);
				}
				else if(matrix[i][2].contains("�씠鍮꾩씤�썑怨�"))
				{ 	
					OtorhinolaryngologyInfo = new JsonObject();
					OtorhinolaryngologyInfo.addProperty("location", "�씠鍮꾩씤�썑怨�");
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
					DentistInfo.addProperty("location", "移섍낵");
					DentistInfo.addProperty("event", matrix[i][3] + "");
					DentistInfo.addProperty("hospital", matrix[i][8] + "");
					DentistInfo.addProperty("patient", matrix[i][7] + "");
					DentistInfo.addProperty("appraisal", matrix[i][9] + "");
					DentistInfo.addProperty("adjustment", matrix[i][10] + "");	
					OtorhinolaryngologyArray.add(DentistInfo);
				}
				
				}
			
			JsonArray OAGstatArray = new JsonArray();//�궛遺��씤怨�
			JsonObject OAGstatInfo = new JsonObject();//�궛遺��씤怨�
			JsonArray GastroenterologystatArray = new JsonArray();//�냼�솕湲곕궡怨�
			JsonObject GastroenterologystatInfo = new JsonObject();//�냼�솕湲곕궡怨�
			JsonArray OrthopedicsstatInfoArray = new JsonArray();//�젙�삎�쇅怨�
			JsonObject OrthopedicsstatInfo = new JsonObject();//�젙�삎�쇅怨�
			JsonArray respiratorystatArray = new JsonArray();//�샇�씉湲곕궡怨�
			JsonObject respiratorystatInfo = new JsonObject();//�샇�씉湲곕궡怨�
			JsonArray neurosurgerystatArray = new JsonArray();//�떊寃쎌쇅怨�
			JsonObject neurosurgerystatInfo = new JsonObject();//�떊寃쎌쇅怨�
			JsonArray medicinestatArray = new JsonArray();//�궡怨�
			JsonObject medicinestatInfo = new JsonObject();//�궡怨�
			JsonArray OphthalmologystatArray = new JsonArray();//�븞怨�
			JsonObject OphthalmologystatInfo = new JsonObject();//�븞怨�
			JsonArray ThoracicstatArray = new JsonArray();//�쓨遺��쇅怨�
			JsonObject ThoracicstatInfo = new JsonObject();//�쓨遺��쇅怨�
			JsonArray OtorhinolaryngologystatArray = new JsonArray();//�씠鍮꾩씤�썑怨�
			JsonObject OtorhinolaryngologystatInfo = new JsonObject();//�씠鍮꾩씤�썑怨�
			JsonArray DentiststatArray = new JsonArray();//移섍낵
			JsonObject DentiststatInfo = new JsonObject();//移섍낵

			
			
			for(int i = 1; i < rows; i++)
			{
			if(matrix[i][2] == null)
				continue;
			if(matrix[i][2].contains("�궛遺��씤怨�"))
			{ 	
				OAGstatInfo = new JsonObject();
				OAGstatInfo.addProperty("location", "�궛遺��씤怨�");
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
			else if(matrix[i][2].contains("�젙�삎�쇅怨�"))
			{ 	
				OrthopedicsstatInfo = new JsonObject();
				OrthopedicsstatInfo.addProperty("location", "�젙�삎�쇅怨�");
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
			else if(matrix[i][2].contains("�떊寃쎌쇅怨�"))
			{ 	
				neurosurgerystatInfo = new JsonObject();
				neurosurgerystatInfo.addProperty("location", "�떊寃쎌쇅怨�");
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
			else if(matrix[i][2].contains("�궡怨�"))
			{ 	
				if(matrix[i][2].contains("�냼�솕湲�"))
				{ 	
					GastroenterologystatInfo = new JsonObject();
					GastroenterologystatInfo.addProperty("location", "�냼�솕湲곕궡怨�");
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
				else if(matrix[i][2].contains("�샇�씉湲�"))
				{ 	
					respiratorystatInfo = new JsonObject();
					respiratorystatInfo.addProperty("location", "�샇�씉湲곕궡怨�");
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
					medicinestatInfo.addProperty("location", "�궡怨�");
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
			else if(matrix[i][2].contains("�븞怨�"))
			{ 	
				OphthalmologystatInfo = new JsonObject();
				OphthalmologystatInfo.addProperty("location", "�븞怨�");
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
			else if(matrix[i][2].contains("�쓨遺��쇅怨�"))
			{ 	
				ThoracicstatInfo = new JsonObject();
				ThoracicstatInfo.addProperty("location", "�쓨遺��쇅怨�");
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
			else if(matrix[i][2].contains("�씠鍮꾩씤�썑怨�"))
			{ 	
				OtorhinolaryngologystatInfo = new JsonObject();
				OtorhinolaryngologystatInfo.addProperty("location", "�씠鍮꾩씤�썑怨�");
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
				DentiststatInfo.addProperty("location", "移섍낵");
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
			String path = "D:\\而댄벂�꽣怨듯븰\\java\\workspace\\mass\\src\\main\\resources\\static\\�쓽猷뚭린愿��룊媛��씤利앹썝_�솚�옄�븞�쟾 �궗怨좊뜲�씠�꽣_20181231.csv";
			
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
					String[] temp = line.split(","); // �꺆�쑝濡� 援щ텇
					
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
					if(matrix[i][6].contains("蹂묒썝"))
						if(matrix[i][6].contains("�긽湲됱쥌�빀"))
							b++;
						else if(matrix[i][6].contains("�슂�뼇"))
							d++;
						else if(matrix[i][6].contains("醫낇빀"))
							e++;
						else
							a++;
					else if(matrix[i][6].contains("�빟援�"))
						h++;
					else
						f++;
						
				}
				
				HInfo.addProperty("location", "蹂묒썝");
				HInfo.addProperty("count", a + "");
				HArray.add(HInfo);
				HInfo = new JsonObject();
				HInfo.addProperty("location", "醫낇빀蹂묒썝");
				HInfo.addProperty("count", e + "");
				HArray.add(HInfo);
				HInfo = new JsonObject();
				HInfo.addProperty("location", "�긽湲됱쥌�빀蹂묒썝");
				HInfo.addProperty("count", b + "");
				HArray.add(HInfo);
				HInfo = new JsonObject();
				HInfo.addProperty("location", "�빟援�");
				HInfo.addProperty("count", h + "");
				HArray.add(HInfo);
				HInfo = new JsonObject();
				HInfo.addProperty("location", "遺덈챸�솗");
				HInfo.addProperty("count", (f-1) + "");
				HArray.add(HInfo);
				
				/* jsonObject.addProperty("Hospital", HArray); */
				mv.addObject("HArray", HArray.toString());
				
				JsonArray SArray = new JsonArray();
				 
				JsonObject SInfo = new JsonObject();
		        SInfo.addProperty("range", "500�씠�긽");
		        SInfo.addProperty("count", mc + "");
		        SArray.add(SInfo);
		        SInfo = new JsonObject();
		        SInfo.addProperty("range", "200�씠�긽 500誘몃쭔");
		        SInfo.addProperty("count", c + "");
		        SArray.add(SInfo);
		        SInfo = new JsonObject();
		        SInfo.addProperty("range", "遺덈챸�솗");
		        SInfo.addProperty("count", (n-1) + "");
		        SArray.add(SInfo);
		        
				/* jsonObject.addProperty("Scale", SArray); */
		        mv.addObject("SArray", SArray.toString());
		        
		        String jsonInfo = jsonObject.toString();
		        
		        System.out.print(jsonInfo);
				
				/*System.out.println("蹂묒썝" + a);
				System.out.println("�긽湲됱쥌�빀蹂묒썝 " + b);
				System.out.println("醫낇빀蹂묒썝" + e);
				System.out.println("�슂�뼇蹂묒썝" + d);
				System.out.println("�빟援�" + h);
				System.out.println("遺덈챸�솗" + (f-1));
				
				System.out.println("200 ~ 500 蹂묒긽洹쒕え :" + c);
				System.out.println("500�씠�긽 蹂묒긽 洹쒕え : " + mc);
				System.out.println("遺덈챸�솗�븳 蹂묒긽 洹쒕え :" + (n-1));*/
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
		//�긽�쐞 �삤釉뚯젥�듃 �깮�꽦
		JsonObject obj1 = new JsonObject();
		//data: �뮘�뿉 �뱾�뼱媛� 媛믪씤 jArray �깮�꽦
		JsonArray jArray = new JsonArray();
		
		//諛곗뿴�깮�꽦, jArray�쓽 0踰덉㎏ 諛곗뿴�뿉 彛덈（猷�, 1踰덉㎏ 諛곗뿴�뿉 彛덈（猷�~
		for(int i=0; i<10; i++){
		
			JsonObject obj2 = new JsonObject();
			//obj2�뒗 諛섎뱶�떆 for臾� �븞�뿉 �넃�븘�빞 �븳�떎. 洹몃옒�빞 以묐났�씠 �븞�깮湲대떎.
			
			obj2.addProperty("name",i + "name");
			obj2.addProperty("position",i + "position");
			obj2.addProperty("salary",i + "salary");
			obj2.addProperty("start_date",i + "start_date");
			obj2.addProperty("office",i + "office");
			obj2.addProperty("extn",i + "extn");
			
			jArray.add(obj2);

		}
		
		//留덉�留됱쑝濡� 理쒖긽�쐞�쓽 jsonObject�뿉 data�� jArry瑜� �꽔�뼱以��떎.
		
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
		String path = "D:\\而댄벂�꽣怨듯븰\\java\\workspace\\mass\\src\\main\\resources\\static\\�쓽猷뚭린愿��룊媛��씤利앹썝_�솚�옄�븞�쟾 �궗怨좊뜲�씠�꽣_20181231.csv";
		
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
				String[] temp = line.split(","); // �꺆�쑝濡� 援щ텇
				
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
				if(matrix[i][6].contains("蹂묒썝"))
					if(matrix[i][6].contains("�긽湲됱쥌�빀"))
						b++;
					else if(matrix[i][6].contains("�슂�뼇"))
						d++;
					else if(matrix[i][6].contains("醫낇빀"))
						e++;
					else
						a++;
				else if(matrix[i][6].contains("�빟援�"))
					h++;
				else
					f++;
					
			}
			
			HInfo.addProperty("location", "蹂묒썝");
			HInfo.addProperty("count", a + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "醫낇빀蹂묒썝");
			HInfo.addProperty("count", e + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "�긽湲됱쥌�빀蹂묒썝");
			HInfo.addProperty("count", b + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "�빟援�");
			HInfo.addProperty("count", h + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			HInfo = new JsonObject();
			HInfo.addProperty("location", "遺덈챸�솗");
			HInfo.addProperty("count", (f-1) + "");
			HInfo.addProperty("count", a + "");
			HArray.add(HInfo);
			
			/* jsonObject.addProperty("Hospital", HArray); */
			mv.addObject("HArray", HArray.toString());
			
			JsonArray SArray = new JsonArray();
			 
			JsonObject SInfo = new JsonObject();
	        SInfo.addProperty("range", "500�씠�긽");
	        SInfo.addProperty("count", mc + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "200�씠�긽 500誘몃쭔");
	        SInfo.addProperty("count", c + "");
	        SArray.add(SInfo);
	        SInfo = new JsonObject();
	        SInfo.addProperty("range", "遺덈챸�솗");
	        SInfo.addProperty("count", (n-1) + "");
	        SArray.add(SInfo);
	        
			/* jsonObject.addProperty("Scale", SArray); */
	        mv.addObject("SArray", SArray.toString());
	        
	        String jsonInfo = jsonObject.toString();
	        
	        System.out.print(jsonInfo);
			
			/*System.out.println("蹂묒썝" + a);
			System.out.println("�긽湲됱쥌�빀蹂묒썝 " + b);
			System.out.println("醫낇빀蹂묒썝" + e);
			System.out.println("�슂�뼇蹂묒썝" + d);
			System.out.println("�빟援�" + h);
			System.out.println("遺덈챸�솗" + (f-1));
			
			System.out.println("200 ~ 500 蹂묒긽洹쒕え :" + c);
			System.out.println("500�씠�긽 蹂묒긽 洹쒕え : " + mc);
			System.out.println("遺덈챸�솗�븳 蹂묒긽 洹쒕え :" + (n-1));*/
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