
## SQL Overview

### RDBMS
- **Relational Database Management System (RDBMS)**: Stores data in tables with defined relationships.
- **Key Properties**:
  - **Atomicity**: Each transaction is "all or nothing".
  - **Unique Rows**: Each row in a table is unique.
  - **Same Data Type**: Each column contains values of the same type.
  - **Order Irrelevant**: The order of rows and columns doesn't matter.
  - **Unique Column Names**: Each column name in a table is unique.

### Normalization
- **Normalization**: Organizing data to minimize redundancy.
  - **1NF**: Ensure unique values per column.
  - **2NF**: Eliminate partial dependencies.
  - **3NF**: Remove transitive dependencies.
  - **4NF**: Avoid multi-valued dependencies.
  - **5NF**: Isolate semantically related relationships.
- **DeNormalization**: Adding redundancy for performance gains.

### ACID Properties
- **Atomicity**: Transactions are "all or nothing".
- **Consistency**: Transactions leave the database in a valid state.
- **Isolation**: Transactions do not interfere with each other.
- **Durability**: Completed transactions persist, even in a system failure.

### Indexing
- **Index**: A structure that improves data retrieval speed.

### SQL Operations
- **Dirty Read**: Reading uncommitted changes, potentially incorrect.
- **Locks**:
  - **Shared**: Used for read operations.
  - **Update**: Prevents deadlocks by transitioning to exclusive when needed.
  - **Exclusive**: Used for write operations, preventing concurrent modifications.
  - **Bulk Update, Intent, Schema, Pessimistic, Optimistic Locks**: Specialized locks for different scenarios.
  
### Connection Pooling
- **Connection Pool**: Manages connections efficiently by reusing them.

### Relationships
- **1-to-1**: One-to-one relationship.
- **1-to-Many**: One record in a table relates to multiple records in another.
- **Many-to-Many**: Many records in one table relate to many in another via a junction table.

## SQL Commands

### DDL (Data Definition Language)
- **CREATE TABLE**: Define a new table.
  ```sql
  CREATE TABLE Person (
    FirstName VARCHAR(MAX) NOT NULL,
    PhoneNumber VARCHAR(MAX) NULL
  );
  ```
- **ALTER TABLE**: Modify an existing table.
  ```sql
  ALTER TABLE Person
  ADD Education VARCHAR(50) NULL;
  ```

### DML (Data Manipulation Language)
- **SELECT**: Retrieve data from a table.
  ```sql
  SELECT FirstName, LastName FROM PersonTable;
  ```
- **INSERT**: Add new records to a table.
  ```sql
  INSERT INTO OrderTable (OrderId, OrderName) VALUES ('1', 'OneToy');
  ```
- **UPDATE**: Modify existing records in a table.
  ```sql
  UPDATE OrderTable SET OrderPrice = 10 WHERE OrderId = 1;
  ```
- **DELETE**: Remove records from a table.
  ```sql
  DELETE FROM OrderTable WHERE OrderId = 10;
  ```

### TCL (Transaction Control Language)
- **COMMIT**: Save all changes made in the transaction.
- **ROLLBACK**: Undo changes made in the current transaction.
- **SAVEPOINT**: Define a point in a transaction to which you can roll back.
- **SET TRANSACTION**: Specify transaction characteristics.

### DCL (Data Control Language)
- **GRANT**: Give access privileges to a user.
- **REVOKE**: Remove access privileges.

### SQL Statements and Clauses
- **DISTINCT**: Select unique values.
  ```sql
  SELECT DISTINCT FirstName FROM PersonTable;
  ```
- **GROUP BY**: Aggregate data based on columns.
  ```sql
  SELECT Department, COUNT(OrderId) FROM OrderTable GROUP BY Department;
  ```
- **HAVING**: Filter results after `GROUP BY`.
  ```sql
  SELECT Department, COUNT(OrderId)
  FROM OrderTable
  GROUP BY Department
  HAVING COUNT(OrderId) > 3;
  ```

### SQL Joins
- **INNER JOIN**: Return only matching records from both tables.
  ```sql
  SELECT emp.FName, ord.OrderName
  FROM EmployeeTable emp
  INNER JOIN OrderTable ord ON emp.OrderId = ord.OrderId;
  ```
- **LEFT JOIN**: Return all records from the left table and matching records from the right.
- **RIGHT JOIN**: Return all records from the right table and matching records from the left.
- **FULL JOIN**: Return all records when there is a match in either table.
- **SELF JOIN**: Join a table to itself.
- **CROSS JOIN**: Return Cartesian product of two tables.

### SQL Operators
- **BETWEEN**: Select records within a range.
  ```sql
  SELECT * FROM EmployeeTable WHERE Salary BETWEEN 500 AND 600;
  ```
- **EXISTS / NOT EXISTS**: Check for existence of rows in a subquery.
- **IN**: Match values in a list.
  ```sql
  SELECT * FROM EmployeeTable WHERE Salary IN (500, 600, 700);
  ```
- **LIKE**: Match a pattern.
  ```sql
  SELECT * FROM EmployeeTable WHERE FirstName LIKE 'Tej%';
  ```
- **INTERSECT**: Return common rows from two queries.
