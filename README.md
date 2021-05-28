Project MASS
===============
### 목차
1. [What is the MASS?](#What-is-the-MASS?)  
2. [Development environment](#Development-environment)  
3. [Documents](#Documents)  
4. [Developers](#Developers)  
5. [Others](#Others)  
  
## What is the MASS?
![alt Text](https://github.com/code243031/MASS/blob/main/res/img/banner.png)  
MASS는 Medical Accident Statistics Site의 줄임말로 국내 의료사고 및 이로인한 의료분쟁이 발생했던 기록들을 통하여 국민들이 제공받고 있는 의료산업 및 서비스의 실태를 분석하기 위해 만들어진 웹사이트 입니다.  
저희는 대한민국 의료환경의 개선을 위해 정보를 제공하는 사이트를 개설하기로 마음먹었으며 제공되는 자료들이 부디 대한민국의 발전에 좋은 영향을 주었으면 하는 바램입니다.  

## Development environment
|개발품 형태 | 웹 사이트|
|-----------|----------------------------|
|사용 언어   | HTML, Java, JavaScript, CSS|
|적용 기술   | Spring framework, value Esculator, Apache Web Server|
|호스팅 서비스|[닷홈](https://www.dothome.co.kr/)|
|라이선스   | GPL 3.0v License |
|개발주소   | https://github.com/code243031/MASS |
  

## Documents

**1. Project Directory**  

디렉토리 구조는 다음과 같다.
> main  
├ JAVA ┬ MASS  
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└ file  
│  
├ css  
├ html  
├ js  
└ res ┬ json  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├ csv  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└ img  

* JAVA  
웹 서버 구축에 사용된 JAVA Maven프로젝트와 의료사고 및 의료분쟁 공공데이터 추출 및 분석에 사용되는 자바 파일들이 있는 디렉토리이다. MASS폴더에 Maven프로젝트가, file에 자바 파일들이 들어있다.
  
* js  
웹 페이지 동작에 사용되는 자바스크립트 파일들이 들어있는 디렉토리다.
  
* html  
웹 페이지를 구성하고 만들어내는 HTML파일들이 들어있는 디렉토리다.
  
* css  
웹 페이지 스타일 구축에 사용되는 css파일들이 들어있는 디렉토리다.

* res  
프로젝트의 리소스가 모여있는 디렉토리다. json에는 공공데이터로부터 추출한 자료들 및 다른 자료를 포함한 json파일들이 들어있고, csv에는 공공데이터 포털에서 다운로드 받은 엑셀 테이블 파일들이, img에는 웹 페이지 및 기타 문서들의 제작에 사용된 이미지 파일들이 들어있다.
  
**2. Webpage Example**  
![Alt image](https://github.com/code243031/MASS/blob/main/res/img/01.jpg)
* Home  
메인 페이지. 사이트 개설 목적 및 개발 방향에 대해 요약해놓은 페이지다.  

* About us  
프로젝트 참여자들의 정보가 들어있는 페이지다.  

* Analysis Data  
의료사고 및 의료분쟁 분석 데이터 가공 데이터를 조회할 수 있는 페이지다.  

* Release
공공 데이터 원본과 분석 자료에 대한 JSON파일을 바로 다운로드 받아볼 수 있는 페이지다.

* Blog  
개발팀장의 블로그로 연결된다.  

**3. Applied Algorithm**  
_준비중..._
  
## Developers
> 마지막 수정일자 : 2021-05-28  
> ※ 이 프로젝트는 선문대학교 아산캠퍼스 컴퓨터공학부 재학생들의 오픈소스SW 팀 프로젝트입니다.  
> 담당교수 : 김정동교수님  
+ 최주홍(팀장)  
  - koy321@naver.com  
  - code243031  
+ 이수형  
  - suhyung1006@naver.com
  - suhyung1006
+ 김태현  
  - xogus9715@naver.com
  - KimTaeHyeon9715
+ 김지연  
  - wusemr2@naver.com
  - wusemr
  
## Others
+ 개발팀장 블로그 : https://blog.naver.com/koy321
