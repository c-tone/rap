package ctone.rap.component;

import ctone.rap.db.module.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/22.
 */
public class ArticleComponent implements Component<Article> {
    public long draft(){return 0;}

    public int publish(){return 0;}

    public int cancle(long id){return 0;}

    public List<Article> listDraft(){return null;}

    public List<Article> listPublish(){return null;}

    public int countDratf(){return 0;}

    public int countPublish(){return 0;}

    @Override
    public Article load(long id){return null;}

    @Override
    public List<Article> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }

}
