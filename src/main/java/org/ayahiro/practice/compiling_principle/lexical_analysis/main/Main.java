package org.ayahiro.practice.compiling_principle.lexical_analysis.main;

import org.ayahiro.practice.compiling_principle.lexical_analysis.utils.Token;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char special[] = {'+', '-', '*', '/', '=', '<', '(', ')', ':', ';'};//特殊符号
    static char opt[] = {'+', '-', '*', '/', '=', '<', '>'};//单目运算符符号
    static String reserved[] = {"int", "if", "then", "else", "end", "repeat", "until", "read", "write", "endif"};//保留字
    static String bracketPrefix[] = {"if", "read", "write"}; //括号前缀
    static String semicolonPrefix[] = {"endif", "end"}; //分号前缀

    static StringBuffer readBuffer = new StringBuffer(); //读入缓存

    public static boolean isSpecialSymbol(char symbol) {
        for (char c : special) {
            if (symbol == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isReservedWord(String word) {
        for (String s : reserved) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBracketPrefix(String word) {
        for (String s : bracketPrefix) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSemicolonPrefix(String word) {
        for (String s : semicolonPrefix) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOpt(char symbol) {
        for (char c : opt) {
            if (symbol == c) {
                return true;
            }
        }
        return false;
    }

    public static List<String> readTestFile(String filename) throws IOException {
        List<String> list = new ArrayList<String>();
        String fileContent = "";
        FileReader fread = new FileReader(filename);
        BufferedReader bf = new BufferedReader(fread);
        String strLine = bf.readLine();
        while (strLine != null) {
            //System.out.println("strLine:" + strLine);
            list.add(strLine);
            strLine = bf.readLine();
        }
        bf.close();
        fread.close();
        return list;
    }

    public static List<Token> analyze(String str) {
        List<Token> list = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        int state = 0; //初始状态为0
        int pos = 0;
        str += "#";
        while (pos < str.length()) {
            char cur = str.charAt(pos);
            switch (state) {
                case 0:
                    if (cur == ' ') {
                        pos++;
                        state = 0;
                    } else if (Character.isDigit(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 1;
                    } else if (Character.isLetter(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 9;
                    } else if (isSpecialSymbol(cur)) {
                        readBuffer.append(cur);
                        state = 13;
                    } else if (cur == '{') {
                        pos++;
                        state = 14;
                    } else if (cur == '#') {
                        pos = Integer.MAX_VALUE;
                        state = 0;
                    }
                    break;
                case 1:
                    if (Character.isDigit(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 1;
                    } else if (cur == '.') {
                        pos++;
                        readBuffer.append(cur);
                        state = 4;
                    } else if (cur == ' ' || cur == '#') {
                        state = 2;
                    } else if (isOpt(cur) || cur == ';') {
                        state = 16;
                    } else state = 3;
                    break;
                case 2:   // NUM_
                    list.add(new Token(readBuffer.toString(), "SINGLE_NUM", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos++;
                    state = 0;
                    break;
                case 3: // NUMspecical
                    list.add(new Token("error at state 3", "ERROR", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos = Integer.MAX_VALUE;
                    state = 0;
                    break;
                case 4:
                    if (Character.isDigit(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 5;
                    } else state = 8;
                    break;
                case 5:
                    if (Character.isDigit(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 5;
                    } else if (cur == ' ' || cur == '#') state = 6;
                    else if (isOpt(cur) || cur == ';') state = 17;
                    else state = 7;
                    break;
                case 6: // NUM.NUM_
                    list.add(new Token(readBuffer.toString(), "FLOAT_NUM", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos++;
                    state = 0;
                    break;
                case 7:
                    list.add(new Token("error at state 7", "ERROR", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos = Integer.MAX_VALUE;
                    state = 0;
                    break;
                case 8:
                    list.add(new Token("error at state 8", "ERROR", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos = Integer.MAX_VALUE;
                    state = 0;
                    break;
                case 9:
                    if (Character.isDigit(cur) || Character.isLetter(cur)) {
                        pos++;
                        readBuffer.append(cur);
                        state = 9;
                    } else if (cur == ' ' || cur == '#') state = 10;
                    else if (isSpecialSymbol(cur)) state = 11;
                    else if (cur == '{') state = 12;
                    break;
                case 10: //ID_
                    String temp1 = readBuffer.toString();
                    String type1 = "Reserved Word";
                    if (!isReservedWord(temp1))
                        type1 = "ID";
                    list.add(new Token(temp1, type1, pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos++;
                    state = 0;
                    break;
                case 11: // IDspecial  readBuffer: ID
                    String temp2 = readBuffer.toString();
                    if (isBracketPrefix(temp2) && cur == '(') {
                        list.add(new Token(temp2, "Reserved Word", pos));
                    } else if (isSemicolonPrefix(temp2) && cur == ';') {
                        list.add(new Token(temp2, "Reserved Word", pos));
                    } else if (!isBracketPrefix(temp2) && cur == ')') {
                        list.add(new Token(temp2, "ID", pos));
                    } else {
                        list.add(new Token("error at state 11", "ERROR", pos));
                        pos = Integer.MAX_VALUE;
                    }
                    readBuffer.delete(0, readBuffer.length());
                    state = 0;
                    break;
                case 12: // ID{  readBuffer: ID
                    String temp3 = readBuffer.toString();
                    String type2 = "Reserved Word";
                    if (!isReservedWord(temp3))
                        type2 = "ID";
                    list.add(new Token(temp3, type2, pos));
                    readBuffer.delete(0, readBuffer.length());
                    state = 0;
                    break;
                case 13: //special  readBuffer: special
                    String symbol = readBuffer.toString();
                    list.add(new Token(readBuffer.toString(), "Special", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos++;
                    state = 0;
                    break;
                case 14:
                    if (cur == '{') state = 15;
                    else if (cur == '}') {
                        pos++;
                        state = 0;
                    } else {
                        pos++;
                        state = 14;
                    }
                    break;
                case 15:
                    list.add(new Token("error at state 15", "ERROR", pos));
                    readBuffer.delete(0, readBuffer.length());
                    pos = Integer.MAX_VALUE;
                    state = 0;
                    break;
                case 16:
                    list.add(new Token(readBuffer.toString(), "SINGLE_NUM", pos));
                    readBuffer.delete(0, readBuffer.length());
                    state = 0;
                    break;
                case 17:
                    list.add(new Token(readBuffer.toString(), "FLOAT_NUM", pos));
                    readBuffer.delete(0, readBuffer.length());
                    state = 0;
                    break;
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        //读取文件
        List<String> strList = readTestFile("C:\\Users\\ayahiro\\Desktop\\text.txt");
        String[] list = null;
        for (int i = 0; i < strList.size(); i++) {
            System.out.println((i + 1) + ": " + strList.get(i));
            List<Token> result = analyze(strList.get(i));
            for (Token token : result) {
                String type = token.getType();
                if (type.equals("Reserved Word")) {
                    System.out.println("    " + (i + 1) + ": reserved word: " + token.getValue());
                } else if (type.equals("ID")) {
                    System.out.println("    " + (i + 1) + ": ID, name: " + token.getValue());
                } else if (type.equals("Special")) {
                    System.out.println("    " + (i + 1) + " " + token.getValue());
                } else if (type.equals("SINGLE_NUM") || type.equals("FLOAT_NUM")) {
                    System.out.println("    " + (i + 1) + ": NUM, value: " + token.getValue());
                } else if (type.equals("ERROR")) {
                    System.out.println("    " + (i + 1) + " " + token.getValue() + ", position: " + token.getLocation());
                }
            }
        }
    }
}
