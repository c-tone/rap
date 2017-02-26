package ctone.rap.db.module.plan;


import java.util.List;

/**
 * Created by ouyi on 2017/2/16.
 * 日程
 */
public class Schedule {
    private List<Station> stationList;
    private String description;

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
