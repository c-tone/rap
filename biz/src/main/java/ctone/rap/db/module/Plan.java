package ctone.rap.db.module;

import ctone.rap.db.domain.BOM;
import ctone.rap.db.module.plan.Schedule;

/**
 * Created by ouyi on 2017/2/15.
 * 计划
 */
public class Plan extends BOM {
    private int status;
    //名称
    private String name;
    //发布人/负责人
    private String owner;
    //日程安排
    private Schedule schedule;
    //备注
    private String remark;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
