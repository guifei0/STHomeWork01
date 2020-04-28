import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // 存储所有学生信息的List: ID, Name, Birthday, Gender
    private List<Student> stu = new ArrayList<Student>();
    StudentManager() { // 初始化清空List, 没有学生
        stu.clear();
    }
    public int Get_Student_sum() { return stu.size(); } // 获取当前的学生数量
    // -- 插入一名学生的信息
    // 参数：学生ID，学生姓名Name，学生生日xxxx.xx.xx，性别(true-man, false-woman)
    void Insert_Student(int stu_id, String stu_name, 
            String stu_birDate, boolean stu_gender) throws Exception {
        if(stu_birDate.length() != 10) throw new Exception();   // 判断输入是否合法，如果生日串长度不是10，说明是输入有误
        else {
            // 对于生日中的每个字符，只有下标4和7的位置是., 其他的都不是., 如果不是这样则输入有误
            for(int i = 0;i < stu_birDate.length();++i) {
                if((i == 4 || i == 7) && stu_birDate.charAt(i) != '.')
                    throw new Exception();
                if(i != 4 && i != 7 && stu_birDate.charAt(i) == '.')
                    throw new Exception();
            }
        }
        // 合法输入，实例化一个Student记录新加入学生的信息
        Student add_Student = new Student(stu_id, stu_name, stu_birDate, stu_gender);
        // add_Index表示插入的位置，初始位置设为序列末尾空白位置
        // 初始化为序列末尾的好处是不用处理边界清空，也就是插入的数值比序列中的所有学生的ID都大
        // 这样插入即可保证递增，插入可以用二分来优化，因为数据量很小，因此采用直接遍历的方法
        int add_Index = stu.size();
        for(int i = 0;i < stu.size();++i) {
            Student t = stu.get(i);
            if(add_Student.Get_ID() < t.Get_ID()) { // 查询到第一个大于要插入元素的值记录这个位置到add_Index中然后跳出遍历
                add_Index = i;
                break;
            }
        }
        stu.add(add_Index, add_Student);    // 将元素插入到需要插入的元素之前
        System.out.println("Insert successfully!");
    }
    // -- 输出所有的学生信息，每个学生信息占一行
    public void Print_Student() {
        if(stu.size() == 0) System.out.println("No students!"); // 如果当前没有学生，输出No students!
        else {
            // 遍历List，将所有学生的信息输出
            for(Student res : stu) {
                System.out.println("ID: " + res.Get_ID() + ", Name: " + 
                    res.Get_name() + ", Birthday: " + res.Get_birDate() + 
                    ", Gender: " + res.Get_gender());
            }
        }
    }
    // -- 按照姓名查找
    public void Find_Student(String name) {
        boolean flg = false;    // flg = true表示姓名为name的学生是存在的，反之为false表示不存在
        for(Student res : stu) {
            if(name.equals(res.Get_name())) {
                flg = true;
                break;
            }
        }
        if(flg) System.out.println("Query successful");
        else System.out.println("Query failed");
    }
    // -- 删除功能，按照姓名删除
    public void Del_Student(String name) {
        Iterator<Student> it = stu.iterator();  // 创建迭代器遍历学生List
        while(it.hasNext()) {
            Student t_student = it.next();
            if(t_student.Get_name().equals(name)) it.remove();  // 如果遍历到需要删除的学生(名字)，则删除
        }
        System.out.println("successfully deleted");
    }
    // -- 修改功能，按照姓名查找后修改年龄等信息
    public void Modify_Studen(String name, int year, int month, int day) {
        Iterator<Student > it = stu.iterator();
        while(it.hasNext()) {
            Student t = it.next();
            if(t.Get_name().equals(name)) t.Set_birDate(year, month, day);  // 如果遍历到需要修改的学生(名字匹配了)，则调用Set_birDate修改生日
        }
        System.out.println("Successfully modified");
    }
    // -- 菜单选项
    public void Get_Menu() {
        System.out.println("Please select an operation: ");
        System.out.println("**********************************");
        System.out.println("*            1.Insert            *");
        System.out.println("*            2.Find              *");
        System.out.println("*            3.Delete            *");
        System.out.println("*            4.Modify            *");
        System.out.println("*            5.Output            *");
        System.out.println("*            6.Quit              *");
        System.out.println("**********************************");
    }
    // -- 控制流程
    public void App() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                Get_Menu(); // 创建菜单
                int op = in.nextInt();  // 读入操作op表示做哪个操作
                boolean is_quit = false; // 是否要退出程序
                in.nextLine(); // 输入后同时清空缓冲区，清除用户多余输入
                switch (op) {
                    case 1: // -- Insert：插入学生
                        System.out.println("请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): ");
                        int stu_id = in.nextInt();  // 读入学生的ID
                        String stu_name = in.next();    // 读入学生的姓名
                        String stu_birDate = in.next(); // 读入学生的生日
                        boolean stu_gender;
                        String gender = in.next();
                        // 读入学生的性别，如果不为man或者woman则抛异常重新输入
                        if(gender.equals("man")) stu_gender = true;
                        else if(gender.equals("woman")) stu_gender = false;
                        else throw new Exception();
                        // 如果输入合理，则调用学生插入函数，将学生信息记录下来
                        Insert_Student(stu_id, stu_name, stu_birDate, stu_gender);
                        break;
                    case 2: // -- Find：按照姓名查询，判断是否存在
                        System.out.println("请输入学生姓名: ");
                        String Find_Name = in.next();
                        Find_Student(Find_Name);
                        break;
                    case 3: // -- Delete：删除制定姓名的学生
                        System.out.println("请输入学生姓名: ");
                        Del_Student(in.next());
                        break;
                    case 4: // -- Modify：修改制定姓名学生的生日
                        System.out.println("请输入学生姓名, 年, 月, 日 ");
                        String name = in.next();
                        int year = in.nextInt();
                        int month = in.nextInt();
                        int day = in.nextInt();
                        Modify_Studen(name, year, month, day);
                        break;
                    case 5: // -- Output：输出所有学生的信息
                        Print_Student();
                        break;
                    case 6: // -- Quit
                        is_quit = true;
                        break;
                    default: // -- 输入有误则抛出异常
                        throw new Exception();
                }
                if(is_quit) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect operation input! Please input again!");
                in.nextLine();
            }
        }
        in.close();
    }
}