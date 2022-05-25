package sos.haruhi.dbframe.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sos.haruhi.dbframe.dto.ImpDataDetail01Dto;
import sos.haruhi.dbframe.dto.ImpDataDetailDto;
import sos.haruhi.dbframe.mybatis.entity.Users;
import sos.haruhi.dbframe.mybatis.mapper.ImpDataDetailMapper;
import sos.haruhi.dbframe.mybatis.service.IUsersService;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusTest {

    @Autowired
    private ImpDataDetailMapper impDataDetailMapper;

    @Autowired
    private IUsersService usersService;

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
    void myBatisPlusCrud() {
        Users users = new Users();
        users.setId(6);
        users.setName("pika");
        users.setAddress("russia");
        users.setAge(76);
        usersService.save(users);
        users.setName("pppkkk");
        usersService.saveOrUpdate(users);
    }

    /**
     * 简单查询
     */
    @Test
    void myBatisPlusSimpleQuery() {
        List<Users> users = usersService.list();
        for (Users user : users) {
            log.info(user.toString());
        }
    }

    /**
     * 多表查询需要构建 Dto，手动编写sql
     * @Select("select t1.imp_value tagNo, t2.imp_value equipType, t1.row_index, t1.logs_id " +
     * "from imp_data_detail t1 " +
     * "inner join imp_data_detail t2 on t1.row_index = t2.row_index " +
     * "and t1.logs_id = t2.logs_id " +
     * "where t1.prop_id = 'tagNo' and t2.prop_id = 'equipType'")
     */
    @Test
    void mybatisPlusComplexQuery() {
        List<ImpDataDetailDto> impDataDetails = impDataDetailMapper.customeList();
        for (ImpDataDetailDto impDataDetail : impDataDetails) {
            log.info(impDataDetail.toString());
        }
    }

    /**
     * 复杂查询需要构建 Dto，手动编写sql
     *     @Select("SELECT " +
     *             " eq.type_id, " +
     *             " tt.tagNo, " +
     *             " tt.equipName, " +
     *             " tt.rowIndex  " +
     *             "FROM " +
     *             " define_equip_type eq " +
     *             "INNER JOIN (SELECT " +
     *             " ttt.tagNo, " +
     *             " ttt.equipType, " +
     *             " t3.imp_value AS equipName, " +
     *             " ttt.row_index AS rowIndex  " +
     *             "FROM ( " +
     *             "SELECT " +
     *             " t1.imp_value tagNo, " +
     *             " t2.imp_value equipType, " +
     *             " t1.row_index, " +
     *             " t1.logs_id  " +
     *             "FROM " +
     *             " imp_data_detail t1 " +
     *             " INNER JOIN imp_data_detail t2 ON t1.row_index = t2.row_index  " +
     *             " AND t1.logs_id = t2.logs_id  " +
     *             "WHERE " +
     *             " t1.prop_id = 'tagNo'  " +
     *             " AND t2.prop_id = 'equipType'  " +
     *             " ) ttt " +
     *             " INNER JOIN imp_data_detail t3 ON ttt.row_index = t3.row_index  " +
     *             " AND t3.prop_id = 'equipName'  " +
     *             " AND t3.logs_id = ttt.logs_id  " +
     *             " AND t3.logs_id = #{logs_id} " +
     *             " ) tt ON eq.type_name = tt.equipType")
     *     List<ImpDataDetail01Dto> complexQuery(@Param("logs_id") String logsId);
     */
    @Test
    void mybatisPlus01ComplexQuery() {
        String logs_id = "402885eb7ddbc98d017ddbcfeb250b39";
        List<ImpDataDetail01Dto> impDataDetails = impDataDetailMapper.complexQuery(logs_id);
        for (ImpDataDetail01Dto impDataDetail : impDataDetails) {
            log.info(impDataDetail.toString());
        }
    }
}