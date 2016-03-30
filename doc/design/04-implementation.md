# Implementation

In the implementation portion of the design document, we discuss the design
decision which we have chosen. This is broken up into __ Sections. These
sections include User Interface, Data Layer (coresponds to the dao and beans packages), Models (models package),
Controllers (controllers), and Analytics (analytics).

## User Interface

## Data Layer

In the _Data Layer_ we explore our Database schema, Java Beans, and Data Access Objects.

### Database Schema

We have chosen to use a _MySQL_ database. This decision was made in part because it provides more
functionality than _Derby_ but, mostly due to developer familiarity.

Our database consists of 6 tables. These tables include book, address, po,
poitem, visitevent, and user. Each of these database tables has a corresponding
Data Access Object and Java Bean to convert these flat database rows into Java
Objects.

![Database Schema](resources/database-schema.png)

### Java Beans

Each of our database tables has a corresponding Java Object. These Java Objects
are called beans. In our implementation we use beans to represent a singular
database row.  

Within these beans we use the XML annotation library to allow XML to be
converted to, and from beans (Figure __).  

![JavaBean UML Diagrams](resources/class-diagram/Beans.png)

### Data Access Objects

![Data Access Object UML Diagrams](resources/class-diagram/DataAccessObjects.png)

## Models

![Models UML Diagrams](resources/class-diagram/Models.png)

### Addresses

### Books

### Store

### Object Marchaller

### Visits

### PoItems

### Pos

## Controllers

## Analytics
