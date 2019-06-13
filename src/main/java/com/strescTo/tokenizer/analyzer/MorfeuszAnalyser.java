package com.strescTo.tokenizer.analyzer;

import com.strescTo.tokenizer.entity.Token;
import pl.sgjp.morfeusz.Morfeusz;
import pl.sgjp.morfeusz.MorphInterpretation;

import java.util.List;


public class MorfeuszAnalyser implements Analysis {

    private Morfeusz morph = Morfeusz.createInstance();
    @Override
    public Token getToken(Token token) {

        List<MorphInterpretation> analysis = morph.analyseAsList(token.getText());
        token.setLemma(analysis.get(0).getLemma());

        return token;
    }
}
