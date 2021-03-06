/*
 * This file is generated by jOOQ.
 */
package sos.haruhi.dbframe.jooq.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sos.haruhi.dbframe.jooq.tables.Users;
import sos.haruhi.dbframe.jooq.tables.records.UsersRecord;

import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class UsersDao extends DAOImpl<UsersRecord, sos.haruhi.dbframe.jooq.tables.pojos.Users, Integer> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, sos.haruhi.dbframe.jooq.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    @Autowired
    public UsersDao(Configuration configuration) {
        super(Users.USERS, sos.haruhi.dbframe.jooq.tables.pojos.Users.class, configuration);
    }

    @Override
    public Integer getId(sos.haruhi.dbframe.jooq.tables.pojos.Users object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Users.USERS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchById(Integer... values) {
        return fetch(Users.USERS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public sos.haruhi.dbframe.jooq.tables.pojos.Users fetchOneById(Integer value) {
        return fetchOne(Users.USERS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchByName(String... values) {
        return fetch(Users.USERS.NAME, values);
    }

    /**
     * Fetch records that have <code>age BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchRangeOfAge(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Users.USERS.AGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchByAge(Integer... values) {
        return fetch(Users.USERS.AGE, values);
    }

    /**
     * Fetch records that have <code>address BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchRangeOfAddress(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.ADDRESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    public List<sos.haruhi.dbframe.jooq.tables.pojos.Users> fetchByAddress(String... values) {
        return fetch(Users.USERS.ADDRESS, values);
    }
}
