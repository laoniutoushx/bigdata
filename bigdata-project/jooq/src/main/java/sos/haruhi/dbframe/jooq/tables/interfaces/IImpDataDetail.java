/*
 * This file is generated by jOOQ.
 */
package sos.haruhi.dbframe.jooq.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IImpDataDetail extends Serializable {

    /**
     * Setter for <code>public.imp_data_detail.data_id</code>.
     */
    public void setDataId(String value);

    /**
     * Getter for <code>public.imp_data_detail.data_id</code>.
     */
    public String getDataId();

    /**
     * Setter for <code>public.imp_data_detail.imp_name</code>.
     */
    public void setImpName(String value);

    /**
     * Getter for <code>public.imp_data_detail.imp_name</code>.
     */
    public String getImpName();

    /**
     * Setter for <code>public.imp_data_detail.imp_value</code>.
     */
    public void setImpValue(String value);

    /**
     * Getter for <code>public.imp_data_detail.imp_value</code>.
     */
    public String getImpValue();

    /**
     * Setter for <code>public.imp_data_detail.logs_id</code>.
     */
    public void setLogsId(String value);

    /**
     * Getter for <code>public.imp_data_detail.logs_id</code>.
     */
    public String getLogsId();

    /**
     * Setter for <code>public.imp_data_detail.prop_id</code>.
     */
    public void setPropId(String value);

    /**
     * Getter for <code>public.imp_data_detail.prop_id</code>.
     */
    public String getPropId();

    /**
     * Setter for <code>public.imp_data_detail.row_index</code>.
     */
    public void setRowIndex(Integer value);

    /**
     * Getter for <code>public.imp_data_detail.row_index</code>.
     */
    public Integer getRowIndex();

    /**
     * Setter for <code>public.imp_data_detail.valid_state</code>.
     */
    public void setValidState(Short value);

    /**
     * Getter for <code>public.imp_data_detail.valid_state</code>.
     */
    public Short getValidState();

    /**
     * Setter for <code>public.imp_data_detail.value_unit</code>.
     */
    public void setValueUnit(String value);

    /**
     * Getter for <code>public.imp_data_detail.value_unit</code>.
     */
    public String getValueUnit();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IImpDataDetail
     */
    public void from(IImpDataDetail from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IImpDataDetail
     */
    public <E extends IImpDataDetail> E into(E into);
}