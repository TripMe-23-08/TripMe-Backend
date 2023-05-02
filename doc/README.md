# EnjoyTrip 
## Team08. 박은정, 양승현
## API 문서
[trip route](https://documenter.getpostman.com/view/26837182/2s93eU3aNo)

[user - info](https://documenter.getpostman.com/view/26837182/2s93Xx14zt)

[user - like place](https://documenter.getpostman.com/view/26837182/2s93eU3aTA)

[areacode](https://documenter.getpostman.com/view/26837182/2s93Xx155D)

[places :attraction](https://documenter.getpostman.com/view/26837182/2s93Xx155C)

[signin, signup, signout](https://documenter.getpostman.com/view/26837182/2s93eU3aNp)

[post](https://documenter.getpostman.com/view/26837182/2s93Xx155E)

---
## 실행 화면 캡쳐

### 지역 코드

[GET] 모든 Area Code 조회

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled.png)

[GET] 시도에 포함된 모든 구군 조회

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%201.png)

## 관광지

### 관광지 타입 & 지역별 조회

[GET] 관광지 타입 & 지역별 조회 (시도)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%202.png)

[GET] 관광지 타입 & 지역별 조회 (시도,구)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%203.png)

[GET] 관광지 타입 & 지역별 조회 (시도, 구군, 카테고리)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%204.png)

[GET] 관광지 타입 & 지역별 조회 (관광)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%205.png)

### 관광지 자세히 조회

[GET] 관광지 자세히 조회

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%206.png)

## 회원 가입 , 로그인, 로그아웃

### 회원가입

[POST] 회원가입 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%207.png)

[POST] 회원가입 (실패; 필수값 없음)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%208.png)

[POST] 회원가입 (실패; 중복된 이메일)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%209.png)

### 로그인

[POST] 로그인 실패

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2010.png)

### 로그아웃

[GET] 로그아웃

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2011.png)

## 여행 경로

### 모든 여행 경로 조회

[GET] 모든 여행 경로 조회 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2012.png)

### 특정 여행 경로 조회

[GET] 특정 여행 경로 조회 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2013.png)

### 여행 경로 추가

[POST] 여행 경로 추가 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2014.png)

### 여행 경로 수정

[PUT] 여행 경로 수정 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2015.png)

### 여행 경로 삭제

[DEL] 여행 경로 삭제 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2016.png)

## 회원 정보

### 회원 정보 수정

[PUT] 회원 정보 수정 (성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2017.png)

[PUT] 회원 정보 수정 (실패; 유저 없음)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2018.png)

### 회원 정보 삭제 (탈퇴)

[DELETE] 회원 삭제(성공)

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2019.png)

[DELETE] 회원 삭제(실패) ; 잘못된 요청 or 실패

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2020.png)

### 회원 정보 조회

[GET] 회원 정보 조회 (성공)

![성공](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2021.png)

성공

[GET] 회원 정보 조회 (실패패)

![실패](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2022.png)

실패

## 좋아요한 장소

### 좋아요한 모든 장소 조회

[GET] 스크랩(좋아요)한 모든 장소 조회

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2023.png)

### 장소 좋아요 취소

[DELETE] 스크랩(좋아요)한 장소 취소

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2024.png)

### 장소 좋아요 추가

[POST] 스크랩(좋아요)한 장소 추가

![Untitled](documentation%20ddbedda39663453eae43a79189d35acd/Untitled%2025.png)