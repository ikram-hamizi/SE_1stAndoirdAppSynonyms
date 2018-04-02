package com.example.cstech.se4_2;

public class WordSynTuple {

    private String word;
    private String syn;

    public WordSynTuple(String word, String syn){
        this.word = word;
        this.syn = syn;
    }
    public WordSynTuple()
    {

    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public String getSyn()
    {
        return syn;
    }

    public String getWord() {
        return word;
    }

    public void setSyn(String syn) {
        this.syn = syn;
    }

    //If word exists in DB
}
