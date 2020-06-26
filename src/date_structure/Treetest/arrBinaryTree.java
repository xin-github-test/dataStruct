package date_structure.Treetest;


/**
 * 顺序存储二叉树就是将数组按照二叉树的遍历的方法遍历就行了，只要找到数组在二叉树中的位置的规律就行了
 * 此处：二叉树左边的数组的下标都是满足：2 * index + 1
 *                       右边满足：2 * index +2
 * 根据这个规律可以对数组在二叉树中的位置进行递归遍历
 */
public class arrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrTree ar = new ArrTree(arr);
        ar.preOrder(0);
    }
}

//编写一个类，实现顺序存储二叉树
class ArrTree{
    private int [] arr;

    public ArrTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法用于对数组进行前序遍历

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空！");
        }
        System.out.println(arr[index]);
        //向左递归
        if(index * 2 + 1 < arr.length){
            preOrder(index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }

    //后序和中序就是将前序的代码的位置改一下就行了
}
