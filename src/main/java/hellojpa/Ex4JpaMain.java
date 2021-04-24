package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 *
 * @author snow
 * @since 2021/04/24
 */
public class Ex4JpaMain {
    public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

    EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
        Member member = new Member();
        member.setId(103L);
        member.setUsername("김수수");
        member.setRoleType(RoleType.GUEST);
        em.persist(member);

        System.out.println("==================");

        transaction.commit();
    }catch(Exception e){
        transaction.rollback();
    }finally {
        em.close();
    }
    emf.close();
}
}
