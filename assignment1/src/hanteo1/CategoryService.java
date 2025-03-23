package hanteo1;

import hanteo1.entities.Board;
import hanteo1.entities.Category;
import hanteo1.entities.CategoryRelation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.*;

public class CategoryService {
    // 카테고리를 저장 (Map의 idx를 활용 조회성능 개선  ex) DB 인덱스)
    private final Map<Integer, Category> categoryMap = new HashMap<>();
    // 모든 Category의 관계 리스트로 저장
    private final List<CategoryRelation> relations = new ArrayList<>();
    // 트리의 시작점을 빠르게 찾기위해 트리의 루트는 따로 저장
    private final List<Category> roots = new ArrayList<>();

    // 카테고리 생성
    public void createCategory(int id, String name) {
        categoryMap.put(id, new Category(id, name));
    }

    public void addBoardToCategory(int categoryId, Board board) {
        Category category = categoryMap.get(categoryId);
        if (category != null) category.attachBoard(board);
    }

    public void addRelation(Integer parentId, int childId) {
        relations.add(new CategoryRelation(parentId, childId));
    }

    public void buildTree() {
        for (CategoryRelation relation : relations) {
            if (relation.getParentIdx() == null) {
                // 부모 idx가 null이면 roots에 넣어주기
                roots.add(categoryMap.get(relation.getChildId()));
            } else {
                // 관계에서 부모와 자식 Category를 찾고 부모의 categories안에 자식 카테고리 삽입
                Category parent = categoryMap.get(relation.getParentIdx());
                Category child = categoryMap.get(relation.getChildId());
                parent.addCategories(child);
            }
        }
    }

    public Category findById(int id) {
        return categoryMap.get(id);
    }

    public Category findByName(String name) {
        for (Category cat : categoryMap.values()) {
            if (cat.getName().equalsIgnoreCase(name)) return cat;
        }
        return null;
    }

    public String toJson(Category category) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(category);
    }

    public String toJsonRoots() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this.roots);
    }

    public List<Category> getRoots() {
        return roots;
    }
}
