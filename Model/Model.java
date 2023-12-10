package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Model {
    private final List<User> userList  = new ArrayList<>();

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
    public User find(UUID uuid){
        for(User user: userList){
            if (user.getId().equals(uuid)){
                return user;
            }
        }
        return null;
    }
    public User update(UUID uuid,String newFirstName,String newLastName,String newPostion,Role role){
        User toUp = find(uuid);
        if((newFirstName == null) || newFirstName.isEmpty()) {
            newFirstName = toUp.getFirst_name();
        }
        if(newLastName == null || newLastName.isEmpty()){
            newLastName = toUp.getLast_name();
        }
        if(newPostion == null || newPostion.isEmpty()){
            newPostion = toUp.getPosition();
        }
        if (role == null){
            role = toUp.getRole();
        }
        if(toUp != null){
            toUp.setFirst_name(newFirstName);
            toUp.setLast_name(newLastName);
            toUp.setPosition(newPostion);
            toUp.setRole(role);
            return toUp;
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
