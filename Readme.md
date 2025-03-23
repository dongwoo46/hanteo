1. 트리구조로 카테고리와 게시판 만들기
- closure 테이블 활용하여 모든 카테고리간의 관계 저장 
  - 단점 : 많은 수의 쿼리가 나감
  - 장점 : 수정작업 시 해당 컬럼만 삭제 가능
- Category(카테고리), CategoryRelation(카테고리관계), Board(게시판)로 엔티티 생성
- CategoryRelation을 조회하여 카테고리 객체안에 하위 카테고리 삽입
- 익명 게시판의 경우 게시판은 id가 6번인 게시판 하나가 모든 카테고리에 동일하게 포함됨
따라서 하나의 Board만 만들어서 카테고리에 매핑시키기

2. 중복 조합 문제
- DP를 활용하여 계산량 축소
- Bottom Up 작은값을 활용하여 큰값을 계산하기
