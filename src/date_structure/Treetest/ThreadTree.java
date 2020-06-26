package date_structure.Treetest;
/**
 * 线索二叉树：n个节点的二叉树有n+1个空指针域，利用这种空的指针域存放该节点在某种遍历下的前驱或后继节点的指针，这种附加的指针叫做线索
 */
public class ThreadTree {
    public static void main(String[] args) {

         HeroNode1 root = new HeroNode1(1,"tom");
         HeroNode1 node2 = new HeroNode1(3,"jack");
         HeroNode1 node3 = new HeroNode1(6,"smith");
         HeroNode1 node4 = new HeroNode1(8,"mary");
         HeroNode1 node5 = new HeroNode1(10,"king");
         HeroNode1 node6 = new HeroNode1(14,"dim");

         root.setLeft(node2);
         root.setRight(node3);
         node2.setLeft(node4);
         node2.setRight(node5);
         node3.setLeft(node6);

         tree2 tr = new tree2();
         tr.setRoot(root);
         tr.threadNodes(root);

        System.out.println(node4.getRight());

    }
}
class tree2{
    //只需要给出二叉树的根节点就行
    private HeroNode1 root;
    //为了实现线索化，需要加上一个指向当前节点前驱节点的属性
    private HeroNode1 pre = null;

    public HeroNode1 getPre() {
        return pre;
    }

    public void setPre(HeroNode1 pre) {
        this.pre = pre;
    }

    public void setRoot(HeroNode1 root) {
        this.root = root;
    }

    //线索化 (中序）
    public void threadNodes(HeroNode1 node){
        if(node == null){
            //System.out.println("无法线索化！");
            return;
        }
        //1.先线索化左子树
        threadNodes(node.getLeft());
        //2.先线索化当前节点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node; //使得pre一直是下一个节点的前驱节点

        //3.先线索化右子树
        threadNodes(node.getRight());
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
    public HeroNode1 preSearch(int no){
        return root.preSearch(no);
    }

}
class HeroNode1 {
    private int no;
    private String  name;
    private HeroNode1 left;
    private HeroNode1 right;

    //线索二叉树中添加俩个属性，代表指向的是左（右）子树还是前（后）驱节点
    //1.若leftType = 0表示指向的是左子树，= 1 表示指向的是前驱节点
    //2.rightType和上面的类似
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode1(int no, String name) {
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

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
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
    public HeroNode1 preSearch(int no){
        if(this.no == no){
            return this;
        }
        HeroNode1 tem = null;   //需要一个中间的节点来保存结果
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
    public HeroNode1 behindSearch(int no){
        HeroNode1 tem = null;
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
    public HeroNode1 midSearch(int no){
        HeroNode1 tem = null;
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