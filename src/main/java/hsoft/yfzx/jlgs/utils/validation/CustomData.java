package hsoft.yfzx.jlgs.utils.validation;

import hsoft.yfzx.jlgs.utils.model.common.RequestData;

import java.math.BigDecimal;
import java.util.List;

public class CustomData
{
    @DataValidation(description="用户名称",dataType = DataType.STRING, required = true, length = 8)
    private String userName;

    @DataValidation(description="电话号码",dataType = DataType.PHONE_NUM, required = true)
    private String phoneNum;

    @DataValidation(description="电子邮箱",dataType = DataType.EMAIL, required = true)
    private String email;

    @DataValidation(description="年龄",dataType = DataType.INTEGER, required = true, minimum = 1, maximum = 99)
    private String age;

    @DataValidation(description="id标识",dataType = DataType.LETTER_NUM, required = true, length = 10)
    private String id;

    @SuppressWarnings("rawtypes")
    @DataValidation(description="id列表",dataType = DataType.LIST, required = false, length = 1)
    private List<RequestData> idList;
    
    @DataValidation(description="年龄",dataType = DataType.INTEGER, required = true, minimum = 1, maximum = 99)
    private Integer count ;
    
    @DataValidation(description="价格",dataType = DataType.DECIMAL, required = true)
    private BigDecimal money;
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @SuppressWarnings("rawtypes")
    public List<RequestData> getIdList()
    {
        return idList;
    }

    @SuppressWarnings("rawtypes")
    public void setIdList(List<RequestData> idList)
    {
        this.idList = idList;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public BigDecimal getMoney()
    {
        return money;
    }

    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }


}
