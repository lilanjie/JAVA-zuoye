package com.lilanjie;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            switch (symbol) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (!stack.empty()&&stack.pop().equals('('));else {return false;}break;
                case ']':
                    if ( !stack.empty()&&stack.pop().equals('['));else { return false;}break;
                case '}':
                    if (! stack.empty()&&stack.pop().equals('{'));else { return false;}break;
            }
        }
        return stack.empty();
    }
}


