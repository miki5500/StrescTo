package com.strescTo.tokenizer.entity;

import java.util.ArrayList;
import java.util.List;

public class Article {

    private List<Paragraph> paragraphs = new ArrayList<>();

    private List<Sentence> sentences;

    private String title;

    private String article;

    public Article()
    {}

    public void setArticle(String article)
    {
        this.article = article;
    }

    public String getArticle()
    {
        return this.article;
    }

    public void setParagraphs()
    {
        List<Paragraph> par = new ArrayList<>();
        String[] splitedArticle = article.trim().split("\\n+");

        for(String paragraph: splitedArticle)
        {
            Paragraph parTemp = new Paragraph();
            parTemp.setSentences(paragraph);
            par.add(parTemp);

        }
        this.paragraphs.addAll(par);
    }


    public String getTitle() {
        return this.title;
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public List<Sentence> getSentences() {
        if(this.sentences == null)
        {
            setSentences();
        }
        return this.sentences;
    }

    private void setSentences() {
        this.sentences = new ArrayList<>();
        for(Paragraph paragraph:this.paragraphs)
        {
            this.sentences.addAll(paragraph.getSentences());
        }
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getStemmedText() {
        StringBuilder build = new StringBuilder();
        for(Paragraph paragraph:this.paragraphs)
        {
            build.append(paragraph.getStemmedText());
            build.append(" ");
        }
        return build.toString().trim();
    }

    public String getText() {

        StringBuilder sbi = new StringBuilder();
        for (Paragraph paragraph:this.paragraphs)
        {
           sbi.append(paragraph.getText());
            sbi.append("\n");
        }
        return sbi.toString().trim();
    }

    public int getNumberOfOccurience(Token token) {
    int count = 0;
        if(this.sentences == null)
        {
            setSentences();
        }
        List<Token> tokenList = new ArrayList<>();
        for (Sentence sentence : this.sentences)
        {
            tokenList.addAll(sentence.getTokens());
        }
        for (Token tok:tokenList)
        {
            if(tok.equals(token)){
                count++;
            }
        }
        return count;
    }
}
