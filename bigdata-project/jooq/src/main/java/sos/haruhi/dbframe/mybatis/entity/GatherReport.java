package sos.haruhi.dbframe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author shx
 * @since 2022-03-22
 */
@TableName("gather_report")
@ApiModel(value = "GatherReport对象", description = "")
public class GatherReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer callNumber;

    private String dataCode;

    private Long dataCount;

    private String dataName;

    private String dataType;

    private String deviceId;

    private Integer gatherCycle;

    private String gatherIp;

    private LocalDateTime lastTime;

    private LocalDateTime nextTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Integer getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(Integer callNumber) {
        this.callNumber = callNumber;
    }
    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }
    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }
    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public Integer getGatherCycle() {
        return gatherCycle;
    }

    public void setGatherCycle(Integer gatherCycle) {
        this.gatherCycle = gatherCycle;
    }
    public String getGatherIp() {
        return gatherIp;
    }

    public void setGatherIp(String gatherIp) {
        this.gatherIp = gatherIp;
    }
    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }
    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    @Override
    public String toString() {
        return "GatherReport{" +
            "id=" + id +
            ", callNumber=" + callNumber +
            ", dataCode=" + dataCode +
            ", dataCount=" + dataCount +
            ", dataName=" + dataName +
            ", dataType=" + dataType +
            ", deviceId=" + deviceId +
            ", gatherCycle=" + gatherCycle +
            ", gatherIp=" + gatherIp +
            ", lastTime=" + lastTime +
            ", nextTime=" + nextTime +
        "}";
    }
}
