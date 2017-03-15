package ctone.rap.component;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import ctone.rap.constant.Status;
import ctone.rap.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by ouyi on 2017/2/2.
 */
public class QiniuHelper {
    private static final Logger logger = LoggerFactory.getLogger(QiniuHelper.class);
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String ACCESS_KEY = "GoPiPdqzgBbhkrvjnDSc8-9gM7GSNZScQrEWdigi";
    private static final String SECRET_KEY = "T3cWniByRpUL9MrvJ_bTmzyu3tnEjDAchQIk1dAC";
    //密钥配置
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //要上传的空间
    //private static final String bucketname = "ctone";

    //upToken
    public static String getUpToken(String bucketName, String fileName) {
        return auth.uploadToken(bucketName, fileName);
    }

    /**
     * 上传文件到七牛云，支持断点续传
     *
     * @param breakpointDirectory 断点续传目录
     * @param zone                存储区域 华东 华北
     * @param bucketName          存储空间
     * @param filePath            存储路径
     * @param fileName            存储文件名
     * @param override            是否覆盖
     */
    public static Result upload(String breakpointDirectory, Zone zone, String bucketName, String filePath, String fileName, boolean override) {
        Result result = new Result();
        try {
            //创建上传对象
            Recorder recorder = new FileRecorder(breakpointDirectory);
            Configuration configuration = new Configuration(zone);
            UploadManager uploadManager = new UploadManager(configuration, recorder);
            //调用put方法上传
            Response response = uploadManager.put(filePath, fileName, getUpToken(bucketName, override ? fileName : null));
            result.setStatus(response.isOK(), response.statusCode, response.error);
            result.setData(response.bodyString());
        } catch (QiniuException e) {
            result.setStatus(false, e.code(), e.error());
            logger.error("upload error", e);
        } catch (IOException e) {
            result.setStatus(Status.FAIL);
            result.setMessage(e.getMessage());
            logger.error("upload error", e);
        }
        return result;
    }

    /**
     * 从七牛云下载，生成下载链接
     *
     * @param url 文件路径
     */
    public static Result download(String url){
        String downloadUrl = auth.privateDownloadUrl(url);
        Result result = new Result();
        result.setStatus(Status.SUCCESS);
        result.setData(downloadUrl);
        return result;
    }


}
