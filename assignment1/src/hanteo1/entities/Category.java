package hanteo1.entities;

import java.util.ArrayList;
import java.util.List;

public class Category {

    // 카테고리 PK
    private int id;
    //카테고리명
    private String categoryName;
    // 카테고리의 게시판들
    private Board board;
    // 해당 카테고리의 하위 카테고리들
    private List<Category> categories = new ArrayList<>();

    public Category(int id, String name) {
        this.id = id;
        this.categoryName = name;
    }

    public int getId() { return id; }
    public String getName() { return categoryName; }
    public Board getBoard() { return board; }
    public List<Category> getCategories() {
        return categories;
    }

    public void addCategories(Category category) { this.categories.add(category); }

    // 카테고리에 보드 객체 삽입
    public void attachBoard(Board board) {
        if (this.board != null) throw new IllegalStateException("이미 게시판이 연결됨");
        this.board = board;
    }
}
