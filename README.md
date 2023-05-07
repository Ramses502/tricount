# tricount

# Groups
  create group
  "/group/create"
  
    {
      "name":"Grupo1"
    }
    
  Add user to group
  "/group/add_user?groupId=1&userName=Pepe"
  
  Remove user from group
  "/group/remove_user?groupId=1&userName=Pepe"
  
  Get all groups
  "/group/get_all"
