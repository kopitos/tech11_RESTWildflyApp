package com.example.tech11;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class UserService {
    @Inject
    UserEJB ejb;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getAll() {
        List<User> list = ejb.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : list) {
            UserDTO userDTO = new UserDTO(user.getEmail(), user.getFirstName(), user.getLastName(), user.getBirthday());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("id") Long id) {
        User u = ejb.getUser(id);
        UserDTO user = new UserDTO(u.getEmail(), u.getFirstName(), u.getLastName(), u.getBirthday());
        return user;
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public void createNewUser(User user) {
        ejb.register(user);
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("id") Long id, User user) {
        ejb.update(id, user);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteUser() {

    }
}

