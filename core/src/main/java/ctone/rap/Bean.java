package ctone.rap;

/**
 * Created by ouyi on 16/9/26.
 */
public class Bean {
    private String ip;
    private String user;
    private String type;
    private String client;//browser smartPhone
    private String method;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", client='" + client + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
