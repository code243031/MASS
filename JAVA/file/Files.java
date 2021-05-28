package file;

//파일에서 추출한 데이터들을 이중배열로 저장한 객체들을 관리하는 클래스입니다.
//각 배열의 첫 줄은 항목을 구분합니다.(예: 번호, 구분, 진료과목, 제목, 키워드...)
public class Files {
	
	// 감정분석
	public String[][] judge = new String[54][12];
	
	// 상담분석
	public String[][] call = new String[141][14];
	
	// 조정분석
	public String[][] mediation = new String[91][12];	//현재 정상적으로 초기화되지 않는 배열입니다.
	
	// 환자 안전 사고 데이터
	public String[][] data = new String[9251][20];
	
	// 불가항력 의료사고 보상재원 현황
	public String[][] compensate = new String[11][5];
	
}
