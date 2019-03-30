package chatAPP.controllers;

import chatAPP.Services.UserService;
import chatAPP.Services.model.UserModel;
import chatAPP.controllers.requestObject.userRO;
import chatAPP.controllers.viewObject.UserVO;
import chatAPP.error.BusinessException;
import chatAPP.error.EmBusinessError;
import chatAPP.response.CommonReturnTrye;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RestController("user")
@RequestMapping("/user")
//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
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

    @PostMapping(value = "/login",consumes = "application/json")
    public CommonReturnTrye login(@RequestBody userRO userRO) throws BusinessException{
        String username = userRO.getUsername();
        String password = userRO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.INVALID_USERNAME_OR_PASSWORD);
        }
        UserModel userModel = userService.getUserByUsername(username, DigestUtils.md5DigestAsHex(password.getBytes()));

        if (userModel == null) {
            throw new BusinessException(EmBusinessError.INVALID_USERNAME_OR_PASSWORD);
        }

        UserVO userVO = convertFromUserModel(userModel);
        return CommonReturnTrye.create(userVO);
    }

    @RequestMapping(value = "/updateAvatar",method = RequestMethod.POST)
    public String file(@RequestParam("file") MultipartFile file,
                       @RequestParam("userId") String userId) throws IOException {

        if (file.isEmpty()) {
            return "文件为空";
        }
        System.out.println(userId);

        String UPLOADED_FOLDER = "/Users/ransheng/Documents/Java/chatApp/src/main/resources/upload/";
        File path = new File(UPLOADED_FOLDER + file.getOriginalFilename());
        try{
            byte[] fileSize = file.getBytes();
            file.transferTo(path);
            return "上传成功";
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";



    }

    @GetMapping(value = "/{name}")
    public void getByName(@PathVariable final String name) {

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
