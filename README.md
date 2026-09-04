# PacktCass Dev
Code exercises for Mastering Apache Cassandra 3.x (2018 Packt Publishing).

## The Java code requires a running Cassandra cluster, with the following definition:

```SQL
CREATE TABLE security_logs_by_location (
  location_id TEXT,
  day int,
  time_in TIMESTAMP,
  employee_id TEXT,
  mailstop TEXT,
  PRIMARY KEY ((location_id, day), time_in, employee_id)
) WITH CLUSTERING ORDER BY (time_in ASC, employee_id ASC);
```
