package com.tianyi.goods.service.utils;

import com.tianyi.goods.entity.GoodsPricePropose;
import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.User;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: 使用邮件进行审批通知
 * @author: Simon
 * @create: 2019-09-09 22:08
 **/
@Component
public class ApproveEmailAdviceUtil {


    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage mailMessage;


    public void sendMail(Set<User> userSet) {

        mailMessage.setSubject("申请消息");
        mailMessage.setText("请及时查看申请消息");
        List<String> emailList = new ArrayList<>();
        for (User user : userSet) {
            emailList.add(user.getUserEmail());
        }

        String[] emails = emailList.toArray(new String[emailList.size()]);


        mailMessage.setTo(emails);

        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param userSet       {用户集合}
     * @param subjectString {自定义邮件名}
     * @param text          {自定义邮件文本内容}
     */
    public void sendMail(Set<User> userSet, String subjectString, String text) {

        mailMessage.setSubject(subjectString);
        mailMessage.setText(text);
        List<String> emailList = new ArrayList<>();
        for (User user : userSet) {
            emailList.add(user.getUserEmail());
        }
        mailMessage.setTo((String[]) emailList.toArray());

        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }

    }


}
