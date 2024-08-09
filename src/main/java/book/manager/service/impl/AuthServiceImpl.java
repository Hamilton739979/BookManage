package book.manager.service.impl;

import book.manager.entity.authUser;
import book.manager.mapper.UserMapper;
import book.manager.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UserMapper mapper;

    @Transactional
    @Override
    public void register(String name,String sex,String grade,String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        authUser user = new authUser(0,name,encoder.encode(password),"user");
        if (mapper.registerUser(user)<=0){
            throw new RuntimeException("用户基本信息添加失败！");
        }
        if (mapper.addStudentInfo(user.getId(),name,sex,grade)<=0){
            throw new RuntimeException("学生详细信息添加失败！");
        }
    }

    @Override
    public authUser findUser(HttpSession session) {
        authUser user = (authUser) session.getAttribute("user");
        if (user == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user",user);
        }
        return user;
    }


}
