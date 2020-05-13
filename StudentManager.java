import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // 存储所有学生信息的List: ID, Name, Birthday, Gender
    // private List<Student> stu = new ArrayList<Student>(); - 1.1
    private List<Student> stuList = new ArrayList<Student>();
    StudentManager() { // 初始化清空List, 没有学生
        stuList.clear();
    } 
    // public int Get_Student_sum() { return stuList.size(); } // 获取当前的学生数量 - 1.1
    // 2.5: 无输入，返回学生的数量总数int
    public int getStudentSum() { return stuList.size(); } // 获取当前的学生数量
    // -- 插入一名学生的信息 - 1.1
    // 参数：学生ID，学生姓名Name，学生生日xxxx.xx.xx，性别(true-man, false-woman)
    // void Insert_Student(int stu_id, String stu_name, 
    //         String stu_birDate, boolean stu_gender) throws Exception {
    //     if(stu_birDate.length() != 10) throw new Exception();   // 判断输入是否合法，如果生日串长度不是10，说明是输入有误
    //     else {
    //         // 对于生日中的每个字符，只有下标4和7的位置是., 其他的都不是., 如果不是这样则输入有误
    //         for(int i = 0;i < stu_birDate.length();++i) {
    //             if((i == 4 || i == 7) && stu_birDate.charAt(i) != '.')
    //                 throw new Exception();
    //             if(i != 4 && i != 7 && stu_birDate.charAt(i) == '.')
    //                 throw new Exception();
    //         }
    //     }
    //     // 合法输入，实例化一个Student记录新加入学生的信息
    //     Student add_Student = new Student(stu_id, stu_name, stu_birDate, stu_gender);
    //     // add_Index表示插入的位置，初始位置设为序列末尾空白位置
    //     // 初始化为序列末尾的好处是不用处理边界清空，也就是插入的数值比序列中的所有学生的ID都大
    //     // 这样插入即可保证递增，插入可以用二分来优化，因为数据量很小，因此采用直接遍历的方法
    //     int add_Index = stu.size();
    //     for(int i = 0;i < stu.size();++i) {
    //         Student t = stu.get(i);
    //         if(add_Student.Get_ID() < t.Get_ID()) { // 查询到第一个大于要插入元素的值记录这个位置到add_Index中然后跳出遍历
    //             add_Index = i;
    //             break;
    //         }
    //     }
    //     stu.add(add_Index, add_Student);    // 将元素插入到需要插入的元素之前
    //     System.out.println("Insert successfully!");
    // }
    // 2.5: 输入学生的stuId和学生的名字StuName, 以及学生生日stuBriDate和学生性别stuGender，无返回
    // 3.5: if () for (a; b; c) { } while () { }
    public void insertStudent(int stuId, String stuName, 
            String stuBirDate, boolean stuGender) throws Exception {
        // 4.2: 单个的循环, 条件语句也加{ }
        // 4.3: if-else, switch-case格式
        // 5.11: 判断使用了(常量 == 变量)的形式
        if (10 != stuBirDate.length()) {
            throw new Exception();   // 判断输入是否合法，如果生日串长度不是10，说明是输入有误
        } else {
            // 对于生日中的每个字符，只有下标4和7的位置是., 其他的都不是., 如果不是这样则输入有误
            for (int i = 0; i < stuBirDate.length(); ++i) {
                // 4.2: 单个的循环, 条件语句也加{ }
                // 5.10: 用()使操作符优先级明确化
                // 5.11: 判断使用了(常量 == 变量)的形式
                if (((4 == i) || (7 == i)) && ('.' != stuBirDate.charAt(i))) {
                    throw new Exception();
                }    
                if (((4 != i) && (7 != i)) && ('.' == stuBirDate.charAt(i))) {
                    throw new Exception();
                }
            }
        }
        // 合法输入，实例化一个Student记录新加入学生的信息
        Student addStudent = new Student(stuId, stuName, stuBirDate, stuGender);
        // add_Index表示插入的位置，初始位置设为序列末尾空白位置
        // 初始化为序列末尾的好处是不用处理边界清空，也就是插入的数值比序列中的所有学生的ID都大
        // 这样插入即可保证递增，插入可以用二分来优化，因为数据量很小，因此采用直接遍历的方法
        int addIndex = stuList.size();
        for (int i = 0; i < stuList.size(); ++i) {
            Student t = stuList.get(i);
            if(addStudent.getId() < t.getId()) { // 查询到第一个大于要插入元素的值记录这个位置到add_Index中然后跳出遍历
                addIndex = i;
                break;
            }
        }
        stuList.add(addIndex, addStudent);    // 将元素插入到需要插入的元素之前
        System.out.println("Insert successfully!");
    }
    // -- 输出所有的学生信息，每个学生信息占一行 - 1.1
    // public void Print_Student() {
    //     if(stu.size() == 0) System.out.println("No students!"); // 如果当前没有学生，输出No students!
    //     else {
    //         // 遍历List，将所有学生的信息输出
    //         for(Student res : stu) {
    //             System.out.println("ID: " + res.Get_ID() + ", Name: " + 
    //                 res.Get_name() + ", Birthday: " + res.Get_birDate() + 
    //                 ", Gender: " + res.Get_gender());
    //         }
    //     }
    // }
    // 2.5: 输出所有的学生，无输入，无返回，输出形式：ID: xx, Name: xxx, Birthday: xxx,  Gender: xxx
    // 3.5: if () { } else { } for (a; b; c) { } while () { } 
    public void printStudent() {
        // 4.2: 单个的循环, 条件语句也加{ }
        // 4.3: if-else, switch-case格式
        // 5.11: 判断使用了(常量 == 变量)的形式
        if (0 == stuList.size()) {
            System.out.println("No students!"); // 如果当前没有学生，输出No students!
        } else {
            // 遍历List，将所有学生的信息输出
            for (Student res : stuList) {
                System.out.println("ID: " + res.getId() + ", Name: " + 
                    res.getName() + ", Birthday: " + res.getBirDate() + 
                    ", Gender: " + res.getGender());
            }
        }
    }
    // -- 按照姓名查找 - 1.1
    // public void Find_Student(String name) {
    //     boolean flg = false;    // flg = true表示姓名为name的学生是存在的，反之为false表示不存在
    //     for(Student res : stu) {
    //         if(name.equals(res.Get_name())) {
    //             flg = true;
    //             break;
    //         }
    //     }
    //     if(flg) System.out.println("Query successful");
    //     else System.out.println("Query failed");
    // }
    // 2.5: 按照姓名查找学生，输入学生姓名String, 无返回
    // 3.5: if () for (a; b; c) { } while () { }
    public void findStudent(String name) {
        boolean flg = false;    // flg = true表示姓名为name的学生是存在的，反之为false表示不存在
        for (Student res : stuList) {
            if (name.equals(res.getName())) {
                flg = true;
                break;
            }
        }
        // 4.2: 单个的循环, 条件语句也加{ }
        if(flg) {
            System.out.println("Query successful");
        } else {
            System.out.println("Query failed");
        }
    }
    // -- 删除功能，按照姓名删除 - 1.1
    // public void Del_Student(String name) {
    //     Iterator<Student> it = stu.iterator();  // 创建迭代器遍历学生List
    //     while(it.hasNext()) {
    //         Student t_student = it.next();
    //         if(t_student.Get_name().equals(name)) it.remove();  // 如果遍历到需要删除的学生(名字)，则删除
    //     }
    //     System.out.println("successfully deleted");
    // }
    // 2.5: delStudent: 输入String类型表示名字，无返回，含义：删除指定名字的学生
    // 3.5: if () for (a; b; c) { } while () { }
    public void delStudent(String name) {
        Iterator<Student> stuListIter = stuList.iterator();  // 创建迭代器遍历学生List
        while (stuListIter.hasNext()) {
            Student tStudent = stuListIter.next();
            // 4.2: 单个的循环, 条件语句也加{ }
            if (tStudent.getName().equals(name)) {
                stuListIter.remove();  // 如果遍历到需要删除的学生(名字)，则删除
            }
        }
        System.out.println("successfully deleted");
    }
    // -- 修改功能，按照姓名查找后修改年龄等信息 - 1.1
    // 2.5: 
    // public void Modify_Studen(String name, int year, int month, int day) {
    //     Iterator<Student > it = stu.iterator();
    //     while(it.hasNext()) {
    //         Student t = it.next();
    //         if(t.Get_name().equals(name)) t.Set_birDate(year, month, day);  // 如果遍历到需要修改的学生(名字匹配了)，则调用Set_birDate修改生日
    //     }
    //     System.out.println("Successfully modified");
    // }
    // 2.5: 修改学生的生日，输入学生的姓名String，初始年int，月int，日int，无返回值
    // 3.5: if () for (a; b; c) { } while () { }
    public void modifyStuden(String name, int year, int month, int day) {
        Iterator<Student > it = stuList.iterator();
        while (it.hasNext()) {
            Student t = it.next();
            // 4.2: 单个的循环, 条件语句也加{ }
            if (t.getName().equals(name)) {
                t.setBirDate(year, month, day);  // 如果遍历到需要修改的学生(名字匹配了)，则调用Set_birDate修改生日
            }
        }
        System.out.println("Successfully modified");
    }
    // -- 菜单选项 - 1.1
    // public void Get_Menu() {
    //     System.out.println("Please select an operation: ");
    //     System.out.println("**********************************");
    //     System.out.println("*            1.Insert            *");
    //     System.out.println("*            2.Find              *");
    //     System.out.println("*            3.Delete            *");
    //     System.out.println("*            4.Modify            *");
    //     System.out.println("*            5.Output            *");
    //     System.out.println("*            6.Quit              *");
    //     System.out.println("**********************************");
    // }
    // 2.5: 获取操作的菜单，无输入，无返回 
    public void getMenu() {
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
    // -- 控制流程 - 1.1
    // public void App() {
    //     Scanner in = new Scanner(System.in);
    //     while(true) {
    //         try {
    //             Get_Menu(); // 创建菜单
    //             int op = in.nextInt();  // 读入操作op表示做哪个操作
    //             boolean is_quit = false; // 是否要退出程序
    //             in.nextLine(); // 输入后同时清空缓冲区，清除用户多余输入
    //             switch (op) {
    //                 case 1: // -- Insert：插入学生
    //                     System.out.println("请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): ");
    //                     int stu_id = in.nextInt();  // 读入学生的ID
    //                     String stu_name = in.next();    // 读入学生的姓名
    //                     String stu_birDate = in.next(); // 读入学生的生日
    //                     boolean stu_gender;
    //                     String gender = in.next();
    //                     // 读入学生的性别，如果不为man或者woman则抛异常重新输入
    //                     if(gender.equals("man")) stu_gender = true;
    //                     else if(gender.equals("woman")) stu_gender = false;
    //                     else throw new Exception();
    //                     // 如果输入合理，则调用学生插入函数，将学生信息记录下来
    //                     Insert_Student(stu_id, stu_name, stu_birDate, stu_gender);
    //                     break;
    //                 case 2: // -- Find：按照姓名查询，判断是否存在
    //                     System.out.println("请输入学生姓名: ");
    //                     String Find_Name = in.next();
    //                     Find_Student(Find_Name);
    //                     break;
    //                 case 3: // -- Delete：删除制定姓名的学生
    //                     System.out.println("请输入学生姓名: ");
    //                     Del_Student(in.next());
    //                     break;
    //                 case 4: // -- Modify：修改制定姓名学生的生日
    //                     System.out.println("请输入学生姓名, 年, 月, 日 ");
    //                     String name = in.next();
    //                     int year = in.nextInt();
    //                     int month = in.nextInt();
    //                     int day = in.nextInt();
    //                     Modify_Studen(name, year, month, day);
    //                     break;
    //                 case 5: // -- Output：输出所有学生的信息
    //                     Print_Student();
    //                     break;
    //                 case 6: // -- Quit
    //                     is_quit = true;
    //                     break;
    //                 default: // -- 输入有误则抛出异常
    //                     throw new Exception();
    //             }
    //             if(is_quit) {
    //                 System.out.println("Goodbye!");
    //                 break;
    //             }
    //         } catch (Exception e) {
    //             System.out.println("Incorrect operation input! Please input again!");
    //             in.nextLine();
    //         }
    //     }
    //     in.close();
    // }
    // 2.5: 运行程序的函数，无输入，无返回
    // 3.5: if () for (a; b; c) { } while () { }
    public void App() {
        // Scanner in = new Scanner(System.in);  // - 1.1
        Scanner inScanner = new Scanner(System.in);
        while (true) {
            try {
                getMenu(); // 创建菜单
                int op = inScanner.nextInt();  // 读入操作op表示做哪个操作
                boolean isQuit = false; // 是否要退出程序
                inScanner.nextLine(); // 输入后同时清空缓冲区，清除用户多余输入
                // 4.3: if-else, switch-case格式
                switch (op) {
                    /* 2.2 - switch分支
                     * case 1: 插入学生
                     * case 2: 按照姓名查询，判断此学生是否存在
                     * case 3: 删除指定姓名的学生
                     * case 4: 修改指定姓名学生的生日
                     * case 5: 输出所有学生的信息
                     * case 6: 退出程序
                     * default: 输入错误，抛出异常，使得用户重新输入
                     * */
                    case 1: // -- Insert：插入学生
                        System.out.println("请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): ");
                        int stuId = inScanner.nextInt();  // 读入学生的ID
                        String stuName = inScanner.next();    // 读入学生的姓名
                        String stuBirDate = inScanner.next(); // 读入学生的生日
                        boolean stuGender;
                        String gender = inScanner.next();
                        // 读入学生的性别，如果不为man或者woman则抛异常重新输入
                        // 4.2: 单个的循环, 条件语句也加{ }
                        if (gender.equals("man")) {
                            stuGender = true;
                        } else if (gender.equals("woman")) {
                            stuGender = false;
                        } else {
                            throw new Exception();
                        }
                        // 如果输入合理，则调用学生插入函数，将学生信息记录下来
                        insertStudent(stuId, stuName, stuBirDate, stuGender);
                        break;
                    case 2: // -- Find：按照姓名查询，判断是否存在
                        System.out.println("请输入学生姓名: ");
                        String findName = inScanner.next();
                        findStudent(findName);
                        break;
                    case 3: // -- Delete：删除指定姓名的学生
                        System.out.println("请输入学生姓名: ");
                        delStudent(inScanner.next());
                        break;
                    case 4: // -- Modify：修改指定姓名学生的生日
                        System.out.println("请输入学生姓名, 年, 月, 日 ");
                        String name = inScanner.next();
                        int year = inScanner.nextInt();
                        int month = inScanner.nextInt();
                        int day = inScanner.nextInt();
                        modifyStuden(name, year, month, day);
                        break;
                    case 5: // -- Output：输出所有学生的信息
                        printStudent();
                        break;
                    case 6: // -- Quit
                    isQuit = true;
                        break;
                    default: // -- 输入有误则抛出异常
                        throw new Exception();
                }
                // 2.1: 如果isQuit = true则说明用户想退出程序，输入Goodbye并且跳出循环
                if(isQuit) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                // 2.1: 如果出现异常，说明用户输入错误，此时给出提醒，并且引导用户重新输入
                System.out.println("Incorrect operation input! Please input again!");
                // 2.1: 清除用户的多余输入
                inScanner.nextLine();
            }
        }
        inScanner.close();
    }
}