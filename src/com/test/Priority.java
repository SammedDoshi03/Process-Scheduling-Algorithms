package com.test;

public class Priority {
	int ETime[] = new int[] { 3, 6, 1, 2, 4 };
	int priority[] = new int[] { 3, 4, 9, 7, 8 };
	int arrivalTime[] = new int[] { 0, 1, 3, 2, 4 };
	String[] processId = new String[] { "P1", "P2", "P3", "P4", "P5" };
	int numberOfProcess = 5;

	void sortAccordingArrivalTimeAndPriority(int[] at, int[] bt, int[] prt, String[] pid) {
		int temp;
		String stemp;
		for (int i = 0; i < numberOfProcess; i++) {
			for (int j = 0; j < numberOfProcess - i - 1; j++) {
				if (at[j] > at[j + 1]) {

					temp = at[j];
					at[j] = at[j + 1];
					at[j + 1] = temp;

					temp = bt[j];
					bt[j] = bt[j + 1];
					bt[j + 1] = temp;

					temp = prt[j];
					prt[j] = prt[j + 1];
					prt[j + 1] = temp;

					stemp = pid[j];
					pid[j] = pid[j + 1];
					pid[j + 1] = stemp;

				}

				if (at[j] == at[j + 1]) {
					if (prt[j] > prt[j + 1]) {
						temp = at[j];
						at[j] = at[j + 1];
						at[j + 1] = temp;

						temp = bt[j];
						bt[j] = bt[j + 1];
						bt[j + 1] = temp;

						temp = prt[j];
						prt[j] = prt[j + 1];
						prt[j + 1] = temp;

						stemp = pid[j];
						pid[j] = pid[j + 1];
						pid[j + 1] = stemp;

					}
				}
			}
		}
	}

	void priority() {
		int finishTime[] = new int[numberOfProcess];
		int bt[] = ETime.clone();
		int at[] = arrivalTime.clone();
		int prt[] = priority.clone();
		String pid[] = processId.clone();
		int waitingTime[] = new int[numberOfProcess];
		int turnAroundTime[] = new int[numberOfProcess];

		sortAccordingArrivalTimeAndPriority(at, bt, prt, pid);

		finishTime[0] = at[0] + bt[0];
		turnAroundTime[0] = finishTime[0] - at[0];
		waitingTime[0] = turnAroundTime[0] - bt[0];

		for (int i = 1; i < numberOfProcess; i++) {
			finishTime[i] = bt[i] + finishTime[i - 1];
			turnAroundTime[i] = finishTime[i] - at[i];
			waitingTime[i] = turnAroundTime[i] - bt[i];
		}

		float sum = 0;
		for (int n : waitingTime)
			sum += n;

		float averageWaitingTime = sum / numberOfProcess;

		sum = 0;
		for (int n : turnAroundTime)
			sum += n;

		float averageTurnAroundTime = sum / numberOfProcess;

		System.out.println("Priority Scheduling Algorithm : ");
		System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "ETime", "ArrivalTime", "Priority",
				"FinishTime", "WaitingTime", "TurnAroundTime");
		for (int i = 0; i < numberOfProcess; i++) {
			System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], bt[i], at[i], prt[i], finishTime[i],
					waitingTime[i], turnAroundTime[i]);
		}
		System.out.format("%100s%20f%20f\n", "Average", averageWaitingTime, averageTurnAroundTime);
	}
}