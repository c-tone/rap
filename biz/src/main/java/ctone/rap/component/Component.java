package ctone.rap.component;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/26.
 */
public interface Component<T> {

    T load(long id);

    List<T> list(Map<String,Object> conditions);

    int count(Map<String,Object> conditions);


}
