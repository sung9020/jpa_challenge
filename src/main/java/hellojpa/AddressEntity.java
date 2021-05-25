package hellojpa;

import javax.persistence.*;

/*
 *
 * @author snow
 * @since 2021/05/25
 */
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Address address;

    public  AddressEntity(){}

    public AddressEntity(String city, String street, String zipCode) {
        this.address = new Address(city,street, zipCode);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
