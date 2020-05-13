
public class Student {
    // private int ID;         // 学生的ID - 1.1
    private int stuId;         // 学生的ID
    // private String name;    // 学生的姓名 - 1.1
    private String stuName;    // 学生的姓名
    // private String birDate; // 学生的生日: year.month.day - 1.1
    private String stuBirDate; // 学生的生日: year.month.day
    // private boolean gender; // 学生的性别: man: true, woman: false - 1.1
    private boolean stuGender; // 学生的性别: man: true, woman: false
    // 构造函数，默认初始化方式
    Student() {
        stuId = -1;
        stuName = "";
        stuBirDate = "";
        stuGender = false;        
    }
    // 接受学生信息进行构造学生对象
    // stu_id是ID, stu_name是Name, stu_birDate是birthday, stu_gender是性别
    // Student(int stu_id, String stu_name, String stu_birDate, boolean stu_gender) {
    //     stuId = stu_id;
    //     stuName = stu_name;
    //     stuBirDate = stu_birDate;
    //     stuGender = stu_gender;
    // }
    // - 1.1
    Student(int stuId, String stuName, String stuBirDate, boolean stuGender) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuBirDate = stuBirDate;
        this.stuGender = stuGender;
    }
    // public int Get_ID() { return ID; }  // 获取学生的ID - 1.1
    public int getId() { return stuId; }  // 获取学生的ID
    // public void Set_ID(int xc_ID) { ID = xc_ID; }   // 修改学生的ID为xc_ID - 1.1
    public void setId(int stuId) { this.stuId = stuId; }   // 修改学生的ID为xc_ID
    // public String Get_name() { return stuName; }   // 获取学生的姓名 - 1.1
    public String getName() { return stuName; }   // 获取学生的姓名
    // public void Set_name(String xc_name) { stuName = xc_name; }    // 修改学生的姓名为xc_name - 1.1
    public void setName(String stuName) { this.stuName = stuName; }    // 修改学生的姓名为xc_name
    // public String Get_birDate() { return stuBirDate; } // 获取学生的生日 - 1.1
    public String getBirDate() { return stuBirDate; } // 获取学生的生日
    // public void Set_birDate(int year, int month, int day) { stuBirDate = year + "." + month + "." + day; } // 修改学生的生日，接受姓名，年, 月, 日4个参数 - 1.1
    public void setBirDate(int year, int month, int day) { stuBirDate = year + "." + month + "." + day; } // 修改学生的生日，接受姓名，年, 月, 日4个参数
    // public String Get_gender() {   // 获取学生的性别：man为男生，woman为女生 - 1.1
    //     if(stuGender == true) return String.valueOf("man");
    //     return String.valueOf("woman");
    // }
    // 3.5: if () for (a; b; c) { } while () { }
    // 4.2: 单个的循环, 条件语句也加{ }
    public String getGender() {   // 获取学生的性别：man为男生，woman为女生
        // 5.11: 判断使用了(常量 == 变量)的形式
        if(true == stuGender) {
            return String.valueOf("man");
        }
        return String.valueOf("woman");
    }
    // 修改学生的性别：man为男生，woman为女生，其他输入抛异常 - 1.1
    // public void Set_gender(String xc_gender) throws Exception {
    //     if(xc_gender.equals("man")) stuGender = true;
    //     else if(xc_gender.equals("woman")) stuGender = false;
    //     else throw new Exception();
    // }
    // 3.5: if () for (a; b; c) { } while () { }
    // 4.2: 单个的循环, 条件语句也加{ }
    public void setGender(String stuGender) throws Exception {
        if (stuGender.equals("man")) {
            this.stuGender = true;
        } else if (stuGender.equals("woman")) {
            this.stuGender = false;
        } else {
            throw new Exception();
        }
    }
    // 按照boolean来修改学生的姓名：true为男生，false为女生 - 1.1
    // public void Set_gender(boolean xc_gender) { stuGender = xc_gender; }
    public void Set_gender(boolean stuGender) { this.stuGender = stuGender; }
}