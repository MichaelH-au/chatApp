package chatAPP.controllers;

import chatAPP.error.BusinessException;
import chatAPP.error.EmBusinessError;
import chatAPP.response.CommonReturnTrye;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController {

    @GetMapping("/hello")
    public CommonReturnTrye hello() throws BusinessException {
//        if (1 == 1) {
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
        return CommonReturnTrye.create("hello world");
    }
}
