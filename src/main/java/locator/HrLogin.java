package locator;

public interface HrLogin {
	String Login = "//a[text()='登录']"; //登录
	String account = "//input[@id='txtAccount']";		// 帐号
	String password = "//input[@id='txtPassword']";  //密码
	String submit = "//a[@id='btnLogin']"; //登录按钮
	String warning="//div[@id='mengbanPush']/descendant::a[text()='关闭']";//预警查看详情
	String warNing="//div[@id='mengban']/descendant::a[text()='暂不需要']";//手机号码绑定弹框
	String showName = "//a[contains(@class,'header-item')]";//显示名称
	String loginOut = "//div[@id='sbdiv']/a[text()='退出']"; //退出帐号
}
