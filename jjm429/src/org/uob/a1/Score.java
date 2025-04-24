package org.uob.a1;

public class Score {
    private int startingScore;
    private int currentScore;
    private int roomsVisited;
    private int puzzlesSolved;
    private final int PUZZLE_VALUE = 10;

    //create methods for all score related tasks needed in game
    public Score(int startingScore)
    {
        this.startingScore = startingScore;

    }

    public void visitRoom()
    {
        this.roomsVisited++;

    }

    public void solvePuzzle()
    {
        this.puzzlesSolved++;
        //give the user a hint that they have solved a puzzle
        System.out.println("You can feel your power increasing...");

    }

    //calc score
    public double getScore()
    {
        currentScore = startingScore - roomsVisited + (puzzlesSolved*PUZZLE_VALUE);
        return currentScore;
    }
    
        
}