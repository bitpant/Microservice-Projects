package io.assignment.userinfo.user;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
@Component
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> userList=new ArrayList<User>();
        for(User u:userRepository.findAll())
            userList.add(u);
        return userList;
    }

    public User addUser(User user) {
        return  userRepository.save(user);

    }

    public User getUserById(int id) {
        List<User> userList=new ArrayList<User>();
        for(User u:userRepository.findAll())
        {
            if(u.getId()==id)
                return u;
        }
        return null;
    }

    public User deleteUser(int id) {
        for(User u:userRepository.findAll())
        {
            if(u.getId()==id) {
                userRepository.delete(u);
                return u;
            }
        }
        return null;

    }


   /* public User getUserById(int id){
        for(userRepository.)
        return userRepository.f;
    }*/
}
