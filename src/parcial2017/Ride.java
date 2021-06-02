package parcial2017;

import queue.DynamicQueue;
import util.IsEmptyException;

public class Ride implements Comparable<Ride>{
    private String name;
    private int capacity;
    private int totalWaitTime;
    private DynamicQueue<Visitor> normalQueue;
    private DynamicQueue<Visitor> fpQueue;
    private int popularity;
    private Visitor[] currentVisitorsInRide;
    private int totalVisitors;
    private double averageWaitTime;


    public Ride(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.totalVisitors = 0;
        this.normalQueue = new DynamicQueue<>();
        this.fpQueue = new DynamicQueue<>();
        this.totalWaitTime = 0;
        this.popularity = -1;
        this.currentVisitorsInRide = new Visitor[capacity];
    }

    public void addVisitor(Visitor visitor){
        if(!visitor.isFastPass() || fpQueue.size()==20){
            normalQueue.enqueue(visitor);
        } else{
            fpQueue.enqueue(visitor);
            visitor.useFastPass();
        }
        totalVisitors++;
        checkPopularity();
    }

    public void checkPopularity(){
        int totalVisitors = fpQueue.size() + normalQueue.size();
        if(totalVisitors > 80) this.popularity = 1;
        this.popularity = 10- totalVisitors/100;
    }




    public void cycle(Hub hub){
        if(currentVisitorsInRide[0] != null){
            for (int i = 0; i < currentVisitorsInRide.length; i++) {
                totalWaitTime += hub.getOpenTime() - currentVisitorsInRide[i].getRideEntranceTime();
            }

            hub.receiveVisitors(currentVisitorsInRide);
        }
        for (int i = 0; i < currentVisitorsInRide.length; i++) {
            try {
                if (fpQueue.size() != 0) {
                    currentVisitorsInRide[i] = fpQueue.dequeue();
                } else if (normalQueue.size() != 0) {
                    currentVisitorsInRide[i] = normalQueue.dequeue();
                }
            } catch (IsEmptyException e){
                break;
            }
        }
    }

    public void computeAverageWaitTime(){
        this.averageWaitTime = totalWaitTime/totalVisitors;
    }

    public double getAverageWaitTime() {
        return averageWaitTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Ride o) {
        if(o == null) return 1;
        return Integer.compare(this.popularity, ((Ride)o).popularity);
    }
}
