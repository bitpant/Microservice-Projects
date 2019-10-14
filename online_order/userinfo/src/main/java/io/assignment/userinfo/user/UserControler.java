package io.assignment.userinfo.user;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
@RestController
public class UserControler {
    @Autowired
    private  UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        User u= userService.getUserById(id);
        if(u==null){
            throw new UserNotFoundException("id- "+id);
        }
        return u;
    }

    @RequestMapping(method=RequestMethod.POST,value="/users")
    public  ResponseEntity<Object> addUser(@RequestBody User user){
         User u= userService.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(u.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

   /* @RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
    public String updateUser(@RequestBody User user,@PathVariable String id){
        return userService.updateUser(id);
    }*/

    @RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
    public User deleteUser(@PathVariable int id){
        User u= userService.deleteUser(id);
        if(u==null){
            throw new UserNotFoundException("id- "+id);
        }
        return u;
    }
}
