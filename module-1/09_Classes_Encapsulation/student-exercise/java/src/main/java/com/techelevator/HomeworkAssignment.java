package com.techelevator;

public class HomeworkAssignment {
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	
	public HomeworkAssignment(int possibleMarks, String submitterName) {
		super();
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}

	public int getEarnedMarks() {
		return earnedMarks;
	}

	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}

	public int getPossibleMarks() {
		return possibleMarks;
	}

	public String getSubmitterName() {
		return submitterName;
	}
	
	public String getLetterGrade() {
		int percentScore = (int)(((double) earnedMarks/possibleMarks)*100);
		if (percentScore >= 90) {
			return "A";
		}else if (percentScore >= 80) {
			return "B";
		}else if (percentScore >= 70) {
			return "C";
		}else if (percentScore >= 60) {
			return "D";
		}else {
			return "F";
		}
	}
}
