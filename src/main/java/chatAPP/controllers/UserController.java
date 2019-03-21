package chatAPP.controllers;

import chatAPP.Services.UserService;
import chatAPP.Services.model.UserModel;
import chatAPP.error.BusinessException;
import chatAPP.response.CommonReturnTrye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/registerOrLogin")
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
}
