package spikeking.github.com.testrxandroid.network.module;

/**
 * Created by lumin on 16-8-22.
 */
public enum UserCareerRoleEnum {

    FOUNDER("创始人"),
    PARTNER("合伙人"),
    EMPLOYEE("员工");

    private String name;
    UserCareerRoleEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
