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
@TableName("define_equip_type")
@ApiModel(value = "DefineEquipType对象", description = "")
public class DefineEquipType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String typeId;

    private String cateCode;

    private String cateName;

    private String typeCode;

    private String typeDesc;

    private String typeGroup;

    private String typeIcon;

    private String typeMajor;

    private String typeName;

    private String versionCode;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
    public String getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }
    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }
    public String getTypeMajor() {
        return typeMajor;
    }

    public void setTypeMajor(String typeMajor) {
        this.typeMajor = typeMajor;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    @Override
    public String toString() {
        return "DefineEquipType{" +
            "typeId=" + typeId +
            ", cateCode=" + cateCode +
            ", cateName=" + cateName +
            ", typeCode=" + typeCode +
            ", typeDesc=" + typeDesc +
            ", typeGroup=" + typeGroup +
            ", typeIcon=" + typeIcon +
            ", typeMajor=" + typeMajor +
            ", typeName=" + typeName +
            ", versionCode=" + versionCode +
        "}";
    }
}
