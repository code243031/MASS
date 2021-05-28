package file;

import java.io.*;

//파일을 읽고, 읽은 데이터들을 배열 객체에 저장하는 클래스 입니다.
//csv 파일을 프로젝트 내부에 넣어 상대 경로만으로 찾아갈 수 있게 합니다.
//기존에 UTF-8 형식으로 되어있지 않아 한글 깨짐 현상이 발생해 CSV_UTF-8로 변경했습니다.
//의료사고 조정분석 파일에 줄바꿈이 많아 파일을 제대로 읽는 것이 불가능하여 csv 파일을 읽어들이는 다른 방법을 찾는 중입니다.
//현재 잘 작동하는지 확인하기 위해 메소드로 구현하였으나 파일 읽는 기능이 안정적으로 되면 해당 코드들을 생성자 내에 넣을 예정입니다.
public class Fileread {
	Files f = null;
	
	public Fileread(Files _f) {
		this.f = _f;
		
	}
	
	public void setJudge() {
		try {
			File jud_csv = new File("의료분쟁 감정분석 현황(2017.11.8.)..csv");
			BufferedReader br = new BufferedReader(new FileReader(jud_csv));
			//System.out.println("성공1");
			
			String line = "";
			int i;
			int row=0;
			
			while((line = br.readLine()) != null) {
				String[] s = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
				
				for(i=0; i<12; i++) {
					f.judge[row][i] = s[i];
				}
				
				row++;
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setCall() {
		try {
			File cal_csv = new File("의료분쟁 상담분석 현황(2015.6.1.)..csv");
			BufferedReader br = new BufferedReader(new FileReader(cal_csv));
			//System.out.println("성공2");
			
			String line = "";
			int i;
			int row = 0;
			
			while((line = br.readLine()) != null) {
				String[] s = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
				
				for(i=0; i<14; i++) {
					f.call[row][i] = s[i];
				}
				
				row++;
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setMediation() {	//파일을 읽는데 문제있음
		try {
			File med_csv = new File("의료분쟁 조정분석 현황(2015.6.1.)..csv");
			BufferedReader br = new BufferedReader(new FileReader(med_csv));
			//System.out.println("성공3");
			
			String line = "";
			int i;
			int row = 0;
			
			while((line = br.readLine()) != null) {
				String[] s = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
				
				for(i=0; i<12; i++) {
					f.mediation[row][i] = s[i];
				}
				
				row++;
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException e) {
			System.out.println(e.toString());
		} catch(Exception e) {	//혼자 정상작동 안돼서 예외/오류 찾으려고 넣어둠 문제 해결하면 빼야 함
			System.out.println(e.toString());
		}
	}
	
	public void setData() {
		try {
			File dat_csv = new File("의료기관평가인증원_환자안전 사고데이터_20181231..csv");
			BufferedReader br = new BufferedReader(new FileReader(dat_csv));
			//System.out.println("성공4");
			
			String line = "";
			int i;
			int row = 0;
			
			while((line = br.readLine()) != null) {
				String[] s = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
				
				for(i=0; i<20; i++) {
					f.data[row][i] = s[i];
				}
				
				row++;
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setCompensate() {
		try {
			File com_csv = new File("한국의료분쟁조정중재원_불가항력 의료사고 보상재원 현황_20191231.csv");
			BufferedReader br = new BufferedReader(new FileReader(com_csv));
			//System.out.println("성공5");
			
			String line = "";
			int i;
			int row = 0;
			
			while((line = br.readLine()) != null) {
				String[] s = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

				for(i=0; i<5; i++) {
					f.compensate[row][i] = s[i];
				}
				
				row++;
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}
