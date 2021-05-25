package hellojpa;

/*
 *
 * @author snow
 * @since 2021/05/25
 */
public class ValueMain {
    public static void main(String[] args) {
        Address address1 = new Address("cityp","street","111-222");
        // 참조값이 다르므로 다르다고 나옴.
        Address address2 = new Address("cityp","street","111-222");
        System.out.println(address1 == address2);
        System.out.println(address1.equals(address2));

    }
}
