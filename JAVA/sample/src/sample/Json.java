

import java.io.*;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class excel {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader pr = null;
		String line, line2;
		String path = "C:\\Users\\������\\Downloads\\2.csv";
		String path2 = "C:\\Users\\������\\Downloads\\�Ƿ�����������_ȯ�ھ��� �������_20181231.csv";
		
		JSONObject jsonObject = new JSONObject();
		 
    
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			pr = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "UTF-8"));
			int rows = 54;
			int cols = 13;
			int rows2 = 9251;
			int cols2 = 20;
			int[] arr = new int[54];//���� �� ���� ����
			int death = 0;//���
			int ndeath = 0;
			int syndrome = 0;//���ı�
			int cancer = 0;//��
			int delay = 0;//���� ����
			int lesion = 0;//���
			int reoperation = 0;//�����
			int paralysis = 0;//����
			int c = 0;//��Ÿ ����
			int nc = 0;// ��Ÿ ���� �Ǻ�
			int[] Hname = new int[6];// 0.���� 	1.������պ���	2.���պ���		3.��纴��		4.�౹	5.�Ҹ�Ȯ
			int[] ScaleCount = new int[3]; //0. 500�̻� 	1. 200~500 		2. �Ҹ�Ȯ 
			int[] ms = new int[6];//1.����  	2.�ܰ�  	3.����ΰ�		4.�Ȱ�	5.�̺����İ�		6.ġ�� 
			String[][] matrix= new String[rows][cols];//csv ���� ���� �迭 ����
			String[][] matrix2= new String[rows2][cols2];//csv ���� ���� �迭 ����
			int row = 0;
			while((line = br.readLine()) != null) {				
				if (line.isEmpty()) {
			        continue;
			    }
				String[] temp = line.split(","); //  ,�� ����
			    for(int col= 0; col < cols; col++) {// �迭�� ���� �ֱ�
			        matrix[row][col]= temp[col];
			    }
			    row++;
			}
			row = 0;
			while((line2 = pr.readLine()) != null) {				
				if (line2.isEmpty()) {
			        continue;
			    }
				String[] temp = line2.split(","); //  ,�� ����
			    for(int col= 0; col < cols2; col++) {// �迭�� ���� �ֱ�
			        matrix2[row][col]= temp[col];
			    }
			    row++;
			}
			for(int i = 1; i < rows; i++)// ȯ�� ���� �м� �ڵ�
			{
				for(int j = 0; j < 5; j++)
				{
					nc = 0;
					if(matrix[i][j] == null)
						continue;
					if(matrix[i][j].contains("���"))
					{
						if(matrix[i][j].contains("�Ұ��׷�"))
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
					else if(matrix[i][j].contains("���ı�") && matrix[i][j].contains("�߻�"))
					{
						syndrome ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("����") && matrix[i][j].contains("����"))
					{
						delay ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("���"))
					{
						lesion ++;
						nc = 1;
						break;				
					}
					else if(matrix[i][j].contains("�����"))
					{
						reoperation ++;
						nc = 1;
						break;
					}
					else if(matrix[i][j].contains("����"))
					{
						paralysis ++;
						nc = 1;
						break;
					}
				}
				if(nc == 0)
					c++;
			}
			for(int i = 0; i < rows; i++)//���� �� �Ǻ� �ڵ�
			{
				if(matrix[i][11] == null)
					continue;
				if(matrix[i][11].equals("."))
					continue;
				else arr[i] = 1;
			}
			for(int i = 0; i < rows; i++) //����� ���� �ڵ�
			{
				if(matrix[i][0] == null)
					continue;
				if(matrix[i][1].contains("�ǰ�"))
					{
						if(matrix[i][2].contains("����"))
							ms[0]++;
						else if(matrix[i][2].contains("�ܰ�"))
							ms[1]++;
						else if(matrix[i][2].contains("����ΰ�"))
							ms[2]++;
						else if(matrix[i][2].contains("�Ȱ�"))
							ms[3]++;
						else if(matrix[i][2].contains("�̺����İ�"))
							ms[4]++;
					}
				else ms[5]++;
			}
			
			for(int i = 1; i < rows2; i++)//0. 500�̻� 	1. 200~500 		2. �Ҹ�Ȯ 
			{
				if(matrix2[i][7].contains("500"))
					if(matrix2[i][7].contains("200"))
						ScaleCount[1]++;
					else ScaleCount[0]++;
				else ScaleCount[2]++;
					
			}
			
			for(int i = 1; i < rows2; i++)// 0.���� 	1.������պ���	2.���պ���		3.��纴��		4.�౹	5.�Ҹ�Ȯ
			{
				if(matrix2[i][6].contains("����"))
					if(matrix2[i][6].contains("�������"))
						Hname[1]++;
					else if(matrix2[i][6].contains("���"))
						Hname[3]++;
					else if(matrix2[i][6].contains("����"))
						Hname[2]++;
					else
						Hname[0]++;
				else if(matrix2[i][6].contains("�౹"))
					Hname[4]++;
				else
					Hname[5]++;
					
			}
			
			
			JSONArray HArray = new JSONArray();
			 
	        JSONObject HInfo = new JSONObject();
	        
	        HInfo.put("������պ��� : ", Hname[1]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("���պ��� : ", Hname[2]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("���  ���� : ", Hname[3]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("�౹ : ", Hname[4]);
			HArray.add(HInfo);
			HInfo = new JSONObject();
			HInfo.put("�Ҹ�Ȯ : ", Hname[5]);
			HArray.add(HInfo);
			jsonObject.put("�߻� ����", HArray);
			
			
			JSONArray SArray = new JSONArray();
			 
	        JSONObject SInfo = new JSONObject(); //0. 500�̻� 	1. 200~500 		2. �Ҹ�Ȯ 
	        SInfo.put("500�̻� : ", ScaleCount[0]);
	        SArray.add(SInfo);
	        SInfo = new JSONObject();
	        SInfo.put("200�̻� 500�̸� :  ", ScaleCount[1]);
	        SArray.add(SInfo);
	        SInfo = new JSONObject();
	        SInfo.put("�Ҹ�Ȯ : ", ScaleCount[2]);
	        SArray.add(SInfo);
	        jsonObject.put("���� �Ը� ", SArray);		
			
			//event
			JSONArray EArray = new JSONArray();		    
	        JSONObject EInfo = new JSONObject();
						
			EInfo.put("��� : ", death);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("�Ұ��׷� ��� : ", ndeath);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("���ı� : ", syndrome);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("���� ���� : ", delay);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("����� : ", reoperation);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("��� : ", lesion);
			EArray.add(EInfo);
			EInfo = new JSONObject();
			EInfo.put("��Ÿ : ", c);
			EArray.add(EInfo);
			jsonObject.put("����", EArray);
			
			//�����
			JSONArray MSArray = new JSONArray();
			JSONObject MSInfo = new JSONObject();
			MSInfo.put("���� : ", ms[0]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("�ܰ� : ", ms[1]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("����ΰ�: ", ms[2]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("�Ȱ� : ", ms[3]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("�̺����İ� : ", ms[4]);
			MSArray.add(MSInfo);
			MSInfo = new JSONObject();
			MSInfo.put("ġ�� : ", ms[5]);
			MSArray.add(MSInfo);
			jsonObject.put("�����", MSArray);
			
			//����
			JSONArray GArray = new JSONArray();
			JSONObject GInfo = new JSONObject();
			for(int i = 1; i < rows; i++)
				{
					GInfo = new JSONObject();
					GInfo.put("��� : ", matrix[i][3]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("ġ����� : ", matrix[i][6]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("������� : ", matrix[i][9]);
					GArray.add(GInfo);
					GInfo = new JSONObject();
					GInfo.put("������� : ", matrix[i][10]);
					GArray.add(GInfo);	
					GInfo = new JSONObject();
					if(arr[i] == 1) {					
						GInfo.put("������ : ", matrix[i][11]);
						GArray.add(GInfo);	
					}
					else
					{
						GInfo.put("������ : ", "������ �� ���� ��� �Դϴ�.");
						GArray.add(GInfo);	
					}
				}
			
			jsonObject.put("����", GArray);
			
			try { //�������� �ڵ�
				 
				FileWriter file = new FileWriter("C:\\Users\\������\\Desktop\\�� ����\\test.json");
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

	