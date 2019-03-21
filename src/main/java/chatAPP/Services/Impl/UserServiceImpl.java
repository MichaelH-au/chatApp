package chatAPP.Services.Impl;

import chatAPP.Services.UserService;
import chatAPP.Services.model.UserModel;
import chatAPP.error.BusinessException;
import chatAPP.error.EmBusinessError;
import chatAPP.mapper.UsersMapper;
import chatAPP.model.Users;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        if (StringUtils.isEmpty(userModel.getUsername())
            || StringUtils.isEmpty(userModel.getPassword())
            || StringUtils.isEmpty(userModel.getNickname())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Users user = convertFromModel(userModel);
        usersMapper.insertSelective(user);
    }

    private Users convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        Users users = new Users();
        BeanUtils.copyProperties(userModel, users);
        return users;
    }
}
