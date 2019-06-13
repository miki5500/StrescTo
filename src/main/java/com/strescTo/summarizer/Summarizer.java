package com.strescTo.summarizer;

import com.strescTo.tokenizer.entity.Article;
import com.strescTo.tokenizer.entity.Sentence;

import java.util.List;

public interface Summarizer {

    List<Sentence> summarize(String text);

    List<Sentence> summarize();


}
