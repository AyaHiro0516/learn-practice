package org.ayahiro.practice.compiling_principle.grammar_analysis.core;

import org.ayahiro.practice.compiling_principle.grammar_analysis.model.AnalyzeResult;
import org.ayahiro.practice.compiling_principle.grammar_analysis.model.Gs;
import org.ayahiro.practice.compiling_principle.grammar_analysis.util.TextUtil;

import java.util.ArrayList;
import java.util.Stack;

// 模拟表驱动分析过程的类
public class Analyzer {

    public Analyzer() {
        super();
        analyzeStack = new Stack<Character>();
        // 结束符进栈
        analyzeStack.push('#');
    }

    private ArrayList<AnalyzeResult> analyzeResults;

    /**
     * LL（1）文法
     */
    private Gs ll1Gs;

    public Gs getLl1Gs() {
        return ll1Gs;
    }

    public void setLl1Gs(Gs ll1Gs) {
        this.ll1Gs = ll1Gs;
    }

    /**
     * 开始符
     */
    private Character startChar;

    /**
     * 分析栈
     */
    private Stack<Character> analyzeStack;
    /**
     * 剩余输入串
     */
    private String str;
    /**
     * 推导所用产生或匹配
     */
    private String useExp;

    public ArrayList<AnalyzeResult> getAnalyzeResults() {
        return analyzeResults;
    }

    public void setAnalyzeResults(ArrayList<AnalyzeResult> analyzeResults) {
        this.analyzeResults = analyzeResults;
    }

    public Character getStartChar() {
        return startChar;
    }

    public void setStartChar(Character startChar) {
        this.startChar = startChar;
    }

    public Stack<Character> getAnalyzeStack() {
        return analyzeStack;
    }

    public void setAnalyzeStack(Stack<Character> analyzeStack) {
        this.analyzeStack = analyzeStack;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getUseExp() {
        return useExp;
    }

    public void setUseExp(String useExp) {
        this.useExp = useExp;
    }

    /**
     * 分析
     */
    public void analyze() {
        analyzeResults = new ArrayList<AnalyzeResult>();

        // 开始符进栈
        analyzeStack.push(startChar);
        int index = 0;
        // 开始分析
        // while (analyzeStack.peek() != '#' && str.charAt(0) != '#') {
        while (!analyzeStack.empty()) {
            index++;
            if (analyzeStack.peek() != str.charAt(0)) {
                // 到分析表中找到这个产生式
                String nowUseExpStr = TextUtil.findUseExp(ll1Gs.getSelectMap(), analyzeStack.peek(), str.charAt(0));
                //System.out.println(index + "\t\t\t" + analyzeStack.toString() + "\t\t\t" + str + "\t\t\t"
                //        + analyzeStack.peek() + "->" + nowUseExpStr);
                AnalyzeResult produce = new AnalyzeResult();
                produce.setIndex(index);
                produce.setAnalyzeStackStr(analyzeStack.toString());
                produce.setStr(str);
                if (null == nowUseExpStr) {
                    produce.setUseExpStr("无法匹配!");
                } else {
                    produce.setUseExpStr(analyzeStack.peek() + "->" + nowUseExpStr);
                }
                analyzeResults.add(produce);
                // 将之前的分析栈中的栈顶出栈
                analyzeStack.pop();
                // 将要用到的表达式入栈,反序入栈
                if (null != nowUseExpStr && nowUseExpStr.charAt(0) != 'ε') {
                    for (int j = nowUseExpStr.length() - 1; j >= 0; j--) {
                        char currentChar = nowUseExpStr.charAt(j);
                        analyzeStack.push(currentChar);
                    }
                }
                continue;
            }
            // 如果可以匹配,分析栈出栈，串去掉一位
            if (analyzeStack.peek() == str.charAt(0)) {
                //System.out.println(index + "\t\t\t" + analyzeStack.toString() + "\t\t\t" + str + "\t\t\t" + "“"
                //        + str.charAt(0) + "”匹配");
                AnalyzeResult produce = new AnalyzeResult();
                produce.setIndex(index);
                produce.setAnalyzeStackStr(analyzeStack.toString());
                produce.setStr(str);
                produce.setUseExpStr("“" + str.charAt(0) + "”匹配");
                analyzeResults.add(produce);
                analyzeStack.pop();
                str = str.substring(1);
                continue;
            }
        }
    }

    public void showAnalyzeResult() {
        System.out.println("=========================== 进行表驱动预测分析 ===========================");
        System.out.println("开始符:" + startChar);
        System.out.printf("%-8s %-23s %-15s %-15s\n", "序号", "分析栈", "剩余输入", "输出");
        int index = 1;
        for (AnalyzeResult analyzeResult : analyzeResults) {
            System.out.printf("%-10s %-25s %-19s %-15s\n",
                    analyzeResult.getIndex(),
                    analyzeResult.getAnalyzeStackStr(),
                    analyzeResult.getStr(),
                    analyzeResult.getUseExpStr());
        }
    }

}