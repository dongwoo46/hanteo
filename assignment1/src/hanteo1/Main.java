package hanteo1;

import hanteo1.entities.Board;
import hanteo1.entities.Category;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();

        // 카테고리 생성
        service.createCategory(1, "남자");
        service.createCategory(2, "엑소");
        service.createCategory(3, "공지사항");
        service.createCategory(4, "첸");
        service.createCategory(5, "백현");
        service.createCategory(6, "시우민");
        service.createCategory(7, "방탄소년단");
        service.createCategory(8, "공지사항");
        service.createCategory(9, "익명게시판");
        service.createCategory(10, "뷔");
        service.createCategory(11, "여자");
        service.createCategory(12, "블랙핑크");
        service.createCategory(13, "공지사항");
        service.createCategory(14, "익명게시판");
        service.createCategory(15, "로제");

        // 게시판 객체 생성 (익명게시판은 공유)
        Board board1 = new Board(1, "공지사항", "엑소 공지사항");
        Board board2 = new Board(2, "첸", "첸 게시판");
        Board board3 = new Board(3, "백현", "백현 게시판");
        Board board4 = new Board(4, "시우민", "시우민 게시판");
        Board board5 = new Board(5, "공지사항", "방탄 공지사항");
        Board board6 = new Board(6, "익명게시판", "공유 게시판");
        Board board7 = new Board(7, "뷔", "뷔 게시판");
        Board board8 = new Board(8, "공지사항", "블핑 공지사항");
        Board board9 = new Board(9, "로제", "로제 게시판");

        // 게시판 연결
        service.addBoardToCategory(3, board1);  // 엑소-공지사항
        service.addBoardToCategory(4, board2);  // 첸
        service.addBoardToCategory(5, board3);  // 백현
        service.addBoardToCategory(6, board4);  // 시우민
        service.addBoardToCategory(8, board5);  // 방탄-공지사항
        service.addBoardToCategory(9, board6);  // 방탄-익명게시판
        service.addBoardToCategory(10, board7); // 뷔
        service.addBoardToCategory(13, board8); // 블핑-공지사항
        service.addBoardToCategory(14, board6); // 블핑-익명게시판 (공유)
        service.addBoardToCategory(15, board9); // 로제

        // 관계 설정
        service.addRelation(null, 1);    // 루트: 남자
        service.addRelation(1, 2);       // 남자 → 엑소
        service.addRelation(2, 3);       // 엑소 → 공지사항
        service.addRelation(2, 4);       // 엑소 → 첸
        service.addRelation(2, 5);       // 엑소 → 백현
        service.addRelation(2, 6);       // 엑소 → 시우민
        service.addRelation(1, 7);       // 남자 → 방탄소년단
        service.addRelation(7, 8);       // 방탄 → 공지사항
        service.addRelation(7, 9);       // 방탄 → 익명게시판
        service.addRelation(7, 10);      // 방탄 → 뷔

        service.addRelation(null, 11);   // 루트: 여자
        service.addRelation(11, 12);     // 여자 → 블랙핑크
        service.addRelation(12, 13);     // 블핑 → 공지사항
        service.addRelation(12, 14);     // 블핑 → 익명게시판
        service.addRelation(12, 15);     // 블핑 → 로제

        // 트리 제작
        service.buildTree();

        // 확인: 블랙핑크 카테고리 출력
        Category result = service.findByName("블랙핑크");
        Category result2 = service.findById(1);
        System.out.println(service.toJson(result));
    }
}
