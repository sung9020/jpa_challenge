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
public class Ex3JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
//            Member member = new Member(null, "강");
//            em.persist(member);
//            em.flush(); // 플러시를 하더라도 1차 캐시는 남아있음.

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent); // 자식의 생명주기를 부모가 컨트롤함

            em.flush();
            em.clear();

            System.out.println("==================");

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildren().remove(0);
            //em.remove(findParent);

            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
