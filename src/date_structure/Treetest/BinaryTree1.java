package date_structure.Treetest;

public class BinaryTree1 {
    public static void main(String[] args) {
        //首先需要创建一颗二叉树
       tree1 b = new tree1();
        //创建树的节点
        HeroNode node1 = new HeroNode(1,"A");
        HeroNode node2 = new HeroNode(2,"B");
        HeroNode node3 = new HeroNode(3,"C");
        HeroNode node4 = new HeroNode(4,"D");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        //设置根节点
        b.setRoot(node1);
        System.out.println("前序遍历：");
        b.preOrder();
        System.out.println("中序遍历：");
        b.midOrder();
        System.out.println("后序遍历：");
        b.behindOrder();
        System.out.println("寻找的节点是：");
        System.out.println(b.preSearch(4));

    }
}

//建立一颗二叉树
class tree1{
    //只需要给出二叉树的根节点就行
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else {
                this.root.delNode(no);
            }
        }else{
            System.out.println("这是空树！");
        }

    }





    public void preOrder(){
        if(root != null){
            this.root.preOrder();
        }else{
            System.out.println("当前的二叉树为空！");
        }
    }
    public void midOrder(){
        if(root != null){
            this.root.midOrder();
        }else{
            System.out.println("当前的二叉树为空！");
        }
    }
    public void behindOrder(){
        if(root != null){
            this.root.behindOrder();
        }else{
            System.out.println("当前的二叉树为空！");
        }
    }
    public HeroNode preSearch(int no){
        return root.preSearch(no);
    }

}
class HeroNode{
    private int no;
    private String  name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
     //递归删除节点 简单版的，删除的如果不是叶子节点的话，就直接删除出子树 
     //1.如果删除的节点是叶子节点，那么直接删除该节点
     //2.如果删除的不是叶子节点则直接删除子树
    public void delNode(int no){
        if(this.left != null &&  this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //向左递归
        if(this.left != null){
            this.left.delNode(no);
        }
        //向右递归
        if(this.right != null){
            this.right.delNode(no);
        }
    }



    //前序遍历的方法
    public void preOrder(){
        //先输出中间的节点
        System.out.println(this);
        //向左递归
        if(this.left != null){
            this.left.preOrder();
        }
        //向右递归
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    //中序遍历的方法
    public void midOrder(){
        //向左递归
        if(this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        //向右递归
        if(this.right != null) {
            this.right.midOrder();
        }
    }
    //后序遍历的方法
    public void behindOrder(){
        //向左递归
        if(this.left != null){
            this.left.behindOrder();
        }
        //向右递归
        if(this.right != null) {
            this.right.behindOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preSearch(int no){
        if(this.no == no){
            return this;
        }
        HeroNode tem = null;   //需要一个中间的节点来保存结果
        if(this.left != null){
          tem = this.left.preSearch(no);
        }
        if(tem != null){   //不为空说明找到了
            return tem;
        }
        if(this.right != null){
            tem = this.right.preSearch(no);
        }

            return tem;   //最后的一个返回不管有没有找到都必须返回
    }
 //后序查找
    public HeroNode behindSearch(int no){
       HeroNode tem = null;
        if(this.left != null){
            tem = this.left.behindSearch(no);
        }
        if(tem != null){
            return tem;
        }
        if(this.right != null){
            this.right.behindSearch(no);
        }
        if(this.no == no){
            return this;
        }
        return tem;
    }
 //中序查找
    public HeroNode midSearch(int no){
        HeroNode tem = null;
        if(this.left != null){
            this.left.midSearch(no);
        }
        if(tem != null){
            return tem;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            this.right.midSearch(no);
        }
        return tem;
    }

}
