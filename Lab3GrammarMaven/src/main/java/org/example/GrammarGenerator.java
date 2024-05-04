package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class GrammarGenerator {
    class Node {
        String name;
        Vector<Vector<Node>> matrix_roles;
        ArrayList<String> tokens;

        public void setTokens(ArrayList<String> tokens) {
            this.tokens = tokens;
        }

        public void setMatrix_roles(Vector<Vector<Node>> matrix_roles) {
            this.matrix_roles = matrix_roles;
        }

        String getRandomToken() {
            return tokens.get(new Random().nextInt(tokens.size()));
        }

        Vector<Node> getRandomRules() {
            return matrix_roles.get(new Random().nextInt(matrix_roles.size()));
        }

        Node(String name) {
            this.name = name;
            matrix_roles = new Vector<>();
            tokens = new ArrayList<>();
        }
    }

    Node SentP = new Node("SentP");
    Node SentN = new Node("SenN");
    Node SentQ = new Node("SentQ");
    Node NounGroup = new Node("NounGroup");
    Node Had = new Node("Had");
    Node Not = new Node("Not");
    Node Been = new Node("Been");
    Node V3Group = new Node("V3Group");
    Node AddSent = new Node("AddSent");
    Node Abjective = new Node("Abjective");
    Node NounPronoun = new Node("NounPronoun");
    Node NounObject = new Node("NounObject");
    Node Pronoun = new Node("Pronoun");
    Node V3State = new Node("V3State");
    Node AddState = new Node("AddState");
    Node V3Move = new Node("V3Move");
    Node AddMove = new Node("AddMove");
    Node V3Action = new Node("V3Action");
    Node AddAction = new Node("AddAction");
    Node Preposition = new Node("Preposition");
    Node Place = new Node("Place");
    Node Link = new Node("Link");

    Node V2Group = new Node("V2Group");
    Node V2Action = new Node("V2Action");
    Node V2Move = new Node("V2Move");
    Node V2State = new Node("V2State");

    GrammarGenerator() {
        Dict dict = new Dict();
        Vector<Vector<Node>> helpVec = new Vector<Vector<Node>>() {{
            add(new Vector<Node>() {{
                add(NounGroup);
                add(Had);
                add(Been);
                add(V3Group);
                add(AddSent);
            }});
        }};
        SentP.setMatrix_roles(new Vector<>(helpVec));
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(NounGroup);
            add(Had);
            add(Not);
            add(Been);
            add(V3Group);
            add(AddSent);
        }});
        SentN.setMatrix_roles(new Vector<>(helpVec));
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(Had);
            add(NounGroup);
            add(Been);
            add(V3Group);
            add(AddSent);
        }});
        SentQ.setMatrix_roles(new Vector<>(helpVec));
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(Abjective);
            add(Abjective);
            add(Abjective);
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Abjective);
            add(Abjective);
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Abjective);
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Abjective);
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(NounObject);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Pronoun);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Pronoun);
        }});
        NounGroup.setMatrix_roles(new Vector<>(helpVec));
        Abjective.setTokens(dict.adjectives);
        NounObject.setTokens(dict.nounObjects);
        Pronoun.setTokens(dict.pronouns);
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(V3State);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V3State);
            add(AddState);
        }});
        //helpVec.add(new Vector<Node>() {{ add(V3Move);}});
        //helpVec.add(new Vector<Node>() {{ add(V3Move);add(AddMove);}});
        helpVec.add(new Vector<Node>() {{
            add(V3Action);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V3Action);
            add(AddAction);
        }});
        V3Group.setMatrix_roles(new Vector<>(helpVec));
        V3State.setTokens(dict.V3States);
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(NounObject);
        }});
        AddState.setMatrix_roles(new Vector<>(helpVec));
        V3Move.setTokens(dict.V3Moves);
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(Preposition);
            add(Place);
        }});
        AddMove.setMatrix_roles(new Vector<>(helpVec));
        Preposition.setTokens(dict.prepositions);
        Place.setTokens(dict.places);
        V3Action.setTokens(dict.V3Actions);
        AddAction.setTokens(dict.addAction);
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
        }});
        helpVec.add(new Vector<Node>() {{
            add(AddSent);
        }});
        helpVec.add(new Vector<Node>() {{
            add(Link);
            add(NounGroup);
            add(V2Group);
        }});
        AddSent.setMatrix_roles(new Vector<>(helpVec));
        Link.setTokens(dict.links);
        helpVec.clear();
        helpVec.add(new Vector<Node>() {{
            add(V2State);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V2State);
            add(AddState);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V2Move);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V2Move);
            add(AddMove);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V2Action);
        }});
        helpVec.add(new Vector<Node>() {{
            add(V2Action);
            add(AddAction);
        }});

        V2Group.setMatrix_roles(new Vector<>(helpVec));
        V2State.setTokens(dict.V2States);
        V2Move.setTokens(dict.V2Moves);
        V2Action.setTokens(dict.V2Actions);
        Had.setTokens(dict.had);
        Not.setTokens(dict.not);
        Been.setTokens(dict.been);
    }

    String GenerateQ() {
        return GenerateGen(SentQ) + "?";
    }

    String GenerateP() {
        return GenerateGen(SentP) + ".";
    }

    String GenerateN() {
        return GenerateGen(SentN) + ".";
    }

    String GenerateGen(Node role) {
        Vector<Node> vecNode = new Vector<>();
        vecNode.add(role);
        int amountApply = 0;
        for (int i = 0; i < vecNode.size(); i++) {
            if (!vecNode.get(i).matrix_roles.isEmpty()) {
                amountApply++;
                Vector<Node> helpVec = vecNode.get(i).getRandomRules();
                vecNode.remove(i);
                vecNode.addAll(i, helpVec);
                i--;
            }
        }
        Vector<String> tokens = new Vector<>();
        for (int i = 0; i < vecNode.size(); i++) {
            tokens.add(vecNode.get(i).getRandomToken());
        }
        String sentence = String.join(" ", tokens);

        if (!sentence.isEmpty()) {
            sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
        }
        return sentence;
    }

}
