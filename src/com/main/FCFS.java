package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FCFS {

	 void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        wt[0] = 0;
 
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }
 
    void findTurnAroundTime(int processes[], int n,
            int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }
 
    public void findavgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
 
        findWaitingTime(processes, n, bt, wt);
 
        findTurnAroundTime(processes, n, bt, wt, tat);
 
        
        System.out.printf("Processes Burst time Waiting"
                    +" time Turn around time\n");
 
        
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("  %d ", bt[i]);
            System.out.printf("  %d", wt[i]);
            System.out.printf("  %d\n", tat[i]);
        }
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }
 
    public void runFCFS(){
        
		int processes[] = {0, 4, 2,1,3};
        int n = processes.length;
        int burst_time[] = {3,2,1,4,8};
        findavgTime(processes, n, burst_time);
    }
}

