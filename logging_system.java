import java.util.Scanner;

public class logging_system {
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MIN_PASSWORD_LENGTH = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("用户注册与登录系统");
        System.out.println("==================");

        String username = registerUsername(input);
        String password = registerPassword(input);

        System.out.println("\n注册成功！请登录。");

        boolean loggedIn = login(input, username, password);
        if (loggedIn) {
            System.out.println("登录成功！欢迎你，" + username + "！");
        } else {
            System.out.println("登录失败次数过多，账号已暂时锁定。");
        }

        input.close();
    }

    private static String registerUsername(Scanner input) {
        while (true) {
            System.out.print("请输入用户名：");
            String username = input.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("用户名不能为空，请重新输入。");
                continue;
            }

            if (username.length() < 3) {
                System.out.println("用户名至少需要 3 个字符。");
                continue;
            }

            return username;
        }
    }

    private static String registerPassword(Scanner input) {
        while (true) {
            System.out.print("请输入密码：");
            String password = input.nextLine().trim();

            if (password.length() < MIN_PASSWORD_LENGTH) {
                System.out.println("密码至少需要 " + MIN_PASSWORD_LENGTH + " 个字符。");
                continue;
            }

            System.out.print("请再次确认密码：");
            String confirmPassword = input.nextLine().trim();

            if (!password.equals(confirmPassword)) {
                System.out.println("两次输入的密码不一致，请重新设置。");
                continue;
            }

            return password;
        }
    }

    private static boolean login(Scanner input, String username, String password) {
        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
            System.out.print("请输入用户名：");
            String loginUsername = input.nextLine().trim();

            System.out.print("请输入密码：");
            String loginPassword = input.nextLine().trim();

            if (loginUsername.equals(username) && loginPassword.equals(password)) {
                return true;
            }

            int remainingAttempts = MAX_LOGIN_ATTEMPTS - attempt;
            if (remainingAttempts > 0) {
                System.out.println("用户名或密码错误！你还可以尝试 " + remainingAttempts + " 次。");
            }
        }

        return false;
    }
}
