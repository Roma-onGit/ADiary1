package com.roma;

import java.util.Date;
import java.util.Objects;
import java.text.SimpleDateFormat;

import javax.persistence.*;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String date;
    private String records;

    public Record()  {

    }

    public Record(long id, String date, String records) {
        this.id = id;
        this.date = date;
        this.records = records;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @PrePersist
    void createAt()  {

        date = new SimpleDateFormat().format(new Date());
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return id == record.id &&
                Objects.equals(date, record.date) &&
                Objects.equals(records, record.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, records);
    }

    @Override
    public String toString() {
        return "Your record at:"
                + date + "\n"
                + records + "\n"
                + "Id of record: " + id;
    }

    public long getId() {
        return id;
    }
}
