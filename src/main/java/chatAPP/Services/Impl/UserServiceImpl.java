package chatAPP.Services.Impl;

import chatAPP.Services.UserService;
import chatAPP.Services.model.UserModel;
import chatAPP.error.BusinessException;
import chatAPP.error.EmBusinessError;
import chatAPP.mapper.ChatMsgMapper;
import chatAPP.mapper.UsersMapper;
import chatAPP.model.Users;
import chatAPP.model.UsersExample;
import chatAPP.netty.ChatMsg;
import chatAPP.validator.ValidationResult;
import chatAPP.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ChatMsgMapper chatMsgMapper;

    @Autowired
    private ValidatorImpl validator;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        ValidationResult  result = validator.validate(userModel);
        if (result.isHasError()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }

        Users user = convertFromModel(userModel);
        usersMapper.insertSelective(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserModel getUserByUsername(String username, String password) throws BusinessException {
//        Users user = usersMapper.selectByUsername(username, password);
        // Two way to query
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andPasswordEqualTo(password);
        criteria.andUsernameEqualTo(username);

        List<Users> users = usersMapper.selectByExample(usersExample);
        return convertFromDataObject(users.get(0));
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String saveMsg(ChatMsg chatMsg) {
        chatAPP.model.ChatMsg msgDB = new chatAPP.model.ChatMsg();
        msgDB.setSender(Integer.parseInt(chatMsg.getSenderId()));
        msgDB.setReceiver(Integer.parseInt(chatMsg.getReceiverId()));
        msgDB.setCreateAt(new Date());
        msgDB.setSignFlag(0);
        msgDB.setMsg(chatMsg.getMsg());

        Integer msgId = chatMsgMapper.insertSelective(msgDB);
        return msgDB.getId().toString();
    }

    @Override
    public List<UserModel> searchByName(String username) throws BusinessException {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<Users> usersList = usersMapper.selectByExample(usersExample);
        List<UserModel> userModels = usersList.stream().map((user) -> {
            return convertFromDataObject(user);
        }).collect(Collectors.toList());
        return userModels;
    }

    private Users convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        Users users = new Users();
        BeanUtils.copyProperties(userModel, users);
        return users;
    }

    private UserModel convertFromDataObject(Users user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        userModel.setFace_image(user.getFaceImage());
        return userModel;
    }
}
