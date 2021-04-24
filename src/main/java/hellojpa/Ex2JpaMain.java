package hellojpa;

import javax.persistence.*;

/*
 *
 * @author snow
 * @since 2021/04/24
 */
public class Ex2JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member3 = em.find(Member.class, 150L);
            member3.setName("AAAA");

            // em.detach(member3); // 준영속 상태로 만듬.
            em.clear(); // 영속성 컨텍스트 초기화

            Member member4 = em.find(Member.class, 150L);
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


