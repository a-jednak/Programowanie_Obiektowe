package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    private final List<Simulation> simulations;
    private final List<Thread> threads = new ArrayList<>();
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync() throws InterruptedException {
        for(Simulation simulation : simulations){
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
        awaitSimulationsEnd();
    }

    private void awaitSimulationsEnd() throws InterruptedException {
        for(Thread thread : threads){
            thread.join();
        }
        threadPool.shutdown();
        if(!threadPool.awaitTermination(10, TimeUnit.SECONDS)){
            threadPool.shutdownNow();
        }
    }

    public void runAsyncInThreadPool() throws InterruptedException {
        for(Simulation simulation : simulations){
            threadPool.submit(simulation);
        }
        awaitSimulationsEnd();
    }
}
