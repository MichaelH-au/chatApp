package chatAPP.controllers;

import chatAPP.Services.UserService;
import chatAPP.Services.model.UserModel;
import chatAPP.controllers.viewObject.UserVO;
import chatAPP.error.BusinessException;
import chatAPP.error.EmBusinessError;
import chatAPP.response.CommonReturnTrye;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public CommonReturnTrye register(@RequestParam(required=false,name="username") String username,
                                     @RequestParam(required=false,name="password") String password,
                                     @RequestParam(required=false,name="nickname") String nickname) throws BusinessException {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userModel.setNickname(nickname);

        userService.register(userModel);
        return CommonReturnTrye.create("Register successfully");
    }

    @PostMapping("/login")
    public CommonReturnTrye login(@RequestParam(required=false,name="username") String username,
                                  @RequestParam(required=false,name="password") String password) throws BusinessException{
        UserModel userModel = userService.getUserByUsername(username, DigestUtils.md5DigestAsHex(password.getBytes()));

        if (userModel == null) {
            throw new BusinessException(EmBusinessError.INVALID_USERNAME_OR_PASSWORD);
        }

        UserVO userVO = convertFromUserModel(userModel);
        return CommonReturnTrye.create(userVO);
    }

    private UserVO convertFromUserModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
