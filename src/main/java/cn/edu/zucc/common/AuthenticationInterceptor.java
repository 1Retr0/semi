package cn.edu.zucc.common;

import cn.edu.zucc.Annotation.PassToken;
import cn.edu.zucc.Annotation.Role;
import cn.edu.zucc.Annotation.UserLoginToken;
import cn.edu.zucc.domain.entity.User;
import cn.edu.zucc.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");
        String username = httpServletRequest.getHeader("username");

        System.out.println("aa");
        //如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有password注释，有则通过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if(method.isAnnotationPresent(Role.class)) {
           Role role = method.getAnnotation(Role.class);
           User user = userService.getUser(username);
           System.out.println(role.value());
           System.out.println(user.getRole());
           if(!role.value().equals(user.getRole())) {
               throw new InvaildClientException("用户没有该权限");
           }
           return true;
        }

        //检查有没有需要用户权限的注释
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            //执行认证
            if (token == null) {
                throw new InvaildClientException("无token，请重新登录");
            }
            //获取token中的user id
            Jws<Claims> jwt = Jwts.parser()
                    .setSigningKey(R.KEY)
                    .parseClaimsJws(token);
            long userId = jwt.getBody().get("id", Long.class);

            User user = userService.getUser(userId);
            if (user == null) {
                throw new Exception("用户不存在，请重新登录");
            }
            if (jwt.getBody().get("exp", Date.class).before(new Date())) {
                throw new Exception("登录超时，请重新登录");
            }
            return true;
        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

/*    @Override
    public void afterVomletion(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse,
                               Object o, Exception e) throws Exception{

    }*/
}
