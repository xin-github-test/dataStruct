package date_structure.PolandNotation;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Poland {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //（3+4）*5-6  -》3 4 + 5 * 6 -
        String exp = "3 4 + 5 * 6 -";
        List<String> list = getList(exp);
        System.out.println(calcu(list));
        String exp1 = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List list1 = toHouzui(getList(exp1));

        System.out.println(list1);

    }
    public static List<String> getList(String s){

        return Arrays.stream(s.split(" ")).collect(Collectors.toList());
    }
    public static int calcu(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item :
                list) {
            if(item.matches("\\d+")) //匹配多位数
            {
                stack.push(item);
            }else{
                //如果不是数字就直接弹出俩个数进行运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("符号有误！");
                }
                stack.push(String.valueOf(res));
            }
        }
        //最后留下的数就是结果
        return Integer.parseInt(stack.pop());
    }
    public static List toHouzui(List<String> list){
        Stack<String> oper = new Stack<>();
        Stack<String> value = new Stack<>();

        for (String item :
                list) {
            if (item.matches("\\d+")) {
                value.push(item);
            }else {
                if(item.equals("(") || oper.isEmpty() || oper.peek().equals("(") || priority(oper.peek()) < priority(item)){
                    oper.push(item);
                }else {
                   if(item.equals(")")){
                       while(!oper.peek().equals("(")){
                           value.push(oper.pop());
                       }
                       oper.pop();
                       continue;
                   }
                   value.push(oper.pop());
                   oper.push(item);
                }
            }

            }
            while(!oper.isEmpty()){
                value.push(oper.pop());
            }
        return Arrays.stream(value.toArray()).collect(Collectors.toList());
    }
    public static int priority(String s){
        switch (s){
            case "+":
                 return 1;
            case "-":
                 return 1;
            case "*":
                 return 2;
            case "/":
                 return 2;
            default:return -1;
        }
    }
}
