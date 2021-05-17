package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
//            Member member1 = em.find(Member.class, 101L); // 영속성 컨텍스트에 올려둠
//            Member member2 = em.find(Member.class, 101L);
//            System.out.println("result=" + (member1 == member2));
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
