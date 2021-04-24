package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Member")
@Table(name = "Member")
public class Member {
    @Id
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default '김씨'")
    private String username;

    @Column(precision = 5)
    private BigDecimal age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)  // db에서 구분하는 시간 타입
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar 를 넘어서는 큰 컨텐츠
    private String description;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Transient
    private int temp;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Member(){}

    public Member(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAge() {
        return age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

}
