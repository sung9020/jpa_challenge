package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
            Team team1 = new Team();
            team1.setName("팀1");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("팀2");
            em.persist(team2);

//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(team1);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(team1);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(team2);
//            em.persist(member3);

            em.flush();
            em.clear();

            String query = "select t From Team t";
            // 즉시로딩 해버림.

            List<Team> result = em.createQuery(query, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();

//            System.out.println(result.size());
//            for (Team t: result){
//                System.out.println(t.getName() + " ");
//                for(Member m: t.getMembers()){
//                    System.out.println(m.getUsername());
//                }
//                //회원1, 팀a(sql),
//                //회원2, 팀a(1차캐시)
//                //회원3, 팀b(sql)
//            }

//            em.detach(refMember);
//            em.close();
//            System.out.println(refMember.getUsername());
//            System.out.println(emf.getPersistenceUnitUtil().isLoaded(refMember));
//            System.out.println(refMember.getClass());
//            Hibernate.initialize(refMember);
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println(findMember.getClass()); // member
//
//            System.out.println(refMember == findMember);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

}


