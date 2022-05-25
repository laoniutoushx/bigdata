/*
 * This file is generated by jOOQ.
 */
package sos.haruhi.dbframe.jooq.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sos.haruhi.dbframe.jooq.tables.ImpDataDetail;
import sos.haruhi.dbframe.jooq.tables.records.ImpDataDetailRecord;

import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ImpDataDetailDao extends DAOImpl<ImpDataDetailRecord, sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail, String> {

    /**
     * Create a new ImpDataDetailDao without any configuration
     */
    public ImpDataDetailDao() {
        super(ImpDataDetail.IMP_DATA_DETAIL, sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail.class);
    }

    /**
     * Create a new ImpDataDetailDao with an attached configuration
     */
    @Autowired
    public ImpDataDetailDao(Configuration configuration) {
        super(ImpDataDetail.IMP_DATA_DETAIL, sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail.class, configuration);
    }

    @Override
    public String getId(sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail object) {
        return object.getDataId();
    }

    /**
     * Fetch records that have <code>data_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfDataId(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.DATA_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>data_id IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByDataId(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.DATA_ID, values);
    }

    /**
     * Fetch a unique record that has <code>data_id = value</code>
     */
    public sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail fetchOneByDataId(String value) {
        return fetchOne(ImpDataDetail.IMP_DATA_DETAIL.DATA_ID, value);
    }

    /**
     * Fetch records that have <code>imp_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfImpName(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.IMP_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>imp_name IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByImpName(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.IMP_NAME, values);
    }

    /**
     * Fetch records that have <code>imp_value BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfImpValue(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.IMP_VALUE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>imp_value IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByImpValue(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.IMP_VALUE, values);
    }

    /**
     * Fetch records that have <code>logs_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfLogsId(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.LOGS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>logs_id IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByLogsId(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.LOGS_ID, values);
    }

    /**
     * Fetch records that have <code>prop_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfPropId(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.PROP_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>prop_id IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByPropId(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.PROP_ID, values);
    }

    /**
     * Fetch records that have <code>row_index BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfRowIndex(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.ROW_INDEX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>row_index IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByRowIndex(Integer... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.ROW_INDEX, values);
    }

    /**
     * Fetch records that have <code>valid_state BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfValidState(Short lowerInclusive, Short upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.VALID_STATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>valid_state IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByValidState(Short... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.VALID_STATE, values);
    }

    /**
     * Fetch records that have <code>value_unit BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchRangeOfValueUnit(String lowerInclusive, String upperInclusive) {
        return fetchRange(ImpDataDetail.IMP_DATA_DETAIL.VALUE_UNIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>value_unit IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.ImpDataDetail> fetchByValueUnit(String... values) {
        return fetch(ImpDataDetail.IMP_DATA_DETAIL.VALUE_UNIT, values);
    }
}