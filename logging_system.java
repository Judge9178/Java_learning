import java.io.PrintStream;
import java.util.Scanner;

public class logging_system {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("用户注册系统");
      System.out.println("\n");
      System.out.println("请输入用户名：");
       String name = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        System.out.println("注册成功！");
System.out.println("请输入用户名：");
         String name1 = input.next();
        System.out.println("请输入密码：");
        String password1 = input.next();
        if (name1.equals(name1)&&password1.equals(password)) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
   }
      
    
}//this is the beginning of the system....