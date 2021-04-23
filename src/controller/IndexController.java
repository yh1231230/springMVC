package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;


@Controller
public class IndexController{
@RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message1", "Hello Spring MVC");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump() throws Exception {
        ModelAndView mav = new ModelAndView("redirect:/index");//跳转到/index控制器
       //  mav.setViewName("/index");//直接跳转到index.jsp页面
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session){
        Integer i=(Integer)session.getAttribute("count");       //用session记录访问次数
        if(i==null)
        i=0;
        i++;
        session.setAttribute("count",i);
        ModelAndView mav=new ModelAndView("check");
        return mav;
    }

}