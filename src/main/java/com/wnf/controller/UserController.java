package com.wnf.controller;

import com.wnf.dto.ResultDto;
import com.wnf.entity.User;
import com.wnf.handle.BaseExceptionHandleAction;
import com.wnf.service.UserService;
import com.wnf.utils.FileUploadUtil;
import com.wnf.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseExceptionHandleAction {

    @Autowired
    private UserService userService;

    /**
     * 通过phone查找用户的信息（可用于查看用户信息功能的请求接口）
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findUserByPhone")
    public ResultDto findUserByPhone(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        User user = userService.findUserByPhone(phone);
        if (user == null) {
            return new ResultDto(200, "nodata", null);
        } else {
            return new ResultDto(200, "success", user);
        }
    }

}
