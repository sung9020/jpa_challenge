package hellojpa;

import javax.naming.Name;
import javax.persistence.*;

/*
 *
 * @author snow
 * @since 2021/05/05
 */
@Entity
public class Locker {
    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

}
