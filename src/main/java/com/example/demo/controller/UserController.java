package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * / 就表示 http://127.0.0.1:9996/
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        /**
         * 我们访问的请求是 “/”
         * 现在把请求重新定向到 “/index”
         */
        return "redirect:/index";
    }

    /**
     * 新的请求路径
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(Model model) {
        /**
         * 这里的 index 是我们的前端页面的名字，不用加后缀
         * 这一块里面有数据吗？
         */
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "user/searchAllUser", method = RequestMethod.POST)
    public Msg searchUser(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                          @RequestParam(value = "pageize", defaultValue = "5") int pageSize, Model model) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> userList = userService.getAllPageUserInfo(pageable);

        return Msg.success().add("userList", userList);
    }

    /**
     * @ResponseBody 返回JSON格式的内容
     * Response ：响应
     */
    @ResponseBody
    @RequestMapping(value = "user/searchUser", method = RequestMethod.POST)
    public Msg searchUser(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                          @RequestParam(value = "pageize", defaultValue = "5") int pageSize, String name) {
        //List<User> userList = userService.getUserInfoByName(name);

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> userList = userService.getUserInfoByName(pageable, name);
        return Msg.success().add("userList", userList);
    }

    @ResponseBody
    @RequestMapping(value = "user/editUser/{id}", method = RequestMethod.POST)
    public Msg editUserAjax(@PathVariable("id") String id) {
        User user = userService.findUserById(Integer.parseInt(id));
        return Msg.success().add("user", user);
    }

    @ResponseBody
    @RequestMapping(value = "user/updateUser", method = RequestMethod.POST)
    public Msg updateUserAjax(String id, String name, String age) {
        Boolean flag = userService.updateUserById(name, Integer.parseInt(age), Integer.parseInt(id));
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "user/addUser", method = RequestMethod.POST)
    public Msg addUserAjax(String name, String age) {
        Boolean flag = userService.addUserinfo(name, Integer.parseInt(age));
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "user/delUser/{id}", method = RequestMethod.POST)
    public Msg deleteUserAjax(@PathVariable("id") String id) {
        Boolean flag = userService.deleteUserById(Integer.parseInt(id));
        return Msg.success();
    }
}
