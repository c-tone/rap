package ctone.rap.component;

import ctone.rap.db.module.Comment;

import java.util.List;

/**
 * Created by ouyi on 2017/2/26.
 */
public class CommentComponent {
    public long add(){
        return 0;
    }
    public int edit(){
        return 0;
    }
    //删除下挂的回复
    public int delete(){
        return 0;
    }

    public long addReply(){
        return 0;
    }
    public int editReply(){
        return 0;
    }
    public int deleteReply(){
        return 0;
    }

    public List<Comment> listComment(){
        return null;
    }

    public int countComment(){
        return 0;
    }

    public Comment load(){
        return null;
    }
}
