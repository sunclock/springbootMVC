# springboot와 AWS로 혼자 구현하는 웹서비스
이동욱(@jojoldu)님의 저서 'springboot와 AWS로 혼자 구현하는 웹서비스'를 따라 공부한 기록입니다.

## 실습 목적
[soul_food 심리테스트](https://github.com/sunclock/soul_food) 프로젝트의 차기 프로젝트로 식당 리뷰 플랫폼 모바일 앱 백엔드 개발을 맡았습니다. 
백엔드 개발에 앞서 MVC 패턴과 springboot 프레임워크를 이해하기 위해 멘토님의 추천을 받은 이 책을 공부했습니다. 

## 실습 기간
2021.7.17 ~ 2021.7.21

## 배운 내용
### 1장
- IntelliJ의 설치와 기본 사용법
- mavenCentral, jcenter 비교
- springboot 프로젝트와 gradle 연동 방법
- IntelliJ에서 GitHub 사용하는 방법


### 2장
- TDD와 Unit Test
- springboot 환경에서 테스트 코드 작성하는 방법
- Java의 필수 utility인 lombok 사용법


### 3장
- JPA/Hibernate/Spring Data Jpa의 관계
- Spring Data Jpa를 이용해 관계형 데이터베이스를 객체지향적으로 관리하는 방법
- JPA의 Dirty Checking을 이용하면 Update Query 없이 테이블 수정이 가능하다는 것
- JPA Auditing을 이용하여 등록/수정 시간을 자동화하는 방법

### 4장
- Server Template Engine과 Client Template Engine의 차이
- mustache의 기본 사용 방법
- springboot에서의 화면 처리 방식
- js/css 선언 위치를 다르게 하여 웹사이트의 로딩 속도를 향상하는 방법
- js 객체를 이용하여 브라우저의 전역 변수 충돌 문제를 회피하는 방법

### 5장
- springboot 1.5와 springboot 2.0에서 security 설정의 차이점
- spring security를 이용한 google/naver 로그인 연동 방법
- Session 저장소로 tomcat/database/memory DB가 있으며 이중 database를 사용하는 이유
- ArgumentResolver를 이용하면 @Annotaion으로 로그인 Session 정보를 가져올 수 있다는 것
- spring security 적용 시 기존 테스트 코드에서 문제 해결 방법

### 6장
- AWS와 Cloud Service란?
- AWS의 가상 관리형 서버인 EC2 서비스 소개와 생성 방법
- EC2의 instace IP를 고정시켜주는 elastic IP에 대한 소개와 설정 방법
- EC2 instance 접근을 위한 pem key 사용 방법
- linux 서버 생성 시 해야 할 설정들


### 7장
- AWS의 관리형 데이터베이스 서비스인 RDS에 대한 소개와 생성 방법
- RDS로 서비스하는 데 필요한 여러 parameter 설정들
- IntelliJ Community 버전으로 데이터베이스를 다루는 방법
- EC2와 RDS 간 연동 방법


### 8장
- AWS EC2 서비스에 springboot 프로젝트를 배포하는 방법
- 간단한 shell scripts 사용 방법
- spirngboot 프로젝트와 AWS RDS 연동 방법
- EC2에서 Google/Naver 로그인 설정 방법

### 9장
- CI / CD에 대한 소개
- GitHub의 무료 CI 서비스인 Travis CI에 대한 소개와 프로젝트 연동 방법
- AWS의 CD 서비스인 CodeDeploy에 대한 소개와 프로젝트 연동 방법
- 수동 배포 방식에서 자동화 방식으로의 개선
- CodeDeploy에서 오류 로그를 보는 방법


### 10장 (ongoing)
- 무중단 배포 소개
- Web Server이자 Load Balancer 역할을 하는 nginx에 대한 소개
- nginx를 이용한 무중단 배포 방법
- source 명령어를 이용한 shell script 파일 import 방법
