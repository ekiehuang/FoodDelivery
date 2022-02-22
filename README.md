# Project Description

## 1. Introduction

This is a food delivery project, which allows customers to order restaurant dishes and administrators to manage menu,
users, and orders. There are seven modules, including eureka server, config server, account, client, user, menu, order.

## 2. Functions

Eureka server: all these microservices need to register in Eureka center that is used to discover and monitor all the
registered services.

Config center: use yaml files to manage all the microservices' config files, like the port, mybatis, eureka
registration, and mysql database connection information

Menu: service provider. All the dishes in the restaurant.

Order: service provider. All the orders placed by clients.

User: service provider. Manage users, like adding, finding, and deleting users.

Account: service provider. For users and administrators login use.

Client: service consumer. This module includes all the front-end pages, and use OpenFeign to call service provider
to realize the functions.
