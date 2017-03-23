package spikeking.github.com.testrxandroid.network.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lumin on 16-4-25.
 */
public class UserInfo implements Serializable {

    private String userId;
    private String nickName;
    private String realName;
    private boolean signedInvestorAgreement;
    private boolean certifiedRealName;
    private boolean mobileVerified;
    private boolean emailVerified;
    private String mobile;
    private String email;
    private String qq;
    private String weixin;
    private String weiboUrl;
    private String linkedinUrl;
    private String siteUrl;
    private String country;
    private String province;
    private String city;
    private String district;
    private String avatarURL;
    private String shorDesc;
    private String description;
    private String shareURL;
    private String weixinUnionId;
    private List<String> userRoleList;
    //0 创业者，1、2投资人
    private String defaultpart;

    private EMChatUser emChatInfo;
    private String investorAuthPassTime;
    private List<UserEduInfo> eduInfos;
    private List<UserCareerInfo> careerInfos;


    public String getDefaultpart() {
        return defaultpart;
    }

    public void setDefaultpart(String defaultpart) {
        this.defaultpart = defaultpart;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isSignedInvestorAgreement() {
        return signedInvestorAgreement;
    }

    public void setSignedInvestorAgreement(boolean signedInvestorAgreement) {
        this.signedInvestorAgreement = signedInvestorAgreement;
    }

    public boolean isCertifiedRealName() {
        return certifiedRealName;
    }

    public void setCertifiedRealName(boolean certifiedRealName) {
        this.certifiedRealName = certifiedRealName;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeiboUrl() {
        return weiboUrl;
    }

    public void setWeiboUrl(String weiboUrl) {
        this.weiboUrl = weiboUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getShorDesc() {
        return shorDesc;
    }

    public void setShorDesc(String shorDesc) {
        this.shorDesc = shorDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public List<String> getUserRoleList() {
        return userRoleList;
    }

    public String getWeixinUnionId() {
        return weixinUnionId;
    }

    public void setWeixinUnionId(String weixinUnionId) {
        this.weixinUnionId = weixinUnionId;
    }

    public EMChatUser getEmChatInfo() {
        return emChatInfo;
    }

    public void setEmChatInfo(EMChatUser emChatInfo) {
        this.emChatInfo = emChatInfo;
    }

    public String getInvestorAuthPassTime() {
        return investorAuthPassTime;
    }

    public void setInvestorAuthPassTime(String investorAuthPassTime) {
        this.investorAuthPassTime = investorAuthPassTime;
    }

    public List<UserEduInfo> getEduInfos() {
        return eduInfos;
    }

    public void setEduInfos(List<UserEduInfo> eduInfos) {
        this.eduInfos = eduInfos;
    }

    public List<UserCareerInfo> getCareerInfos() {
        return careerInfos;
    }

    public void setCareerInfos(List<UserCareerInfo> careerInfos) {
        this.careerInfos = careerInfos;
    }

    public void setUserRoleList(List<String> userRoleList) {
        defaultpart = 0+"";
        if(userRoleList!= null){
            for(String part : userRoleList){
                if(part.equals("INVESTOR")){
                    defaultpart = 1+"";
                    break;
                }
            }
        }

        this.userRoleList = userRoleList;
    }

    public boolean isInvestor(){
        return userRoleList != null && userRoleList.contains("INVESTOR");
    }

}
