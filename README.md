# flo

## 기술스택
* Spring Boot 2.1.4
* Java 1.8
* Gradle 5.2.1
* MySQL 8.0.15
* Mybatis

## 2/6

1. 이클립스에 Gradle 프로젝트 import 및 서버 실행
   - localhost:5000 확인
2. GitHub에 flo repository 생성 및 프로젝트 연동

## 4/1

1. MySQL 설정
2. MyBatis 설정
3. Controller, Mapper, Service 폴더구조 만들기

## 4/2

1. View 설정

2. Albums 테이블 추가, Songs 테이블에 조인 칼럼 추가
```
<요구사항 가정>
앨범에 수록되지 않은 곡이 존재할 수도 있음
앨범에 수록되지 않은 곡은 소수일거 같음
한 곡이 여러 앨범에 수록되지 않음
같은 곡이라도 다른 앨범에 수록될 경우 다른 곡으로 취급

<설계>
다대일 : Songs-Albums
조인테이블과 조인컬럼 중에 조인칼럼 이용
NULL이 가능하도록 설정
존재하는 모든 노래 갯수를 생각하면 타입을 LONG으로 해야할 것 같지만 실습이니 INT로 설정

<추가적인 고민>
1. album_id가 null이 가능할 경우 문제점은 없을까?
-> 외부조인을 해야하는데 내부조인에 비해 성능이 안 좋다
앨범없음이라는 앨범을 하나 만들어 그 앨범을 지정하는 방법은?

2. 다른 앨범에 속한 같은 곡일 경우 같은 곡으로 묶어서 처리해야할 경우(예를 들어 통계) 어떻게 하는게 좋을까?

<기타>
MyBatis로 외래키 맵핑시키고 엔티티 클래스로 표현하는 게 아직 좀 서툰거같음
Mapper클래스로만 작업하고 싶은데 XML을 만들어야하나 고민중
```

## 4/6
1. 구조 다듬기

* Songs 테이블 album_id NOT NULL로 변경
```
  - 내부조인으로 변경
  - Controller에서 album null 체크 간편해짐
  - 초반부터 구조를 복잡하게 가져가지 않도록
```
* 규칙 정하기
  * 필드 명명
     * Join 시 별칭을 써야하지만 통일성을 위해 비슷한 이름 사용 (album 테이블의 title, song 테이블의 title)
  * Entity 클래스
     * Entity 클래스틑 최대한 객체지향답게 구현 (album_id 필드를 album 참조로 표현)
     * Entity 클래스와 DB 테이블 사이의 차이는 Mapper에서 Result를 통해 맵핑
     
## 4/8
1. Playlists 테이블 추가, PlaylistsSongs 테이블 추가
```
<설계>
다대다 : Songs-Playlists
조인테이블 이용
복합 키를 이용해 중복 방지

Entity 클래서에서 Song에서는 Playlist를 아직 사용할 필요가 없다고 가정
Playlists에만 List<Song> 컬렉션 추가

<기타>
Mapper클래스로만 작업하고 싶은데 XML을 만들어야하나 고민중222222
컬렉션 맵핑이 까다롭고 XML 예제는 많은데 어노테이션 예제가 많이 없음
```
