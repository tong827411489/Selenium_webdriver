package locator;

public interface HRCreateOrder {
	String close = "//img[contains(@src,'in_close_')]";		//关闭绑定手机
	String newOder = "//img[contains(@src,'new_order_b')]"; //新建订单按钮
	String photo1 = "//input[@upload-key='1']";  //身份证正面
	String photo2 = "//input[@upload-key='141']";  //申请人征信签字照片
	String photo3 = "//input[@upload-key='11']";	//申请人身份证照片(背面)
	String photo4 = "//input[@upload-key='111']";	//申请人征信授权书照片
	String confirm = "//div[@class='ngdialog-close']"; //OCR解析失败，确定按钮
	String name = "//input[@placeholder='真实姓名']";  //身份证姓名
	String oppositeID = "//input[@placeholder='身份证号码']";  //身份证号码
	String phone = "//input[@placeholder='手机号码']";		//手机号码
	String Preservation = "//a[text()='保存']"; //保存按钮
	String PerfectInformation = "//a[text()='完善信息']"; //图片页面点击完善信息
	String unmarried = "//input[@name='marry'and@value='0']";  //未婚
	String married = "//input[@name='marry'and@value='1']";		//已婚
	String SingleDivorce = "//input[@name='marry'and@value='2']";  //单身离婚
	String Widowed = "//input[@name='marry'and@value='3']";		//丧偶 
	//无房 	有商品房 	有自建房 
	String NoHouse = "//input[@name='house'and@value='0']";		
	String CommercialHousing = "//input[@name='house'and@value='1']";
	String selfBuilding = "//input[@name='house'and@value='2']";
	//	私牌 	公牌 
	String PrivateBrand = "//input[@name='car'and@value='0']";
	String commonBrand = "//input[@name='car'and@value='1']";
	// 是否需要反担保人  否 	是 
	String guarantorNo = "//input[@name='guarantor'and@value='0']";
	String guarantorYes = "//input[@name='guarantor'and@value='1']";
	// 是否是企业法人  否  是
	String legalPersonNo = "//input[@name='carfrom'and@value='0']";
	String legalPersonYes = "//input[@name='carfrom'and@value='1']";
	//新车   二手车
	String newcar = "//input[@name='isSecondform'and@value='0']";
	String oldCar = "//input[@name='isSecondform'and@value='1']";
	//选择公积金所在 市县
	String city = "//select[@ng-model='fund.city']";
	String area = "//select[@ng-model='fund.area']";
	//公积金帐号密码
	String formdbAccount = "//input[@ng-model='fund.formdb.account']";
	String formdbPassword = "//input[@ng-model='fund.formdb.password']";
	String nextPage = "//a[text()='下一步']"; 	//问卷页面下一页
	//选择银行   分行  区域  支行
	String selectBank = "//a[text()='选择银行']";  //选择银行
	String totalBank = "//select[@ng-model='bankinfo.bank']";
	String areaBank	=  "//select[@ng-model='bankinfo.area']";
	String branchBank	=  "//select[@ng-model='bankinfo.branch']";
	String determine = "//a[text()='确定']";
	// 征信查询 信用等级 贷款逾期    信用卡逾期  分期数  未结清余额  备注
	String query = "//a[text()='征信查询']";
	String grade = "//select[@ng-model='loanUserCredit.creditLevel']";
	String HistoricalLoan = "//input[@ng-model='loanUserCredit.loanCrdtot']";
	String HistoryCreditCard = "//input[@ng-model='loanUserCredit.cardCrdtot']";
	String amortized = "//input[@ng-model='loanUserCredit.leftNumot']";
	String unCleared = "//input[@ng-model='loanUserCredit.leftAmountot']";
	String Remarks = "//input[@ng-model='loanUserCredit.creditResultsot']";
	//材料管理按钮
	String MaterialManagement = "//a[text()='进入材料管理']";

}
