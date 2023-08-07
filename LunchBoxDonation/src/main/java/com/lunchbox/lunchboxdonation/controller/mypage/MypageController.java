package com.lunchbox.lunchboxdonation.controller.mypage;

import com.lunchbox.lunchboxdonation.entity.Order.OrderAddress;
import com.lunchbox.lunchboxdonation.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Slf4j
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;



    @RequestMapping("/mypages")
    public String mypage(Model model){
        Page<OrderAddress> recentOrderAddressesPage = mypageService.getRecentOrderAddressesWithinThreeMonthsPageable(0, 3);
        model.addAttribute("recentOrderAddresses",recentOrderAddressesPage);
        return "mypage/mypage";
    }



}
