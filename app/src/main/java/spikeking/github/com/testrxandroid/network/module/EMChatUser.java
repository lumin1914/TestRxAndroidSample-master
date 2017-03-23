package spikeking.github.com.testrxandroid.network.module;

import java.io.Serializable;

/**
 * @author suzhuning
 * @date 2016/10/9.
 * Description:
 */
public class EMChatUser implements Serializable {

    private String createTime;
    //用户唯一标识
    private String userId;
    //环信的登录ID
    private String emId;
    //连接环信的登录密码
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
