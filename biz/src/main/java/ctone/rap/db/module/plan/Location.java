package ctone.rap.db.module.plan;

/**
 * Created by ouyi on 2017/2/17.
 * 地理位置
 */
public class Location {
    private String country;
    private String area;//省份 州 独立区域
    private String city;
    private String address;
    private String description;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return country+"."+area+"."+city+"."+address;
    }
}
