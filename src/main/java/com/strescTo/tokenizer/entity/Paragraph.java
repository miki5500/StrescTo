package com.strescTo.tokenizer.entity;





import com.strescTo.tokenizer.tools.StringTool;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Sentence> sentences = new ArrayList<>();

    private List<Token> tokens;

    private String title;



    public String getTitle() {
        return null;
    }

    List<Sentence> getSentences() {
        return this.sentences;
    }

    void setSentences(String paragraph)
    {
        String[] words = paragraph.trim().split("\\s+");
        List<Sentence> sentences = new ArrayList<>();
        StringBuilder sBi = new StringBuilder();
        for(String word: words)
        {

            if(!StringTool.haveEndChar(word))
            {
                if(StringTool.isAbberivation(word))
                {
                    sBi.append(StringTool.cleanWord(word));
                    sBi.append(" ");
                }else{
                    sBi.append(word);
                    sBi.append(" ");

                }
            }else
            {
                sBi.append(word);
                sBi.append(" ");
                Sentence sentence1 = new Sentence();
                sentence1.setTokens(sBi.toString());
                sentences.add(sentence1);

                sBi = new StringBuilder();
            }
        }
        this.sentences.addAll(sentences);
    }

    public List<Token> getTokens() {
        if(this.tokens == null)
        {
           getTokens();
        }
        return tokens;
    }

    public String getStemmedText() {
        String stemText = "";
        for(Sentence sen: sentences)
        {
            stemText = sen.getStemmedText();
        }
        return stemText;
    }

    public String getText() {

        StringBuilder sBi = new StringBuilder();

        if(this.title != null) {
            sBi.append(this.title);
            sBi.append("\n");
        }
            for(Sentence sentence: this.sentences)
            {
                sBi.append(sentence.getText());
                sBi.append(" ");
            }

        return sBi.toString().trim();
    }

    public int getNumberOfOccurience(Token token) {
        if( this.tokens == null)
        {
            setTokens();
        }

        int count = 0;
        for (Token tok:this.tokens)
        {
            if(tok.equals(token)){
                count++;
            }
        }
        return count;
    }

    private void setTokens() {
        this.tokens = new ArrayList<>();
        for(Sentence sen: sentences)
        {
            this.tokens.addAll(sen.getTokens());
        }
    }
}
