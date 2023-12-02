package Model;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class User {
    private String first_name,last_name,position;
    private Double salary;
    private UUID id;
    private Role role;

    public User(){

    }
    public User(String first_name,String last_name,String position){
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.role = Role.COMMON_USER;
        Supplier<UUID> randomSupplier = UUID::randomUUID;
        Stream<UUID> infiniteStream = Stream.generate(randomSupplier);
        id = infiniteStream.findFirst().orElseThrow(()-> new IllegalStateException("No UUID generated"));
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public boolean equals(Object ob){
        if (this == ob){
            return  true;
        }
        if (ob == null || getClass() != ob.getClass()){
            return false;
        }
        User user = (User)ob;
        return Objects.equals(getFirst_name(),user.getFirst_name())
                && Objects.equals(getLast_name(),user.getLast_name())
                && Objects.equals(getId(),user.getId())
                && Objects.equals(getPosition(),user.getPosition());
    }
    @Override
    public int hashCode(){
        int hash = 5;
        hash += hash * 3 + Objects.hashCode(first_name);
        hash += hash * 3 + Objects.hashCode(last_name);
        hash += hash * 3 + Objects.hashCode(id);
        hash += hash * 3 + Objects.hashCode(position);
        return hash;
    }
    @Override
    public String toString(){
        return String.join(" ","Name:",first_name," ",last_name);
    }
}
