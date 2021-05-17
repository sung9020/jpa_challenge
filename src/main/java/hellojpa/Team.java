package hellojpa;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author snow
 * @since 2021/04/30
 */
@Entity
public class Team extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long Id;
    private String name;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team") // 하위 엔티티에 team 필드와 매핑됩니다.
    private List<Member> members = new ArrayList<>();
        //객체그래프 사상에서 team의 멤버를 조회했을 멤버가 전체 다 나와야함 짤리면 사상에 어긋나고 혼돈이 온다.

//    @OneToMany // 하위 엔티티에 team 필드와 매핑됩니다.
//    @JoinColumn(name = "team")
//    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
