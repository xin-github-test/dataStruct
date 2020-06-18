package date_structure.Stack;

public class stack {
}

class Stack1{
    private int[] arr;
    public int top = -1;
    private int maxsize;

    public Stack1(int num){
        this.maxsize = num;
        arr = new int[maxsize];
    }

    public Boolean isNull(){
        return top == -1;
    }
    public Boolean isFull(){

        return top == maxsize -1 ;
    }
    public void push(int no){
        if(!isFull()) {
            top++;
            arr[top] = no;
        }
    }
    public int pop(){
        if(isNull()){
            System.out.println("栈为空！");
            return -1;
        }
        return arr[top--];
    }
    public void show(){
        if(!isNull()){
            for (int i = top; i > -1; i--) {
                System.out.println(arr[i]);
            }
        }
    }
    //扩展功能
    //返回运算符的优先级，返回的数字越大，优先级越高
    public int priority(int a){
        if(a == '*' || a == '/'){
            return 1;
        }else if(a == '+' || a == '-'){
            return 0;
        }else{
             return -1;//假定运算符只包含代码中的几种
        }

    }
    //判断是否是一个运算符
    public boolean isOper(char a){
        return a == '+' || a == '-' || a == '*' || a == '/';
    }
    //计算方法
    public  int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                 res = (num1 + num2); break;
            case '-':
                 res = (num2 - num1); break;
            case '*':
                 res = (num1 * num2); break;
            case '/':
                 res = num2 / num1; break;

        }
        return res;
    }
    public int peek(){
        return arr[top];
    }
}
