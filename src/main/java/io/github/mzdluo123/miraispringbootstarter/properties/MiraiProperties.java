package io.github.mzdluo123.miraispringbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("mirai")
@Validated
public class MiraiProperties {
    @NotNull
    private Boolean enableNetLog = true;
    @NotNull
    private String workingDir = ".";
    @NotNull
    private Long uid;
    @NotNull
    private String password;
    @NotNull
    private String deviceConfig="device.json";

    @NotNull
    private String protocol = "ANDROID_PAD";

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceConfig() {
        return deviceConfig;
    }

    public void setDeviceConfig(String deviceConfig) {
        this.deviceConfig = deviceConfig;
    }


    public Boolean getEnableNetLog() {
        return enableNetLog;
    }

    public void setEnableNetLog(Boolean enableNetLog) {
        this.enableNetLog = enableNetLog;
    }


    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
