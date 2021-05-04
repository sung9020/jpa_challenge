package hellojpa;

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
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "team") // 하위 엔티티에 team 필드와 매핑됩니다.
    private List<Member> members = new ArrayList<>();


    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
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

    @Override
    public String toString() {
        return "Team{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
