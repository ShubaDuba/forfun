package com.company;

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static boolean checkBrackets (char[] brackets) {
        Stack<Character> open = new Stack<>();
        if (brackets.length % 2 == 1) {
            return false;
        } else {
            for (int i = 0; i < brackets.length; ++i) {
                if (brackets[i] == '{' || brackets[i] == '(' || brackets[i] == '[') {
                    open.add(brackets[i]);
                } else {
                    char lastOpened;
                    try {
                        lastOpened = open.pop();
                    }
                    catch (EmptyStackException e) {
                        return false;
                    }
                    if (!(brackets[i] == '}' && lastOpened == '{' || brackets[i] == ')' && lastOpened == '(' ||
                            brackets[i] == ']' && lastOpened == '[')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[] brackets = {'[','{',']','}','(',')'};
        System.out.println(checkBrackets(brackets));
    }
}
