# Direct Address Table

## Introduction
Direct Address Table is a Data Structure cotaining (key, value) pairs. 
Since this is direct address, the index of the stored value is not a hash of the value, rather it is simply the created key associated with the value. 

## Classes
- HashTable
    The Direct Address Table, implemented as an array of type Data
- Data
    Data simply contains an integer "key" and a String "value"

## Table Methods
- HashTable() is the default constructor, setting the default table size to 100
- HashTable(int size) is a constructor contating a size parameter to support larger or smaller tables
- insert(int k, String v) inserts a Datum with key k and value v into the table
- insert(Data d) inserts a Datum into the table
- search(int k) locates and returns the Data with a key value of k
- delete(int k) deletes the Data with a key value of k

### Testing
Mutltiple tests have been implemented for each of these methods

## Authors:
Zach Berman
## Acknowledgements:
Knowledge of how to implement a direct address table provided by Mr. Kuszmaul in Mr. Kuszmaul's Data Structures class at Kehillah Jewish High School

