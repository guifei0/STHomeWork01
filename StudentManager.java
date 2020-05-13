import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // �洢����ѧ����Ϣ��List: ID, Name, Birthday, Gender
    // private List<Student> stu = new ArrayList<Student>(); - 1.1
    private List<Student> stuList = new ArrayList<Student>();
    StudentManager() { // ��ʼ�����List, û��ѧ��
        stuList.clear();
    } 
    // public int Get_Student_sum() { return stuList.size(); } // ��ȡ��ǰ��ѧ������ - 1.1
    // 2.5: �����룬����ѧ������������int
    public int getStudentSum() { return stuList.size(); } // ��ȡ��ǰ��ѧ������
    // -- ����һ��ѧ������Ϣ - 1.1
    // ������ѧ��ID��ѧ������Name��ѧ������xxxx.xx.xx���Ա�(true-man, false-woman)
    // void Insert_Student(int stu_id, String stu_name, 
    //         String stu_birDate, boolean stu_gender) throws Exception {
    //     if(stu_birDate.length() != 10) throw new Exception();   // �ж������Ƿ�Ϸ���������մ����Ȳ���10��˵������������
    //     else {
    //         // ���������е�ÿ���ַ���ֻ���±�4��7��λ����., �����Ķ�����., ���������������������
    //         for(int i = 0;i < stu_birDate.length();++i) {
    //             if((i == 4 || i == 7) && stu_birDate.charAt(i) != '.')
    //                 throw new Exception();
    //             if(i != 4 && i != 7 && stu_birDate.charAt(i) == '.')
    //                 throw new Exception();
    //         }
    //     }
    //     // �Ϸ����룬ʵ����һ��Student��¼�¼���ѧ������Ϣ
    //     Student add_Student = new Student(stu_id, stu_name, stu_birDate, stu_gender);
    //     // add_Index��ʾ�����λ�ã���ʼλ����Ϊ����ĩβ�հ�λ��
    //     // ��ʼ��Ϊ����ĩβ�ĺô��ǲ��ô���߽���գ�Ҳ���ǲ������ֵ�������е�����ѧ����ID����
    //     // �������뼴�ɱ�֤��������������ö������Ż�����Ϊ��������С����˲���ֱ�ӱ����ķ���
    //     int add_Index = stu.size();
    //     for(int i = 0;i < stu.size();++i) {
    //         Student t = stu.get(i);
    //         if(add_Student.Get_ID() < t.Get_ID()) { // ��ѯ����һ������Ҫ����Ԫ�ص�ֵ��¼���λ�õ�add_Index��Ȼ����������
    //             add_Index = i;
    //             break;
    //         }
    //     }
    //     stu.add(add_Index, add_Student);    // ��Ԫ�ز��뵽��Ҫ�����Ԫ��֮ǰ
    //     System.out.println("Insert successfully!");
    // }
    // 2.5: ����ѧ����stuId��ѧ��������StuName, �Լ�ѧ������stuBriDate��ѧ���Ա�stuGender���޷���
    // 3.5: if () for (a; b; c) { } while () { }
    public void insertStudent(int stuId, String stuName, 
            String stuBirDate, boolean stuGender) throws Exception {
        // 4.2: ������ѭ��, �������Ҳ��{ }
        // 4.3: if-else, switch-case��ʽ
        // 5.11: �ж�ʹ����(���� == ����)����ʽ
        if (10 != stuBirDate.length()) {
            throw new Exception();   // �ж������Ƿ�Ϸ���������մ����Ȳ���10��˵������������
        } else {
            // ���������е�ÿ���ַ���ֻ���±�4��7��λ����., �����Ķ�����., ���������������������
            for (int i = 0; i < stuBirDate.length(); ++i) {
                // 4.2: ������ѭ��, �������Ҳ��{ }
                // 5.10: ��()ʹ���������ȼ���ȷ��
                // 5.11: �ж�ʹ����(���� == ����)����ʽ
                if (((4 == i) || (7 == i)) && ('.' != stuBirDate.charAt(i))) {
                    throw new Exception();
                }    
                if (((4 != i) && (7 != i)) && ('.' == stuBirDate.charAt(i))) {
                    throw new Exception();
                }
            }
        }
        // �Ϸ����룬ʵ����һ��Student��¼�¼���ѧ������Ϣ
        Student addStudent = new Student(stuId, stuName, stuBirDate, stuGender);
        // add_Index��ʾ�����λ�ã���ʼλ����Ϊ����ĩβ�հ�λ��
        // ��ʼ��Ϊ����ĩβ�ĺô��ǲ��ô���߽���գ�Ҳ���ǲ������ֵ�������е�����ѧ����ID����
        // �������뼴�ɱ�֤��������������ö������Ż�����Ϊ��������С����˲���ֱ�ӱ����ķ���
        int addIndex = stuList.size();
        for (int i = 0; i < stuList.size(); ++i) {
            Student t = stuList.get(i);
            if(addStudent.getId() < t.getId()) { // ��ѯ����һ������Ҫ����Ԫ�ص�ֵ��¼���λ�õ�add_Index��Ȼ����������
                addIndex = i;
                break;
            }
        }
        stuList.add(addIndex, addStudent);    // ��Ԫ�ز��뵽��Ҫ�����Ԫ��֮ǰ
        System.out.println("Insert successfully!");
    }
    // -- ������е�ѧ����Ϣ��ÿ��ѧ����Ϣռһ�� - 1.1
    // public void Print_Student() {
    //     if(stu.size() == 0) System.out.println("No students!"); // �����ǰû��ѧ�������No students!
    //     else {
    //         // ����List��������ѧ������Ϣ���
    //         for(Student res : stu) {
    //             System.out.println("ID: " + res.Get_ID() + ", Name: " + 
    //                 res.Get_name() + ", Birthday: " + res.Get_birDate() + 
    //                 ", Gender: " + res.Get_gender());
    //         }
    //     }
    // }
    // 2.5: ������е�ѧ���������룬�޷��أ������ʽ��ID: xx, Name: xxx, Birthday: xxx,  Gender: xxx
    // 3.5: if () { } else { } for (a; b; c) { } while () { } 
    public void printStudent() {
        // 4.2: ������ѭ��, �������Ҳ��{ }
        // 4.3: if-else, switch-case��ʽ
        // 5.11: �ж�ʹ����(���� == ����)����ʽ
        if (0 == stuList.size()) {
            System.out.println("No students!"); // �����ǰû��ѧ�������No students!
        } else {
            // ����List��������ѧ������Ϣ���
            for (Student res : stuList) {
                System.out.println("ID: " + res.getId() + ", Name: " + 
                    res.getName() + ", Birthday: " + res.getBirDate() + 
                    ", Gender: " + res.getGender());
            }
        }
    }
    // -- ������������ - 1.1
    // public void Find_Student(String name) {
    //     boolean flg = false;    // flg = true��ʾ����Ϊname��ѧ���Ǵ��ڵģ���֮Ϊfalse��ʾ������
    //     for(Student res : stu) {
    //         if(name.equals(res.Get_name())) {
    //             flg = true;
    //             break;
    //         }
    //     }
    //     if(flg) System.out.println("Query successful");
    //     else System.out.println("Query failed");
    // }
    // 2.5: ������������ѧ��������ѧ������String, �޷���
    // 3.5: if () for (a; b; c) { } while () { }
    public void findStudent(String name) {
        boolean flg = false;    // flg = true��ʾ����Ϊname��ѧ���Ǵ��ڵģ���֮Ϊfalse��ʾ������
        for (Student res : stuList) {
            if (name.equals(res.getName())) {
                flg = true;
                break;
            }
        }
        // 4.2: ������ѭ��, �������Ҳ��{ }
        if(flg) {
            System.out.println("Query successful");
        } else {
            System.out.println("Query failed");
        }
    }
    // -- ɾ�����ܣ���������ɾ�� - 1.1
    // public void Del_Student(String name) {
    //     Iterator<Student> it = stu.iterator();  // ��������������ѧ��List
    //     while(it.hasNext()) {
    //         Student t_student = it.next();
    //         if(t_student.Get_name().equals(name)) it.remove();  // �����������Ҫɾ����ѧ��(����)����ɾ��
    //     }
    //     System.out.println("successfully deleted");
    // }
    // 2.5: delStudent: ����String���ͱ�ʾ���֣��޷��أ����壺ɾ��ָ�����ֵ�ѧ��
    // 3.5: if () for (a; b; c) { } while () { }
    public void delStudent(String name) {
        Iterator<Student> stuListIter = stuList.iterator();  // ��������������ѧ��List
        while (stuListIter.hasNext()) {
            Student tStudent = stuListIter.next();
            // 4.2: ������ѭ��, �������Ҳ��{ }
            if (tStudent.getName().equals(name)) {
                stuListIter.remove();  // �����������Ҫɾ����ѧ��(����)����ɾ��
            }
        }
        System.out.println("successfully deleted");
    }
    // -- �޸Ĺ��ܣ������������Һ��޸��������Ϣ - 1.1
    // 2.5: 
    // public void Modify_Studen(String name, int year, int month, int day) {
    //     Iterator<Student > it = stu.iterator();
    //     while(it.hasNext()) {
    //         Student t = it.next();
    //         if(t.Get_name().equals(name)) t.Set_birDate(year, month, day);  // �����������Ҫ�޸ĵ�ѧ��(����ƥ����)�������Set_birDate�޸�����
    //     }
    //     System.out.println("Successfully modified");
    // }
    // 2.5: �޸�ѧ�������գ�����ѧ��������String����ʼ��int����int����int���޷���ֵ
    // 3.5: if () for (a; b; c) { } while () { }
    public void modifyStuden(String name, int year, int month, int day) {
        Iterator<Student > it = stuList.iterator();
        while (it.hasNext()) {
            Student t = it.next();
            // 4.2: ������ѭ��, �������Ҳ��{ }
            if (t.getName().equals(name)) {
                t.setBirDate(year, month, day);  // �����������Ҫ�޸ĵ�ѧ��(����ƥ����)�������Set_birDate�޸�����
            }
        }
        System.out.println("Successfully modified");
    }
    // -- �˵�ѡ�� - 1.1
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
    // 2.5: ��ȡ�����Ĳ˵��������룬�޷��� 
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
    // -- �������� - 1.1
    // public void App() {
    //     Scanner in = new Scanner(System.in);
    //     while(true) {
    //         try {
    //             Get_Menu(); // �����˵�
    //             int op = in.nextInt();  // �������op��ʾ���ĸ�����
    //             boolean is_quit = false; // �Ƿ�Ҫ�˳�����
    //             in.nextLine(); // �����ͬʱ��ջ�����������û���������
    //             switch (op) {
    //                 case 1: // -- Insert������ѧ��
    //                     System.out.println("������ѧ����id, ����, ����(��.��.����ʽ��ex: 1999.01.01), �Ա�(man, woman): ");
    //                     int stu_id = in.nextInt();  // ����ѧ����ID
    //                     String stu_name = in.next();    // ����ѧ��������
    //                     String stu_birDate = in.next(); // ����ѧ��������
    //                     boolean stu_gender;
    //                     String gender = in.next();
    //                     // ����ѧ�����Ա������Ϊman����woman�����쳣��������
    //                     if(gender.equals("man")) stu_gender = true;
    //                     else if(gender.equals("woman")) stu_gender = false;
    //                     else throw new Exception();
    //                     // ���������������ѧ�����뺯������ѧ����Ϣ��¼����
    //                     Insert_Student(stu_id, stu_name, stu_birDate, stu_gender);
    //                     break;
    //                 case 2: // -- Find������������ѯ���ж��Ƿ����
    //                     System.out.println("������ѧ������: ");
    //                     String Find_Name = in.next();
    //                     Find_Student(Find_Name);
    //                     break;
    //                 case 3: // -- Delete��ɾ���ƶ�������ѧ��
    //                     System.out.println("������ѧ������: ");
    //                     Del_Student(in.next());
    //                     break;
    //                 case 4: // -- Modify���޸��ƶ�����ѧ��������
    //                     System.out.println("������ѧ������, ��, ��, �� ");
    //                     String name = in.next();
    //                     int year = in.nextInt();
    //                     int month = in.nextInt();
    //                     int day = in.nextInt();
    //                     Modify_Studen(name, year, month, day);
    //                     break;
    //                 case 5: // -- Output���������ѧ������Ϣ
    //                     Print_Student();
    //                     break;
    //                 case 6: // -- Quit
    //                     is_quit = true;
    //                     break;
    //                 default: // -- �����������׳��쳣
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
    // 2.5: ���г���ĺ����������룬�޷���
    // 3.5: if () for (a; b; c) { } while () { }
    public void App() {
        // Scanner in = new Scanner(System.in);  // - 1.1
        Scanner inScanner = new Scanner(System.in);
        while (true) {
            try {
                getMenu(); // �����˵�
                int op = inScanner.nextInt();  // �������op��ʾ���ĸ�����
                boolean isQuit = false; // �Ƿ�Ҫ�˳�����
                inScanner.nextLine(); // �����ͬʱ��ջ�����������û���������
                // 4.3: if-else, switch-case��ʽ
                switch (op) {
                    /* 2.2 - switch��֧
                     * case 1: ����ѧ��
                     * case 2: ����������ѯ���жϴ�ѧ���Ƿ����
                     * case 3: ɾ��ָ��������ѧ��
                     * case 4: �޸�ָ������ѧ��������
                     * case 5: �������ѧ������Ϣ
                     * case 6: �˳�����
                     * default: ��������׳��쳣��ʹ���û���������
                     * */
                    case 1: // -- Insert������ѧ��
                        System.out.println("������ѧ����id, ����, ����(��.��.����ʽ��ex: 1999.01.01), �Ա�(man, woman): ");
                        int stuId = inScanner.nextInt();  // ����ѧ����ID
                        String stuName = inScanner.next();    // ����ѧ��������
                        String stuBirDate = inScanner.next(); // ����ѧ��������
                        boolean stuGender;
                        String gender = inScanner.next();
                        // ����ѧ�����Ա������Ϊman����woman�����쳣��������
                        // 4.2: ������ѭ��, �������Ҳ��{ }
                        if (gender.equals("man")) {
                            stuGender = true;
                        } else if (gender.equals("woman")) {
                            stuGender = false;
                        } else {
                            throw new Exception();
                        }
                        // ���������������ѧ�����뺯������ѧ����Ϣ��¼����
                        insertStudent(stuId, stuName, stuBirDate, stuGender);
                        break;
                    case 2: // -- Find������������ѯ���ж��Ƿ����
                        System.out.println("������ѧ������: ");
                        String findName = inScanner.next();
                        findStudent(findName);
                        break;
                    case 3: // -- Delete��ɾ��ָ��������ѧ��
                        System.out.println("������ѧ������: ");
                        delStudent(inScanner.next());
                        break;
                    case 4: // -- Modify���޸�ָ������ѧ��������
                        System.out.println("������ѧ������, ��, ��, �� ");
                        String name = inScanner.next();
                        int year = inScanner.nextInt();
                        int month = inScanner.nextInt();
                        int day = inScanner.nextInt();
                        modifyStuden(name, year, month, day);
                        break;
                    case 5: // -- Output���������ѧ������Ϣ
                        printStudent();
                        break;
                    case 6: // -- Quit
                    isQuit = true;
                        break;
                    default: // -- �����������׳��쳣
                        throw new Exception();
                }
                // 2.1: ���isQuit = true��˵���û����˳���������Goodbye��������ѭ��
                if(isQuit) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                // 2.1: ��������쳣��˵���û�������󣬴�ʱ�������ѣ����������û���������
                System.out.println("Incorrect operation input! Please input again!");
                // 2.1: ����û��Ķ�������
                inScanner.nextLine();
            }
        }
        inScanner.close();
    }
}