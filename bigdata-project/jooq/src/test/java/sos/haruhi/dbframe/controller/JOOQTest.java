package sos.haruhi.dbframe.controller;

import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sos.haruhi.dbframe.jooq.tables.DefineEquipType;
import sos.haruhi.dbframe.jooq.tables.ImpDataDetail;
import sos.haruhi.dbframe.jooq.tables.daos.UsersDao;
import sos.haruhi.dbframe.jooq.tables.pojos.Users;

import java.util.Objects;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class JOOQTest {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private UsersDao usersDao;

    private final String get_user_sql = "select id,name,age,address from users where id = ?";

    private final String complex_sql = "SELECT " +
            " eq.type_id, " +
            " tt.tagNo, " +
            " tt.equipName, " +
            " tt.rowIndex  " +
            "FROM " +
            " define_equip_type eq " +
            "INNER JOIN (SELECT " +
            " ttt.tagNo, " +
            " ttt.equipType, " +
            " t3.imp_value AS equipName, " +
            " ttt.row_index AS rowIndex  " +
            "FROM ( " +
            "SELECT " +
            " t1.imp_value tagNo, " +
            " t2.imp_value equipType, " +
            " t1.row_index, " +
            " t1.logs_id  " +
            "FROM " +
            " imp_data_detail t1 " +
            " INNER JOIN imp_data_detail t2 ON t1.row_index = t2.row_index  " +
            " AND t1.logs_id = t2.logs_id  " +
            "WHERE " +
            " t1.prop_id = 'tagNo'  " +
            " AND t2.prop_id = 'equipType'  " +
            " ) ttt " +
            " INNER JOIN imp_data_detail t3 ON ttt.row_index = t3.row_index  " +
            " AND t3.prop_id = 'equipName'  " +
            " AND t3.logs_id = ttt.logs_id  " +
            " AND t3.logs_id = ? " +
            " ) tt ON eq.type_name = tt.equipType";

    /**
     * crud
     */
    @Test
    void jooqCrud() {
        Users users = new Users(5, "luoluo", 5, "nanjing");
        usersDao.insert(users);
        users.setName("zhang");
        usersDao.update(users);
        usersDao.delete(users);
    }

    /**
     * jooq 常规查询
     */
    @Test
    void jooqSimpleQuery() {
        Result<Record> recordResult = dsl.select().from(sos.haruhi.dbframe.jooq.tables.Users.USERS).fetch();
        for (Record record : recordResult) {
            log.info(record.toString());
        }
    }

    /**
     * jooq 多表关联常规查询
     */
    @Test
    void jooqComplexQueryResultGraceful() {
        ImpDataDetail t1 = ImpDataDetail.IMP_DATA_DETAIL.as("t1");
        ImpDataDetail t2 = ImpDataDetail.IMP_DATA_DETAIL.as("t2");

        Result<Record4<String, String, Integer, String>> fetchResult = dsl.select(t1.IMP_VALUE.as("tagNo"), t2.IMP_VALUE.as("equipType"), t1.ROW_INDEX, t1.LOGS_ID)
                .from(t1)
                .innerJoin(t2).on(t1.ROW_INDEX.eq(t2.ROW_INDEX).and(t1.LOGS_ID.eq(t2.LOGS_ID)))
                .fetch();

        for (Record4<String, String, Integer, String> stringStringIntegerStringRecord4 : fetchResult) {
            log.info(stringStringIntegerStringRecord4.toString());
        }
    }

    /**
     * jooq 多表关联复杂查询
     */
    @Test
    void jooqComplex1QueryResultGraceful() {
        String logs_id = "402885eb7ddbc98d017ddbcfeb250b39";

        DefineEquipType eq = DefineEquipType.DEFINE_EQUIP_TYPE.as("eq");
        ImpDataDetail t1 = ImpDataDetail.IMP_DATA_DETAIL.as("t1");
        ImpDataDetail t2 = ImpDataDetail.IMP_DATA_DETAIL.as("t2");
        ImpDataDetail t3 = ImpDataDetail.IMP_DATA_DETAIL.as("t3");

        Table<Record4<String, String, Integer, String>> ttt = dsl.select(t1.IMP_VALUE.as("tagNo"), t2.IMP_VALUE.as("equipType"), t1.ROW_INDEX, t1.LOGS_ID)
                .from(t1)
                .innerJoin(t2).on(t1.ROW_INDEX.eq(t2.ROW_INDEX).and(t1.LOGS_ID.eq(t2.LOGS_ID)))
                .where(t1.PROP_ID.eq("tagNo")).and(t2.PROP_ID.eq("equipType"))
                .asTable("ttt");

        Table<? extends Record4<?, ?, String, ?>> tt = dsl.select(ttt.field("tagNo"), ttt.field("equipType"), t3.IMP_VALUE.as("equipName"), ttt.field("row_index").as("rowIndex"))
                .from(ttt)
                .innerJoin(t3).on(ttt.field("row_index", Integer.class).eq(t3.ROW_INDEX).and(t3.PROP_ID.eq("equipName"))
                        .and(t3.LOGS_ID.eq(ttt.field("logs_id", String.class)))
                        .and(t3.LOGS_ID.eq(logs_id)))
                .asTable("tt");

        String sql = dsl.select(eq.TYPE_ID, tt.field("tagNo"), tt.field("equipName"), tt.field("rowIndex"))
                .from(eq)
                .innerJoin(tt).on(eq.TYPE_NAME.eq(tt.field("equipType", String.class)))
                .getSQL();

        log.info(sql);

        Result<? extends Record4<String, ?, ?, ?>> result = dsl.select(eq.TYPE_ID, tt.field("tagNo"), tt.field("equipName"), tt.field("rowIndex"))
                .from(eq)
                .innerJoin(tt).on(eq.TYPE_NAME.eq(tt.field("equipType", String.class)))
                .fetch();

        for (Record4<String, ?, ?, ?> stringRecord4 : result) {
            log.info(stringRecord4.toString());
        }
    }

}