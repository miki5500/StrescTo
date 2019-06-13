package com.strescTo.tokenizer.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {


    private List<Token> tokens = new ArrayList<>();

    private String sentenceEndChar;

    Sentence() {
    }

    public void setTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }

    void setTokens(String sentence)
    {

        String[] words = sentence.trim().split("\\s+");
        for(String word:words)
        {
           Token token = new Token(word);
           this.tokens.add(token);
        }
    }

    public void setSentenceEndChar(String endChar)
    {
        this.sentenceEndChar = endChar;
    }

    public List<Token> getTokens() {
        return this.tokens;
    }

    String getStemmedText() {
        return null;
    }

    public String getText() {
        String text = "";
        StringBuilder sBi = new StringBuilder();
        for (Token token:this.tokens)
        {
            sBi.append(token.getText());
            sBi.append(" ");

        }
        return sBi.toString();

    }

    public int getNumberOfOccurience(Token token) {
        return 0;
    }
}
