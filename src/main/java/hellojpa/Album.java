package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 *
 * @author snow
 * @since 2021/05/16
 */
@Entity
@DiscriminatorValue("A")
public class Album extends  Item {
    private String artist;
}
