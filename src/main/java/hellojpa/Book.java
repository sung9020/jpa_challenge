package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 *
 * @author snow
 * @since 2021/05/16
 */
@Entity
@DiscriminatorValue("I")
public class Book extends Item {
    private String author;
    private String isbm;
}
