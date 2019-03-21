package chatAPP.controllers;

import chatAPP.response.CommonReturnTrye;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public CommonReturnTrye hello() {

        return CommonReturnTrye.create("hello world");
    }
}
