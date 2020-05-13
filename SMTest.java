
public class SMTest {
    public static void main(String[] args) {
        // StudentManager StuManager = new StudentManager(); // - 1.1, 1.2
        // 2.1: 创建一个学生管理者, 调用App方法开启程序
        // 调用默认构造函数初始化
        StudentManager stuMngr = new StudentManager();
        stuMngr.App();
    }
}

// -- ex:
// 2 abc 1999.09.12 man
// 1 yyy 1998.02.21 woman
// 3 小明 2000.10.10 woman
// 4 s 2000.11.11 man