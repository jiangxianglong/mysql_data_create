package email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;


/**
 * 邮件工具类
 */
public class MailUtil {

    /**
     * @param tos
     * @param text
     * @param isHtml
     * @param files
     * @throws MessagingException
     */
    public static void send_mail(String[] tos,String themeName ,String text, boolean isHtml, File[] files) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        properties.put("mail.smtp.host", "smtp.163.com");
        //发送端口
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("15600513221@163.com", "linlong1314");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("15600513221@163.com"));

        //多个接收人
        InternetAddress[] address = new InternetAddress[tos.length];
        for (int i = 0; i < address.length; i++) {
            address[i] = new InternetAddress(tos[i]);
        }
        //设置接收人地址
        message.setRecipients(Message.RecipientType.TO, address);

        //设置主题
        message.setSubject(themeName);

        //部件
        Multipart mp = new MimeMultipart();

        //body部件
        MimeBodyPart mbp = new MimeBodyPart();

        //判断发送的是否是html格式
        if (isHtml) {// 如果是html格式
            mbp.setContent(text, "text/html;charset=UTF-8");
        } else {
            mbp.setText(text);
        }
        //将该正文部件加入到整体部件
        mp.addBodyPart(mbp);

        if (files != null && files.length > 0) {// 判断是否有附件
            //存在附件就将附件全部加入到BodyPart
            for (File file : files) {
                mbp = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(file); // 得到数据源
                mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
                mbp.setFileName(fds.getName()); // 得到文件名同样至入BodyPart
                mp.addBodyPart(mbp);
            }
        }
        // Multipart加入到信件
        message.setContent(mp);
        //发送一封邮件
        Transport.send(message);
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
//                String[] strings = {"jiangxianglong@xdf.cn", "841218283@qq.com"};
//                String[]  str = {"841218283@qq.com","741698362@qq.com"};
                String[]  str = {"2191239058@qq.com","841218283@qq.com"};
//              MailUtil.send_mail(str,"蒋向龙","哈哈哈哈哈哈", true,new File[]{new File("/Users/jiangxianglong/Desktop/6")});
                MailUtil.send_mail(str,"蒋向龙","蒋向龙蒋向龙蒋向龙蒋向龙蒋向龙蒋向龙蒋向龙蒋向龙", true,null);

                System.out.println("邮件发送成功!");
            }
        } catch (MessagingException e) {
            System.out.println("发送邮件失败!");
            e.printStackTrace();
        }
    }
}
