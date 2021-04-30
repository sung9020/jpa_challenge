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
            Team team = new Team();
            team.setName("소속팀");
            em.persist(team); // 영속상태가 되어 id가 들어간다

            Member member = new Member();
            member.setUsername("멤버");
            member.setTeam(team);
            em.persist(member);

            em.flush(); // db에 준비된 쿼리를 날려서 사전 동기화 시킨다.
            em.clear(); // 영속성 컨텍스트의 1차 캐시를 삭제한다. 

            Member findMember = em.find(Member.class, member.getId()); // 영속상태가 되엇기 때문에 추가 쿼리가 필요없다.
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}


