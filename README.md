# TRICOUNT

## Groups
### create group
POST "/group/create"

    {
      "name":"Grupo1"
    }

### Add user to group
PUT "/group/add_user?groupId=1&userName=Pepe"

### Remove user from group
PUT "/group/remove_user?groupId=1&userName=Pepe"

### Get all groups
GET "/group/get_all"

### Get all groups from one user
GET "/group/get_all_my_groups?userName=Pepe"

### Get all expenses from a group
GET "/group/get_expenses?groupId=1"

## Users
### Register user
POST "/user/register"

    {
      "name":"Pepe",
      "password":"1234"
    }

### Login user
GET "/user/login?name=Pepe&password=1234"

### Debt of user from group
GET "/user/debt_from_group?name=Pepe&groupId=1"

### Pay quantity
PUT "/user/pay?name=Pepe&groupId=1&money=30"

## Expenses
### Create expenses
POST "/expense"

    {
      "title":"Gasto por cáncer de pene",
      "quantity":12
    }

### Add users from group to expense
PUT "/expense/add_users?groupId=1&expenseId=1"

### Remove user from expense
PUT "/expense/remove_user?expenseId=1&userName=Pepa"