package com.strescTo.summarizer.weights;


import com.strescTo.tokenizer.entity.Token;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Ranking {
    private Set<TermWeight> rank = new TreeSet<>();

    public Ranking()
    {

    }

    public Ranking(Collection<TermWeight> scores)
    {
        rank.addAll(scores);
    }

    public double getTokenWeight(Token token) {
        return 0;
    }
}
