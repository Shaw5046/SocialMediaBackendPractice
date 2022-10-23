package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.*;
import com.appbackend.appdb.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.File;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IUserService extends IService<User> {

    public SendCodeReq sendCode(String  phone);

    public PhoneLoginReq phoneLogin(String phone, int inputcode);

    public UserNameLoginReq userNameLoginReq(String username, String password);

    public LogoutReq logoutReq(String token);

    public UserListReq searchUser(String keyword, int page);

    public UserReq bindPhone(String token, String phone, int inputCode);

    public UserReq bindEmail(String token, String email);

    public boolean resetPassword(String token, String oldPw, String newPw, String newPw2);

    public UserCountsReq getUserCounts(int userId);

    public void resetUserPic(String token, File userPic);

    public UserReq getUserById(int id);


}
