
public class Student {
    // private int ID;         // ѧ����ID - 1.1
    private int stuId;         // ѧ����ID
    // private String name;    // ѧ�������� - 1.1
    private String stuName;    // ѧ��������
    // private String birDate; // ѧ��������: year.month.day - 1.1
    private String stuBirDate; // ѧ��������: year.month.day
    // private boolean gender; // ѧ�����Ա�: man: true, woman: false - 1.1
    private boolean stuGender; // ѧ�����Ա�: man: true, woman: false
    // ���캯����Ĭ�ϳ�ʼ����ʽ
    Student() {
        stuId = -1;
        stuName = "";
        stuBirDate = "";
        stuGender = false;        
    }
    // ����ѧ����Ϣ���й���ѧ������
    // stu_id��ID, stu_name��Name, stu_birDate��birthday, stu_gender���Ա�
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
    // public int Get_ID() { return ID; }  // ��ȡѧ����ID - 1.1
    public int getId() { return stuId; }  // ��ȡѧ����ID
    // public void Set_ID(int xc_ID) { ID = xc_ID; }   // �޸�ѧ����IDΪxc_ID - 1.1
    public void setId(int stuId) { this.stuId = stuId; }   // �޸�ѧ����IDΪxc_ID
    // public String Get_name() { return stuName; }   // ��ȡѧ�������� - 1.1
    public String getName() { return stuName; }   // ��ȡѧ��������
    // public void Set_name(String xc_name) { stuName = xc_name; }    // �޸�ѧ��������Ϊxc_name - 1.1
    public void setName(String stuName) { this.stuName = stuName; }    // �޸�ѧ��������Ϊxc_name
    // public String Get_birDate() { return stuBirDate; } // ��ȡѧ�������� - 1.1
    public String getBirDate() { return stuBirDate; } // ��ȡѧ��������
    // public void Set_birDate(int year, int month, int day) { stuBirDate = year + "." + month + "." + day; } // �޸�ѧ�������գ�������������, ��, ��4������ - 1.1
    public void setBirDate(int year, int month, int day) { stuBirDate = year + "." + month + "." + day; } // �޸�ѧ�������գ�������������, ��, ��4������
    // public String Get_gender() {   // ��ȡѧ�����Ա�manΪ������womanΪŮ�� - 1.1
    //     if(stuGender == true) return String.valueOf("man");
    //     return String.valueOf("woman");
    // }
    // 3.5: if () for (a; b; c) { } while () { }
    // 4.2: ������ѭ��, �������Ҳ��{ }
    public String getGender() {   // ��ȡѧ�����Ա�manΪ������womanΪŮ��
        // 5.11: �ж�ʹ����(���� == ����)����ʽ
        if(true == stuGender) {
            return String.valueOf("man");
        }
        return String.valueOf("woman");
    }
    // �޸�ѧ�����Ա�manΪ������womanΪŮ���������������쳣 - 1.1
    // public void Set_gender(String xc_gender) throws Exception {
    //     if(xc_gender.equals("man")) stuGender = true;
    //     else if(xc_gender.equals("woman")) stuGender = false;
    //     else throw new Exception();
    // }
    // 3.5: if () for (a; b; c) { } while () { }
    // 4.2: ������ѭ��, �������Ҳ��{ }
    public void setGender(String stuGender) throws Exception {
        if (stuGender.equals("man")) {
            this.stuGender = true;
        } else if (stuGender.equals("woman")) {
            this.stuGender = false;
        } else {
            throw new Exception();
        }
    }
    // ����boolean���޸�ѧ����������trueΪ������falseΪŮ�� - 1.1
    // public void Set_gender(boolean xc_gender) { stuGender = xc_gender; }
    public void Set_gender(boolean stuGender) { this.stuGender = stuGender; }
}