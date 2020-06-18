package date_structure.Stack;

public class Calculator {
    public static void main(String[] args) {

        String exp = "70+2*6-4";
        Stack1 value = new Stack1(10);
        Stack1 ope = new Stack1(10);
        int index = 0;
        int num1;
        int num2;
        int res;
        int oper;
        char ch = ' ';
        String keepnum="";
        //扫描表达式
        while(index != exp.length()){
           ch = exp.substring(index,index+1).charAt(0);
           //判断
            if(value.isOper(ch)){
                if(ope.isNull() || ope.priority(ope.peek()) < ope.priority(ch)){
                    ope.push(ch);
                }else {
                    num1 = value.pop();
                    num2 = value.pop();
                    oper =ope.pop();
                    value.push(value.cal(num1,num2,oper));
                    ope.push(ch);
                }

            }else{
                keepnum += ch;
                if(index == exp.length()-1){
                    value.push(Integer.parseInt(keepnum));
                }else {
                    if (ope.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                        value.push(Integer.parseInt(keepnum));
                        keepnum = "";
                    }
                }

            }
            index++;
        }
        //扫描完毕后
        while(!ope.isNull()){
            num1 = value.pop();
            num2 = value.pop();
            oper = ope.pop();
            res = value.cal(num1,num2,oper);
            value.push(res);
        }
        System.out.println("表达式的结果："+value.pop());
    }
}
