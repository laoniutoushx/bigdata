/*
 * This file is generated by jOOQ.
 */
package sos.haruhi.dbframe.jooq.tables.pojos;


import sos.haruhi.dbframe.jooq.tables.interfaces.IImpDataDetail;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ImpDataDetail implements IImpDataDetail {

    private static final long serialVersionUID = 1L;

    private String  dataId;
    private String  impName;
    private String  impValue;
    private String  logsId;
    private String  propId;
    private Integer rowIndex;
    private Short   validState;
    private String  valueUnit;

    public ImpDataDetail() {}

    public ImpDataDetail(IImpDataDetail value) {
        this.dataId = value.getDataId();
        this.impName = value.getImpName();
        this.impValue = value.getImpValue();
        this.logsId = value.getLogsId();
        this.propId = value.getPropId();
        this.rowIndex = value.getRowIndex();
        this.validState = value.getValidState();
        this.valueUnit = value.getValueUnit();
    }

    public ImpDataDetail(
        String  dataId,
        String  impName,
        String  impValue,
        String  logsId,
        String  propId,
        Integer rowIndex,
        Short   validState,
        String  valueUnit
    ) {
        this.dataId = dataId;
        this.impName = impName;
        this.impValue = impValue;
        this.logsId = logsId;
        this.propId = propId;
        this.rowIndex = rowIndex;
        this.validState = validState;
        this.valueUnit = valueUnit;
    }

    /**
     * Getter for <code>public.imp_data_detail.data_id</code>.
     */
    @Override
    public String getDataId() {
        return this.dataId;
    }

    /**
     * Setter for <code>public.imp_data_detail.data_id</code>.
     */
    @Override
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * Getter for <code>public.imp_data_detail.imp_name</code>.
     */
    @Override
    public String getImpName() {
        return this.impName;
    }

    /**
     * Setter for <code>public.imp_data_detail.imp_name</code>.
     */
    @Override
    public void setImpName(String impName) {
        this.impName = impName;
    }

    /**
     * Getter for <code>public.imp_data_detail.imp_value</code>.
     */
    @Override
    public String getImpValue() {
        return this.impValue;
    }

    /**
     * Setter for <code>public.imp_data_detail.imp_value</code>.
     */
    @Override
    public void setImpValue(String impValue) {
        this.impValue = impValue;
    }

    /**
     * Getter for <code>public.imp_data_detail.logs_id</code>.
     */
    @Override
    public String getLogsId() {
        return this.logsId;
    }

    /**
     * Setter for <code>public.imp_data_detail.logs_id</code>.
     */
    @Override
    public void setLogsId(String logsId) {
        this.logsId = logsId;
    }

    /**
     * Getter for <code>public.imp_data_detail.prop_id</code>.
     */
    @Override
    public String getPropId() {
        return this.propId;
    }

    /**
     * Setter for <code>public.imp_data_detail.prop_id</code>.
     */
    @Override
    public void setPropId(String propId) {
        this.propId = propId;
    }

    /**
     * Getter for <code>public.imp_data_detail.row_index</code>.
     */
    @Override
    public Integer getRowIndex() {
        return this.rowIndex;
    }

    /**
     * Setter for <code>public.imp_data_detail.row_index</code>.
     */
    @Override
    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    /**
     * Getter for <code>public.imp_data_detail.valid_state</code>.
     */
    @Override
    public Short getValidState() {
        return this.validState;
    }

    /**
     * Setter for <code>public.imp_data_detail.valid_state</code>.
     */
    @Override
    public void setValidState(Short validState) {
        this.validState = validState;
    }

    /**
     * Getter for <code>public.imp_data_detail.value_unit</code>.
     */
    @Override
    public String getValueUnit() {
        return this.valueUnit;
    }

    /**
     * Setter for <code>public.imp_data_detail.value_unit</code>.
     */
    @Override
    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ImpDataDetail (");

        sb.append(dataId);
        sb.append(", ").append(impName);
        sb.append(", ").append(impValue);
        sb.append(", ").append(logsId);
        sb.append(", ").append(propId);
        sb.append(", ").append(rowIndex);
        sb.append(", ").append(validState);
        sb.append(", ").append(valueUnit);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IImpDataDetail from) {
        setDataId(from.getDataId());
        setImpName(from.getImpName());
        setImpValue(from.getImpValue());
        setLogsId(from.getLogsId());
        setPropId(from.getPropId());
        setRowIndex(from.getRowIndex());
        setValidState(from.getValidState());
        setValueUnit(from.getValueUnit());
    }

    @Override
    public <E extends IImpDataDetail> E into(E into) {
        into.from(this);
        return into;
    }
}
