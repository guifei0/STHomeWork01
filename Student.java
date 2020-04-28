
public class Student {
    private int ID;         // ѧ����ID
    private String name;    // ѧ��������
    private String birDate; // ѧ��������: year.month.day
    private boolean gender; // ѧ�����Ա�: man: true, woman: false
    // ���캯����Ĭ�ϳ�ʼ����ʽ
    Student() {
        ID = -1;
        name = "";
        birDate = "";
        gender = false;        
    }
    // ����ѧ����Ϣ���й���ѧ������
    // stu_id��ID, stu_name��Name, stu_birDate��birthday, stu_gender���Ա�
    Student(int stu_id, String stu_name, String stu_birDate, boolean stu_gender) {
        ID = stu_id;
        name = stu_name;
        birDate = stu_birDate;
        gender = stu_gender;
    }
    public int Get_ID() { return ID; }  // ��ȡѧ����ID
    public void Set_ID(int xc_ID) { ID = xc_ID; }   // �޸�ѧ����IDΪxc_ID
    public String Get_name() { return name; }   // ��ȡѧ��������
    public void Set_name(String xc_name) { name = xc_name; }    // �޸�ѧ��������Ϊxc_name
    public String Get_birDate() { return birDate; } // ��ȡѧ��������
    public void Set_birDate(int year, int month, int day) { birDate = year + "." + month + "." + day; } // �޸�ѧ�������գ�������������, ��, ��4������
    public String Get_gender() {   // ��ȡѧ�����Ա�manΪ������womanΪŮ��
        if(gender == true) return String.valueOf("man");
        return String.valueOf("woman");
    }
    // �޸�ѧ�����Ա�manΪ������womanΪŮ���������������쳣
    public void Set_gender(String xc_gender) throws Exception {
        if(xc_gender.equals("man")) gender = true;
        else if(xc_gender.equals("woman")) gender = false;
        else throw new Exception();
    }
    // ����boolean���޸�ѧ����������trueΪ������falseΪŮ��
    public void Set_gender(boolean xc_gender) { gender = xc_gender; }
}