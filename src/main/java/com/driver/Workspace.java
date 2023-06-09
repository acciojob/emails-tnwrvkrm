package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        if(calendar.size() == 0)
            return 0;
        if(calendar.size() == 1)
            return 1;

        Collections.sort(calendar);

        int maxMeetingCanBeAttended=1;

        for(int i=1; i<calendar.size(); i++){
//            if(calendar.get(i).compareTo(calendar.get(i-1)) > 0) {
//                maxMeetingCanBeAttended++;
//            }
            int j = i-1;
            while(i<calendar.size() && calendar.get(i).getStartTime().compareTo(calendar.get(j).getEndTime()) < 0){
                i++;
            }
            if(i < calendar.size()){
                maxMeetingCanBeAttended++;
            }
        }
        return maxMeetingCanBeAttended;
    }

}
