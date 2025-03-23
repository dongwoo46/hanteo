package hanteo1.entities;

// Category간의 모든 관계를 저장해 놓는 closure table
public class CategoryRelation {
    // Category의 부모 id
    // null 허용 null일 시 트리의 root
    private Integer parentIdx;
    // Category의 하위계층 id
    private Integer childId;

    public CategoryRelation(Integer parentIdx, Integer childId) {
        this.parentIdx = parentIdx;
        this.childId = childId;
    }

    public Integer getParentIdx() { return parentIdx; }
    public Integer getChildId() { return childId; }
}
