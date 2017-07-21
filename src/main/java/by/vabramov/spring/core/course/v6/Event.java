package by.vabramov.spring.core.course.v6;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id = Math.abs(new Random().nextInt());
    private String msg;
    private Date date;
    private DateFormat dateFormat;
    private EventType eventType;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType='" + String.valueOf(eventType) + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
