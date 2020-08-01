package org.ayahiro.practice.compiling_principle.grammar_analysis;

import org.ayahiro.practice.compiling_principle.grammar_analysis.core.Analyzer;
import org.ayahiro.practice.compiling_principle.grammar_analysis.model.Gs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> gsArray = new ArrayList<String>();
        Gs gs = new Gs();
        initGs(gsArray);
        gs.setGsArray(gsArray);
        gs.getNvNt();
        gs.initExpressionMaps();
        gs.getFirst();
        gs.showFirst();
        // 设置开始符
        gs.setS('E');
        gs.getFollow();
        gs.showFollow();
        gs.getSelect();
        gs.showSelect();
        //生成预测分析表
        gs.genAnalyzeTable();
        // 创建一个分析器
        Analyzer analyzer = new Analyzer();
        analyzer.setStartChar('E');
        analyzer.setLl1Gs(gs);
        analyzer.setStr("(A+A)*A#");
        analyzer.analyze();
        analyzer.showAnalyzeResult();
    }

    /**
     * 获取非终结符集与终结符集
     *
     * @param gsArray
     * @param nvSet
     * @param ntSet
     */
    private static void getNvNt(ArrayList<String> gsArray, TreeSet<Character> nvSet, TreeSet<Character> ntSet) {
        for (String gsItem : gsArray) {
            String[] nvNtItem = gsItem.split("->");
            String charItemStr = nvNtItem[0];
            char charItem = charItemStr.charAt(0);
            // nv在左边
            nvSet.add(charItem);
        }
        for (String gsItem : gsArray) {
            String[] nvNtItem = gsItem.split("->");
            // nt在右边
            String nvItemStr = nvNtItem[1];
            // 遍历每一个字
            for (int i = 0; i < nvItemStr.length(); i++) {
                char charItem = nvItemStr.charAt(i);
                if (!nvSet.contains(charItem)) {
                    ntSet.add(charItem);
                }
            }
        }
    }

    /**
     * 初始化LL(1)文法
     *
     * @param gsArray
     */
    private static void initGs(ArrayList<String> gsArray) {
        gsArray.add("E->TU");
        gsArray.add("U->+TU");
        gsArray.add("U->ε");
        gsArray.add("T->FI");
        gsArray.add("I->*FI");
        gsArray.add("I->ε");
        gsArray.add("F->(E)");
        gsArray.add("F->A");
        HashMap<String, Integer> map=new HashMap<>();
        map.containsKey()
    }
}
