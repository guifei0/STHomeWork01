- [软件质量保证与测试 - 作业1](#%e8%bd%af%e4%bb%b6%e8%b4%a8%e9%87%8f%e4%bf%9d%e8%af%81%e4%b8%8e%e6%b5%8b%e8%af%95---%e4%bd%9c%e4%b8%9a1)
  - [程序功能](#%e7%a8%8b%e5%ba%8f%e5%8a%9f%e8%83%bd)
  - [具体要求](#%e5%85%b7%e4%bd%93%e8%a6%81%e6%b1%82)
  - [程序界面](#%e7%a8%8b%e5%ba%8f%e7%95%8c%e9%9d%a2)
  - [运行过程- 例子](#%e8%bf%90%e8%a1%8c%e8%bf%87%e7%a8%8b--%e4%be%8b%e5%ad%90)

## 软件质量保证与测试 - 作业1
### 程序功能
- 菜单选项：程序不断显示如下“菜单”选项，等待用户输入选项（1 ~ 6），之后执行相应功能；
- 插入功能：将学生类（最多20个）插入数组中（可以使用Java集合类），要求学生信息从键盘输入，每次只插入一个学生的信息；每插入一个名字后学生仍要求按学号递增排序；
- 输出功能：输出所有学生信息；
- 查找功能：按姓名查找，若找到显示相关信息，否则提示未找到。
- 退出功能：退出整个程序。
- 删除功能：按姓名删除，即按姓名查找后删除该学生信息；
- 修改功能：按姓名查找后修改学生年龄等信息；（可选择，若实现请标出）

### 具体要求
- 程序结构具体要求：
  - 实现```StudentManager```类  
  - 管理所有```Student```，即```StudentManager```类有一个```Student```类型的数组或```List```作为字段；
  - 插入 、查找、删除、输出、退出等功能在该类中作为方法实现；
  - 该类还要有一个```App```方法，负责程序的整个控制流程（首先输出选择菜单，等待用户输入选项；然后根据选项执行相应操作）
  - 其他成员或功能自行确定
- 实现```Student```类
  - 私有字段包括：```ID（int）、name(string)、birDate(string或者Java日期)、gender(bool)```，分别表示学号、姓名、出生日期和性别
  - 为每个私有字段设置一对儿公有访问方法
  - 其他成员或功能自行确定
- 实现测试类```SMTest```类
  - 在其```Main```方法中执行```StudentManager```的```App```方法
  - “界面”尽量美观

### 程序界面
```
Please select an operation: 
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
```

### 运行过程- 例子
```
Please select an operation: 
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
1
请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): 
3 小明 2000.10.10 woman
Insert successfully!
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
1
请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): 
1 yyy 1998.02.21 woman
Insert successfully!
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
1
请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): 
2 abc 1999.09.12 man
Insert successfully!
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
1
请输入学生的id, 姓名, 生日(年.月.日形式，ex: 1999.01.01), 性别(man, woman): 
4 s 2000.11.11 man
Insert successfully!
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
5
ID: 1, Name: yyy, Birthday: 1998.02.21, Gender: woman
ID: 2, Name: abc, Birthday: 1999.09.12, Gender: man
ID: 3, Name: 小明, Birthday: 2000.10.10, Gender: woman
ID: 4, Name: s, Birthday: 2000.11.11, Gender: man
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
2
请输入学生姓名: 
abc
Query successful
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
2
请输入学生姓名: 
小明
Query successful
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
2
请输入学生姓名: 
qwq
Query failed
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
3
请输入学生姓名: 
小明
successfully deleted
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
5
ID: 1, Name: yyy, Birthday: 1998.02.21, Gender: woman
ID: 2, Name: abc, Birthday: 1999.09.12, Gender: man
ID: 4, Name: s, Birthday: 2000.11.11, Gender: man
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
4
请输入学生姓名, 年, 月, 日 
abc 2020 10 20
Successfully modified
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
5
ID: 1, Name: yyy, Birthday: 1998.02.21, Gender: woman
ID: 2, Name: abc, Birthday: 2020.10.20, Gender: man
ID: 4, Name: s, Birthday: 2000.11.11, Gender: man
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
4
请输入学生姓名, 年, 月, 日 
abc 2020 1 1
Successfully modified
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
5
ID: 1, Name: yyy, Birthday: 1998.02.21, Gender: woman
ID: 2, Name: abc, Birthday: 2020.1.1, Gender: man
ID: 4, Name: s, Birthday: 2000.11.11, Gender: man
Please select an operation:
**********************************
*            1.Insert            *
*            2.Find              *
*            3.Delete            *
*            4.Modify            *
*            5.Output            *
*            6.Quit              *
**********************************
6
Goodbye!
```
