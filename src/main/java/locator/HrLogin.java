package locator;

public interface HrLogin {
	String Login = "//a[text()='登录']"; //登录
	String account = "//input[@id='txtAccount']";		// 帐号
	String password = "//input[@id='txtPassword']";  //密码
	String submit = "//a[@id='btnLogin']"; //登录按钮
}
