package date_structure.linklist;

public class SingleLinklist {
    public static void main(String[] args) {
       Slinklist list = new Slinklist();
        System.out.println("--------------------创建----------------");
       list.add(new HeroNode(1,"张三","小三"));
       list.add(new HeroNode(2,"李四","小四"));
       list.add(new HeroNode(3,"王五","小五"));
       list.add(new HeroNode(4,"钱六","小六"));
//        System.out.println("--------------------按序号添加----------------");
//       list.addByOrder(new HeroNode(0,"孙二","小二"));
//       list.addByOrder(new HeroNode(6,"周八","小八"));
//       list.addByOrder(new HeroNode(5,"吴七","小七"));
//       list.display();
//        System.out.println("--------------------删除----------------");
//        list.deleteByNo(0);
//        list.deleteByNo(3);
//        list.deleteByNo(6);
//        list.display();
//        list.deleteByNo(7);
       // list.reverseLink(list.getTem());
        list.reverseLink1();
        list.display();

    }
}

class Slinklist{
    private HeroNode head = new HeroNode(0,"","");//只单纯的代表头节点，不具备任何数据
    private HeroNode tem = head;
    public void add(HeroNode node){
        tem.next = node;
        tem = node;

    }

    public HeroNode getTem() {
        return head;
    }

    public void display(){
        HeroNode tem = head;
        if(head != null){
            while(tem != null){
                System.out.println(tem);
                tem = tem.next;
            }
            return;
        }
        while (tem.next != null){
            System.out.println(tem.next.toString());
            tem = tem.next;
        }

    }
    public void addByOrder(HeroNode node){
        HeroNode tem = head;

        while (tem.next != null && tem.next.no < node.no){
               tem = tem.next;
        }
        if(tem.next == null){
            tem.next = node;
            return;
        }
         node.next = tem.next;
          tem.next = node;


    }
    public void deleteByNo(int no){
        HeroNode tem = head;
        while (tem.next != null && tem.next.no != no){
            tem = tem.next;
        }
        if(tem.next == null){
            System.out.println("输入的序号有误或无此序号！");
            return;
        }
        if(tem.next.next == null){
            tem.next = null;
            return;
        }
        tem.next = tem.next.next;
    }
     //递归使得链表倒置
    public void reverseLink(HeroNode tem){

        if(tem.next != null){
            HeroNode t = tem.next;
            reverseLink(t);
        }
        System.out.println(tem.no);

    }
    //使用头插法实现倒置
    public void reverseLink1(){
        HeroNode tem = head.next.next;
        HeroNode tem1 = null;
               head = head.next;
         head.next = null;
        while (tem != null){
            tem1 = tem;
            tem = tem.next;
                tem1.next = head;
                head = tem1;

        }





    }



}

class HeroNode{
     public int no;
     public String name;
     public String nickname;
     public HeroNode next = null;
     public HeroNode pre = null;
     public HeroNode(int no,String name,String nickname){
         this.no = no;
         this.name = name;
         this.nickname = nickname;
     }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                ", pre=" + pre +
                '}';
    }
}