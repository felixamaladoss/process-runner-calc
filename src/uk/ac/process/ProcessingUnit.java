package uk.ac.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ProcessingUnit {

    // List holds running Processes
    List<Process> machineList = new ArrayList<>();

    // List holds Processes to be run
    List<Process> processList = new ArrayList<>();

    /**
     * Allocate a Machine for every new process comming in
     * based on Machine availability
     *
     * @param newProcess
     */
    private void allocateMachine(Process newProcess) {
        if (machineList.size() == 0) {
            // Adding first Process to Machine list
            machineList.add(newProcess);
        } else {
            for (int i = 0; i < machineList.size(); i++) {
                Process runningProcess = machineList.get(i); // Current Running Process in a Machine
                if (newProcess.getStartTime() > runningProcess.getEndTime()) {
                    // As Existing process completes, Add new Process to same Machine
                    machineList.set(i, newProcess);
                    break;
                } else {
                    // Existing Process still running before starting new Process
                    // Check for next allocated Machine
                    if ((i + 1) == machineList.size()) {
                        // No other machine allocated");
                        // Add Process to new machine ");
                        machineList.add(newProcess);
                        break;
                    } else {
                        // There is machine another allocated; so check if it can be used");
                        continue;
                    }
                }
            }
        }
    }

    public Integer getRequiredMachines() {
        Collections.sort(processList);
        for (int i = 0; i < processList.size(); i++) {
            allocateMachine(processList.get(i));
        }
        return machineList.size();
    }


    private void validateInput(String input) throws InvalidInputException {
        if (!input.startsWith("[["))
            throw new InvalidInputException();
        if (!input.endsWith("]]"))
            throw new InvalidInputException();
        if (!input.contains(","))
            throw new InvalidInputException();
    }

    private void addToProcessList(String proc) throws InvalidInputException {
        try {
            Integer startTime = Integer.parseInt(proc.split(",")[0]);
            Integer endTime = Integer.parseInt(proc.split(",")[1]);
            processList.add(new Process(startTime, endTime));
        } catch (NumberFormatException ne) {
            throw new InvalidInputException();
        }

    }

    public static void main(String[] args) throws InvalidInputException {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++Processing Unit calculates number Machine required for given process List+++++++++++");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Please enter your input as List of array and press enter. For Example");
        System.out.println("[[1,5 ],[7,8],[4,6],[2,8]]");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        // String input = "[[7 ,9]]";
        //String input = "[[7 ,9] ,  [2, 4], [ 9, 10]] ";
        //String input = "[[0,3 ],[ 15, 18],[17, 20], [2,10]]";
        input = input.replaceAll("\\s+", "");
        ProcessingUnit processUnit = new ProcessingUnit();
        processUnit.validateInput(input);
        input = input.substring(2, input.length() - 2);
        if (input.contains("],[")) {
            String strArray[] = input.split("],\\[");
            for (int i = 0; i < strArray.length; i++) {
                String proc = strArray[i];
                processUnit.addToProcessList(proc);
            }
        } else {
            processUnit.addToProcessList(input);
        }
        Integer processingUnit = processUnit.getRequiredMachines();
        System.out.println("Number of Machines required for processing : " + processingUnit);

    }
}
