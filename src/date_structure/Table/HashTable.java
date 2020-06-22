package date_structure.Table;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
       hash h =new hash(7);
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入任意键继续，输入exit退出：");
        while(!scanner.next().equals("exit")){
            System.out.println("id:");
            int id = scanner.nextInt();
            System.out.println("name：");
            String name = scanner.next();
            h.add(new Emp(id,name));
            h.list();
        }
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

}
//创建hashtable 管理多条链表
class hash{
    private Emplinklist[] emplinklists;
    private int size;
    public hash(int size) {
        this.size = size;
        emplinklists = new Emplinklist[size]; //只是创建了一个数组，数组中的元素并没有创建
        for (int i = 0; i < size; i++) {
            emplinklists[i] = new Emplinklist();
        }
    }
    public void add(Emp emp){
        int num = hashFun(emp.id);
        emplinklists[num].add(emp);
    }

    public int hashFun(int id){

        return id % size;
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            emplinklists[i].list(i);
        }
    }
}
//创建链表
class Emplinklist{
    private Emp head;
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    public void list(int no){
        if(head == null){
            System.out.println("第 "+(no+1)+" 条hash链表为空！");
            return;
        }
        System.out.print("第 "+(no+1)+" 条hash链表的信息为：");
           Emp tem = head;
        while(true){
            System.out.printf("=》id=%d,name=%s \t",tem.id,tem.name);

            if (tem.next == null){
                break;
            }
            tem = tem.next;
        }
        System.out.println();
    }
     public Emp findById(int id){
        Emp tem = head;
        //判断链表是否为空
          if(head == null ){
              System.out.println("链表为空！");
          }
          //遍历
        while(tem != null){
            if(tem.id == id){
                return tem;
            }
            tem = tem.next;
        }
        return null;
     }
}