package analysis;

import java.util.ArrayList;

//의료사고 및 의료분쟁을 분석하기 위해 필요한 정보를 종류(분야)별로 초기화할 객체들을 관리하는 클래스입니다.
//객체들을 효율적으로 관리하기 위해 배열과 ArrayList를 사용하였습니다.
//키워드 부분은 종류가 너무 많아 나누는게 의미가 있을 지 모르겠습니다.
public class DataAnalysis {
	
	// 진료과(예: 내과, 산부인과 등) - 조정분석
	public ArrayList<String> specLM = new ArrayList<String>();
	
	// 진료과(예: 내과, 산부인과 등) - 감정분석
	public ArrayList<String> specLJ = new ArrayList<String>();
	
	// 진료과(예: 내과, 산부인과 등) - 상담분석
	public ArrayList<String> specLC = new ArrayList<String>();
	
	// 키워드(예: 임플란트 등) - 조정분석
	public ArrayList<String> keywordLM = new ArrayList<String>();
	
	// 키워드(예: 진단상 과실 등) - 감정분석
	public ArrayList<String> keyWordLJ = new ArrayList<String>();
	
	// 처리결과(예: 합의성립, 조정불성립 등) - 조정분석
	public String[] result = new String[6];
	
}
