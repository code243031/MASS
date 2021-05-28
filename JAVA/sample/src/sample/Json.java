

import java.io.*;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class excel {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader pr = null;
		String line, line2;
		String path = "C:\\Users\\김태현\\Downloads\\2.csv";
		String path2 = "C:\\Users\\김태현\\Downloads\\의료기관평가인증원_환자안전 사고데이터_20181231.csv";
		
		JSONObject jsonObject = new JSONObject();
		 
    
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			pr = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "UTF-8"));
			int rows = 54;
			int cols = 13;
			int rows2 = 9251;
			int cols2 = 20;
			int[] arr = new int[54];//예방 팁 존재 여부
			int death = 0;//사망
			int ndeath = 0;
			int syndrome = 0;//증후군
			int cancer = 0;//암
			int delay = 0;//진단 지연
			int lesion = 0;//장애
			int reoperation = 0;//재수술
			int paralysis = 0;//마비
			int c = 0;//기타 증상
			int nc = 0;// 기타 증상 판별
			int[] Hname = new int[6];// 0.병원 	1.상급종합병원	2.종합병원		3.요양병원		4.약국	5.불명확
			int[] ScaleCount = new int[3]; //0. 500이상 	1. 200~500 		2. 불명확 
			int[] ms = new int[6];//1.내과  	2.외과  	3.산부인과		4.안과	5.이빈인후과		6.치과 
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
			for(int i = 1; i < rows; i++)// 환자 상태 분석 코드
			{
				for(int j = 0; j < 5; j++)
				{
					nc = 0;
					if(matrix[i][j] == null)
						continue;
					if(matrix[i][j].contains("사망"))
					{
						if(matrix[i][j].contains("불가항력"))
						{
							ndeath ++;
							nc = 1;
							break;
						}
						else
						{
							nc = 1;
							death++;
						}
					}	
					else if(matrix[i][j].contains("증후군") && matrix[i][j].contains("발생"))
					{
						syndrome ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("진단") && matrix[i][j].contains("지연"))
					{
						delay ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("장애"))
					{
						lesion ++;
						nc = 1;
						break;				
					}
					else if(matrix[i][j].contains("재수술"))
					{
						reoperation ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("마비"))
					{
						paralysis ++;
						nc = 1;
						break;
					}
				}
				if(nc == 0)
					c++;
			}
			for(int i = 0; i < rows; i++)//예방 팁 판별 코드
			{
				if(matrix[i][11] == null)
					continue;
				if(matrix[i][11].equals("."))
					continue;
				else arr[i] = 1;
			}
			for(int i = 0; i < rows; i++) //진료과 구분 코드
			{
				if(matrix[i][0] == null)
					continue;
				if(matrix[i][1].contains("의계"))
					{
						if(matrix[i][2].contains("내과"))
							ms[0]++;
						else if(matrix[i][2].contains("외과"))
							ms[1]++;
						else if(matrix[i][2].contains("산부인과"))
							ms[2]++;
						else if(matrix[i][2].contains("안과"))
							ms[3]++;
						else if(matrix[i][2].contains("이비인후과"))
							ms[4]++;
					}
				else ms[5]++;
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
			
			
			JSONArray HArray = new JSONArray();
			 
	        JSONObject HInfo = new JSONObject();
	        
	        HInfo.put("상급종합병원 : ", Hname[1]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("종합병원 : ", Hname[2]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("요양  병원 : ", Hname[3]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("약국 : ", Hname[4]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("불명확 : ", Hname[5]);
			HArray.add(HInfo);
			jsonObject.put("발생 병원", HArray);
			
			
			JSONArray SArray = new JSONArray();
			 
	        JSONObject SInfo = new JSONObject(); //0. 500이상 	1. 200~500 		2. 불명확 
	        SInfo.put("500이상 : ", ScaleCount[0]);
	        SArray.add(SInfo);
	        SInfo = new JSONObject();
	        SInfo.put("200이상 500미만 :  ", ScaleCount[1]);
	        SArray.add(SInfo);
	        SInfo = new JSONObject();
	        SInfo.put("불명확 : ", ScaleCount[2]);
	        SArray.add(SInfo);
	        jsonObject.put("병상 규모 ", SArray);		
			
			//event
			JSONArray EArray = new JSONArray();		    
	        JSONObject EInfo = new JSONObject();
						
			EInfo.put("사망 : ", death);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("불가항력 사망 : ", ndeath);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("증후군 : ", syndrome);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("진단 지연 : ", delay);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("재수술 : ", reoperation);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("장애 : ", lesion);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("기타 : ", c);
			EArray.add(EInfo);
			jsonObject.put("병명", EArray);
			
			//진료과
			JSONArray MSArray = new JSONArray();
			JSONObject MSInfo = new JSONObject();
			MSInfo.put("내과 : ", ms[0]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("외과 : ", ms[1]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("산부인과: ", ms[2]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("안과 : ", ms[3]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("이비인후과 : ", ms[4]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("치과 : ", ms[5]);
			MSArray.add(MSInfo);
			jsonObject.put("진료과", MSArray);
			
			//종합
			JSONArray GArray = new JSONArray();
			JSONObject GInfo = new JSONObject();
			for(int i = 1; i < rows; i++)
				{
					GInfo = new JSONObject();
					GInfo.put("사건 : ", matrix[i][3]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("치료과정 : ", matrix[i][6]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("감정결과 : ", matrix[i][9]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("조정결과 : ", matrix[i][10]);
					GArray.add(GInfo);	
					GInfo = new JSONObject();
					if(arr[i] == 1) {					
						GInfo.put("예방팁 : ", matrix[i][11]);
						GArray.add(GInfo);	
					}
					else
					{
						GInfo.put("예방팁 : ", "예방할 수 없는 사고 입니다.");
						GArray.add(GInfo);	
					}
				}
			
			jsonObject.put("종합", GArray);
			
			try { //파일저장 코드
				 
				FileWriter file = new FileWriter("C:\\Users\\김태현\\Desktop\\새 폴더\\test.json");
				file.write(jsonObject.toJSONString());
				file.flush();
				file.close();
		 
			} catch (IOException e) {
				e.printStackTrace();
			}


			
			 String jsonInfo = jsonObject.toJSONString();
		        
		        System.out.println(jsonInfo);
			
		 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	