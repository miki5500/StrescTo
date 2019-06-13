package com.strescTo.summarizer.weights;

import com.strescTo.tokenizer.entity.Token;

public class TermWeight implements Comparable {

    private Token token;
    private double weight;


    public Token getToken() {
        return token;
    }

    public double getWeight() {
        return weight;
    }

    public TermWeight(Token token, double result)
    {
        this.token = token;
        this.weight = result;
    }


    @Override
    public int compareTo(Object o) {
        TermWeight objectO = (TermWeight) o;
        if(this.getWeight() > objectO.getWeight())
        {
            return -1;
        }else if(this.getWeight() == objectO.getWeight())
        {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString(){
        return token+ " weight ="+ weight;
    }
}
