
public class Student {
    private int ID;         // 学生的ID
    private String name;    // 学生的姓名
    private String birDate; // 学生的生日: year.month.day
    private boolean gender; // 学生的性别: man: true, woman: false
    // 构造函数，默认初始化方式
    Student() {
        ID = -1;
        name = "";
        birDate = "";
        gender = false;        
    }
    // 接受学生信息进行构造学生对象
    // stu_id是ID, stu_name是Name, stu_birDate是birthday, stu_gender是性别
    Student(int stu_id, String stu_name, String stu_birDate, boolean stu_gender) {
        ID = stu_id;
        name = stu_name;
        birDate = stu_birDate;
        gender = stu_gender;
    }
    public int Get_ID() { return ID; }  // 获取学生的ID
    public void Set_ID(int xc_ID) { ID = xc_ID; }   // 修改学生的ID为xc_ID
    public String Get_name() { return name; }   // 获取学生的姓名
    public void Set_name(String xc_name) { name = xc_name; }    // 修改学生的姓名为xc_name
    public String Get_birDate() { return birDate; } // 获取学生的生日
    public void Set_birDate(int year, int month, int day) { birDate = year + "." + month + "." + day; } // 修改学生的生日，接受姓名，年, 月, 日4个参数
    public String Get_gender() {   // 获取学生的性别：man为男生，woman为女生
        if(gender == true) return String.valueOf("man");
        return String.valueOf("woman");
    }
    // 修改学生的性别：man为男生，woman为女生，其他输入抛异常
    public void Set_gender(String xc_gender) throws Exception {
        if(xc_gender.equals("man")) gender = true;
        else if(xc_gender.equals("woman")) gender = false;
        else throw new Exception();
    }
    // 按照boolean来修改学生的姓名：true为男生，false为女生
    public void Set_gender(boolean xc_gender) { gender = xc_gender; }
}