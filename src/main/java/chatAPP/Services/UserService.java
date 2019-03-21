package chatAPP.Services;

import chatAPP.Services.model.UserModel;
import chatAPP.error.BusinessException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserService {
    void register(UserModel userModel) throws BusinessException;

    UserModel getUserByUsername(String username, String password) throws BusinessException;
}
