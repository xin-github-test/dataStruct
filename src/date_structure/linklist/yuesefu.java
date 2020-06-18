package date_structure.linklist;

public class yuesefu {
    public static void main(String[] args) {
        linklist_y list = new linklist_y();
        list.addNode(new person_y(1));
        list.addNode(new person_y(2));
        list.addNode(new person_y(3));
        list.addNode(new person_y(4));
        list.addNode(new person_y(5));
        String[] retureno = list.retureno(1, 2);
        for (String num :
                retureno) {
            System.out.println(num);
        }
    }




}


class linklist_y{
  private person_y head = null;
  private person_y tem = null;

  public void addNode(person_y node){
      if (head == null) {
          head = node;
          tem = head;
          head.next = node;
          return;
      }
      tem.next = node;
      tem = node;
      node.next = head;
  }
  public String[] retureno(int no,int num){
      person_y tem = head;
      StringBuffer sb = new StringBuffer();

          while (true) {
              if (head.no == no) {
                  break;
              }
              head = head.next;
          }
      while(head.next != head) {
          int num1 = num;
          while (num1 != 1) {
              tem = head;
              head = head.next;
              num1--;
          }
          tem.next = head.next;
          sb.append(String.valueOf(head.no) + " ");
          head = tem.next;
      }
      sb.append(String.valueOf(head.no));
      String [] arr = sb.toString().split(" ");

     return arr;
  }

}

class person_y{
    public int no;
    public person_y next = null;

    public person_y(int no){
        this.no = no;
    }

}