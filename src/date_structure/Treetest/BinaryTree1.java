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
    }
}

//建立一颗二叉树
class tree1{
    //只需要给出二叉树的根节点就行
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
            this.left.preOrder();
        }
        System.out.println(this);
        //向右递归
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    //后序遍历的方法
    public void behindOrder(){
        //向左递归
        if(this.left != null){
            this.left.preOrder();
        }
        //向右递归
        if(this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

}
