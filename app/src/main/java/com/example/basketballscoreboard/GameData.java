package com.example.basketballscoreboard;

class Area{

    int numTry; //시도횟수
    int numSuccess; //성공횟수
    int SuccessRate=(this.numTry/this.numSuccess)*100; //성공률
}


public class GameData {

    int ScoreTeamBlue;
    int ScoreTeamYellow;

    Area area[]=new Area[6];



}
