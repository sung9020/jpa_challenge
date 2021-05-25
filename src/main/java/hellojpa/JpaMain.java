package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1", "street","11-11"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("오이");

            member.getAddressHistory().add(new AddressEntity("old1", "old1","11-11"));
            member.getAddressHistory().add(new AddressEntity("old2", "old2","11-11"));

            em.persist(member);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
//            findMember.setHomeAddress(new Address("newCity", findMember.getHomeAddress().getStreet(),findMember.getHomeAddress().getZipCode()));
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new Address("old1", "old1","11-11"));
//            findMember.getAddressHistory().add(new Address("newCity1", "new1","11-12"));

            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
