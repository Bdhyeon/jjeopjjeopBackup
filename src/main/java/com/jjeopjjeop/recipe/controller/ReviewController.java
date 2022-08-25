
package com.jjeopjjeop.recipe.controller;

import com.jjeopjjeop.recipe.config.MySecured;
import com.jjeopjjeop.recipe.dto.CommunityDTO;
import com.jjeopjjeop.recipe.dto.RecipeDTO;
import com.jjeopjjeop.recipe.dto.ReviewDTO;
import com.jjeopjjeop.recipe.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController() {

    }

    //리뷰 작성폼 불러오기 /{pay_num} @PathVariable("pay_num") int pay_num
    @MySecured
    @GetMapping("/review/write/{pay_num}")
    public String reviewWriteForm(@PathVariable("pay_num") int pay_num, Model model){
//, @ModelAttribute("review") ReviewDTO review, Model model
     /*--------------------------
            //빈 객체 넘기기
            // form.html에 th:object를 썼기때문에 모델 어트리뷰트가 있어야함.
            // th:object를 쓰면 id name value 생략가능
            List<ReviewDTO> reviewDTO = Collections.emptyList();
        model.addAttribute("reviewDTO",reviewDTO);

        */
            //-------------------------------
        model.addAttribute("reviewDTO", new ReviewDTO()); //빈 오브젝트를 뷰에 넘겨준다.
        model.addAttribute("pay_num", pay_num);
        //  mav.addObject("pay_num", pay_num);
        return "/produce/reviewWrite";
    }

    //리뷰 작성 반영하기
    @MySecured
    @PostMapping("/review/write")
    public String reviewWrite(@Valid ReviewDTO reviewDTO, Errors errors){

        if (errors.hasErrors()) { //에러있으면 
            return "/produce/reviewWrite"; //폼다시 불러오게
        }
        reviewService.reviewWrite(reviewDTO);

        return "redirect:/mypage/pay/view";
    }


    //리뷰 삭제하기.
    //@PostMapping("/review/delete/{payNum}")  <-이걸로 하면 오류남(There was an unexpected error (type=Method Not Allowed, status=405).
    //Request method 'GET' not supported)
    @MySecured
    @GetMapping("/review/delete/{payNum}")
    public String reviewDelete(@PathVariable("payNum") int pay_num, RedirectAttributes redirectAttributes){
        reviewService.reviewDelete(pay_num);

        redirectAttributes.addFlashAttribute("message","Category deleted");
        redirectAttributes.addFlashAttribute("alertClass","alert-success");

        return "redirect:/mypage/pay/view";

    }

    //리뷰 수정을 위한 작성된 리뷰내용 보기
    @MySecured
    @GetMapping("/review/view/{pay_num}")
    public ModelAndView reviewView(@PathVariable("pay_num") int pay_num, ModelAndView mav){

        ReviewDTO reviewDTO = reviewService.reviewView(pay_num);
        mav.addObject("reviewDTO", reviewDTO);
        mav.setViewName("/produce/reviewUpdate");
        return mav;
    }

    //리뷰 수정 반영
    @MySecured
    @PostMapping("/review/update")
    public String reviewUpdate(ReviewDTO reviewDTO){

        reviewService.reviewUpdate(reviewDTO);
        return "redirect:/mypage/pay/view";
    }
}
