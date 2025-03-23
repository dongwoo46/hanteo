package hanteo1.entities;

// 게시판
public class Board {
    // 게시판번호 PK
    private int id;
    // 제목
    private String name;
    // 게시판 설명
    private String description;

    public Board(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
