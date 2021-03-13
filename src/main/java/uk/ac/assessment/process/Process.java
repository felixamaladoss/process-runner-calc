package uk.ac.assessment.process;

public class Process implements Comparable<Process> {

    private Integer startTime;

    private Integer endTime;

    public Process(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Start Time : " + startTime + ";EndTime : " + endTime;
    }

    @Override
    public int compareTo(Process process) {
        return this.startTime - process.startTime;
    }
}
