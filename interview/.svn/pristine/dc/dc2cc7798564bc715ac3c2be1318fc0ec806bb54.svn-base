package com.qfedu;

public class App5 {
    //  中缀表达式
    //  2 + 3 * 5
    //  5 * (2 + 3)
    //  后缀表达式 - 逆波兰表达式
    //  2 3 5 * +
    //  5 2 3 + *

    public static boolean checkBacket(String expr) {
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0, len = expr.length(); i < len; ++i) {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (! stack.isEmpty()) {
                    char left = stack.pop();
                    if  (!((left == '(' && ch == ')') || (left == '[' && ch == ']') || (left == '{' && ch == '}'))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
