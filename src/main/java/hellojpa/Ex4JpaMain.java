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

        Member member1 = new Member();

        Member member2 = new Member();

        System.out.println("==================");

        em.persist(member); // 1, 51
        em.persist(member1); // 2, 51
        em.persist(member2); // 3, 51
        // 어쩔수 없이 쿼리를 날려서 1차 캐시를 만든다.
//        System.out.println(member.getId());
//        System.out.println(member1.getId());
//        System.out.println(member2.getId());
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
