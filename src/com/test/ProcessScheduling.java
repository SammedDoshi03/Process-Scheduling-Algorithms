package com.test;

import java.io.IOException;
import java.util.Scanner;

import com.main.FCFS;

public class ProcessScheduling {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new ProcessScheduling().makeIt();
	}

	private void makeIt() throws NumberFormatException, IOException {
		int choice = 0;
		Scanner in = new Scanner(System.in);
		FCFS fcfsExample = new FCFS();
		Priority priorityExample = new Priority();
		SJF sjfExample = new SJF();
		RoundRobin roundrobinExample = new RoundRobin();
		System.out.println(
				"Process :" + "\t 1.  FCFS" + "\t 2.  SJF(Preemptive)" + "\t 3.  Priority " + "\t 4.  Round Robin");
		System.out.println("Which process do you to execute :");
		choice = Integer.parseInt(in.nextLine());
		switch (choice) {
		case 1:
			fcfsExample.runFCFS();
			break;
		case 2:
			sjfExample.runSJF();
			break;
		case 3:
			priorityExample.priority();
			break;
		case 4:
			roundrobinExample.runRoundRobin();
			break;	
		}
	}
}
