package com.practice.graph;
/*
Leetcode#997. Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
*/	
public class FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] beingTrusted = new int[N + 1];
        int[] whoTrust = new int[N + 1];

        for(int row = 0; row < trust.length; row++) {
            whoTrust[trust[row][0]]++;
            beingTrusted[trust[row][1]]++;
        }

        for(int index = 1; index < beingTrusted.length; index++) {
            if((beingTrusted[index] == (N-1)) && (whoTrust[index] == 0)){
                return index;
            }

        }
        
        return -1;
    }


}
