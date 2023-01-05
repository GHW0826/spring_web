package com.web.spring.web.address;


import com.web.spring.web.login.LoginDefaultForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class AddressController {

    @GetMapping("/jusoPopup")
    public String loginForm() {
        log.info("get Mapping");
        return "address/jusoPopup";
    }

    @PostMapping("/jusoPopup")
    public ModelAndView jusoPopup(HttpServletRequest request, @RequestParam HashMap<String, String> p, Locale locale) {
        log.info("post Mapping");

        // callback 함수가 실행되어야하니 호출한 html 파일로 return
        ModelAndView mav = new ModelAndView("popup/jusoPopup.html");

        String inputYn = request.getParameter("inputYn");
        String zipNo = request.getParameter("zipNo");
        String roadAddrPart1 = request.getParameter("roadAddrPart1");
        String roadAddrPart2 = request.getParameter("roadAddrPart2");
        String addrDetail = request.getParameter("addrDetail");
        String jibunAddr = request.getParameter("jibunAddr");

        mav.addObject("inputYn", inputYn);
        mav.addObject("zipNo", zipNo);
        mav.addObject("roadAddrPart1", roadAddrPart1);
        mav.addObject("roadAddrPart2", roadAddrPart2);
        mav.addObject("jibunAddr", jibunAddr);
        mav.addObject("addrDetail", addrDetail);

        return mav;
    }
}
