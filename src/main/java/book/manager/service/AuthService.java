package book.manager.service;

import book.manager.entity.authUser;

import javax.servlet.http.HttpSession;

public interface AuthService {
    void register(String name,String sex,String grade,String password);
    public authUser findUser(HttpSession session);
}
