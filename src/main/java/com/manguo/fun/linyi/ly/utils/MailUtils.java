package com.manguo.fun.linyi.ly.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceCompositeResolver;
import org.apache.commons.mail.resolver.DataSourceFileResolver;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import java.net.URL;


@Slf4j
public class MailUtils {
    //收件人
    private static final String TO = "omgsmlz@126.com";
    private static final String TO_MSG = "中国人民银行";
    //发件人
    private static final String FROM = "867745320@qq.com";
    private static final String FROM_MSG = "超级无敌大西瓜";
    //发件人用户名
    private static final String USER_NAME = "867745320@qq.com";
    //发件人授权密码
    private static final String PWD = "mfinejmqvetpbffg";
    //邮件标题
    private static final String TITLE = "你号没了";


    //图片邮件
    public static void sendEmail(String name, String[] arr) {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("姓名: ").append(name);
            for (String s : arr) {
                builder.append("<img src=").append(s).append(">");
            }
            ImageHtmlEmail email = new ImageHtmlEmail();//用ImageHtmlEmail来发送
            email.setDebug(true);//可以看到执行过程的debug信息
            email.setCharset("UTF-8");//防止乱码
            email.setSSLCheckServerIdentity(true);
            email.setSslSmtpPort("465"); // 设定SSL端口

            DataSourceResolver[] dataSourceResolvers =
                    new DataSourceResolver[]{new DataSourceFileResolver(),//添加DataSourceFileResolver用于解析本地图片
                            new DataSourceUrlResolver(new URL("http://"))};//添加DataSourceUrlResolver用于解析网络图片，注意：new URL("http://")
            email.setDataSourceResolver(new DataSourceCompositeResolver(dataSourceResolvers));

            email.setHostName("smtp.qq.com");
            email.addTo(TO, TO_MSG);
            email.setFrom(FROM, FROM_MSG);
            email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PWD));
            email.setSubject(TITLE);

            email.setHtmlMsg(builder.toString());

            //如果客户端不去持HTML格式会显示这句话，不过应该很少有不支持HTML格式的客户端了吧
            email.setTextMsg("你的邮箱客户端不支持HTML格式邮件");
            email.send();
        } catch (Exception e) {
            log.error("银行邮件发送失败");
        }
    }

    public static void main(String[] args) {
        String[] arr = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1555673149454&di=95dbe50f75af52d7c92db957330dcaa6&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F21%2F20180421163232_JvceQ.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1555673226599&di=80b0bb248a9614cf2d595afa6ad69d1f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201805%2F24%2F20180524130347_fkxwv.jpg"};

    }
}