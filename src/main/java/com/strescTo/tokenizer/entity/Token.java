package com.strescTo.tokenizer.entity;




import com.strescTo.tokenizer.tools.StringTool;

import java.util.ArrayList;
import java.util.List;

public class Token {

    private List<String> baseForms = new ArrayList<>();

    private String lemma;

    private String text;

    private List<PartOfSpeach> info = new ArrayList<>();

    private boolean isStopword = false;


    public Token(String token) {
        String transformed = token.toLowerCase();
        transformed = StringTool.cleanWord(transformed);
        this.baseForms.add(transformed);
        this.info.add(PartOfSpeach.UNKNOWN);
        this.text = token;
        setStopword(StringTool.isStopWord(transformed));
    }

    public Token(List<String> baseForms, String text, boolean isStopword, List<PartOfSpeach> info) {
        this.baseForms = baseForms;
        this.text = text;
        this.isStopword = isStopword;
        if(info != null)
        {
            this.info.addAll(info);
        }else
        {
            this.info.add(PartOfSpeach.UNKNOWN);
        }
    }

    public boolean isStopword() {
        return isStopword;
    }

    public void setStopword(boolean isStopword) {
        this.isStopword = isStopword;
    }

    public List<String> getBaseForms() {
        return this.baseForms;
    }

    public String getBaseForm() {
        return this.baseForms.get(0);
    }

    public List<PartOfSpeach> getInfo() {
        return info;
    }

    public PartOfSpeach getFirstInfo() {
        return info.get(0);
    }

    public void setBaseForms(List<String> baseForms) {
       this.baseForms.addAll(baseForms);
    }

    public boolean equals(Object object)
    {
        boolean equal = false;

        if(object instanceof Token)
        {
            Token token = (Token) object;
            if(token != null)
            {
              equal = token.getBaseForms().size() == this.getBaseForms().size() && token.getBaseForms().containsAll(this.getBaseForms());
            }
        }
        return equal;
    }

    public String getText() {
        return text;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }
}
