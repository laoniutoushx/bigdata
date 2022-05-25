package sos.haruhi.dbframe.mybatis.service.impl;

import sos.haruhi.dbframe.mybatis.entity.Users;
import sos.haruhi.dbframe.mybatis.mapper.UsersMapper;
import sos.haruhi.dbframe.mybatis.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shx
 * @since 2022-03-22
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
