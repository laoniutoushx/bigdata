/*
 * This file is generated by jOOQ.
 */
package sos.haruhi.dbframe.jooq.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IGatherReport extends Serializable {

    /**
     * Setter for <code>public.gather_report.id</code>.
     */
    public void setId(String value);

    /**
     * Getter for <code>public.gather_report.id</code>.
     */
    public String getId();

    /**
     * Setter for <code>public.gather_report.call_number</code>.
     */
    public void setCallNumber(Integer value);

    /**
     * Getter for <code>public.gather_report.call_number</code>.
     */
    public Integer getCallNumber();

    /**
     * Setter for <code>public.gather_report.data_code</code>.
     */
    public void setDataCode(String value);

    /**
     * Getter for <code>public.gather_report.data_code</code>.
     */
    public String getDataCode();

    /**
     * Setter for <code>public.gather_report.data_count</code>.
     */
    public void setDataCount(Long value);

    /**
     * Getter for <code>public.gather_report.data_count</code>.
     */
    public Long getDataCount();

    /**
     * Setter for <code>public.gather_report.data_name</code>.
     */
    public void setDataName(String value);

    /**
     * Getter for <code>public.gather_report.data_name</code>.
     */
    public String getDataName();

    /**
     * Setter for <code>public.gather_report.data_type</code>.
     */
    public void setDataType(String value);

    /**
     * Getter for <code>public.gather_report.data_type</code>.
     */
    public String getDataType();

    /**
     * Setter for <code>public.gather_report.device_id</code>.
     */
    public void setDeviceId(String value);

    /**
     * Getter for <code>public.gather_report.device_id</code>.
     */
    public String getDeviceId();

    /**
     * Setter for <code>public.gather_report.gather_cycle</code>.
     */
    public void setGatherCycle(Integer value);

    /**
     * Getter for <code>public.gather_report.gather_cycle</code>.
     */
    public Integer getGatherCycle();

    /**
     * Setter for <code>public.gather_report.gather_ip</code>.
     */
    public void setGatherIp(String value);

    /**
     * Getter for <code>public.gather_report.gather_ip</code>.
     */
    public String getGatherIp();

    /**
     * Setter for <code>public.gather_report.last_time</code>.
     */
    public void setLastTime(LocalDateTime value);

    /**
     * Getter for <code>public.gather_report.last_time</code>.
     */
    public LocalDateTime getLastTime();

    /**
     * Setter for <code>public.gather_report.next_time</code>.
     */
    public void setNextTime(LocalDateTime value);

    /**
     * Getter for <code>public.gather_report.next_time</code>.
     */
    public LocalDateTime getNextTime();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IGatherReport
     */
    public void from(IGatherReport from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IGatherReport
     */
    public <E extends IGatherReport> E into(E into);
}
