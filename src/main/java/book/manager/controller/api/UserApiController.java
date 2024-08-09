package book.manager.controller.api;

import book.manager.entity.authUser;
import book.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/user")
public class UserApiController {
    @Resource
    BookService service;

    @RequestMapping(value = "/borrow_book",method = RequestMethod.GET)
    public String borrowBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")authUser user){
        service.borrowBook(bid, user.getId());
        return "redirect:/page/user/book";
    }

    @RequestMapping(value = "/return_book",method = RequestMethod.GET)
    public String returnBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")authUser user){
        service.returnBook(bid, user.getId());
        return "redirect:/page/user/book";
    }
}
