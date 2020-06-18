package date_structure.linklist;

public class towLinkList {
    public static void main(String[] args) {
        linklistTo list = new linklistTo();
        list.add(new HeroNode(1,"张三","小三"));
        list.add(new HeroNode(2,"李四","小四"));
        list.add(new HeroNode(3,"王五","小五"));
        list.add(new HeroNode(4,"钱六","小六"));
        list.display();
    }

}

class linklistTo{

    public HeroNode head = new HeroNode(0,"","");

    public HeroNode tem = head;

    public void add(HeroNode node){
        tem.next = node;
        node.pre = tem;
        tem = node;
    }
    public void display(){
        HeroNode tem = head;
        while(tem.next != null){
            System.out.println(tem.next.toString());
            tem = tem.next;
        }
    }
    public void deleteByNo(int no){
        HeroNode tem = head;
        if(tem.next == null){
            System.out.println("链表为空！");
        }
        while(tem.next.no == no){
            tem.next = tem.next.next;
            tem.next.next.pre = tem;
            return;
        }
        System.out.println("输入的编号有误!");

    }



}