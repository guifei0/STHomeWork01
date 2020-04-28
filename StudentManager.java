import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // �洢����ѧ����Ϣ��List: ID, Name, Birthday, Gender
    private List<Student> stu = new ArrayList<Student>();
    StudentManager() { // ��ʼ�����List, û��ѧ��
        stu.clear();
    }
    public int Get_Student_sum() { return stu.size(); } // ��ȡ��ǰ��ѧ������
    // -- ����һ��ѧ������Ϣ
    // ������ѧ��ID��ѧ������Name��ѧ������xxxx.xx.xx���Ա�(true-man, false-woman)
    void Insert_Student(int stu_id, String stu_name, 
            String stu_birDate, boolean stu_gender) throws Exception {
        if(stu_birDate.length() != 10) throw new Exception();   // �ж������Ƿ�Ϸ���������մ����Ȳ���10��˵������������
        else {
            // ���������е�ÿ���ַ���ֻ���±�4��7��λ����., �����Ķ�����., ���������������������
            for(int i = 0;i < stu_birDate.length();++i) {
                if((i == 4 || i == 7) && stu_birDate.charAt(i) != '.')
                    throw new Exception();
                if(i != 4 && i != 7 && stu_birDate.charAt(i) == '.')
                    throw new Exception();
            }
        }
        // �Ϸ����룬ʵ����һ��Student��¼�¼���ѧ������Ϣ
        Student add_Student = new Student(stu_id, stu_name, stu_birDate, stu_gender);
        // add_Index��ʾ�����λ�ã���ʼλ����Ϊ����ĩβ�հ�λ��
        // ��ʼ��Ϊ����ĩβ�ĺô��ǲ��ô���߽���գ�Ҳ���ǲ������ֵ�������е�����ѧ����ID����
        // �������뼴�ɱ�֤��������������ö������Ż�����Ϊ��������С����˲���ֱ�ӱ����ķ���
        int add_Index = stu.size();
        for(int i = 0;i < stu.size();++i) {
            Student t = stu.get(i);
            if(add_Student.Get_ID() < t.Get_ID()) { // ��ѯ����һ������Ҫ����Ԫ�ص�ֵ��¼���λ�õ�add_Index��Ȼ����������
                add_Index = i;
                break;
            }
        }
        stu.add(add_Index, add_Student);    // ��Ԫ�ز��뵽��Ҫ�����Ԫ��֮ǰ
        System.out.println("Insert successfully!");
    }
    // -- ������е�ѧ����Ϣ��ÿ��ѧ����Ϣռһ��
    public void Print_Student() {
        if(stu.size() == 0) System.out.println("No students!"); // �����ǰû��ѧ�������No students!
        else {
            // ����List��������ѧ������Ϣ���
            for(Student res : stu) {
                System.out.println("ID: " + res.Get_ID() + ", Name: " + 
                    res.Get_name() + ", Birthday: " + res.Get_birDate() + 
                    ", Gender: " + res.Get_gender());
            }
        }
    }
    // -- ������������
    public void Find_Student(String name) {
        boolean flg = false;    // flg = true��ʾ����Ϊname��ѧ���Ǵ��ڵģ���֮Ϊfalse��ʾ������
        for(Student res : stu) {
            if(name.equals(res.Get_name())) {
                flg = true;
                break;
            }
        }
        if(flg) System.out.println("Query successful");
        else System.out.println("Query failed");
    }
    // -- ɾ�����ܣ���������ɾ��
    public void Del_Student(String name) {
        Iterator<Student> it = stu.iterator();  // ��������������ѧ��List
        while(it.hasNext()) {
            Student t_student = it.next();
            if(t_student.Get_name().equals(name)) it.remove();  // �����������Ҫɾ����ѧ��(����)����ɾ��
        }
        System.out.println("successfully deleted");
    }
    // -- �޸Ĺ��ܣ������������Һ��޸��������Ϣ
    public void Modify_Studen(String name, int year, int month, int day) {
        Iterator<Student > it = stu.iterator();
        while(it.hasNext()) {
            Student t = it.next();
            if(t.Get_name().equals(name)) t.Set_birDate(year, month, day);  // �����������Ҫ�޸ĵ�ѧ��(����ƥ����)�������Set_birDate�޸�����
        }
        System.out.println("Successfully modified");
    }
    // -- �˵�ѡ��
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
    // -- ��������
    public void App() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                Get_Menu(); // �����˵�
                int op = in.nextInt();  // �������op��ʾ���ĸ�����
                boolean is_quit = false; // �Ƿ�Ҫ�˳�����
                in.nextLine(); // �����ͬʱ��ջ�����������û���������
                switch (op) {
                    case 1: // -- Insert������ѧ��
                        System.out.println("������ѧ����id, ����, ����(��.��.����ʽ��ex: 1999.01.01), �Ա�(man, woman): ");
                        int stu_id = in.nextInt();  // ����ѧ����ID
                        String stu_name = in.next();    // ����ѧ��������
                        String stu_birDate = in.next(); // ����ѧ��������
                        boolean stu_gender;
                        String gender = in.next();
                        // ����ѧ�����Ա������Ϊman����woman�����쳣��������
                        if(gender.equals("man")) stu_gender = true;
                        else if(gender.equals("woman")) stu_gender = false;
                        else throw new Exception();
                        // ���������������ѧ�����뺯������ѧ����Ϣ��¼����
                        Insert_Student(stu_id, stu_name, stu_birDate, stu_gender);
                        break;
                    case 2: // -- Find������������ѯ���ж��Ƿ����
                        System.out.println("������ѧ������: ");
                        String Find_Name = in.next();
                        Find_Student(Find_Name);
                        break;
                    case 3: // -- Delete��ɾ���ƶ�������ѧ��
                        System.out.println("������ѧ������: ");
                        Del_Student(in.next());
                        break;
                    case 4: // -- Modify���޸��ƶ�����ѧ��������
                        System.out.println("������ѧ������, ��, ��, �� ");
                        String name = in.next();
                        int year = in.nextInt();
                        int month = in.nextInt();
                        int day = in.nextInt();
                        Modify_Studen(name, year, month, day);
                        break;
                    case 5: // -- Output���������ѧ������Ϣ
                        Print_Student();
                        break;
                    case 6: // -- Quit
                        is_quit = true;
                        break;
                    default: // -- �����������׳��쳣
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