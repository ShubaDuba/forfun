package com.company;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static boolean checkBrackets (char[] brackets) {
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('[', ']');
        bracketsMap.put('{', '}');
        bracketsMap.put('(', ')');
        Stack<Character> open = new Stack<>();
        if (brackets.length % 2 == 1) {
            return false;
        } else {
            for (int i = 0; i < brackets.length; ++i) {
                if (bracketsMap.containsKey(brackets[i])) {
                    open.add(brackets[i]);
                } else {
                    char lastOpened;
                    try {
                        lastOpened = open.pop();
                    }
                    catch (EmptyStackException e) {
                        return false;
                    }
                    if (brackets[i] != bracketsMap.get(lastOpened)) {
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
