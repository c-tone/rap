package ctone.rap.db.module.plan;

import ctone.rap.db.domain.BOM;
import ctone.rap.db.module.Group;

/**
 * Created by ouyi on 2017/2/16.
 * 站点，旅游点，途中一站
 */
public class Station extends BOM {
    private int status;
    private String name;
    private String detail;
    private Location location;//位置
    private SETime seTime;//游览时间
    private Budget budget;//预算
    private Group group;//组队
    private boolean groupSwitchOpen;//招募是否开启

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SETime getSeTime() {
        return seTime;
    }

    public void setSeTime(SETime seTime) {
        this.seTime = seTime;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isGroupSwitchOpen() {
        return groupSwitchOpen;
    }

    public void setGroupSwitchOpen(boolean groupSwitchOpen) {
        this.groupSwitchOpen = groupSwitchOpen;
    }

    public boolean isRecruited() {
        if (groupSwitchOpen && group.getLeaving()>0){
            return true;
        }
        return false;
    }

}
