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
converted to, and from beans (see figure below).  

![JavaBean UML Diagrams](resources/class-diagrams/Beans.png)

### Data Access Objects

The Data access objects directly interface with `JDBC` for generic CRUD (create, read, update, destroy) operations. The specific implementation chosen includes many `DataAccessObject` classes which inherit from a `DataAccessObject` class. Within the parent `DataAccessObject` class contains common information such as database and database connection information as well as generic queries. Each of the children of the `DataAccessObject` class provide implementation of various ways to select information from the database e.g. `findById(String id)`, `findByUserName(String username)`. This is achieved by querying, and passing the received `ResultSet` to a private method `get(ResultSet queryResults)` which creates an instance of the corresponding model class.

![Data Access Object UML Diagrams](resources/class-diagrams/DataAccessObjects.png)

## Models

The model package contains classes which are essentially wrappers for `ArrayList<G>`, where the `G` argument is a Java bean representation of that particular class. This pluralized pattern was chosen due to the fact that each singular class already has an associated bean. E.g. The plural `Addresses` class has a singular `AddressBean` class. Each of these plurals can be seen in the Figure below (their singular, bean counter parts have already been discussed in the Java Beans section).

![Models UML Diagrams](resources/class-diagrams/Models.png)

### Store

The `Store` class holds all of the information of the store. It holds reference
to the stores users, books, addresses, purchase orders, items, and visit events.

### Object Marshaller

The `ObjectMarshaller` facilitates converting a correctly annotated generic class into XML (marshalling) and vica versa (unmarshalling). In this case, the annotated classes are both the models, and the beans.

### Cart

The Cart Model represents a subset of the items in the store; similar to a shopping cart of other ecommerce applications. It achieves this by storing reference to an instance of the `Books` model.

## Controllers

## Analytics
