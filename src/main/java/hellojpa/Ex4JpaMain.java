package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Ex4JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
            member.setUsername("kim");
            em.persist(member);
            List<Member> memberList  = em.createNativeQuery("select MEMBER_ID, city from MEMBER",
                    Member.class)
                    .getResultList();

            for (Member member1 : memberList) {
                System.out.println(member1);
            }

//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            Root<Member> m = query.from(Member.class);
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> memberList = em.createQuery(cq).getResultList();
//            for (Member member : memberList) {
//                System.out.println(member.getUsername());
//            }
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
