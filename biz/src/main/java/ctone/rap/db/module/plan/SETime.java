package ctone.rap.db.module.plan;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by ouyi on 2017/2/16.
 * 起始时间
 */
public class SETime {
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    //todo
    public long getDuration(TimeUnit timeUnit){
        if (timeUnit == null){
            timeUnit = MILLISECONDS;
        }
        long duration = endTime.getTime()-startTime.getTime();
        switch (timeUnit){
            case DAYS:
                return MILLISECONDS.toDays(duration);
            case HOURS:
                return MILLISECONDS.toHours(duration);
            case MINUTES:
                return MILLISECONDS.toMinutes(duration);
            case SECONDS:
                return MILLISECONDS.toSeconds(duration);
            default:return duration;
        }
    }
}
