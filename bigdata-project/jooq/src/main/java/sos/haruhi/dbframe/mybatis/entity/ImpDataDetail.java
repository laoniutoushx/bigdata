package sos.haruhi.dbframe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("imp_data_detail")
@ApiModel(value = "ImpDataDetail对象", description = "")
public class ImpDataDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dataId;

    private String impName;

    private String impValue;

    private String logsId;

    private String propId;

    private Integer rowIndex;

    private Integer validState;

    private String valueUnit;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
    public String getImpName() {
        return impName;
    }

    public void setImpName(String impName) {
        this.impName = impName;
    }
    public String getImpValue() {
        return impValue;
    }

    public void setImpValue(String impValue) {
        this.impValue = impValue;
    }
    public String getLogsId() {
        return logsId;
    }

    public void setLogsId(String logsId) {
        this.logsId = logsId;
    }
    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }
    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }
    public Integer getValidState() {
        return validState;
    }

    public void setValidState(Integer validState) {
        this.validState = validState;
    }
    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    @Override
    public String toString() {
        return "ImpDataDetail{" +
            "dataId=" + dataId +
            ", impName=" + impName +
            ", impValue=" + impValue +
            ", logsId=" + logsId +
            ", propId=" + propId +
            ", rowIndex=" + rowIndex +
            ", validState=" + validState +
            ", valueUnit=" + valueUnit +
        "}";
    }
}
