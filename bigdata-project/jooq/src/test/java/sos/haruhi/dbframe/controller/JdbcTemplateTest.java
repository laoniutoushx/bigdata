package sos.haruhi.dbframe.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import sos.haruhi.dbframe.domain.EquipInfo;
import sos.haruhi.dbframe.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class JdbcTemplateTest {

    @Autowired
    @Qualifier("jdbc_pgsql")
    private JdbcTemplate jdbcTemplate;

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
    void jdbcCrud() {
        jdbcTemplate.update("insert into users (id,name,age,address) values (?,?,?,?);", 5, "liu", 22, "china");
        jdbcTemplate.update("update users set name=?,age=?,address=? where id=?", "liu01", 23, "japan", 5);
        jdbcTemplate.update("delete from users where id=?", 5);
    }

    /**
     * jdbc 简单查询，相应实体手动封装
     */
    @Test
    void jdbcSimpleQueryResultNormal() {
        User user = jdbcTemplate.queryForObject(get_user_sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return User.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .address(rs.getString("address"))
                        .build();
            }
        }, 1);

        log.info(user.toString());
        Assert.assertNotNull(user);
    }

    /**
     * jdbc 复杂查询，相应实体自动封装
     * 自动封装原则（实体属性符合  sql 字段 驼峰或   _ 方式
     */
    @Test
    void jdbcComplexQueryResultGraceful() {
        // 对象查询
        EquipInfo equipInfo = jdbcTemplate.queryForObject(complex_sql, new BeanPropertyRowMapper<>(EquipInfo.class), "402885eb7ddbc98d017ddbcfeb250b39");
        log.info(equipInfo.toString());
        // EquipInfo(type_id=8af4ac737d93aefe017d9a3e625201c4, tagNo=11-C-1010, equipName=裂解炉引风机, rowIndex=1)
        Assert.assertNotNull(equipInfo);

        // 列表查询
        List<EquipInfo> equipInfos = jdbcTemplate.query(complex_sql, new BeanPropertyRowMapper<>(EquipInfo.class), "402885eb7ddbc98d017ddbcfeb250b39");
        Assert.assertTrue(equipInfos.size() > 0);
        log.info(equipInfos.toString());
    }


}
