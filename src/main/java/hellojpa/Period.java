package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/*
 *
 * @author snow
 * @since 2021/05/23
 */
@Embeddable
public class Period {


    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period() {

    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
