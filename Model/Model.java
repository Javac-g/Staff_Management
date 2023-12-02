package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Model {
    private List<User> userList  = new ArrayList<>();

    public User add(String first_name,String last_name,String position){
        User user = new User(first_name,last_name,position);
        userList.add(user);
        return user;
    }
    public List<User> findMatch(String first_name,String last_name){
        return userList.stream().
                filter(user -> user.getFirst_name().equals(first_name)
                        && user.getLast_name().equals(last_name))
                .collect(Collectors.toList());
    }
    public User find(String first_name,String last_name){
        for(User user: userList){
            if (user.getFirst_name().equals(first_name) && user.getLast_name().equals(last_name)){
                return user;
            }
        }
        return null;
    }
    public User update(String fseach,String ssearch,String newFirstName,String newLastName,String newPostion,Role role){
        User toUp = find(fseach,ssearch);
        if(toUp != null){
            toUp.setFirst_name(newFirstName);
            toUp.setLast_name(newLastName);
            toUp.setPosition(newPostion);
            toUp.setRole(role);
        }
        return null;
    }
    public Integer delete(UUID id){
        int index = -1;
        for (int  i = 0; i < userList.size();i++){
            if (userList.get(i).getId().equals(id)){
                index = i;
            }
        }
        if (index != -1){
            userList.remove(index);
            return index;
        }
        return index;
    }

}
