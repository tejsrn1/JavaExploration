1. Theory:

    - RDBMS :
        - Relational database management system i.e it has data / record and index stored in table.
        - Interdependecies among these table are express by datavalues rahter any pointer and that is why RDBMS allows high independece.
        - Property:
            - Atomic
            - Row is unique
            - Column values are same kind.i.e FirstName column with varchar has all varchar datatype items.
            - Sequence of column/row  is not important.
            - Column name must be unique.

    - Normalization:
        - it is a database design and organization process of data
        - organization of data such that minimize redundancy is called normalization.
        - how to organize then? Divide data in two or more table and define relationship between them.
        - How to do it? any Rules?
            -  First Normal Forms 1NF:
                - Table must have column that contains differnt value.
                    - e.g
                      Column = Subject has OS,Java IS INCORRECT
                      Column = Subject SHOULD have only  OS or Java.


				- Table must have column that contains same domain name value
					- e.g. DateOfBirth column should not contain some one firstname.
				- Columns in a table should have unique names 
				- order in which data is stored, should not matter.
			- Second Normal Form 2NF
				- 1NF + Should not have Partial dependency
				- Partial dependency ie. Composite primary key does not fully represent as one of the column only requires either primary key not composite key.
				- how to fix? move that column in related table of that primary key so that composite primary key make sense.
			- Third Normal Form 3NF
				- 2NF +  Does not have Transitive  dependency.
				- Transitive Dependency. When a non-prime column depends on other non-prime column rather than depending upon the prime column or primary key
				- Adv : duplicate removed and achieved data integrity.
				
			- Fourth Normal Form : 4NF
				- 3NF + doesn't have Multi-Valued Dependency.
				
			- Fifth Normal Form : 5NF 
				- 4NF + Isolate Semantically Related Multiple Relationships	
				- I.E. There may be practical constrains on information that justify separating logically related many-to-many relationships.
			- ONF: Optimal Normal Form
			- DKNF: Domain-Key Normal Form
	
	- DeNormalization:
		- it is a database design and organization process of data to let redundent data in table to achieve higher performance.
		- why Normalization is not giving higher performance ? bcs current RDBMS system is not highly normalized at logical level while providing physical storage of data that tuned for high performance.
	- What is ACID property? It is a concep we should look while DB design and Architecutre design.
		- Atomicity 
			- i.e All or none  Atomicity guarantees that the transaction completes in an all-or-nothing manner
		- Consistency
			 - transaction never leave database in half finished state.
		- Isolation 
			- keep transaction separate from each other until they are finished.
		- Durablity
			- guarantees that the database will keep track of pending changes in such a way that the server can recover from an abnormal termination.
			
	- Index :
		- Index is a physical structure containing pointers to the data
		- locate rows more quickly and efficiently
	- Dirty Read:
		- When Read and Write operation occures same time and Read operation read uncommited changes done by write which may not be correct as write may not commit that chages.
	- Locks:
		- Different Types of Locks
			- Shared : Used for read operation only by SELECT 
			- Update : Used on resources that can be updated and prevents deadlock to occures.
				-It is kind of exclusive lock but when reading data this lock is ok if anyohter shared lock is already there but when its ready to update it covert itself in to exclusive lock and this way it try to avoid deadlock as much it can.
			- Exclusive :  Uesd on UPDATE/INSERT/DELETE and not allowing multiple data modification on same resource at sametime.
			- Bulk Update Locks: Used when bulk-copying data into a table.
			- Intent : Used to establish a lock hierarchy. The types of intent locks are as follows: intent shared (IS), intent exclusive (IX), and shared with intent exclusive (SIX
			- Schema : Used when an operation dependent on the schema of a table is executing. The types of schema locks are schema modificatio
			- Pessimistic Lock :
				- Lock the resouces for your exclusive use until you have finished it.
				- provide much better integrity but also create deadlock.
			- Optimistic Lock : 
				- It is stratergy lock where you take note of version of record while reading and before you update it back that record you verify if it has same version if yes then go ahead and update and if not abort operation.	
		
	- Connection Pool :
		- TO minimize cost of opening and closing connection ADO.NET OR JDBC will use techniques calls connection pool.
		- Pooler (whichever framwork proives ado or jdbc) owns physical connection and keep alive connection based on connection configuration.
		- upon request for open connection pool pooler give it from available connection and upon close pooler pool take back connection and keep it for further use rather cacutally closing it.
	- 1-1/1-Many/Many-Many Relationships
		- 1 to 1 moslty wiht single table and rarely with second table via PK=FK
		- 1 to Many : BY splitting data in two table and relate wiht PK and FK.
		- Many to Many : by using a junction table with the keys from both the tables forming the composite primary key of the junction table.
			- e.g. One product can have many order likewise one order has many product.
				Product table has many products
				Order table has many orders
				Cart Table has ProdcutID+OrderId to represent which order for which product.


2. SQL
    - SQL Create /Alter Table
      Create Table Person
      (
      FirstName varchar(max) {NOT NULL},
      PhoneNumber varchar(max) {NULL}
      );

      Alter Table Person
      ADD Education varchar(50) {NULL}

    - SQL Data Type
        - Differnt Types like
            - Int 4bytes ,tinyint 1 bytest ,smallint 2 bytes, bigint 8 bytes, money 8 bytes, smallmoney 4 bytes, decimal(precision,scale) 5to17 bytes, numeric(p,s) its same like decimal, float(n) with precision of 7 digits, real same as float(24)
            - char , nchar , varchar , varchar(max) , nvarchar, nvarchar(max)
            - bit 1 byte = 8 bit, binary,varbinary , varbinary(max)
            - DateTime
            - varchar vs nvarchar : nvarchar stores unicode and takes double space then defined. ie. 2n .
            -
    - SQL DDL Commands
        - create and modify structure of database and its objects.
        - Create (table ,index , view ...) , Alter, Drop, Truncate, Rename
    -  SQL DML Commands
        - its Data Manipulation command i.e play with data inside database.
        - Select, Insert , Update and Delete.
    - SQL TCL Commands
        - Transaction Control command to control transaction
        - Commit,Rollback,SavePoint(save point so that it will start from this point nexttime), Set Transaction(to specifie transaciton char)
    - SQL DCL Commands
        - Data control command to control access permission to data.
        - GRANT, REVOKE

    - SQL Statements:

        - SELECT
            - Select ColumnName from TableName
            - Select FirstName AS FName from PersonTable
            - Select FirstName  FName from PersonTable
            - Select FirstName + LastName AS FullName from PersonTable
        - DISTINCT -
            - If NULL as value it will also return as its distinct.
            - Select DISTINCT FirstName from PersonTable
            - Select DISTINCT FirstName, LastName from PersonTable
            - Select Eductation , COUNT(DISTINCT EmpID) AS TotalEmployee from Employee group by Education
                - This will get count of each distinct employee against their education.
                - e.g Master degree total employee is 5

        - SELECT INTO :
            - to add data into table.
            - it will create first new table and then insert selected data from select statment.
            - Select FName,LName,SSN into NewPersonSummaryTable from PersonTable where Salary >=10;
            - Select PersonTable.FName , EmployeeTable.Education INTO BonusTable from EmployeeTable inner join .....

        - INSERT :
            - Insert into OrderTable (OrderId,OrderName) values ('1','OneToy'); // only listed column added.
            - Insert into OrderTable values ('1','TwoToy','$5'); // all columns added
            - Insert into OrderTable
              values ('1','TwoToy','$5'),
              ('2','ThreeToy','$52'); // multiple record added to all columns.

            - Insert Into OrderTable
              Select OrderId,OrderName,OrderPrice from oldOrderTable where... // multiple record added to all columns using select.

        - Update :
            - Update OrderTable
              SET OrderPrice = $10,
              OrderName = SecondToy,
              OrderSurchage = OrderPrice % 2 // this is runtime calculation using existing column.
              where OrderId = 1;

            - Update OrderTable
              SET OrderSurchage =
              (
              Select OLDSurcharge from OrderTable  // here we are reading from same table by using select .
              where ....

              );

            - Update OrderTable
              SET OrderSurchage =
              (
              Select stateSurchate + FederalSurchage from ExternalTable  // here we are reading from some other table table by using select .
              where ....

              );
        - DELETE :
            - Delete from OrderTable
            - Delete from OrderTable where orderId =10;
            - Delete Top(5) from OrderTable;
            - Delete ordDel from OrderTable AS ordDel // will delete OrderTable but only record which match Inner Join condition match.
              Inner Join CustomerTable cus
              ON cus.OrderId = ordDel.OrderId
            - Delete from OrderTable
              where OrderID IN
              (
              Select OrderId from CustomerTable where OrderStatus = 'Canceled';
              )
        - Truncate :
            - remove records from table like Delete
            - Unlike Delete it will not support where clause
            - Fast bcs not row level lock only table level and also no transaciton supported.
            - Unlike Delete it will reset any Identity value

            - e.g.  Truncate OrderTable

        - SubQuery  aka Inner Query aka nested Query aka inner select query
            - SQL Sub query can be nested inside Select,Insert,Update,Delete as seen earlier and even another sub query.
            - Mostly used in Where clause like NOT IN (--sub query --) or IN (--sub query --)
            - e.g.
                - Select subTbl.FName, subTbl.LName from
                  (
                  Select Fname, LName from EmployeeTable  where Salary <5;
                  ) AS subTbl;

                - Select Fname,LName,
                  (
                  Select SUM(Salary) from EmployeeTable where Department ='IT'
                  )
                  AS TotalIncome
                  from EmployeeTable where Department = 'IT'

                - Select Fname,LName from EmployeeTable  // get all employee whose salary is > avg salary of Fed Emploee of HR department.
                  where Salary >
                  (
                  Select AVG(Salary) from FedEmployeeTable where Dept ='HR';
                  )


	- SQL Clauses :
		- Order By
			- Select * from EmployeeTable Order By Salary DESC
			- Select * from EmployeeTable Order By 8 ASC // by # of column
			- Select * from EmployeeTable Order By FName ASC, LName DSCD 
			
		- TOP	
			- Select TOP(10) from OrderTable;
		- Where
			- Select TOP(10) from OrderTable where Salary < 99;
			- Select TOP(10) from OrderTable where 1=2 ; // using some math or general condition i.e here 1=2? False i.e it will not return anything
		- Group By
			- returns the aggregated data by grouping column(s)
			- e.g. find out the Total number of Sales by region then group by region column and use function SUM to get total sales.
			- Find total orderID in Deparment group.
				- Select Department, COUNT(orderId) from OrderTable group by Department
					Food 3
					Toy 2
					Garden 4
				- Select Department, COUNT(orderId) from OrderTable group by Department ,OrderDate
					Food 3 1/12/2019
					Toy 2 2/13/2019
					Garden 4 1/12/2019
				- Select Department, COUNT(orderId) from OrderTable 
					where Department <> 'IT' 
					group by Department
					Order BY Count(OrderId) desc
		- Having
			- to restrict the number of rows (or records) returned by the Group By Clause
			- only works with Group by since where in group by will not work aginst aggregated data.
			- e.g.
				- Select Department, COUNT(orderId) 
					from OrderTable 
					group by Department
					Having COUNT[orderId] > 3;
		
				- Select Department, 
					 COUNT(orderId) , AVG(OrderShippingCharge)
					from OrderTable 
					group by Department
					Having COUNT[orderId] > 3 AND AVG(OrderShippingCharge) <9;
					
				- Select Department, COUNT(orderId) 
					from OrderTable 
					group by Department
					Having COUNT[orderId] > 3;
					OrderBy COUNT[orderId] Desc
					
				- Where + Having => below e.g will take out Grocery Deparment first then apply group and then having condition
					
					Select Department, COUNT(orderId) 
					from OrderTable 
					where Department <> 'Grocery'
					group by Department
					Having COUNT[orderId] > 3;
				
	- SQL Joins 	
		- Inner Join : Display record which exists in both table.
			- Select emp.FName , ord.OrderName
				from EmployeeTable emp
				Inner Join OrderTable ord
				ON emp.orderId = ord.OrderId
				where emp.Salary > 8
				Order By emp.FName desc
				
		- Left Join : Display all record from Left table and return only matched from Right table.
			- Select emp.FName , ord.OrderName
				from EmployeeTable emp
				Left Join OrderTable ord
				ON emp.orderId = ord.OrderId
				where emp.Salary > 8
				Order By emp.FName desc 
		- Right Join : Display all record from Rigth table and return only matched from Left table.
			- Select emp.FName , ord.OrderName
				from EmployeeTable emp
				Right Join OrderTable ord
				ON emp.orderId = ord.OrderId
				where emp.Salary > 8
				Order By emp.FName desc 
					
		- Full Join : Display all records from both table regardless matched or not and when not matched represent as NULL.
			- Select emp.FName , ord.OrderName
					from EmployeeTable emp
					Full Join OrderTable ord
					ON emp.orderId = ord.OrderId
					where emp.Salary > 8
					Order By emp.FName desc 
			
		- Self Join : 
			- to Join table to itself but only where it has PK and FK.
			- Select emp1.FName , emp1.LName , emp2.FName + emp2.LName`
				from EmployeeTable emp1 ,
					 EmployeeTable emp2
				where emp1.DeptId= emp2.Id 
				--------------------------
				Id fnm lnm  depthe depid
				1 Greg Down GregDown 1
				2 Gally Bronw GregDown 1
				
		- Cross Join : 
			- return crtesian product (i.e Rows of table 1 x Rows of table 2 ) from both table.
			- i.e for each row in table one goes aginst all rows of table 2 and so one.
			
			- Select emp.FName , ord.OrderName
					from 
					EmployeeTable emp
					Cross Join
					OrderTable ord
					
					
	- SQL Operator	: 
	
		- Between : return records between two range including them.
			- Select * from EmployeeTable where salary between 500 AND 600;
			- will return employee with in 500 and 600 
		- Exists :
			- It will run against SubQuery if Subquery return rows Exists = true otherwise Exists = false.
			- If Exists = true then main query will return record otherwise no record will be returned.
			
			- Select * from EmployeeTable // WILL return only all employee if they had placed order.
				where Exists
				(
					Select * from OrderTable where orderCreated IS NOT NULL;
				)
					
		- NOT Exists : opposite to Exists.
			- Select * from EmployeeTable // WILL return only all employee if they had NOT placed order.
				where NOT Exists
				(
					Select * from OrderTable where orderCreated IS NOT NULL;
				)
					
		- IN : For given expression If there is at least one match select statment will return records.
			
			- Select * from EmployeeTable 
				where employeeSalary
				IN (5,1,29); // anyone has salary from this list select will return rows.
				
			** Here coloumns  names c1, c2 and c3 are in IN() Clause 
				SELECT * FROM table
				WHERE 'Yellow' IN (C1, C2, C3)
				
		- LIKE : worked based on matching pattern.
		
			- Select * from EmployeeTable 
				where firstName 
				Like 'Te%'
				Like 'T%L'
				Like '%jp_L'
				Like 'Tejpa_'
				Like 'Tej__L'
				Like '[TM]' either Tejpal or Montu
				Like '[^TM]' Neither Tejpal or Montu
				
		- INTERSECT	: Return rows exists in both Left query and Right query.
			- # of column must be same
			- datatype of cloumn must be compitable.
			- order of column must be same.
			
			- Select ID,FName,SSN 
				from EmployeeTable
				
				INTERSECT
				
			  Select ID,FName,SSN
				from StateEmployeeTable
				
			- Select ID,FName,SSN 
				from EmployeeTable
				where salary >55 
				INTERSECT
				
			  Select ID,FName,SSN
				from StateEmployeeTable
				
					
		- EXCEPT : Return rows FROM left query that are NOT present in right query.
		
			- # of column must be same
			- datatype of cloumn must be compitable.
			- order of column must be same.
			
			- Select ID,FName,SSN  // WILL return only records present in employee table ONLY..
				from EmployeeTable
				
				EXCEPT
				
			  Select ID,FName,SSN
				from StateEmployeeTable			
					
			- Select ID,FName,SSN  // WILL return only records present in employee table ONLY..
				from EmployeeTable
				where salary < 45;
				EXCEPT
				
			  Select ID,FName,SSN
				from StateEmployeeTable		
					
		- UNION : combine distinct results from two or more select statment
		
			- Rows of Select 1 + Rows of Select 2 + Rows of Select 3
			- DISTINCT rows only
			- # of column must be same
			- datatype of cloumn must be compitable.
			- order of column must be same.
			
			- Select employeeId from EmployeeTable // will return all distinct rows from both queries.
				UNION
			  Select employeeId from StateEmployeeTable
					
			- Select employeeId from EmployeeTable // will return all distinct rows from both queries.
				UNION
			  Select employeeId from StateEmployeeTable
			  Order by bonus desc
			  
			- Select employeeId from EmployeeTable // will return all distinct rows from both queries.
			  where salary <56
				UNION
			  Select employeeId from StateEmployeeTable
			  Order by bonus desc  
			
			- Union with same table to remove duplicate rows.
				
				Select employeeId ,Fname from EmployeeTable // return distinct employee whose salary <99 from Tech dept.
				where salary < 99
				UNION
				Select employeeId ,Fname from EmployeeTable 
				where Deparment = 'Tech'
				-----------------------
				
				1 Manu 23 Tech
				2 Dab 55 HR // this comes as it match salary even not the department.
				4 James 98 Tech
				
		- UNION ALL : combine all results even duplicate from two or more select statment
		
			- Rows of Select 1 + Rows of Select 2 + Rows of Select 3
			- Duplicates rows allowed
			- # of column must be same
			- datatype of cloumn must be compitable.
			- order of column must be same.
			
			- Select employeeId from EmployeeTable // will return all even duplicate rows from both queries.
				UNION ALL
			  Select employeeId from StateEmployeeTable
			  
		- Others operators.
			- AND
			- OR
			- = , > , < , >= ,<>, !=
			- 
			
	- SQL Index:
	
		- Clustered Index 
			 - defines the order in which data is physically stored in a table
			 - i.e SQL cluster index will sort the records first and then store them
			 - How to create
				- When PK created 
				- Manually created by 
				
					CREATE Cluster Index MyclusterindexName
					ON EmployeeTable ([FName] ASC/DESC)
					
				- even it can be deleted as DROP INDEX Myclusterindex
				
			- you can point the same clustered index to Multiple columns aks Composite Clustered  Index
			
				CREATE CLUSTERED INDEX MyclusterindexName
				ON EmployeeTable ([FName] ASC, [Salary] DESC)
		
		- NON Cluster Index
			- stores the index structure separately from the data that is physically stored in a table
			- max 999 index per table.
			- improve the query performance
			- Only Manually it can be created
				
				CREATE NON Cluster Index MyclusterindexName
				ON EmployeeTable ([FName] ASC/DESC)
				
			- you can point the same clustered index to Multiple columns aks Composite NON Clustered  Index
			
				CREATE NON CLUSTERED INDEX MyclusterindexName
				ON EmployeeTable ([FName] ASC, [Salary] DESC)
				
			- UNLIKE Cluster index Multiple Non Clustered Index can be created
			
				CREATE NON Cluster Index MyclusterindexName
				ON EmployeeTable ([FName] ASC/DESC)
				
				CREATE NON Cluster Index MyclusterindexName2
				ON EmployeeTable ([Department] ASC/DESC)
				
				