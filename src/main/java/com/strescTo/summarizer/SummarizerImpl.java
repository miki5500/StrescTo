package com.strescTo.summarizer;

import com.strescTo.Conf.Configuration;
import com.strescTo.summarizer.weights.Ranking;
import com.strescTo.summarizer.weights.Weight;
import com.strescTo.tokenizer.entity.Article;
import com.strescTo.tokenizer.entity.Sentence;
import com.strescTo.tokenizer.entity.Token;

import java.util.*;

public class SummarizerImpl implements Summarizer {

    private int summarylength = 5;

    private Weight weight;

    protected Article article;

    public SummarizerImpl(Article article, Configuration conf)
    {
        this.summarylength = conf.getSummaryLength();
        this.article = article;
    }

    public SummarizerImpl(Article article)
    {
        this.article = article;
    }



    @Override
    public List<Sentence> summarize(String text) {
        return null;
    }

    @Override
    public List<Sentence> summarize() {
        List<Sentence> sentences = article.getSentences();
        if(sentences.size() <= 0)
        {
            return new ArrayList<>();
        }
        if(sentences.size() <= this.summarylength)
        {return sentences;}else {
         return getSummary() ;
        }

    }

    private List<Sentence> getSummary() {

        List<Sentence> sentences = article.getSentences();
        List<Sentence> summary = new ArrayList<>();
        SortedMap<Double,Integer> sentenceMap = new TreeMap<>();
        Ranking ranking = weight.getKeywords();

        //sentences weights
        for(int i = 0; i < sentences.size(); i++)
        {
            double sentenceWeight = 0.0;

            for(Token token: sentences.get(i).getTokens())
            {
                sentenceWeight += ranking.getTokenWeight(token);
            }

            sentenceMap.put(sentenceWeight,i);
        }

        TreeMap<Double,Integer> sortedSentenceWeight = new TreeMap<>(sentenceMap);

        int count = 0;
        for(double weight:sortedSentenceWeight.keySet())
        {
            if(count >= this.summarylength)
        {
           return summary;
        }
            summary.add(sentences.get(sortedSentenceWeight.get(weight)));

        }

        return summary;
    }
}
