package model;

import operation.Operation;
import state.State;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 20.09.2016
 */
public class Task {

    private State state;
    private Calendar startTime;
    private Calendar updateTime;
    private List<Operation> operations;

    public Task(State state, Calendar startTime, Calendar updateTime) {
        this.state = state;
        this.startTime = startTime;
        this.updateTime = updateTime;
        this.operations = new ArrayList<>();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public List<Operation> getOperations() {
        return this.operations;
    }
}
