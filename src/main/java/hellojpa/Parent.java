package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author snow
 * @since 2021/05/22
 */
@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();
    // 일대다 에서 일쪽에 세팅한다.(부모의 개념이라고 본다.)


    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child){
        children.add(child);
        child.setParent(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
