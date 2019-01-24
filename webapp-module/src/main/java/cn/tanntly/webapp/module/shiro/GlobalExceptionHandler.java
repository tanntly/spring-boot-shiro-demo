package cn.tanntly.webapp.module.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//    @ExceptionHandler(value=UnauthorizedException.class)
//    public String unauthorizedHandler(HttpServletRequest request, UnauthorizedException exception) throws Exception{
//        return "您无此权限"+exception.getMessage();
//    }
//}