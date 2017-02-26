package ctone.rap.component;

import ctone.rap.db.module.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/26.
 */
public class MessageComponent implements Component<Message> {

    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    public int delete(){
        return 0;
    }

    //发送
    public int send(){
        return 0;
    }
    //撤销
    public int undo(){
        return 0;
    }
    //已读
    public int read(){
        return 0;
    }

    @Override
    public Message load(long id) {
        return null;
    }

    @Override
    public List<Message> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
