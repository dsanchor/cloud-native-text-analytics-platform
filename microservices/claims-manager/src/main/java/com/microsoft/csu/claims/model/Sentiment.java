package com.microsoft.csu.claims.model;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentenceSentiment;

public class Sentiment {

    private String overallScore;

    private double neutralScore;

    private double negativeScore;

    private double positiveScore;

    private List<SentenceScore> sentencesScore;

    public Sentiment(){};

    public Sentiment(String overallScore, double neutralScore, double negativeScore, double positiveScore,
            List<SentenceScore> sentencesScore) {
        this.overallScore = overallScore;
        this.neutralScore = neutralScore;
        this.negativeScore = negativeScore;
        this.positiveScore = positiveScore;
        this.sentencesScore = sentencesScore;
    }

    public static Sentiment fromDocument(DocumentSentiment ds) {
        Sentiment sentiment = new Sentiment();
        sentiment.setOverallScore(ds.getSentiment().toString().toLowerCase());
        sentiment.setNeutralScore(ds.getConfidenceScores().getNeutral());
        sentiment.setNegativeScore(ds.getConfidenceScores().getNegative());
        sentiment.setPositiveScore(ds.getConfidenceScores().getPositive());
        List<SentenceScore> sentencesScores = new ArrayList<SentenceScore>();
        for (SentenceSentiment ss : ds.getSentences()) {
            SentenceScore sc = 
                new SentenceScore(ss.getText(), 
                    ss.getSentiment().toString().toLowerCase());
            sentencesScores.add(sc);
        }
        sentiment.setSentencesScore(sentencesScores);
        return sentiment;
    }

    public String getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(String overallScore) {
        this.overallScore = overallScore;
    }

    public List<SentenceScore> getSentencesScore() {
        return sentencesScore;
    }

    public void setSentencesScore(List<SentenceScore> sentencesScore) {
        this.sentencesScore = sentencesScore;
    }

    public double getNeutralScore() {
        return neutralScore;
    }

    public void setNeutralScore(double neutralScore) {
        this.neutralScore = neutralScore;
    }

    public double getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(double negativeScore) {
        this.negativeScore = negativeScore;
    }

    public double getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore(double positiveScore) {
        this.positiveScore = positiveScore;
    } 

    
    
}
