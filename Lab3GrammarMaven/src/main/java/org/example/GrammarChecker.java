package org.example;

import java.util.ArrayList;

public class GrammarChecker {
    Dict dict;
    int curr_index;
    ArrayList<String> tokens ;
    String currWord;

    void NextWord() throws RuntimeException{
        curr_index++;
        if(curr_index<tokens.size())
            currWord=tokens.get(curr_index);
        else throw new RuntimeException("0");
    };


    void SentenceP()throws RuntimeException{
        curr_index=0;
        currWord=tokens.get(0);
        NounGroup();
        if(currWord.equals("had")) NextWord(); else throw new RuntimeException("0");
        if(currWord.equals("been")) NextWord(); else throw new RuntimeException("0");
        V3Group();
        AddSent();
    }

    void SentenceN()throws RuntimeException{
        curr_index=0;
        currWord=tokens.get(0);
        NounGroup();
        if(currWord.equals("had"))  NextWord();  else throw new RuntimeException("0");
        if(currWord.equals("not")) NextWord();  else throw new RuntimeException("0");
        if(currWord.equals("been")) NextWord();  else throw new RuntimeException("0");
        V3Group();
        AddSent();
    }
    void SentenceQ()throws RuntimeException{
        curr_index=0;
        currWord=tokens.get(0);
        if(currWord.equals("had"))  NextWord();  else throw new RuntimeException("0");
        NounGroup();
        if(currWord.equals("been")) NextWord();  else throw new RuntimeException("0");
        V3Group();
        AddSent();
    }
    void NounGroup()throws RuntimeException{
        while(! NounPronounCelebrity()){
            Abjective();
        }
    };
    void V3Group()throws RuntimeException{
        if(!V3Action() && !V3Move() && !V3State()){
            throw new RuntimeException("1");
        }
    }
    void V2Group()throws RuntimeException{
        if(!V2Action() && !V2Move() && !V2State()){
            throw new RuntimeException("2");
        }
    }
    void AddSent()throws RuntimeException{
        if(currWord.equals(".") ||currWord.equals("?"))
            return;
        Link();
        NounGroup();
        V2Group();
        AddSent();
    }



    boolean NounPronounCelebrity() throws RuntimeException{
        if(currWord.equals("the")){
            NextWord();
            if(dict.adjectives.contains(currWord)) {
                NextWord();
                return true;
            }
        }
        if( dict.nounObjects.contains(currWord) || dict.pronouns.contains(currWord)){
            NextWord();
            return true;
        }
        return false;
    }

    boolean V3State(){
        if(dict.V3States.contains(currWord)){
            NextWord();
        }
        else
            return false;
        NounPronounCelebrity();
        return true;
    }

    boolean V3Move(){
        if(dict.V3Moves.contains(currWord)){
            NextWord();
        }
        else
            return false;
        if(dict.prepositions.contains(currWord)) {
            NextWord();
            if(dict.places.contains(currWord))
                NextWord();
            else{
                return false;
            }
        }
        return true;
    }

    boolean V3Action(){
        if(dict.V3Actions.contains(currWord)){
            NextWord();
        }
        else
            return false;
        if(dict.addAction.contains(currWord)) {
            NextWord();
        }
        return true;
    }


    boolean V2State(){
        if(dict.V2States.contains(currWord)){
            NextWord();
        }
        else
            return false;
        NounPronounCelebrity();
        return true;
    }

    boolean V2Move(){
        if(dict.V2Moves.contains(currWord)){
            NextWord();
        }
        else
            return false;
        if(dict.prepositions.contains(currWord)) {
            NextWord();
            if(dict.places.contains(currWord))
                NextWord();
            else{
                return false;
            }
        }
        return true;
    }

    boolean V2Action(){
        if(dict.V2Actions.contains(currWord)){
            NextWord();
        }
        else
            return false;
        if(dict.addAction.contains(currWord)) {
            NextWord();
        }
        return true;
    }





























    void Abjective() throws RuntimeException{
        if(dict.adjectives.contains(currWord)){
            NextWord();
        }
        else {
            throw new RuntimeException("1");
        }
    }
    void Link() throws RuntimeException{
        if(dict.links.contains(currWord)){
            NextWord();
        }
        else {
            throw new RuntimeException("2");
        }
    }





    GrammarChecker(){
        dict = new Dict();

    }
    void setTokens(ArrayList<String> tokens){
        this.tokens = tokens;
    }

}
