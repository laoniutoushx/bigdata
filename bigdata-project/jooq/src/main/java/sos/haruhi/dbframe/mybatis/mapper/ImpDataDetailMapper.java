package sos.haruhi.dbframe.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sos.haruhi.dbframe.dto.ImpDataDetail01Dto;
import sos.haruhi.dbframe.dto.ImpDataDetailDto;
import sos.haruhi.dbframe.mybatis.entity.ImpDataDetail;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shx
 * @since 2022-03-22
 */
public interface ImpDataDetailMapper extends BaseMapper<ImpDataDetail> {

    @Select("select t1.imp_value tagNo, t2.imp_value equipType, t1.row_index, t1.logs_id " +
            "from imp_data_detail t1 " +
            "inner join imp_data_detail t2 on t1.row_index = t2.row_index " +
            "and t1.logs_id = t2.logs_id " +
            "where " +
            "t1.prop_id = 'tagNo' " +
            "and t2.prop_id = 'equipType'")
    List<ImpDataDetailDto> customeList();

    @Select("SELECT " +
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
            " AND t3.logs_id = #{logs_id} " +
            " ) tt ON eq.type_name = tt.equipType")
    List<ImpDataDetail01Dto> complexQuery(@Param("logs_id") String logsId);
}
